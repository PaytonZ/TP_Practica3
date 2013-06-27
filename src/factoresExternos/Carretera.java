package factoresExternos;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

import bicicleta.Bicicleta;
import entradaDeDatos.EntradaFichero;

/**
 * esta clase crea una carretera a partir de un fichero
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */
public class Carretera {

    /**
     * @uml.property name="fichero"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private EntradaFichero fichero;
    /**
     * @uml.property name="ruta"
     */
    private String ruta;
    /**
     * @uml.property name="bici"
     * @uml.associationEnd multiplicity="(1 1)"
     *                     inverse="carretera:bicicleta.Bicicleta"
     */
    private Bicicleta bici;
    /**
     * @uml.property name="matriz"
     */
    private double[] matriz;
    /**
     * @uml.property name="arbol"
     */
    private TreeMap<Integer, Integer> arbol;

    /**
     * @uml.property name="tramo"
     */
    private int tramo;

    /**
     * recibe la direccion de la ruta en la que se encuentra el fichero de
     * carretera
     * 
     * @param miruta
     */

    public Carretera(String miruta, Bicicleta mibici) {
	ruta = miruta;
	fichero = new EntradaFichero();
	bici = mibici;
	tramo = 0;
	arbol = new TreeMap<Integer, Integer>();

    }

    /**
     * la matriz resultante es del tipo entero y su composicion es la siguiente
     * matriz[0] = metro en el que cambia la pendiente matriz[1] =pendiente que
     * ira desde 90 hasta -90
     */
    public TreeMap<Integer, Integer> getArbol() {

	return arbol;
    }



   
    
}
