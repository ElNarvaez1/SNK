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
public enum Tokens {
    PUBLIC("PUBLICO"), CLASS("CLASE"),
    THIS("OBJETO MISMO"), RETURN("RETORNO"),
    VOID("VACIO"), INT("ENTERO"),
    FLOAT("PUNTO FLOTANTE"), IF("CONDICIONAL"),
    ELSE("CONDICION FALSO"), WHILE("MIENTRAS"),
    RESERVADAS("RESERVADA"), IGUAL("ASIGNACION"),
    SUMA("SUMA"), RESTA("RESTA"),
    MULTIPLICACION("MULTIPLICACION"), DIVISION("DIVISION"),
    IDENTIFICADOR("NOMBRE"), NUMERO("NUMERO"),
    PARENTESIS_A("PARENTESIS_A"), PARENTESIS_C("PARENTESIS_C"),
    MENOR_QUE("COMPARADOR LOGICO"), MAYOR_QUE("COMPARADOR LOGICO"),
    LLAVE_A("INICIO BLOQUE"), LLAVE_C("FIN BLOQUE"),
    FIN_LINEA("FIN DE LINEA"), ERROR("ERROR"),
    CONSTRUCTOR("CONSTRUCTOR"),
    METHOD("METODO");
    private String descripcion;

    private Tokens(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
