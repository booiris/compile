grammar temp;

// 文法分析入口

translationUnit:
	externalDeclaration
	| translationUnit externalDeclaration;

externalDeclaration: functionDeﬁnition | declaration;

functionDeﬁnition:
	declarationSpecifiers declarator compoundStatement;

// 声明 类

declaration: declarationSpecifiers init_declarator? ';';

init_declarator: declarator | declarator '=' assignmentExpression;

declarationSpecifiers: 'int';

declarator:
	ID
	| declarator '[' assignmentExpression? ']'
	| declarator '(' parameter_type_list? ')';

parameter_type_list: parameter_list | parameter_list ',' '...';

parameter_list:
	parameter_declaration
	| parameter_list ',' parameter_declaration;

parameter_declaration: declarationSpecifiers declarator;

// statement 类

compoundStatement: '{' block_item_list? '}';

block_item_list: block_item | block_item_list block_item;

block_item: declaration | statement;

expressionStatament: expression ';';

iterationStatement:
	'for' '(' expression? ';' expression? ';' expression? ')' statement
	| 'for' '(' declaration expression? ';' expression? ')' statement;

jumpStatement:
	'continue' ';'
	| 'break' ';'
	| 'return' expression?;

selectionStatement:
	'if' '(' expression ')' statement ('else' statement)?;

statement:
	selectionStatement
	| compoundStatement
	| expressionStatament
	| iterationStatement
	| jumpStatement;

// Expression 类

primaryExpression:
	ID
	| INT
	| CHAR
	| STRING
	| '(' expression ')';

postfixExpression:
	primaryExpression
	| postfixExpression '[' expression ']'
	| postfixExpression '(' argument_expression_list? ')'
	| postfixExpression '++';

argument_expression_list:
	assignmentExpression
	| argument_expression_list ',' assignmentExpression;

additiveExpression:
	postfixExpression
	| additiveExpression '+' postfixExpression
	| additiveExpression '-' postfixExpression;

relationExpression:
	additiveExpression
	| relationExpression '<' additiveExpression
	| relationExpression '<=' additiveExpression
	| relationExpression '>' additiveExpression
	| relationExpression '>=' additiveExpression;

assignmentExpression:
	relationExpression
	| postfixExpression assignmentOperator assignmentExpression;

assignmentOperator: '=';

expression:
	assignmentExpression
	| expression ',' assignmentExpression;

// 符号类

ID: ('a' ..'z' | 'A' ..'Z' | '_') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '_'
	)*;

INT: '0' ..'9'+;

STRING: '"' ( ESC_SEQ | ~('\\' | '"'))* '"';

CHAR: '\'' ( ESC_SEQ | ~('\'' | '\\')) '\'';

fragment ESC_SEQ:
	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\');