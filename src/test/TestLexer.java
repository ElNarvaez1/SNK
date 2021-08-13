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
import lexico.Lexer;

/**
 *
 * @author Alexis Narvaez Ruiz
 *
 * Esta clase, sirve para saber si las cosas que escribirmos, coinciden con las
 * expresiones regulares escrtas en el archivo "Lexer.flex".
 *
 * Se debe señalar que el archivo "Lexer.flex", es de tipo "Tokens" (el
 * enumeroda del paquete "elmentos"), es importante saber esto ya que al ser de
 * ese tipo, nos permitira recuperar los tokens y los lexemas que existan en
 * nuestro archivo de prueba.
 *
 * ¡¡CUIDADO!! el archivo "lexer.flex" Nos permite recuperar los "tokens", en
 * caso que los necesitemos, en cambio el archivo "LexerCup.flex" nos permite
 * recuperar Simbolos.
 */
public class TestLexer {

    public static void main(String[] args) {
        String rutaArchivo = "src/codigos/code.txt";
        FileReader fileReader;//Archivo a leer.

        try {
            fileReader = new FileReader(rutaArchivo);
            BufferedReader lector = new BufferedReader(fileReader);
            Lexer lexer = new Lexer(lector);
            //Este objeto(lexer) es el que nos permite
            //recuperar los tokens
            Tokens token = null;
            System.out.println("Tabla de tokens");
            
            while (true) {
                token = lexer.yylex(); //Extraemos el token detectado.
                if (token == null) {
                    break;
                }
                System.out.printf("Lexema: %-8s | Token: %-15s | Descripcion: %-15s \n",
                        lexer.lexeme, token, token.getDescripcion());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestLexer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.err.println("Ocurrio un problema.");
            //Logger.getLogger(TestLexer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
