/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Alexis Narvaez Ruiz
 */
public class TablaSimbolos {

    private final HashMap<String, RowTS> tabla;

    public TablaSimbolos() {
        this.tabla = new HashMap<String, RowTS>();

    }

    public void addSimbolo(String identificador, RowTS fila) {
        try {
            
            RowTS temp = tabla.put(identificador, fila);
            if(temp != null){
                System.out.println("Repetido: "+fila);
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el simbolo");
        }
    }

    
    public RowTS buscarSimbolo(String identificador) {
        RowTS retorno = tabla.get(identificador);
        if (retorno != null) {
            return retorno;
        }
        return null;
    }

    public void imprimir() {
        Iterator it = tabla.values().iterator();
        while (it.hasNext()) {
            RowTS s = (RowTS) it.next();
            System.out.println(s.toString());
        }
    }
    public int size(){
        return tabla.size();
    }

}
