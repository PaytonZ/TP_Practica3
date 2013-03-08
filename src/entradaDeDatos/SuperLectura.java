package entradaDeDatos;

import java.io.*;
/**
 * 
 * Esta clase genera las referencias de tipo BufferStream de la forma más general posible , haciendo posible que sea reutilizable para futuros usos.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class SuperLectura {
    BufferedReader lectura;
    public SuperLectura() {
	lectura = new BufferedReader(new InputStreamReader(new BufferedInputStream(new DataInputStream(System.in))));
	    
    }

    /**
     *      * Devuelve un BufferReader que usa la entrada estándar del sistema con todos los métodos utilizables posibles 
     * @return Una referencia a un BufferReader con la descripción anterior
    */
    public  void CrearLectorPorTeclado() {

	}
    /**
     * /** Devuelve un BufferReader que usa la entrada un fichero dado por paramétro con todos los métodos utilizables posibles 
     * @param Fichero El fichero a abrir 
     * @return Una referencia a un BufferReader con la descripción anterior
     */
    public static BufferedReader CrearLectorPorFichero(String Fichero) {
	BufferedReader Lector = null;
	try {
	    Lector = new BufferedReader(new InputStreamReader(
		    new BufferedInputStream(new FileInputStream(Fichero))));
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return Lector;
    }
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
