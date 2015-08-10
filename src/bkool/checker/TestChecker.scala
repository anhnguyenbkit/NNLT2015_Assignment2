package bkool.checker

import scala.collection.JavaConversions._
import java.io.{FileInputStream,PrintWriter}

import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream,ParserRuleContext}
import org.antlr.v4.runtime.tree.{ParseTreeWalker,TerminalNode,ErrorNode,ParseTree};

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

class StaticChecker extends BKOOLBaseVisitor[Object] {}
