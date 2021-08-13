package lexico;
import elementos.Tokens;
import static elementos.Tokens.*;

%%
%class Lexer
%public
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

public {lexeme=yytext(); return PUBLIC;}
class {lexeme=yytext(); return CLASS;}
this {lexeme=yytext(); return THIS;}
return {lexeme=yytext(); return RETURN;}
void {lexeme=yytext(); return VOID;}
int {lexeme=yytext(); return INT;}
float {lexeme=yytext(); return FLOAT;}
if {lexeme=yytext(); return IF;}
else {lexeme=yytext(); return ELSE;}
while {lexeme=yytext(); return WHILE;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {lexeme=yytext(); return IGUAL;}
"+" {lexeme=yytext(); return SUMA;}
"-" {lexeme=yytext(); return RESTA;}
"*" {lexeme=yytext(); return MULTIPLICACION;}
"/" {lexeme=yytext(); return DIVISION;}
"(" {lexeme=yytext(); return PARENTESIS_A;}
")" {lexeme=yytext(); return PARENTESIS_C;}
"{" {lexeme=yytext(); return LLAVE_A;}
"}" {lexeme=yytext(); return LLAVE_C;}
"<" {lexeme=yytext(); return MENOR_QUE;}
">" {lexeme=yytext(); return MAYOR_QUE;}
";" {lexeme=yytext(); return FIN_LINEA;}
{L}({L}|{D})* {lexeme=yytext(); return IDENTIFICADOR;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}
 . {return ERROR;}