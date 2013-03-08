package entradaDeDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**TODO:
 * Juan: Las entradas deberían estar centralizadas y no deberia haber más de una. Aprovecha el "SuperLector" y haz los cambios pertinentes para que solo tengamos un lector.
 * 
 */


/**
 * esta clase es capaz de devolver los datos de un fichero, en un array de
 * enteros.
 * 
 * @author juancly
 * 
 */
public class EntradaFichero {

    /**
     * dado un fichero, este se convierte a tokens, y estos son devueltos en un
     * array de enteros
     * 
     * @param fichero
     * @return
     */

    public double[] convertirAArrayFichero(String fichero,String delimitadores) {

	return devuelveMatrizDeStringTokenizer(cargarFicheroEnStringTokenizer(fichero,delimitadores));

    }

    /**
     * devuelve un array de enteros dado un texto con tokens
     * 
     * @param textoConTokens
     * @return
     */
    private double[] devuelveMatrizDeStringTokenizer(StringTokenizer textoConTokens) {
	double[] array = new double[textoConTokens.countTokens()];
	int i = 0;
	while (textoConTokens.hasMoreElements()) {
	    array[i] = Integer.parseInt(textoConTokens.nextToken());
	    i++;

	}
	return array;
    }

    public StringTokenizer cargarFicheroEnStringTokenizer(String fichero,String delimitadores) {

	String contenidoficherocontokens = new String();

	if (fichero != null) {
	    BufferedReader bufferdelectura;
	    try {
		bufferdelectura = new BufferedReader(new FileReader(fichero));
		while (bufferdelectura.ready()) {

		    contenidoficherocontokens += bufferdelectura.readLine();
		}
	    } catch (FileNotFoundException e) {
		System.err.println(e + "\nArchivo no encontrado."
			+ "Escriba el nuevo nombre de archivo y por área.");

	    } catch (IOException e) {
		System.err.println(e
			+ "\nError de hardware durante la lectura."
			+ "Introduzca el nuevo nombre de archivo y por área.");
	    }
	}

	return new StringTokenizer(contenidoficherocontokens, delimitadores);
    }
}
