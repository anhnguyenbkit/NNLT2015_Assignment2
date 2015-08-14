package bkool.checker

/**
 * @author nhphung
 */


import bkool.parser._
import java.io.{FileInputStream,PrintWriter}
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree._
import scala.collection.JavaConverters._
//import bkool.parser.BKOOLParser.ArrayTypeContext
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream,ParserRuleContext}
import org.antlr.v4.runtime.tree.{ParseTreeWalker,TerminalNode,ErrorNode,ParseTree};
object TestChecker {
  def test(input:ANTLRInputStream,dest:PrintWriter) = {
    val lexer = new BKOOLLexer(input);
    val tokens = new CommonTokenStream(lexer)
    val parser = new BKOOLParser(tokens)
    val progtree = parser.program()
    val listBodyclass = progtree.class_decl()
    val body = progtree.class_decl(0).class_body()
    val medthodbody = body.member_decl(2)
    val astbuild = new BuildAST()
    val ast = astbuild.visit(body)
    dest.println(ast)
    val bldecls = new BuildDeclaration()
    val env = bldecls.visit(progtree).asInstanceOf[List[(String,Kind)]]
    val dup = findDuplicate(env,(x:(String,Kind)) => x._1)
    dup match {
      case Some((n,t)) => println("duplicate class")
      case None => findDupMethod(bldecls.visit(body).asInstanceOf[List[(String,Kind)]])
    } 
    def findDupMethod(x:List[(String,Kind)]){
      val attmthdup = findDuplicate(x,(x:(String,Kind)) => x._1)
      if (attmthdup != None)
      {
        println("duplicate in method")
      } 
    }
    val bodydecls = new BuildDeclaration()
    val bodytree = bodydecls.visit(body).asInstanceOf[List[(String,Kind)]]
    for(i<-0 to (listBodyclass.size - 1)) 
      findDupMethod(bldecls.visit(progtree.class_decl(i).class_body()).asInstanceOf[List[(String,Kind)]])
//    val dup2 = findDuplicate(bodytree,(y:(String,Kind)) => y._1)
//    dup2 match {
//      case Some((n,t)) => println("duplicate decl in class")
//      case None => dest.println(bodytree)
//    }  
    
//    val methoddecls = new BuildDeclaration()
//    val methodtree = methoddecls.visit(medthodbody).asInstanceOf[List[(String,Kind)]]
//    val dup3 = bodytree find {x => x._2 == Method}
//    dup3 match {
//      case Some((x,Method)) =>  find_in_method(medthodbody)
//    }
//    def find_in_method(x:BKOOLParser.Member_declContext) {
//      println("debug here")
//      val tbuild = new BuildDeclaration()
//      val ttree = tbuild.visit(x).asInstanceOf[List[(String,Kind)]]
//       val dup4 = findDuplicate(ttree,(y:(String,Kind)) => y._1)
//      dup4 match {
//        case Some((n,t)) => println("duplicate decl in class")
//        case None => dest.println(ttree)
//      }
//    }
//    println(dup3)
    
//    val dup4 = findDuplicate(dup3,(y:(String,Kind)) => y._1)
//    dup4 match {
//      case Some((n,t)) => println("duplicate decl in class")
//      case None => dest.println(bodytree)
//    }
//    val env1 = bldecls.visit(progtree).asInstanceOf[List[(String,Kind)]]
    val tc = new TypeChecking(bodytree)
    tc.visit(body)  
  }
  def findDuplicate[T](lst:List[T],mapfunc:T=>String):Option[T] = lst match {
    case List() => None
    case head::tail => findDuplicate(head,tail,mapfunc) match {
      case None => findDuplicate(tail,mapfunc)
      case Some(t) => Some(t)
    }
  }
  def findDuplicate[T](head:T,rest:List[T],mapfunc:T=>String):Option[T] = rest match {
    case List() => None
    case h::t => if (mapfunc(head) == mapfunc(h)) Some(h) else findDuplicate(head,t,mapfunc)
  }
  //def getName(d:Declare) = d.getName
}

//trait Kind
case object IntType extends Kind
case object FloatType extends Kind
case object ClassType extends Kind
case class MethodType(partype:List[Kind],rettype:Kind) extends Kind
case class JointType(typlst:List[Kind]) extends Kind
case class ConstructorType(partype:List[Kind]) extends Kind
/*trait Declare {def getName:String}
case class VarDeclare(name:String,vartype:Kind) extends Declare {
  def getName = name
}
case class MethodDeclare(name:String,partype:List[Kind],rettype:Kind) extends Declare {
  def getName = name
}
*/

class BuildDeclaration extends BKOOLBaseVisitor[Object] {
  
  override def visitProgram(ctx:BKOOLParser.ProgramContext) = ctx.class_decl().asScala.map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
  override def visitClass_decl(ctx:BKOOLParser.Class_declContext) = {
    val name = ctx.IDENTIFIER(0).getText
    List((name,Class))
  }
  
  override def visitClass_body(ctx:BKOOLParser.Class_bodyContext) = ctx.member_decl().asScala.map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
  override def visitMember_decl(ctx:BKOOLParser.Member_declContext) = visit(ctx.getChild(0))
  
  override def visitBody(ctx:BKOOLParser.BodyContext) = ctx.mem().asScala.map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
  override def visitDecl(ctx: BKOOLParser.DeclContext) = visit(ctx.getChild(0))//if (ctx.var_dl() != null) visit(ctx.var_dl()) else visit(ctx.func_decl())
  
  override def visitVar_dl(ctx:BKOOLParser.Var_dlContext) = visit(ctx.var_decl())
  
  override def visitVar_decl(ctx:BKOOLParser.Var_declContext) = {
    val il = visit(ctx.idlist()).asInstanceOf[List[String]]
    il.map(x => (x,Variable))
  }
  
  override def visitConst_dl(ctx:BKOOLParser.Const_dlContext) = visit(ctx.const_decl())
  
  override def visitConst_decl(ctx:BKOOLParser.Const_declContext) = {
    val name = ctx.IDENTIFIER().getText
    List((name,Constant))
  }
  
  override def visitIdlist(ctx:BKOOLParser.IdlistContext) = ctx.IDENTIFIER().asScala.map(visit).toList
  
  override def visitFunc_decl(ctx: BKOOLParser.Func_declContext) = {
    val name = ctx.IDENTIFIER().getText
    List((name,Method))
  }
  
  override def visitConstructor_decl(ctx:BKOOLParser.Constructor_declContext) = {
    val name = ctx.IDENTIFIER().getText
    List((name,Method))
  }
  
  override def visitBkoolType(ctx: BKOOLParser.BkoolTypeContext) = ctx.getChild(0).getText
  match {
    case "int" => IntType
    case "float" => FloatType
  }
  
  override def visitParlist(ctx: BKOOLParser.ParlistContext) = 
    ctx.var_decl()
    .asScala
    .map(visit)
    .toList
    .asInstanceOf[List[List[(String,Kind)]]]
    .flatten
    .map(_ match {
      case (_,t) => t
    })
    
  override def visitTerminal(node:TerminalNode) = node.getText
}
class TypeChecking(env:List[(String,Kind)]) extends BKOOLBaseVisitor[Object] {  
  def lookup[T](name:String,lst:List[T],func:T=>String):Option[T] = lst match {
    case List() => None
    case head::tail => if (func(head) == name) Some(head) else lookup(name,tail,func)
  }
  def typecheck(pt:Kind,at:Kind):Boolean = pt == at
  def typecheck(pt:List[Kind],at:List[Kind]):Boolean = 
      if (pt.length != at.length) false 
      else if (pt.length == 0) true 
      else pt.zip(at).forall(x=>typecheck(x._1,x._2))
  def typecheck(pt:JointType,at:List[Kind]):Boolean = typecheck(pt.typlst,at)

  override def visitCall(ctx: BKOOLParser.CallContext) = {
    val id = ctx.IDENTIFIER.getText
    val iddecl = lookup(id,env,(x:(String,Kind)) => x._1)
    if (iddecl == None) {
      println("call")
      throw UndeclareIdentifier(id)
    }
        
    else {
        val explst = ctx.explist()      
        val at = if (explst != null) visit(explst).asInstanceOf[JointType].typlst else List()
        
        iddecl match {                   
              case Some((_,MethodType(pt,rt))) => if (typecheck(pt,at)) rt else throw TypeMismatchInStatement(ctx.getText)            
              case _ => throw TypeMismatchInStatement(ctx.getText)
        }       
    }
  }
  
  override def visitExplist(ctx:BKOOLParser.ExplistContext) = JointType(ctx.exp().asScala.map(visit).toList.asInstanceOf[List[Kind]])

  override def visitExp(ctx:BKOOLParser.ExpContext) = 
              ctx.moreterm().asScala.map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else throw TypeMismatchInExpression(ctx.getText)
              })
              
  
  override def visitMoreterm(ctx:BKOOLParser.MoretermContext) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm(ctx:BKOOLParser.TermContext) = 
              ctx.morefact().asScala.map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.fact()).asInstanceOf[Kind])((x,y)=> y match {
                case ("*",t) => if (typecheck(x,t)) t else throw TypeMismatchInExpression(ctx.getText)
                case ("/",t) => if (typecheck(x,t)) FloatType else throw TypeMismatchInExpression(ctx.getText)
              })
              
  
  override def visitMorefact(ctx:BKOOLParser.MorefactContext) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  
  override def visitFact(ctx: BKOOLParser.FactContext) = {
    if (ctx.INTLIT() != null) IntType
    else if (ctx.FLOATLIT() != null) FloatType
         else if (ctx.IDENTIFIER() != null) {
              val id = ctx.IDENTIFIER.getText
//              println(env)
              val iddecl = lookup(id,env,(x:(String,Kind)) => x._1)
              if (iddecl == None) {
                println("fact")
                 throw UndeclareIdentifier(id)
              }
               
              else {
                val explst = ctx.explist()      
                if (ctx.LBRAC() != null) {
                    val at = if (explst != null) visit(explst).asInstanceOf[JointType].typlst else List()
                    iddecl match {                   
                      case Some((_,MethodType(pt,rt))) => if (typecheck(pt,at)) rt else throw TypeMismatchInExpression(ctx.getText)
                      case _ => throw TypeMismatchInExpression(ctx.getText)
                    }
                } else 
                  iddecl match {
                    case Some((_,IntType)) => IntType
                    case Some((_,FloatType)) => FloatType
                    case _ => throw TypeMismatchInExpression(ctx.getText)
                  }
             }
         } else        
          visit(ctx.exp())        
    }       

  override def visitTerminal(node:TerminalNode) = node.getText
}
trait AST
case class ProgramAST(decls:List[DeclAST]) extends AST
trait BodyMember extends AST
trait DeclAST
trait Stmt extends BodyMember
case class VarDeclAST(name:String,vtype:Kind) extends DeclAST with BodyMember
case class ParDeclAST(name:String,vtype:Kind) extends DeclAST
case class ManyVarDeclAST(vardecls:List[VarDeclAST]) extends DeclAST
case class MethodDeclAST(name:String,partype:List[ParDeclAST],rettype:Kind,body:List[BodyMember]) extends DeclAST
case class ConstructorDeclAST(name:String,partype:List[ParDeclAST],body:List[BodyMember]) extends DeclAST
case class ClassDeclAST(name:String,body:List[BodyMember]) extends DeclAST
case class AssignAST(lhs:String,rhs:ExpAST) extends Stmt
case class CallStmtAST(name:String,args:List[ExpAST]) extends Stmt
case class ConstDeclAST(name:String, ctype:Kind)
trait ExpAST extends AST
case class BinaryAST(left:ExpAST,op:String,right:ExpAST) extends ExpAST
case class IntAST(value:Integer) extends ExpAST
case class FloatAST(value:Float) extends ExpAST
case class CallExpAST(name:String,args:List[ExpAST]) extends ExpAST
case class IdAST(name:String) extends ExpAST

class BuildAST extends BKOOLBaseVisitor[Object] {
  def flatten(arg:List[DeclAST]):List[DeclAST] = arg match {
    case List() => List()
    case ManyVarDeclAST(l)::tail => l ++ flatten(tail)
    case h::tail => h :: flatten(tail)
  }
  override def visitProgram(ctx:BKOOLParser.ProgramContext) = ProgramAST(flatten(ctx.class_decl().asScala.map(visit).toList.asInstanceOf[List[DeclAST]]))
  
  override def visitClass_decl(ctx:BKOOLParser.Class_declContext) = {
	  val name = ctx.IDENTIFIER(0).getText
    val body = visit(ctx.class_body()).asInstanceOf[List[BodyMember]]
    ClassDeclAST(name, body)
  }
  
  override def visitClass_body(ctx:BKOOLParser.Class_bodyContext) = ctx.member_decl().asScala.map(visit).toList
  
  
  override def visitDecl(ctx: BKOOLParser.DeclContext) = visit(ctx.getChild(0))    //if (ctx.var_dl() != null) visit(ctx.var_dl()) else visit(ctx.func_decl())
  
  override def visitVar_dl(ctx:BKOOLParser.Var_dlContext) = visit(ctx.var_decl())
  
  override def visitVar_decl(ctx:BKOOLParser.Var_declContext) = {
    val il = visit(ctx.idlist()).asInstanceOf[List[String]]
    val vtype = visit(ctx.bkoolType()).asInstanceOf[Kind]
    if (il.length == 1) VarDeclAST(il(0),vtype) else ManyVarDeclAST(il.map(x => VarDeclAST(x,vtype)))
  }
  
  override def visitConst_dl(ctx:BKOOLParser.Const_dlContext) = visit(ctx.const_decl())
  
  override def visitConst_decl(ctx:BKOOLParser.Const_declContext) = {
    val name = ctx.IDENTIFIER().getText
    val ctype = visit(ctx.bkoolType()).asInstanceOf[Kind]
    ConstDeclAST(name,ctype)
  }
  
  override def visitIdlist(ctx:BKOOLParser.IdlistContext) = ctx.IDENTIFIER().asScala.map(visit).toList
  
  override def visitFunc_decl(ctx: BKOOLParser.Func_declContext) = {
    val name = ctx.IDENTIFIER().getText
    val partype = if (ctx.parlist() != null) visit(ctx.parlist()).asInstanceOf[List[ParDeclAST]] else List()
    val rettype = visit(ctx.bkoolType()).asInstanceOf[Kind]
    val body = visit(ctx.body()).asInstanceOf[List[BodyMember]]
    MethodDeclAST(name,partype,rettype,body)
  }
  
  override def visitConstructor_decl(ctx:BKOOLParser.Constructor_declContext) = {
    val name = ctx.IDENTIFIER().getText
    val partype = if (ctx.parlist() != null) visit(ctx.parlist()).asInstanceOf[List[ParDeclAST]] else List()
    val body = visit(ctx.body()).asInstanceOf[List[BodyMember]]
    ConstructorDeclAST(name,partype,body)
  }
  
  override def visitBkoolType(ctx: BKOOLParser.BkoolTypeContext) = ctx.getChild(0).getText
  match {
    case "integer" => IntType
    case "float" => FloatType
  }
  override def visitArrayType(ctx:BKOOLParser.ArrayTypeContext) = ctx.getChild(0)
  
  override def visitClassType(ctx:BKOOLParser.ClassTypeContext) = ctx.IDENTIFIER().getText
  
  def var2par(lst:List[DeclAST]):List[ParDeclAST] = lst match {
    case List() => List()
    case VarDeclAST(n,t)::tail => ParDeclAST(n,t)::var2par(tail)
    case ManyVarDeclAST(l)::tail => var2par(l) ++ var2par(tail)
  }
  override def visitParlist(ctx: BKOOLParser.ParlistContext) = 
    var2par(ctx.var_decl().asScala.map(visit).toList.asInstanceOf[List[DeclAST]])

  override def visitBody(ctx:BKOOLParser.BodyContext) = ctx.mem().asScala.map(visit).toList
  
  //override def visitMem(ctx:BKOOLParser.MemContext) = visit(ctx.getChild(0))//if (ctx.decl() != null) visit(ctx.var_dl()) else visit(ctx.stmt())
  
  //override def visitStmt(ctx:BKOOLParser.StmtContext) = visit(ctx.getChild(0))//if (ctx.assign() != null) visit(ctx.assign()) else visit(ctx.call())
  
  override def visitAssign(ctx:BKOOLParser.AssignContext) = {
    val id = ctx.IDENTIFIER().getText
    val exp = visit(ctx.exp()).asInstanceOf[ExpAST]
    AssignAST(id,exp)
  }
  override def visitCall(ctx:BKOOLParser.CallContext) = {
    val id = ctx.IDENTIFIER().getText
    val args = if (ctx.explist() != null) visit(ctx.explist()).asInstanceOf[List[ExpAST]] else List()
    CallStmtAST(id,args)
  } 
  
  override def visitExplist(ctx:BKOOLParser.ExplistContext) = ctx.exp().asScala.map(visit).toList
  
  override def visitExp(ctx:BKOOLParser.ExpContext) = {
    val first = visit(ctx.term()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm().asScala.map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm(ctx:BKOOLParser.MoretermContext) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term()).asInstanceOf[ExpAST]
    (op,exp)
  }
  override def visitTerm(ctx:BKOOLParser.TermContext) = {
    val first = visit(ctx.fact()).asInstanceOf[ExpAST]
    val lst = ctx.morefact().asScala.map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMorefact(ctx:BKOOLParser.MorefactContext) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.fact()).asInstanceOf[ExpAST]
    (op,exp)
  }  
  
  override def visitFact(ctx:BKOOLParser.FactContext) = {
    if (ctx.IDENTIFIER() != null) {
      val id = ctx.IDENTIFIER().getText
      if (ctx.LBRAC() != null) {
        val args =if (ctx.explist() != null) visit(ctx.explist()).asInstanceOf[List[ExpAST]] else List()
        CallExpAST(id,args)
      } else IdAST(id)
    } else if (ctx.INTLIT() != null) IntAST(ctx.INTLIT().getText.toInt) 
           else if (ctx.FLOATLIT() != null) FloatAST(ctx.FLOATLIT().getText.toFloat)
                else visit(ctx.exp())
  }
  override def visitTerminal(node:TerminalNode) = node.getText

}
  