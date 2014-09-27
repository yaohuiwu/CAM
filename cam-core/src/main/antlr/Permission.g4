/*
Permission Expression Language

Description: A recognizer for permission of authorization, which compatable with hql or sql grammar.
Version : 1.0
Author: Yaohui Wu

Examples:
    create : User : org_id = 100 and ( age > 18 or height > 1.75) and name = '中 文'
*/
grammar Permission ;

permission : action ':' objectType ':' criteria;

action
       : ID
       | STAR
       ;
//action :  'create' | 'delete' | 'update' | 'view';

//full class name
objectType
        : ID ( '.' ID )*
        | STAR
        ;

criteria
        : condition
        | STAR
        ;

//SQL where clause like condition
condition
        : ID op=('>' | '>=' | '=' | '!=' | '<' | '<=' | 'like') value			#compExpr
        | ID 'in' '(' value (','value)* ')'	                        #inExpr
        | condition  'and' condition	                            #andExpr
        | condition  'or' condition		                            #orExpr
        | '(' condition ')'			                                #parentExpr
        ;

value 
	: STRING 
	| INT 
	| FLOAT
	| boo=( 'true' | 'false')
	| 'null'
	;
STAR : '*';

GT:'>';
GE:'>=';
EQ:'=';
NE:'!=';
LT:'<';
LE:'<=';
LIKE:'like';

TRUE:'true';
FALSE:'false';

ID : ID_LETTER (ID_LETTER|DIGIT)*;

//LIKE_STRING : '\'' '%'? .*? '%'? '\'' ;
//BOOLEAN : 'true'|'false';
STRING : '\'' .*? '\'';
//borrow from json grammar
//STRING : '"' (ESC | ~["\\])* '"' ;
FLOAT:  DIGIT+ '.' DIGIT*
        | '.' DIGIT+
        ;
INT : DIGIT+;



fragment DIGIT : [0-9];
fragment ID_LETTER : 'a'..'z' | 'A'..'Z' | '_' ;

//borrow from json grammar
//fragment ESC : '\\' (["\\/bfnrt] | UNICODE) ;
//fragment UNICODE : 'u' HEX HEX HEX HEX ;
//fragment HEX : [0-9a-fA-F] ;
//fragment UNDERLINE : '_';
//fragment SQ :'\'';
//fragment PERCENT :'%';

WS : [ ]+ -> skip;
