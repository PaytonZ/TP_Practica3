package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import persona.Ciclista;
import constantes.Constantes;

/**
 * esta clase crea las curvasdel trazado
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Curva implements InterfaceEjecuta {

    /**
	 * @uml.property  name="arbolCurvas"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.Integer"
	 */
    private TreeMap<Integer, Integer> arbolCurvas;
    /**
	 * @uml.property  name="lista_de_ciclistas"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="persona.Ciclista"
	 */
    private ArrayList<Ciclista> lista_de_ciclistas;

    /**
     * Crea una clase curva y requiere los ciclistas afectados.
     * 
     * @param nueva_lista_de_ciclistas
     */
    public Curva(ArrayList<Ciclista> nueva_lista_de_ciclistas) {
	arbolCurvas = new TreeMap<Integer, Integer>();
	lista_de_ciclistas = nueva_lista_de_ciclistas;
    }

    @Override
    public void ejecuta() {

	/**
	 * si la hora actual, esta en nuestro mapa de vientos, asignaremos el
	 * viento a las bicicletas
	 */

	for (Ciclista c : lista_de_ciclistas) {
	    Iterator<Entry<Integer, Integer>> it = arbolCurvas.entrySet()
		    .iterator();

	    while (it.hasNext()) {
		Entry<Integer, Integer> elemento = it.next();
		double espacio_recorrido = c.getBici().getEspacioRecorrido();
		// comprobamos que llevamos una velocidad adecuada a la curva en
		// su
		// distancia de frenado, para asi reducirla y conseguir una
		// velocidad
		// adecuada
		if (espacio_recorrido >= elemento.getKey()
			- Constantes.DISTANCIA_FRENADO
			&& espacio_recorrido < elemento.getKey()) {
		    // si la velocidad es mayor que la de la curva, la reducimos
		    if (c.getBici().getVelocidad() > elemento.getValue()) {
			// c.getBici().setVelocidad(elemento.getValue());
			c.setMuerto(true);
		    }
		}
	    }
	}

    }

    public TreeMap<Integer, Integer> getArbolCurvas() {
	return arbolCurvas;
    }

    /**
     * Añade una curva al mapa de curvas
     * 
     * @param PK
     *            El punto kilometrico
     * @param velocidadMax
     *            Velocidad maxima a la que puede atravesar.
     */
    public void setCurva(int PK, int velocidadMax) {
	arbolCurvas.put(PK, velocidadMax);

    }
}