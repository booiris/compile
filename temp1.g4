grammar temp1;

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

// 词法规则

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


Auto: 'auto';
Break: 'break';
Case: 'case';
Char: 'char';
Const: 'const';
Continue: 'continue';
Default: 'default';
Do: 'do';
Double: 'double';
Else: 'else';
Enum: 'enum';
Extern: 'extern';
Float: 'float';
For: 'for';
Goto: 'goto';
If: 'if';
Inline: 'inline';
Int: 'int';
Long: 'long';
Register: 'register';
Restrict: 'restrict';
Return: 'return';
Short: 'short';
Signed: 'signed';
Sizeof: 'sizeof';
Static: 'static';
Struct: 'struct';
Switch: 'switch';
Typedef: 'typedef';
Union: 'union';
Unsigned: 'unsigned';
Void: 'void';
Volatile: 'volatile';
While: 'while';

Alignas: '_Alignas';
Alignof: '_Alignof';
Atomic: '_Atomic';
Bool: '_Bool';
Complex: '_Complex';
Generic: '_Generic';
Imaginary: '_Imaginary';
Noreturn: '_Noreturn';
StaticAssert: '_Static_assert';
ThreadLocal: '_Thread_local';

LeftParen: '(';
RightParen: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';

Less: '<';
LessEqual: '<=';
Greater: '>';
GreaterEqual: '>=';
LeftShift: '<<';
RightShift: '>>';

Plus: '+';
PlusPlus: '++';
Minus: '-';
MinusMinus: '--';
Star: '*';
Div: '/';
Mod: '%';

And: '&';
Or: '|';
AndAnd: '&&';
OrOr: '||';
Caret: '^';
Not: '!';
Tilde: '~';

Question: '?';
Colon: ':';
Semi: ';';
Comma: ',';

Assign: '=';
// '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='
StarAssign: '*=';
DivAssign: '/=';
ModAssign: '%=';
PlusAssign: '+=';
MinusAssign: '-=';
LeftShiftAssign: '<<=';
RightShiftAssign: '>>=';
AndAssign: '&=';
XorAssign: '^=';
OrAssign: '|=';

Equal: '==';
NotEqual: '!=';

Arrow: '->';
Dot: '.';
Ellipsis: '...';

Identifier: IdentifierNondigit ( IdentifierNondigit | Digit)*;

fragment IdentifierNondigit:
	Nondigit
	| UniversalCharacterName
	; //|   // other implementation-defined characters...

fragment Nondigit: [a-zA-Z_];

fragment Digit: [0-9];

fragment UniversalCharacterName:
	'\\u' HexQuad
	| '\\U' HexQuad HexQuad;

fragment HexQuad:
	HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit;

Constant:
	IntegerConstant
	| FloatingConstant
	//|   EnumerationConstant
	| CharacterConstant;

fragment IntegerConstant:
	DecimalConstant IntegerSuffix?
	| OctalConstant IntegerSuffix?
	| HexadecimalConstant IntegerSuffix?
	| BinaryConstant;

fragment BinaryConstant: '0' [bB] [0-1]+;

fragment DecimalConstant: NonzeroDigit Digit*;

fragment OctalConstant: '0' OctalDigit*;

fragment HexadecimalConstant:
	HexadecimalPrefix HexadecimalDigit+;

fragment HexadecimalPrefix: '0' [xX];

fragment NonzeroDigit: [1-9];

fragment OctalDigit: [0-7];

fragment HexadecimalDigit: [0-9a-fA-F];

fragment IntegerSuffix:
	UnsignedSuffix LongSuffix?
	| UnsignedSuffix LongLongSuffix
	| LongSuffix UnsignedSuffix?
	| LongLongSuffix UnsignedSuffix?;

fragment UnsignedSuffix: [uU];

fragment LongSuffix: [lL];

fragment LongLongSuffix: 'll' | 'LL';

fragment FloatingConstant:
	DecimalFloatingConstant
	| HexadecimalFloatingConstant;

fragment DecimalFloatingConstant:
	FractionalConstant ExponentPart? FloatingSuffix?
	| DigitSequence ExponentPart FloatingSuffix?;

fragment HexadecimalFloatingConstant:
	HexadecimalPrefix (
		HexadecimalFractionalConstant
		| HexadecimalDigitSequence
	) BinaryExponentPart FloatingSuffix?;

fragment FractionalConstant:
	DigitSequence? '.' DigitSequence
	| DigitSequence '.';

fragment ExponentPart: [eE] Sign? DigitSequence;

fragment Sign: [+-];

DigitSequence: Digit+;

fragment HexadecimalFractionalConstant:
	HexadecimalDigitSequence? '.' HexadecimalDigitSequence
	| HexadecimalDigitSequence '.';

fragment BinaryExponentPart: [pP] Sign? DigitSequence;

fragment HexadecimalDigitSequence: HexadecimalDigit+;

fragment FloatingSuffix: [flFL];

fragment CharacterConstant:
	'\'' CCharSequence '\''
	| 'L\'' CCharSequence '\''
	| 'u\'' CCharSequence '\''
	| 'U\'' CCharSequence '\'';

fragment CCharSequence: CChar+;

fragment CChar: ~['\\\r\n] | EscapeSequence;
fragment EscapeSequence:
	SimpleEscapeSequence
	| OctalEscapeSequence
	| HexadecimalEscapeSequence
	| UniversalCharacterName;
fragment SimpleEscapeSequence: '\\' ['"?abfnrtv\\];
fragment OctalEscapeSequence:
	'\\' OctalDigit OctalDigit? OctalDigit?;
fragment HexadecimalEscapeSequence: '\\x' HexadecimalDigit+;
StringLiteral: EncodingPrefix? '"' SCharSequence? '"';
fragment EncodingPrefix: 'u8' | 'u' | 'U' | 'L';
fragment SCharSequence: SChar+;
fragment SChar:
	~["\\\r\n]
	| EscapeSequence
	| '\\\n' // Added line
	| '\\\r\n' ; // Added line

ComplexDefine: '#' Whitespace? 'define' ~[#\r\n]* -> skip;

IncludeDirective:
	'#' Whitespace? 'include' Whitespace? (
		('"' ~[\r\n]* '"')
		| ('<' ~[\r\n]* '>')
	) Whitespace? Newline -> skip;

// ignore the following asm blocks:
/*
 asm { mfspr x, 286; }
 */
AsmBlock: 'asm' ~'{'* '{' ~'}'* '}' -> skip;

// ignore the lines generated by c preprocessor sample line : '#line 1 "/home/dm/files/dk1.h" 1'
LineAfterPreprocessing: '#line' Whitespace* ~[\r\n]* -> skip;

LineDirective:
	'#' Whitespace? DecimalConstant Whitespace? StringLiteral ~[\r\n]* -> skip;

PragmaDirective:
	'#' Whitespace? 'pragma' Whitespace ~[\r\n]* -> skip;

Whitespace: [ \t]+ -> skip;

Newline: ( '\r' '\n'? | '\n') -> skip;

BlockComment: '/*' .*? '*/' -> skip;

LineComment: '//' ~[\r\n]* -> skip;