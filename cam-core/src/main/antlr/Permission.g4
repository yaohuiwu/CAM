/*
Permission Expression Language

Description: A recognizer for permission of authorization, which compatable with hql or sql grammar.
Version : 1.0
Author: Yaohui Wu

Examples:
1. example
    create : User : org_id = 100 and ( age > 18 or height > 1.75) and name = '中 文'
2. 查看子孙机构的所有文档
    VIEW : com.pekall.mdm.document.model.MdmDocumentInfo : orgId in ( select descendantCode from MdmOrgTreePath where ancestorCode = ${user.orgId} and ancestorCode != descendantCode)
3. 查看祖先机构的所有文档
    VIEW : com.pekall.mdm.document.model.MdmDocumentInfo : orgId in ( select ancestorCode from MdmOrgTreePath where descendantCode = ${user.orgId} and ancestorCode != descendantCode)
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

idAlias : ID ( 'as' ID )? ;

//SQL where clause like condition
condition
        : ID op=('>' | '>=' | '=' | '!=' | '<' | '<=' | 'like') value			#compExpr
        | ID 'in' '(' list ')'	                        #inExpr
        | condition  'and' condition	                            #andExpr
        | condition  'or' condition		                            #orExpr
        | '(' condition ')'			                                #parentExpr
        ;
// 列表（字面，子查询）
list : literalList | queryList ;

literalList : value (','value)* ;

queryList : 'select' idAlias 'from' idAlias 'where' condition ;

value
	: ID // 如果是ID类型，则必须能在对象类型中找到相关属性
	| scalarVariable
	| STRING
	| INT
	| FLOAT
	| boo=( 'true' | 'false')
	| NULL
	;

// 变量
scalarVariable : '${' innerObject '.' ID '}';

innerObject : 'user' ;

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
NULL:'null';

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
