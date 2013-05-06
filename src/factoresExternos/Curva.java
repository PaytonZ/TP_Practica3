package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

    private Map<Double, Double> mapaCurvas;
    private ArrayList<Ciclista> lista_de_ciclistas;

    /**
     * Crea una clase curva y requiere los ciclistas afectados.
     * 
     * @param nueva_lista_de_ciclistas
     */
    public Curva(ArrayList<Ciclista> nueva_lista_de_ciclistas) {
	mapaCurvas = new HashMap<Double, Double>();
	lista_de_ciclistas = nueva_lista_de_ciclistas;
    }

    /**
     * Añade una curva al mapa de curvas
     * 
     * @param PK
     *            El punto kilometrico
     * @param velocidadMax
     *            Velocidad maxima a la que puede atravesar.
     */
    public void setCurva(double PK, double velocidadMax) {
	mapaCurvas.put(PK, velocidadMax);

    }

    @Override
    public void ejecuta() {

	/**
	 * si la hora actual, esta en nuestro mapa de vientos, asignaremos el
	 * viento a las bicicletas
	 */

	for (Ciclista c : lista_de_ciclistas) {
	    Iterator<Entry<Double, Double>> it = mapaCurvas.entrySet()
		    .iterator();

	    while (it.hasNext()) {
		Entry<Double, Double> elemento = it.next();
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
			c.getBici().setVelocidad(elemento.getValue());
		    }
		}
	    }
	}

    }
}