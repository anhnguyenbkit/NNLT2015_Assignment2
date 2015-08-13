grammar BKOOL;

@lexer::header{
//package bkool.parser;
}

@parser::header{
//package bkool.parser;
}

options{
language=Java;
}

program: class_decl+ EOF;

class_decl
	: 'class' IDENTIFIER ('extends' IDENTIFIER)? class_body;
	
class_body: '{' member_decl* '}';


member_decl
	: func_decl
	| var_dl
	| const_dl
	| constructor_decl
	;
decl: var_dl | func_decl ;

var_decl: idlist ':' bkoolType ;

var_dl: var_decl SEMI;

const_decl
	:	'static'? 'final' bkoolType IDENTIFIER '=' exp
	;

const_dl
	:	const_decl ';'
	;

constructor_decl
    :   IDENTIFIER LBRAC parlist? RBRAC body
    ;

idlist: IDENTIFIER (COMMA IDENTIFIER)* ;

func_decl: bkoolType IDENTIFIER LBRAC parlist? RBRAC body ;

bkoolType
	:	classType
	|	arrayType
	|	primitiveType
	;


arrayType: 
	(classType | primitiveType) '['INTLIT']'
	;
classType: IDENTIFIER;

primitiveType: INTTYPE | FLOATTYPE ;

parlist: var_decl (SEMI var_decl)* ;

body: LPAREN mem* RPAREN ;

mem: var_dl | const_dl | stmt ;

stmt
	:	assign
	|	exp
	|	'if' exp 'then' stmt ('else' stmt)?
	| 	'while' exp 'do' stmt
	|	'break' ';'
	|	'continue' ';'
	|	'return' exp? ';'
	;

assign: IDENTIFIER ASSIGN exp SEMI ;

call: IDENTIFIER LBRAC explist? RBRAC SEMI ;

explist: exp (COMMA exp)* ;

exp: term moreterm* ;

moreterm: (ADD | SUB) term;

term: fact morefact*;

morefact: (MUL | DIV) fact;

fact: IDENTIFIER (LBRAC explist? RBRAC)? | INTLIT  | FLOATLIT | LBRAC exp RBRAC ;

// student for Lexer start from here
//Keywords
BOOL	:	'bool';
BREAK	:	'break';
CLASS	:	'class';
CONTINUE:	'continue';
DO		:	'do';
ELSE	:	'else';
EXTENDS	:	'extends';
IF		:	'if';
NEW		:	'new';
STRING	:	'string';
THEN	:	'then';
WHILE	:	'while';
RETURN	:	'return';
TRUE	:	'true';
FALSE	:	'false';
VOID	:	'void';
NULL	:	'null';
SELF	:	'self';
FINAL	:	'final';
STATIC	:	'static';

fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits ExponentPart?
	|	Digits ExponentPart
	|	Digits '.' Digits?
	;
fragment
Digits
	:	Digit Digit*
	;
fragment
Digit
	:	'0'
	| NonZeroDigit
	;
fragment
NonZeroDigit
	:	[1-9]
	;
fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;
fragment
ExponentIndicator
	:	[eE]
	;
fragment
SignedInteger
	:	Sign? Digits
	;
fragment
Sign
	:	[+-]
	;

//Separators
SEMI: ';';
COMMA: ',';
LBRAC: '(';
RBRAC: ')';
LPAREN: '{';
RPAREN: '}';
LBRACK		: '[';
RBRACK		: ']';
DOT			: '.';
COLON		: ':';

//Operators
ASSIGN: ':=';
CONSTANTDECLARATION: '=';
GT			: '>';
LT			: '<';
BANG		: '!';
EQUAL		: '++';
LE			: '<=';
GE			: '>=';
NOTEQUAL	: '<>';
AND			: '&&';
OR			: '||';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
INTDIV 		: '\\';
CARET		: '^';
MOD			: '%';

INTTYPE: 'integer';
FLOATTYPE: 'float';
FLOATLIT: DecimalFloatingPointLiteral;
INTLIT: [0-9]+;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

// Whitespace and comments
WS	: [ \t\r\f\n]+ -> skip;
COMMENT: '(*' .*? '*)' -> skip;
LINE_COMMENT
	:	'#' ~[\r\n]* -> skip
	;
	
UNCLOSE_STRING: '\"'  {System.out.print("There is an unclosed string.");};
