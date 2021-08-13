/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import jflex.exceptions.SilentExit;

/**
 *
 * @author Alexis Narvaez Ruiz
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String jflexPath = "src/lexico/lexer.flex";
        String jflexPath2 = "src/lexico/lexerCup.flex";
        String jCup = "src/sintaxis/Syntax.cup";
        String[] intrucciones =new String[]{
                "-parser",
                "Syntax",
                jCup};
        generador(jflexPath,jflexPath2,intrucciones);
        
    }
    public static void generador(String path1,String path2,String[] inst) {
        
        try {
            jflex.Main.generate(
                    new String[]{path1}
            );
            
            jflex.Main.generate(
                    new String[]{path2}
            );
            
            java_cup.Main.main(inst);
            
            Path archivoReal = Paths.get("src/sintaxis/sym.java");
            if(Files.exists(archivoReal)){
                Files.delete(archivoReal);
            }
            Files.move(
                        Paths.get("sym.java"), 
                        Paths.get("src/sintaxis/sym.java")
            );
            
            Path archivoReal2 = Paths.get("src/sintaxis/Syntax.java");
            if(Files.exists(archivoReal2)){
                Files.delete(archivoReal2);
            }
            Files.move(
                        Paths.get("Syntax.java"), 
                        Paths.get("src/sintaxis/Syntax.java")
            );
            
        } catch (SilentExit ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
