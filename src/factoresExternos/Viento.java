package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import persona.Ciclista;
import tiempo.Reloj;
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

    private EntradaFichero fichero;
    private Map<String, String> mapaVientos;
    private Reloj reloj;
    private float viento;
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

    /**
     * añade el viento al mapaVientos con la hora, tipo de viento
     * (AFAVO,ENCONTRA,NULO) y su velocidad
     * 
     * @param hora
     * @param tipo
     * @param velocidad
     */
    public void setViento(String hora, String tipo, String velocidad) {
	mapaVientos.put(hora, tipo + "#" + velocidad);

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

    @Override
    public void ejecuta() {

	/**
	 * si la hora actual, esta en nuestro mapa de vientos, asignaremos el
	 * viento a las bicicletas
	 */
	if (mapaVientos.containsKey(reloj.devuelveTiempoEnString())) {
	    String[] tipo = mapaVientos.get(reloj.devuelveTiempoEnString())
		    .split("#");
	    for (Ciclista c : lista_de_ciclistas) {
		switch (tipo[0]) {
		case "AFAVOR":
		    viento = Float.parseFloat(tipo[1]);
		    break;
		case "ENCONTRA":
		    viento = Float.parseFloat(tipo[1]) * -1;
		    break;
		case "NULO":
		    viento = 0;
		    break;
		}
		c.getBici().setFactorViento(viento);
	    }

	} else {
	    for (Ciclista c : lista_de_ciclistas) {
		c.getBici().setFactorViento(viento);
	    }
	}
    }
}