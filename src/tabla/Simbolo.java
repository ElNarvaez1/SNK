/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Nellyda Narvaez Ruiz
 */
public class Simbolo {

    private String nombre;
    private Stack<Campo> campos;

    public Simbolo(String nombre) {
        this(nombre, new Stack<Campo>());
    }

    public Simbolo(String nombre, Stack campos) {
        this.nombre = nombre;
        this.campos = campos;
    }

    public void addCampo(String nombre, Object value) {
        this.campos.add(new Campo(nombre, value));
    }

    public String toString(){
        String s = String.format("Lexema: %-10s", this.nombre);
        String s2 = this.campos.toString()
                        .replace("[", "")
                        .replace("]","")
                        .replace(",","");
        return s+s2;
    }
    
    class Campo {

        private String campo;
        private Object valor;

        public Campo(String campo, Object valor) {
            this.campo = campo;
            this.valor = valor;
        }

        @Override
        public String toString() {
            String s=String.format("| "+this.campo + "%-9s", valor.toString());
            return s;
        } 
    }
}
