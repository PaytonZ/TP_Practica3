package entradaDeDatos;

import interfaceMain.InterfaceEjecuta;

import java.io.*;

/**
 * 
 * Esta clase se encarga de leer por teclado sin interrupcion y devolver un
 * string para ser usado por otra clase.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */
public class EntradaTeclado {

    BufferedReader lectura;

    public EntradaTeclado() {

    }

    public EntradaTeclado(BufferedReader nuevo_origen_de_lectura) {
	lectura = nuevo_origen_de_lectura;
    }

    /**
     * Mediante un BufferReader cualquiera , lee (si están disponibles // no
     * realiza espera activa ) una cadena y la devuelve.
     * 
     * @return Salida La cadena leída o NINGUNA si no ha leido nada.
     */
    public String leer() {
	String Salida = "NINGUNA";

	try {

	    if (lectura.ready()) {
		char[] buffer_de_lectura = new char[100];
		lectura.read(buffer_de_lectura);

		Salida = new String(buffer_de_lectura);

	    }
	} catch (IOException e) {

	    e.printStackTrace();
	} finally {

	}
	return Salida;
    }

}
