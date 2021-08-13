
Created: August 12, 2021 8:58 PM
Created By: Alexis Narvaez
Last Edited By: Alexis Narvaez
Last Edited Time: August 12, 2021 9:53 PM

# Desarrollado por:

- Narvaez Ruiz Alexis
- Silverio Ibáñez Omar
- Torres Velazco Álvaro Eduardo

# Dependencias.

- JFlex.
- JCup.
- Netbeans (IDE de darrollo)

---

# Modo de uso.

Si modificas algo de los archivos **lexerCup.flex** o **Syntaxis.cup** deberás ejecutar la clase "Generador" para poder convertir los archivos .java correspondientes.

# Palabras reservadas.

```java
public, class, this, return, void, int, float, if, else, while 
```

# Operadores.

```markdown
"=" | "+" | "-" | "*" | "/" | "(" | ")" | "{" | "}" | "<" | ">" | ";"
```

# Gramática libre de contexto.

## Terminales.

```markdown
PUBLIC, CLASS, THIS, RETURN,VOID, INT, FLOAT, IF, ELSE, WHILE, RESERVADAS, 
IGUAL, SUMA, RESTA,MULTIPLICACION, DIVISION, IDENTIFICADOR, NUMERO, 
PARENTESIS_A, PARENTESIS_C,MENOR_QUE, MAYOR_QUE,LLAVE_A, LLAVE_C,FIN_LINEA, ERROR
```

## No terminales.

```markdown
INICIO, CONSTRUCTOR,SENTENCIA, DECLARACION,METODOVOID, METODOINT, METODOFLOAT
```

## Reglas de producción.

- INICIO → PUBLIC CLASS IDENTIFICADOR LLAVE_A SENTENCIA LLAVE_C
- SENTENCIA → DECLARACION | DECLARACION SENTENCIA | CONSTRUCTOR | CONSTRUCTOR SENTENCIA | METODOVOID | METODOVOID SENTENCIA | METODOINT | METODOINT SENTENCIA | METODOFLOAT | METODOFLOAT SENTENCIA
- METODOVOID → PUBLIC VOID IDENTIFICADOR PARENTESIS_A PARENTESIS_C LLAVE_A DECLARACION LLAVE_C
- METODOINT → PUBLIC VOID IDENTIFICADOR PARENTESIS_A PARENTESIS_C LLAVE_A DECLARACION LLAVE_C
- METODOFLOAT → PUBLIC VOID IDENTIFICADOR PARENTESIS_A PARENTESIS_C LLAVE_A DECLARACION LLAVE_C
- DECLARACION  → INT IDENTIFICADOR FIN_LINEA | INT IDENTIFICADOR IGUAL NUMERO FIN_LINEA |  FLOAT IDENTIFICADOR FIN_LINEA | FLOAT  IDENTIFICADOR IGUAL NUMERO FIN_LINEA
- CONSTRUCTOR →
PUBLIC IDENTIFICADOR PARENTESIS_A PARENTESIS_C LLAVE_A DECLARACION  LLAVE_C

# Ejemplo de código de análisis.

El código que se analiza es muy similar a java.

- Declaración de una clase, esto debe ser obligatorio.

    ```jsx
    public class NombreClase{
    		//Puede llevar cualquier nombre
    }
    ```

- Ejemplo 1.

    ```jsx
    public class Clase1{
    		int atri1;
    		float atri2;
    }
    ```

- Ejemplo 2.

    ```jsx
    public class Clase2{
    		int atri1;
    		float atri2;
    		
    		public Clase2(){

    		}
    }
    ```

- Ejemplo 3.

    ```jsx
    public class Clase3{
    		int atri1;
    		float atri2;
    		
    		public Clase3(){

    		}
    		public void metodo(){
    			int variable1;
    		}
    }
    ```

# Observaciones extra ...