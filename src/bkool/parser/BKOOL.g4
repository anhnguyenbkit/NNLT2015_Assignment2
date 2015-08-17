/*
 * student ID: 1570007
 */

grammar BKOOL;

@lexer::header{
}
//
@parser::header{
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

//stmt
//	:	assign
//	|	exp
//	|	'if' exp 'then' stmt ('else' stmt)?
//	| 	'while' exp 'do' stmt
//	|	'break' ';'
//	|	'continue' ';'
//	|	'return' exp? ';'
//	;
stmt
	: 	block_stat
	|	assign_statement
	|	if_Statement
	|	while_Statement
	|	break_statement
	|	continue_statement
	|	return_statement
	|	method_statement
	;
block_stat: LPAREN (const_decl | var_decl | stmt)* RPAREN;// {block of statements}
assign_statement: ( memberaccess| array | IDENTIFIER )':=' exp ';';
if_Statement: ('if' exp 'then') stmt ('else' stmt)? ;
while_Statement: ('while' exp 'do') stmt; 
break_statement: 'break' ';';
continue_statement:'continue' ';' ;
return_statement: 'return' exp ';';
method_statement: method_statement1|method_2;
method_statement1: exp '.' IDENTIFIER '(' expBlock ')'';' ; //instance...(array|ID|'self') ('.' ID '(') expBlock ')'';' 
method_2:  IDENTIFIER '.' IDENTIFIER '(' expBlock ')' ';';//static...'new' ID '(' expBlock ')' '.' ID '(' expBlock ')

memberaccess: (IDENTIFIER | exp) ('.' IDENTIFIER); //could change expr -> self?

array: exp ('[' exp']');// could change 1st expr to ID?

assign: IDENTIFIER ASSIGN exp SEMI ;

call: IDENTIFIER LBRAC explist? RBRAC SEMI ;

explist: exp (COMMA exp)* ;

//morefact: (MUL | DIV) fact;
exp: term moreterm*;
moreterm:  ('<'|'>'|'<='|'>=') term;
term:	term1 moreterm1*;
moreterm1: ('<>'|'==') term1;
term1: term2 moreterm2*;
moreterm2: ('&&'|'||') term2;
term2: term3 moreterm3*;
moreterm3: ('+'|'-') term3;
term3: term4 moreterm4*;
moreterm4: ('*'|'/'|'\\'|'%') term4;
term4: term5 moreterm5*;
moreterm5: ('^') term5;
term5: moreterm6* term6;
moreterm6: '!'term6;
term6: moreterm7* term7;
moreterm7: ('+'|'-') term7;
term7: term8 moreterm8*;
moreterm8: '[' exp ']' term8;
term8: term9 moreterm9*;
moreterm9: (DOT IDENTIFIER) (LBRAC expBlock RBRAC)? term9;
term9:  morefact* fact;
morefact: NEW IDENTIFIER LBRAC expBlock RBRAC fact;
fact: (LBRAC exp RBRAC)|IDENTIFIER|BOOLEANIT|INTLIT|FLOATLIT|STRINGIT|'null'|'self';
expBlock: (exp (',' exp)*)?;

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

//string literal
STRINGIT:  '\"' StringElement* '\"';

fragment StringElement    :  '\u0020'| '\u0021'|'\u0023' .. '\u005B' | '\u005D'..'\u007E' // (PrintableChar  Except '"' and '\')
                          |  CharEscapeSeq;
fragment CharEscapeSeq    : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\\');

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
BOOLEANIT: 'true' | 'false';
// Whitespace and comments
WS	: [ \t\r\f\n]+ -> skip;
COMMENT: '(*' .*? '*)' -> skip;
LINE_COMMENT
	:	'#' ~[\r\n]* -> skip
	;
	
UNCLOSE_STRING: '\"'  {System.out.print("There is an unclosed string.");};
