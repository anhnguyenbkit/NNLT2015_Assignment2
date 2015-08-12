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

program: decl+ EOF;

decl: CLASS IDENTIFIER '{' '}' ;

var_decl: mctype idlist ;

var_dl: var_decl SEMI;

idlist: IDENTIFIER (COMMA IDENTIFIER)* ;

func_decl: mctype IDENTIFIER LBRAC parlist? RBRAC body ;

mctype: INTTYPE | FLOATTYPE ;

parlist: var_decl (SEMI var_decl)* ;

body: LPAREN mem* RPAREN ;

mem: var_dl | stmt ;

stmt: assign | call ;

assign: IDENTIFIER ASSIGN exp SEMI ;

call: IDENTIFIER LBRAC explist? RBRAC SEMI ;

explist: exp (COMMA exp)* ;

exp: term moreterm* ;

moreterm: (ADD | SUB) term;

term: fact morefact*;

morefact: (MUL | DIV) fact;

fact: IDENTIFIER (LBRAC explist? RBRAC)? | INTLIT  | FLOATLIT | LBRAC exp RBRAC ;

SEMI: ';';
ASSIGN: '=';
COMMA: ',';
LBRAC: '(';
RBRAC: ')';
LPAREN: '{';
RPAREN: '}';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
INTTYPE: 'int';
FLOATTYPE: 'float';
FLOATLIT: [0-9]+'.'[0-9]+;
INTLIT: [0-9]+;
IDENTIFIER: [a-z]+;
CLASS: 'class';
WS: [ \t\r\n] -> skip;

