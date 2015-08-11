package bkool.checker

import scala.collection.JavaConversions._
import java.io.{FileInputStream,PrintWriter}
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream,ParserRuleContext}
import org.antlr.v4.runtime.tree.{ParseTreeWalker,TerminalNode,ErrorNode,ParseTree}
import scala.collection.JavaConverters._
import bkool.parser._
import bkool.parser.BKOOLParser.PrimitiveTypeContext
import bkool.parser.BKOOLParser.FormalParameterListContext
import bkool.parser.BKOOLParser.FormalParameterContext
import java.awt.geom.FlatteningPathIterator



object TestChecker {

	// please don't change Name of this class and name, parameter of this function
	def test(input:ANTLRInputStream,dest:PrintWriter) {
		println("dest debug")
		val lexer = new BKOOLLexer(input)
		val tokens = new CommonTokenStream(lexer)
		val parser = new BKOOLParser(tokens)

		val prog = parser.program
		val astbuild = new BuildAST()
    
		val ast = astbuild.visit(prog)
    dest.print(ast)
    val bldecls = new BuildDeclaration()
    val env = bldecls.visit(prog).asInstanceOf[List[(String,Kind)]]
    val dup = findDuplicate(env,(x:(String,Kind)) => x._1)
    dup match{
      case Some((n,t)) => throw Redeclared(t,n)
      case None => dest.println(env)
    }
    
	}
  def findDuplicate[T](lst:List[T], mapfunc:T=>String):Option[T] = lst match {
    case List() => None
    case head::tail => findDuplicate(head, tail, mapfunc) match {
      case None => findDuplicate(tail, mapfunc)
      case Some(t) => Some(t)
    }
  }
	def findDuplicate[T](head:T,rest:List[T],mapfunc:T=>String):Option[T] = rest match {
    case List() => None
    case h::t => if(mapfunc(head) == mapfunc(h)) Some(h) else findDuplicate(head, t, mapfunc)
    
  }
	
}

trait BKOOLType
case object IntType extends BKOOLType
case object FloatType extends BKOOLType
case class MethodType (partype:List[Kind],retyype:Kind) extends BKOOLType
case class JointType (typlst:List[Kind]) extends BKOOLType
class BuildDeclaration extends BKOOLBaseVisitor[Object] { //
  override def visitProgram(ctx:BKOOLParser.ProgramContext) =
      ctx.classDeclaration().asScala.map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
      
  override def visitMethodDeclaration(ctx:BKOOLParser.MethodDeclarationContext) = {
    val name = ctx.Identifier().getText
    val partype = if(ctx.formalParameters() != null) visit(ctx.formalParameters()).asInstanceOf[List[Kind]] else List()
    val rettype = visit(ctx.`type`()).asInstanceOf[Kind]
    List((name,MethodType(partype,rettype)))
  }   
      
  override def visitClassDeclaration(ctx:BKOOLParser.ClassDeclarationContext) = {
    val name = ctx.Identifier().asScala.map(visit).toList.asInstanceOf[String]
    name.map(x => x)   
  }
  
  override def visitConstantDeclaration(ctx:BKOOLParser.ConstantDeclarationContext) = {
    val name = ctx.Identifier().getText;
    val typeConst = visit(ctx.`type`()).asInstanceOf[BKOOLType]
    List((name, typeConst))
  }
  
  override def visitLocalVariableDeclaration(ctx:BKOOLParser.LocalVariableDeclarationContext) = {
    val il = visit(ctx.variableDeclarators()).asInstanceOf[List[String]]
     val vtype = visit(ctx.`type`()).asInstanceOf[BKOOLType]
    il.map(x => (x, vtype))
  }
  
  override def visitPrimitiveType(ctx:BKOOLParser.PrimitiveTypeContext) =  ctx.getChild(0).getText match {
    case "int" => IntType
    case "float" => FloatType
  }
  
  override def visitFormalParameterList(ctx:BKOOLParser.FormalParameterListContext) =
   ctx.formalParameter().asScala.map(visit).toList.asInstanceOf[List[List[(String,BKOOLType)]]].flatten
    .map(_ match {  
      case (_,t) => t
    })
  
  override def visitTerminal(node:TerminalNode) = node.getText
  
}

trait AST
case class ProgramAST(decl:List[DeclAST]) extends AST
trait BodyMember extends AST
trait DeclAST
trait Stmt extends BodyMember
case class ClassDeclAST(name:String) extends DeclAST
case class VarDeclAST(name:String, vtype:BKOOLType) extends DeclAST with BodyMember
case class ParDeclAST(name:String, vtype:BKOOLType) extends DeclAST
case class ConstDeclAST(name:String, vtype:BKOOLType) extends DeclAST
case class ManyVarDeclAST(vardecls:List[VarDeclAST]) extends DeclAST
case class MethodDeclAST(name:String, partype:List[ParDeclAST], rettype:BKOOLType, body:List[BodyMember]) extends DeclAST
case class ConstructorDeclAST(name:String, partype:List[ParDeclAST], body:List[BodyMember]) extends DeclAST
case class AssignAST(lsh:String, rhs:ExpAST) extends Stmt

trait ExpAST extends AST
case class BinaryAST(left:ExpAST, op:String, right:ExpAST) extends ExpAST
case class IntAST(value:Integer) extends ExpAST
case class FloatAST(value:Float) extends ExpAST
case class IdAST(name:String) extends ExpAST
case class ConstantDeclAST(name:String, consttype:BKOOLType, expr:ExpAST)

class BuildAST extends BKOOLBaseVisitor[Object] {
  def flatten(arg:List[DeclAST]):List[DeclAST] = arg match {
    case List() => List()
    case ManyVarDeclAST(l)::tail => l ++ flatten(tail)
    case h::tail => h :: flatten(tail)
  }
  override def visitProgram(ctx:BKOOLParser.ProgramContext) = ProgramAST(flatten(ctx.classDeclaration().asScala.map(visit).toList.asInstanceOf[List[DeclAST]]))
  override def visitClassDeclaration(ctx:BKOOLParser.ClassDeclarationContext) = ClassDeclAST(ctx.Identifier().asScala.map(visit).toList.asInstanceOf[String])
  override def visitMemberDeclartion(ctx:BKOOLParser.MemberDeclartionContext) = visit(ctx.getChild(0))
  override def visitMethodDeclaration(ctx:BKOOLParser.MethodDeclarationContext) = {
    val name = ctx.Identifier().asInstanceOf[String]
    val partype = if(ctx.formalParameters() != null) visit(ctx.formalParameters()).asInstanceOf[List[ParDeclAST]] else List()
    val rettype = visit(ctx.`type`()).asInstanceOf[BKOOLType]
    val body = visit(ctx.methodBody()).asInstanceOf[List[BodyMember]]
    MethodDeclAST(name, partype, rettype, body)
  }
  override def visitLocalVariableDeclarationStatement(ctx:BKOOLParser.LocalVariableDeclarationStatementContext) = {
    visit(ctx.getChild(0))
  }
  override def visitConstantDeclarationStatement(ctx:BKOOLParser.ConstantDeclarationStatementContext) =
    visit(ctx.getChild(0))
  override def visitConstructorDeclaration(ctx:BKOOLParser.ConstructorDeclarationContext) = {
    val name = ctx.Identifier().asInstanceOf[String]
    val partype = if(ctx.formalParameters() != null) visit(ctx.formalParameters()).asInstanceOf[List[ParDeclAST]] else List()
    val body = visit(ctx.constructorBody()).asInstanceOf[List[BodyMember]]
    ConstructorDeclAST(name, partype, body)
  }
  override def visitConstantDeclaration(ctx:BKOOLParser.ConstantDeclarationContext) = {
    val name = ctx.Identifier().asInstanceOf[String]
    val consttype = ctx.`type`().asInstanceOf[BKOOLType]
    val expr = ctx.expression().asInstanceOf[ExpAST]
    ConstantDeclAST(name, consttype, expr)
  }
  override def visitTerminal(node:TerminalNode) = node.getText
  
}
