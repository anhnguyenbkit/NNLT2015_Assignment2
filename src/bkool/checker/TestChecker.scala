package bkool.checker
import scala.collection.JavaConversions._
import java.io.{FileInputStream,PrintWriter}
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream,ParserRuleContext}
import org.antlr.v4.runtime.tree.{ParseTreeWalker,TerminalNode,ErrorNode,ParseTree};
import bkool.parser._
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
//    dest.println(ast)
    val bldecls = new BuildDeclaration()
    val env = bldecls.visit(progtree).asInstanceOf[List[(String,Kind)]]
    val dup = findDuplicate(env,(x:(String,Kind)) => x._1)
    dup match {
      case Some((n,t)) => throw bkool.checker.Redeclared(t,n)
      case None => findDupMethod(bldecls.visit(body).asInstanceOf[List[(String,Kind)]])
    } 
    def findDupMethod(x:List[(String,Kind)]){
      val attmthdup = findDuplicate(x,(x:(String,Kind)) => x._1)
      attmthdup match {
        case Some((n,t)) => throw bkool.checker.Redeclared(t,n)
        case None => println("none")
      } 
    }
    val bodydecls = new BuildDeclaration()
    val bodytree = bodydecls.visit(body).asInstanceOf[List[(String,Kind)]]
    for(i<-0 to (listBodyclass.size - 1)) {
      findDupMethod(bldecls.visit(progtree.class_decl(i).class_body()).asInstanceOf[List[(String,Kind)]])
      
    val tc = new TypeChecking(bldecls.visit(progtree.class_decl(i).class_body()).asInstanceOf[List[(String,Kind)]])
    tc.visit(progtree.class_decl(i).class_body())  
    }
//    val tl = new TypeChecking(bldecls.visit(body).asInstanceOf[List[(String,Kind)]])
//    tl.visit(body)
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
case object VoidType extends Kind
case object StringType extends Kind
case object ArrayType  extends Kind
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
  
  override def visitProgram(ctx:BKOOLParser.ProgramContext) = ctx.class_decl().map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
  override def visitClass_decl(ctx:BKOOLParser.Class_declContext) = {
    val name = ctx.IDENTIFIER(0).getText
    List((name,Class))
  }
  
  override def visitClass_body(ctx:BKOOLParser.Class_bodyContext) = ctx.member_decl().map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
  override def visitMember_decl(ctx:BKOOLParser.Member_declContext) = visit(ctx.getChild(0))
  
  override def visitBody(ctx:BKOOLParser.BodyContext) = ctx.mem().map(visit).toList.asInstanceOf[List[List[(String,Kind)]]].flatten
  
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
  
  override def visitIdlist(ctx:BKOOLParser.IdlistContext) = ctx.IDENTIFIER().map(visit).toList
  
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
  
  override def visitMethod_statement1(ctx:BKOOLParser.Method_statement1Context) = {
    val id = ctx.exp().asInstanceOf[Kind]
    if (id != Class)
      throw TypeMismatchInStatement(ctx.exp().asInstanceOf[String])
    val callee = ctx.IDENTIFIER().getText
    val calleedecl = lookup(callee,env,(x:(String,Kind)) => x._1)
   calleedecl match {
      case None => throw UndeclareIdentifier(callee)
      case Some((_,Method )) => id
      case _ => throw TypeMismatchInStatement(callee)
    }
   
  }
  
  override def visitMethod_2(ctx:BKOOLParser.Method_2Context) = {
    val id = ctx.IDENTIFIER(0).getText
    val iddecl = lookup(id,env,(x:(String,Kind)) => x._1)
    val callee = ctx.IDENTIFIER(1).getText
    val calleedecl = lookup(callee,env,(x:(String,Kind)) => x._1)
    iddecl match {
      case None => throw UndeclareIdentifier(id)
      case Some((_,Class )) => if(calleedecl == Method) id else TypeMismatchInStatement(id)
      case _ => throw TypeMismatchInStatement(id)
    }
  }
  
  override def visitAssign(ctx:BKOOLParser.AssignContext) = {
    val id = ctx.IDENTIFIER().getText
    val iddecl = lookup(id,env,(x:(String,Kind)) => x._1)
    iddecl match {
      case None => throw UndeclareIdentifier(id)
      case Some((_,Constant)) => throw CannotAssignToConstant(id)
      case _ => id
    }
  }
  
//  override def visitAssign_statement(ctx:BKOOLParser.Assign_StatementContext) = {
//    val typeleft = if(ctx.memberaccess() != null) visit(ctx.memberaccess()).asInstanceOf[Kind]
//    else if(ctx.array() != null) visit(ctx.array()).asInstanceOf[Kind] 
//    else if(ctx.IDENTIFIER() != null) ctx.IDENFIER().getText
//    if (typeleft == VoidType) throw TypeMismatchInStatement(typeleft)
//  }
  
  override def visitExplist(ctx:BKOOLParser.ExplistContext) = JointType(ctx.exp().map(visit).toList.asInstanceOf[List[Kind]])

  override def visitExp(ctx:BKOOLParser.ExpContext) = 
              ctx.moreterm().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else 
                  {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
              
  
  override def visitMoreterm(ctx:BKOOLParser.MoretermContext) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm(ctx:BKOOLParser.TermContext) = 
              ctx.moreterm1().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term1()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  
override def visitMoreterm1(ctx:BKOOLParser.Moreterm1Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm1(ctx:BKOOLParser.Term1Context) = 
              ctx.moreterm2().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term2()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })              
  override def visitMoreterm2(ctx:BKOOLParser.Moreterm2Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm2(ctx:BKOOLParser.Term2Context) = 
              ctx.moreterm3().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term3()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm3(ctx:BKOOLParser.Moreterm3Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm3(ctx:BKOOLParser.Term3Context) = 
              ctx.moreterm4().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term4()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm4(ctx:BKOOLParser.Moreterm4Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm4(ctx:BKOOLParser.Term4Context) = 
              ctx.moreterm5().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term5()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm5(ctx:BKOOLParser.Moreterm5Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm5(ctx:BKOOLParser.Term5Context) = 
              ctx.moreterm6().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term6()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm6(ctx:BKOOLParser.Moreterm6Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm6(ctx:BKOOLParser.Term6Context) = 
              ctx.moreterm7().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term7()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm7(ctx:BKOOLParser.Moreterm7Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm7(ctx:BKOOLParser.Term7Context) = 
              ctx.moreterm8().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term8()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm8(ctx:BKOOLParser.Moreterm8Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm8(ctx:BKOOLParser.Term8Context) = 
              ctx.moreterm9().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.term9()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMoreterm9(ctx:BKOOLParser.Moreterm9Context) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  override def visitTerm9(ctx:BKOOLParser.Term9Context) = 
              ctx.morefact().map(visit).toList.
              asInstanceOf[List[(String,Kind)]].
              foldLeft(visit(ctx.fact()).asInstanceOf[Kind])((x,y)=> y match {
                case (_,t) => if (typecheck(x,t)) t else {
                  println("debug x: " + x)
                  println("debug t: " + t)
                  throw TypeMismatchInExpression(ctx.getText)
                  }
              })
  override def visitMorefact(ctx:BKOOLParser.MorefactContext) = (visit(ctx.getChild(0)),visit(ctx.getChild(1)))
  
  
  override def visitFact(ctx: BKOOLParser.FactContext) = {
    if (ctx.INTLIT() != null) IntType
    else if (ctx.FLOATLIT() != null) FloatType
         else if (ctx.IDENTIFIER() != null) {
              val id = ctx.IDENTIFIER.getText
              println(env)
              val iddecl = lookup(id,env,(x:(String,Kind)) => x._1)
              println("debug on fact: " + env)
              if (iddecl == None) {
                println("fact")
                 throw UndeclareIdentifier(id)
              }
               
              else {
                
                  iddecl match {
                    case Some((_,Variable)) => Variable
                    case Some((_,Constant)) => Constant
                    case Some((_,Method)) => Method
                    case Some((_,Class)) => Class
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
  override def visitProgram(ctx:BKOOLParser.ProgramContext) = ProgramAST(flatten(ctx.class_decl().map(visit).toList.asInstanceOf[List[DeclAST]]))
  
  override def visitClass_decl(ctx:BKOOLParser.Class_declContext) = {
	  val name = ctx.IDENTIFIER(0).getText
    val body = visit(ctx.class_body()).asInstanceOf[List[BodyMember]]
    ClassDeclAST(name, body)
  }
  
  override def visitClass_body(ctx:BKOOLParser.Class_bodyContext) = ctx.member_decl().map(visit).toList
  
  
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
  
  override def visitIdlist(ctx:BKOOLParser.IdlistContext) = ctx.IDENTIFIER().map(visit).toList
  
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
    var2par(ctx.var_decl().map(visit).toList.asInstanceOf[List[DeclAST]])

  override def visitBody(ctx:BKOOLParser.BodyContext) = ctx.mem().map(visit).toList
  
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
  
  override def visitExplist(ctx:BKOOLParser.ExplistContext) = ctx.exp().map(visit).toList
  
  override def visitExp(ctx:BKOOLParser.ExpContext) = {
    val first = visit(ctx.term()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitTerm(ctx:BKOOLParser.TermContext) = {
    val first = visit(ctx.term1()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm1().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm(ctx:BKOOLParser.MoretermContext) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
  override def visitTerm1(ctx:BKOOLParser.Term1Context) = {
    val first = visit(ctx.term2()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm2().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm1(ctx:BKOOLParser.Moreterm1Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term1()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm2(ctx:BKOOLParser.Term2Context) = {
    val first = visit(ctx.term3()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm3().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm2(ctx:BKOOLParser.Moreterm2Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term2()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm3(ctx:BKOOLParser.Term3Context) = {
    val first = visit(ctx.term4()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm4().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm3(ctx:BKOOLParser.Moreterm3Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term3()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm4(ctx:BKOOLParser.Term4Context) = {
    val first = visit(ctx.term5()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm5().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm4(ctx:BKOOLParser.Moreterm4Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term4()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm5(ctx:BKOOLParser.Term5Context) = {
    val first = visit(ctx.term6()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm6().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm5(ctx:BKOOLParser.Moreterm5Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term5()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm6(ctx:BKOOLParser.Term6Context) = {
    val first = visit(ctx.term7()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm7().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm6(ctx:BKOOLParser.Moreterm6Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term6()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm7(ctx:BKOOLParser.Term7Context) = {
    val first = visit(ctx.term8()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm8().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm7(ctx:BKOOLParser.Moreterm7Context) = {
    val op = visit(ctx.getChild(0))
    val exp = visit(ctx.term7()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm8(ctx:BKOOLParser.Term8Context) = {
    val first = visit(ctx.term9()).asInstanceOf[ExpAST]
    val lst = ctx.moreterm9().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm8(ctx:BKOOLParser.Moreterm8Context) = {
    val op = ctx.exp()
    val exp = visit(ctx.term8()).asInstanceOf[ExpAST]
    (op,exp)
  }
  
   override def visitTerm9(ctx:BKOOLParser.Term9Context) = {
    val first = visit(ctx.fact()).asInstanceOf[ExpAST]
    val lst = ctx.morefact().map(visit).toList.asInstanceOf[List[(String,ExpAST)]]
    lst.foldLeft(first)((x,y) => y match {case (a,b) => BinaryAST(x,a,b)} )
  }
  
  override def visitMoreterm9(ctx:BKOOLParser.Moreterm9Context) = {
    val op = ctx.DOT().getText
    val exp = visit(ctx.term9()).asInstanceOf[ExpAST]
    if (ctx.LBRAC() != null) {
      val args = if (ctx.expBlock() != null) visit(ctx.expBlock()).asInstanceOf[List[ExpAST]] else List()
      (op,args,exp)
    } else (op,exp)
  }
  
  override def visitMorefact(ctx:BKOOLParser.MorefactContext) = {
    val op = ctx.NEW().getText
    val id = ctx.IDENTIFIER.getText
    val args = if (ctx.expBlock() != null) visit(ctx.expBlock()).asInstanceOf[List[ExpAST]] else List()
    val exp = visit(ctx.fact()).asInstanceOf[ExpAST]
    (op, id, args, exp)
  }  
  
  override def visitFact(ctx:BKOOLParser.FactContext) = {
    if (ctx.IDENTIFIER() != null) {
      val id = ctx.IDENTIFIER().getText
      if (ctx.LBRAC() != null) {
        val args = if (ctx.exp() != null) visit(ctx.exp()).asInstanceOf[List[ExpAST]] else List()
        CallExpAST(id,args)
      } else IdAST(id)
    } else if (ctx.INTLIT() != null) IntAST(ctx.INTLIT().getText.toInt) 
           else if (ctx.FLOATLIT() != null) FloatAST(ctx.FLOATLIT().getText.toFloat)
                else visit(ctx.exp())
  }
  override def visitTerminal(node:TerminalNode) = node.getText

}

case class UndeclareIdentifier(name:String) extends Exception
  