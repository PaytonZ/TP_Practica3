package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

import tiempo.Reloj;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import constantes.Constantes;

import bicicleta.Bicicleta;
import entradaDeDatos.*;

/**
 * esta clase crea las curvasdel trazado
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Curva implements InterfaceEjecuta {

    Map<Double, Double> mapaCurvas;
    private Vector<Bicicleta> vectorBicis;

    /**
     * se recibe el vector de bicis
     * 
     * @param bicis
     * @param rel
     */

    public Curva(Vector<Bicicleta> bicis) {
	mapaCurvas = new HashMap<Double, Double>();
	vectorBicis = bicis;
    }

    /**
     * añade la curva a su mapaDeCurvas con su PK y su velocidad maxima
     * 
     * @param hora
     * @param tipo
     * @param velocidad
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

	int i = 0;
	int j = 0;
	for (i = 0; i < vectorBicis.size(); i++) {
	    java.util.Iterator<Entry<Double, Double>> it = mapaCurvas
		    .entrySet().iterator();

	    while (it.hasNext()) {
		Entry<Double, Double> elemento = it.next();
		double espacio_recorrido = vectorBicis.get(i)
			.getEspacioRecorrido();
		// comprobamos que llevamos una velocidad adecuada a la curva en
		// su
		// distancia de frenado, para asi reducirla y conseguir una
		// velocidad
		// adecuada
		if (espacio_recorrido >= elemento.getKey()
			- Constantes.DISTANCIA_FRENADO
			&& espacio_recorrido < elemento.getKey()) {
		    // si la velocidad es mayor que la de la curva, la reducimos
		    if (vectorBicis.get(i).getVelocidad() > elemento.getValue())
			vectorBicis.get(i).setVelocidad(elemento.getValue());
		}
	    }
	}

    }
}