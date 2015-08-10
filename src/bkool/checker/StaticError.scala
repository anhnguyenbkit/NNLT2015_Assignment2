package bkool.checker

trait Kind
case object Class extends Kind 
case object Attribute extends Kind
case object Method extends Kind
case object Parameter extends Kind
case object Constant extends Kind
case object Variable extends Kind

case object Identifier extends Kind	// use when "Undeclared Identifier"

/* These exception classes are used to throw when an error is detected */
/* k: the kind of the redeclared identifier; it must be one of the six above kinds
   n: the name of the redeclared identifier; 
*/
case class Redeclared(k:Kind,n:String) extends Exception
case class Undeclared(k:Kind,n:String) extends Exception

case class CannotAssignToConstant(s:String) extends Exception
case class TypeMismatchInStatement(stmt:String) extends Exception
case class TypeMismatchInExpression(exp:String) extends Exception

//case class CannotAccessPrivateAttribute(cName:String, attr:String) extends Exception
//case class NoPrototype(mName:String) extends Exception
//case class NoImplementation(mName:String) extends Exception
