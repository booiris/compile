grammar c;

compilationUnit:
	externalDeclaration
	| compilationUnit externalDeclaration;

externalDeclaration: functionDefinition | declaration;

functionDefinition:
	declaration_specifiers declarator compound_statement;

// Expression

primary_expression:
	Identifier							# a0
	| Constant							# a1
	| StringLiteral						# a2
	| LeftParen assignment_expression RightParen	# a3;

postfix_expression:
	primary_expression													# a4
	| postfix_expression LeftBracket expression RightBracket			# a5
	| postfix_expression op = Dot Identifier							# a6
	| postfix_expression op = Arrow Identifier							# a6
	| postfix_expression op = PlusPlus									# a7
	| postfix_expression op = MinusMinus								# a7
	| postfix_expression LeftParen argument_expression_list? RightParen	# a13;

argument_expression_list:
	assignment_expression
	| argument_expression_list Comma assignment_expression;

unary_expression:
	postfix_expression													# a8
	| op = PlusPlus unary_expression									# a9
	| op = MinusMinus unary_expression									# a9
	| op = (And | Not | Tilde | Plus | Minus | Star) cast_expression	# a9
	| Sizeof unary_expression											# a9
	| Sizeof LeftParen type_name RightParen								# a10;

cast_expression:
	unary_expression
	| LeftParen type_name RightParen cast_expression;

multiplicative_expression:
	cast_expression
	| multiplicative_expression op = Star cast_expression
	| multiplicative_expression op = Div cast_expression
	| multiplicative_expression op = Mod cast_expression;

additive_expression:
	multiplicative_expression
	| additive_expression op = Plus multiplicative_expression
	| additive_expression op = Minus multiplicative_expression;

shift_expression:
	additive_expression
	| shift_expression op = LeftShift additive_expression
	| shift_expression op = RightShift additive_expression;

relational_expression:
	shift_expression
	| relational_expression op = Less shift_expression
	| relational_expression op = Greater shift_expression
	| relational_expression op = GreaterEqual shift_expression
	| relational_expression op = LessEqual shift_expression;

equality_expression:
	relational_expression
	| equality_expression op = Equal relational_expression
	| equality_expression op = NotEqual relational_expression;

logical_AND_expression:
	equality_expression
	| logical_AND_expression op = AndAnd equality_expression;

logical_OR_expression:
	logical_AND_expression
	| logical_OR_expression op = OrOr logical_AND_expression;

conditional_expression:
	logical_OR_expression
	| logical_OR_expression Question expression Colon conditional_expression;

assignment_expression:
	conditional_expression
	| unary_expression op = (
		Assign
		| StarAssign
		| DivAssign
		| ModAssign
		| PlusAssign
		| MinusAssign
		| LeftShiftAssign
		| RightShiftAssign
		| AndAssign
		| XorAssign
		| OrAssign
	) assignment_expression;

expression:
	assignment_expression
	| expression Comma assignment_expression;

constant_expression: conditional_expression;

// declarartion 类

declaration: declaration_specifiers init_declaration_list Semi;

declaration_specifiers:
	storage_class_specifier declaration_specifiers?
	| type_specifier declaration_specifiers?;

storage_class_specifier:
	Typedef
	| Extern
	| Static
	| Auto
	| Register;

type_specifier:
	Void
	| Char
	| Short
	| Int
	| Long
	| Float
	| Double
	| Signed
	| Unsigned
	| Identifier;

init_declaration_list:
	init_declarator
	| init_declaration_list Comma init_declarator;

init_declarator: declarator | declarator Assign initilizer;

declarator:
	Identifier
	| declarator LeftBracket assignment_expression? RightBracket
	| declarator LeftParen parameter_list? RightParen;

parameter_list:
	parameter_declaration
	| parameter_list Comma parameter_declaration;

parameter_declaration: declaration_specifiers declarator;

type_name: declaration_specifiers;

initilizer:
	assignment_expression
	| LeftBrace initilizer_list RightBrace;

initilizer_list: initilizer | initilizer_list Comma initilizer;

// statement 类

statement:
	compound_statement		# a20
	| expression_statement	# a21
	| selection_statement	# a22
	| For LeftParen exp1 = expression? Semi exp2 = expression? Semi exp3 = expression? RightParen
		statement																				# a23
	| For LeftParen declaration exp1 = expression? Semi exp2 = expression? RightParen statement	# a24
	| jump_statement																			# a25
	| label_statement	#a26;

label_statement: Identifier ':' statement;

compound_statement: LeftBrace block_item_list? RightBrace;

block_item_list: block_item | block_item_list block_item;

block_item: declaration | statement;

expression_statement: expression? Semi;

selection_statement:
	If LeftParen expression RightParen statement
	| If LeftParen expression RightParen statement Else statement;

jump_statement:
	Goto Identifier Semi
	| Continue Semi
	| Break Semi
	| Return expression? Semi;

// 词法分析

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

fragment IdentifierNondigit: Nondigit | UniversalCharacterName;

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
fragment SChar: ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n';

Whitespace: [ \t]+ -> skip;

Newline: ( '\r' '\n'? | '\n') -> skip;

BlockComment: '/*' .*? '*/' -> skip;

LineComment: '//' ~[\r\n]* -> skip;
