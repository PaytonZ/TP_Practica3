package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import persona.Ciclista;
import tiempo.Reloj;
import constantes.Constantes;
import entradaDeDatos.EntradaFichero;

/**
 * esta clase crea el viento dado un vector de bicicletas y el reloj
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Viento implements InterfaceEjecuta {

    /**
	 * @uml.property  name="fichero"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private EntradaFichero fichero;
    /**
	 * @uml.property  name="mapaVientos"
	 * @uml.associationEnd  qualifier="hora:java.lang.String java.lang.String"
	 */
    private Map<String, String> mapaVientos;
    /**
	 * @uml.property  name="reloj"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Reloj reloj;
    /**
	 * @uml.property  name="viento"
	 */
    private float viento;
    /**
	 * @uml.property  name="lista_de_ciclistas"
	 */
    private ArrayList<Ciclista> lista_de_ciclistas;

    /**
     * se recibe el vector de bicis y el reloj
     * 
     * @param bicis
     * @param rel
     */

    public Viento(ArrayList<Ciclista> nueva_lista_de_ciclistas, Reloj rel) {
	viento = 0;
	fichero = new EntradaFichero();
	mapaVientos = new HashMap<String, String>();
	lista_de_ciclistas = nueva_lista_de_ciclistas;
	reloj = rel;
    }

    @Override
    public void ejecuta() {

	/**
	 * si la hora actual, esta en nuestro mapa de vientos, asignaremos el
	 * viento a las bicicletas
	 */
	double aceleracion_eolo = 0;
	if (mapaVientos.containsKey(reloj.devuelveTiempoEnString())) {
	    String tipo = mapaVientos.get(reloj.devuelveTiempoEnString());

	    for (Ciclista c : lista_de_ciclistas) {
		switch (tipo) {
		case "AFAVOR":
		    aceleracion_eolo = Constantes.CONSTANTE_EOLO
			    / c.getBici().getVelocidad();
		    break;
		case "ENCONTRA":
		    aceleracion_eolo = -(Constantes.CONSTANTE_EOLO / c
			    .getBici().getVelocidad());
		    break;
		case "NULO":
		    aceleracion_eolo = 0;
		    break;
		}
		c.getBici().acelerarbici(aceleracion_eolo);
	    }

	} else {
	    for (Ciclista c : lista_de_ciclistas) {
		c.getBici().acelerarbici(0);
	    }
	}
    }

    /**
     * devuelve el tipo y la velocidad en este formato tipo#velocidad
     * 
     * @param hora
     * @return
     */
    public String getViento(String hora) {
	return mapaVientos.get(hora);

    }

    /**
     * añade el viento al mapaVientos con la hora, tipo de viento
     * (AFAVO,ENCONTRA,NULO) y su velocidad
     * 
     * @param hora
     * @param tipo
     * @param velocidad
     */
    public void setViento(String hora, String tipo) {
	mapaVientos.put(hora, tipo);

    }
}