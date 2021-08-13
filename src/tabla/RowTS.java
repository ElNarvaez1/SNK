/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

import elementos.Tokens;

/**
 *
 * @author Alexis Narvaez Ruiz
 */
public class RowTS {

    private String lexema;
    private Tokens token; 
    private String ambito;
    private int direccion; 
    private String tipo;

    public RowTS(String lexema, Tokens token, String ambito, int direccion, String tipo) {
        this.lexema = (lexema != null)?lexema:"";
        this.token = token;
        this.ambito = (ambito != null)?ambito:"";
        this.direccion = direccion;
        this.tipo = (tipo != null)?tipo:"";
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public Tokens getToken() {
        return token;
    }

    public void setToken(Tokens token) {
        this.token = token;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean equals(RowTS obj) {
        boolean temp = true;
        
        temp = this.lexema.equals(obj.lexema);
        temp = temp & this.token == obj.token;
        temp = temp & this.ambito.equals(obj.ambito);
        temp = temp & this.tipo.equals(obj.tipo);
       
        return temp; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String s = String.format("Lexema: %-10s | token: %-10s | ambito: %-10s | direccion: %-10s | tipo: %-10s", lexema, token, ambito, direccion, tipo);
        return s;
    }
}
