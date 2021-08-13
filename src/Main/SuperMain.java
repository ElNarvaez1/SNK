/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import elementos.RowTS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis Narvaez Ruiz
 */
public class SuperMain {

    /*
        Clase que generar los archivo de semantica y de sintaxis 
        hara ambos
     */
    public static void main(String[] args) {
        List<RowTS> lista=new ArrayList<>();
        
        
        try {
            Generador.main(null);
            Main.main(null);
        } catch (IOException ex) {
            Logger.getLogger(SuperMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
