/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import elementos.RowET;
import elementos.RowTS;
import sintaxis.Syntax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lexico.LexerCup;
import test.TestLexerCup;

/**
 *
 * @author Alexis Narvaez Ruiz
 *
 * Imprimir tabla de Errores.
 *
 *
 */
public class Main2 {

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

            List<RowTS> tablaSimbolos = sintaxis.getSymbolTable();
            /*
                El metodo "getSymbolTable" esta definido dentro del 
                bloque "parser code" del archivo -Syntax.cup-
            
                Aun falta pulir la tabla de smbolos
                pero, ya tenemos la base de lo que se necesita
             */
//            System.out.println("TABLA DE ERRORES...");
//            List<RowET> tablaErrores = new ArrayList<>();
//
//            
//            for (int i = 0; i < tablaSimbolos.size(); i++) {
//                RowTS get = tablaSimbolos.get(i);
//                for (int j = 0; j < tablaSimbolos.size(); j++) {
//                    RowTS get1 = tablaSimbolos.get(j);
//                    if(i!=j){
//                        if(get.equals(get1)){
//                            RowET error = new RowET(get.getLexema(), i+1, 0, "Ya fue declarada una vez.");
//                            tablaErrores.add(error);
//                        }
//                    }
//                }
//            }
//            
//            //Imprimimos la tabla de errores
//            for (RowET filaError : tablaErrores) {
//                System.out.println(filaError);
//            }
//            
            
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestLexerCup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.err.println("Algo salio mal.");
            sintaxis.getErrorTable().forEach(row -> {
                System.out.println(row);
            });
//            System.err.printf("Simbilo: %-10s | Linea: %-10s \n",
//                    sintaxis.getS().value.toString(), sintaxis.getS().right + 1);
            //Logger.getLogger(TestLexerCup.class.getName()).log(Level.SEVERE, null, ex);
        }
        sintaxis.getErrorTable().forEach(row -> {
                System.out.println(row);
        });
    }
}
