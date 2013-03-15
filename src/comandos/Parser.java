package comandos;

import interfaceMain.InterfaceEjecuta;

import java.util.StringTokenizer;
import java.util.Vector;

import vista.Ventana;
import entradaDeDatos.SuperLectura;

/**
 * 
 * Esta clase convierte los strings que se le introduce como mensaje en órdenes
 * que el sistema pueda entender.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Parser {

    // sirve para indicar el numero de ciclista al que va destinada la accion
    private String parametro;

    private SuperLectura lectura;
    private InterfazInstruccion instruccion;
    private Vector<Object> vector;
    Ventana ventana;

    public Parser(Vector<Object> mivector) {

	// lectura=input;
	lectura = new SuperLectura();
	vector = mivector;

    }

    /**
     * Este metodo, formatea una entrada de teclado en ordenes capaces de ser
     * entendidas El formato de los comandos es el siguiente: comando parametro
     * donde comando es una instruccion creada en el sistema y el parametro se
     * refiere al numero de ciclista al que va destinada esa orden
     * 
     * @param comando
     * @return
     */
    public InterfazInstruccion dameComando(String comando) {

	// partimos la cadena si hay retornos de carro o espacios
	StringTokenizer comandos = new StringTokenizer(comando, "\n\r ");

	/**
	 * si no se introduce nada, entonces solo tenemos un token, por lo cual
	 * es necesario crear este try, para poder coger el siguiente token, si
	 * este existe
	 */
	try {
	    // guardamos la primera parte de la cadena
	    comando = comandos.nextToken();
	    parametro = "";
	    parametro = comandos.nextToken();
	} catch (Exception e) {

	}

	return Comandos.existe(comando).getInstruccion();
    }

    /**
     * metodo heredado de la interfazEjecuta el cual se ejecuta en el for each
     * del principal.
     */
    public void ejecuta(InterfazInstruccion instruccion) {

	// instruccion = dameComando(ventana.dameInstruccion());

	/**
	 * Este try sirve para que no rompa el programa, ya que el parametro al
	 * empezar no tiene valor solo se ejeutara el comando si el parametro es
	 * un numero y este es un indice de la lista de objetos
	 */
	try {
	    if (Integer.parseInt(parametro) >= 0) {
		instruccion.execute(vector.elementAt(Integer
			.parseInt(parametro)));
	    }
	}// TODO Excepciones para indicar que el comando es erroneo????!!!????
	 //
	catch (Exception e) {

	}

    }
    public void setInstruccion(String ins)
    {
	
    	instruccion = dameComando(ins);
    	ejecuta(instruccion);
    }

}