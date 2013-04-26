package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import bicicleta.Bicicleta;
import constantes.Constantes;

public class Pendiente implements InterfaceEjecuta{

    Map<Double, Double> mapaPendientes;
    private Vector<Bicicleta> vectorBicis;

    /**
     * se recibe el vector de bicis
     * 
     * @param bicis
     * @param rel
     */

    public Pendiente(Vector<Bicicleta> bicis) {
	mapaPendientes = new HashMap<Double, Double>();
	vectorBicis = bicis;
    }

    /**
     * añade la curva a su mapaDeCurvas con su PK y su velocidad maxima
     * 
     * @param hora
     * @param tipo
     * @param velocidad
     */
    public void setPendiente(double PK, double pendiente) {
	mapaPendientes.put(PK, pendiente);

    }

    @Override
    public void ejecuta() 
    {

	/**
	 * si la hora actual, esta en nuestro mapa de vientos, asignaremos el
	 * viento a las bicicletas
	 */
	int i = 0;
	for (i = 0; i < vectorBicis.size(); i++) 
	{
	    java.util.Iterator<Entry<Double, Double>> it = mapaPendientes.entrySet().iterator();

	    while (it.hasNext()) 
	    {
		Entry<Double, Double> elemento = it.next();
		double espacio_recorrido = vectorBicis.get(i).getEspacioRecorrido();
		//si hay mas pendientes
		if(it.hasNext())
		{
		    	// comprobamos en que metro nos encontramos del recorrido,
			// si hemos pasado el punto donde empienza la pendiente,
			// esta nos empezara a afectar positiva o negativamente
		    	Entry<Double, Double> elemento2 = it.next();
		    	if (espacio_recorrido >= elemento.getKey() && espacio_recorrido < elemento2.getKey())
			{
			    // si la pendiente es positiva, nos afectara negativamente
			    if (elemento.getValue() >0)
			    {
				vectorBicis.get(i).setFactorPendiente(Constantes.FACTORPENDIENTE*elemento.getValue() *-1);
			    }
			 // si la pendiente es negativa, nos afectara positivamente
			    else if(elemento.getValue()  < 0)
			    {
				vectorBicis.get(i).setFactorPendiente(Constantes.FACTORPENDIENTE*elemento.getValue() );
				    
			    }
			 // si la pendiente es 0, no afecta
			    else
			    {
				vectorBicis.get(i).setFactorPendiente(0);
				    
			    }
			}
		}
		else
		{
		 // comprobamos en que metro nos encontramos del recorrido,
			// si hemos pasado el punto donde empienza la pendiente,
			// esta nos empezara a afectar positiva o negativamente
			if (espacio_recorrido >= elemento.getKey())
			{
			    // si la pendiente es positiva, nos afectara negativamente
			    if (elemento.getValue() >0)
			    {
				vectorBicis.get(i).setFactorPendiente(Constantes.FACTORPENDIENTE*elemento.getValue() *-1);
			    }
			 // si la pendiente es negativa, nos afectara positivamente
			    else if(elemento.getValue()  < 0)
			    {
				vectorBicis.get(i).setFactorPendiente(Constantes.FACTORPENDIENTE*elemento.getValue() );
				    
			    }
			 // si la pendiente es 0, no afecta
			    else
			    {
				vectorBicis.get(i).setFactorPendiente(0);
				    
			    }
			} 
		}
		
	    }
	}

    }
}
