package bkool.checker

import scala.collection.JavaConversions._
import java.io.{FileInputStream,PrintWriter}

import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream,ParserRuleContext}
import org.antlr.v4.runtime.tree.{ParseTreeWalker,TerminalNode,ErrorNode,ParseTree};
import scala.collection.JavaConverters._
import bkool.parser._



object TestChecker {

	// please don't change Name of this class and name, parameter of this function
	def test(input:ANTLRInputStream,dest:PrintWriter) {
		
		val lexer = new BKOOLLexer(input)
		val tokens = new CommonTokenStream(lexer)
		val parser = new BKOOLParser(tokens)

		val prog = parser.program
		val check = new StaticChecker
		check.visit(prog)
	}
	
	
}

trait BKOOLType
case object IntType extends BKOOLType
case object FloatType extends BKOOLType
case class MethodType (partype:List[BKOOLType],retyype:BKOOLType) extends BKOOLType
case class JointType (typlst:List[BKOOLType]) extends BKOOLType
class StaticChecker extends BKOOLBaseVisitor[Object] {
  override def visitProgram(ctx:BKOOLParser.ProgramContext) =
      ctx.classDeclaration().asScala.map(visit).toList.asInstanceOf[List[List[(String,BKOOLType)]]].flatten
  override def visitClass_decl(ctx:BKOOLParser.ClassDeclarationContext) = {
    val name = ctx.Identifier().asScala.map(visit).toList.asInstanceOf[List[List[(String)]]].flatten;
  }
    
}
