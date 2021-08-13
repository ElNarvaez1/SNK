package lexico;
import java_cup.runtime.Symbol;
import sintaxis.sym;
%%
%class LexerCup
%public
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type,Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }
    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }
%}
%%
public {return new Symbol(sym.PUBLIC,(int)yychar,yyline,yytext());}
class {return new Symbol(sym.CLASS,(int)yychar,yyline,yytext());}
this {return new Symbol(sym.THIS,(int)yychar,yyline,yytext());}
return {return new Symbol(sym.RETURN,(int)yychar,yyline,yytext());}
void {return new Symbol(sym.VOID,(int)yychar,yyline,yytext());}
int {return new Symbol(sym.INT,(int)yychar,yyline,yytext());}
float {return new Symbol(sym.FLOAT,(int)yychar,yyline,yytext());}
if {return new Symbol(sym.IF,(int)yychar,yyline,yytext());}
else {return new Symbol(sym.ELSE,(int)yychar,yyline,yytext());}
while {return new Symbol(sym.WHILE,(int)yychar,yyline,yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return new Symbol(sym.IGUAL,(int)yychar,yyline,yytext());}
"+" {return new Symbol(sym.SUMA,(int)yychar,yyline,yytext());}
"-" {return new Symbol(sym.RESTA,(int)yychar,yyline,yytext());}
"*" {return new Symbol(sym.MULTIPLICACION,(int)yychar,yyline,yytext());}
"/" {return new Symbol(sym.DIVISION,(int)yychar,yyline,yytext());}
"(" {return new Symbol(sym.PARENTESIS_A,(int)yychar,yyline,yytext());}
")" {return new Symbol(sym.PARENTESIS_C,(int)yychar,yyline,yytext());}
"{" {return new Symbol(sym.LLAVE_A,(int)yychar,yyline,yytext());}
"}" {return new Symbol(sym.LLAVE_C,(int)yychar,yyline,yytext());}
"<" {return new Symbol(sym.MENOR_QUE,(int)yychar,yyline,yytext());}
">" {return new Symbol(sym.MAYOR_QUE,(int)yychar,yyline,yytext());}
";" {return new Symbol(sym.FIN_LINEA,(int)yychar,yyline,yytext());}
{L}({L}|{D})* {return new Symbol(sym.IDENTIFICADOR,(int)yychar,yyline,yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.NUMERO,(int)yychar,yyline,yytext());}
 . {return new Symbol(sym.ERROR,(int)yychar,yyline,yytext());}

