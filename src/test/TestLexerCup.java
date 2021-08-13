/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import elementos.Tokens;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lexico.LexerCup;
import sintaxis.Syntax;

/**
 *
 * @author Alexis Narvaez Ruiz
 *
 * Esta clase, sirve para saber si las cosas que escribirmos, coinciden con las
 * expresiones regulares escritas en el archivo "LexerCup.flex".
 *
 * Ademas probara la reglas de produccion de la gramatica libre de contexto
 * escritas en el archivo "Syntax.cup"
 *
 * Se debe señalar que el archivo "LexerCup.flex", es de tipo "Symbol" ( ver la
 * linea 6 del archivo "LexerCup.flex"
 *
 * --| %type java_cup.runtime.Symbol |---
 *
 * ), es importante saber esto ya que al ser de ese tipo, nos permitira crear un
 * Objeto que -Hereda- de la clase "java_cup.runtime.Scanner", que este nos
 * srive para crear un objeto de la Clase "Syntax.java" que lo necesita para
 * comprobar la gramatica libre de contexto.
 *
 * ¡¡CUIDADO!! el archivo "lexer.flex" Nos permite recuperar los "tokens", en
 * caso que los necesitemos, en cambio el archivo "LexerCup.flex" nos permite
 * recuperar Simbolos.
 */
public class TestLexerCup {

    public static void main(String[] args) {
        String rutaCodigo = "src/codigos/code2.txt";
        FileReader fileReader;//Archivo a leer.
        Syntax sintaxis = null;
        try {
            fileReader = new FileReader(rutaCodigo);
            BufferedReader lector = new BufferedReader(fileReader);
            LexerCup lexerCup = new LexerCup(lector);
            //Este objeto(lexerCup) es el que nos permite
            //recuperar el Simbolo,fila, columna y ...
            sintaxis = new Syntax(lexerCup);
            //sintaxis -> es el objeto que evaluara las 
            //reglas de construccion de la gramatica libre de contexto.
            
            sintaxis.parse();//El metodo evalua todos de golpe
            System.out.println("Analisis Correcto.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestLexerCup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
                System.err.println("Algo salio mal.");
                System.err.printf("Simbilo: %-10s | Linea: %-10s \n",
                                sintaxis.getS().value.toString(),sintaxis.getS().right+1);
                //Logger.getLogger(TestLexerCup.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
