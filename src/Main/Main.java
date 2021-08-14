/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import sintaxis.Syntax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lexico.LexerCup;
import tabla.TablaSimbolos;
import test.TestLexerCup;

/**
 *
 * @author Alexis Narvaez Ruiz
 *
 * Imprimir tabla de simbolos.
 *
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
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

            sintaxis.parse();//El metodo evalua todo de golpe
            System.out.println("Analisis Correcto.");

            TablaSimbolos tablaSimbolos = sintaxis.getSymbolTable();
            /*
                El metodo "getSymbolTable" esta definido dentro del 
                bloque "parser code" del archivo -Syntax.cup-
             */
            System.out.println("TABLA DE SIMBOLOS...");
            //Impirada en este video :https://youtu.be/eB_n44tTjAw
            tablaSimbolos.imprimir();
            /*
                Aun falta pulir la tabla de smbolos
                pero, ya tenemos la base de lo que se necesita
            */

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestLexerCup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.err.println("Algo salio mal.");
            System.err.printf("Simbilo: %-10s | Linea: %-10s \n",
                    sintaxis.getS().value.toString(), sintaxis.getS().right + 1);
            //Logger.getLogger(TestLexerCup.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("----------------------------------------");
       // sintaxis.getErrorTable().forEach(e->System.out.println(e));
    }
}
