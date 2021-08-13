/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author Alexis Narvaez Ruiz
 */
public class RowET {

    private String lexema;
    private int fila;
    private int columna;
    private String descripcion;

    public RowET(String lexema, int fila, int columna, String descripcion) {
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        String s = String.format("Lexema: %-10s | Fila: %-10s | Columna: %-10s | Descripcion: %-10s", lexema, fila, columna, descripcion);
        return s;
    }
}
