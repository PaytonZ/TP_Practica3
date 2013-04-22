package factoresExternos;

import interfaceMain.InterfaceEjecuta;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

import tiempo.Reloj;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import constantes.Constantes;

import bicicleta.Bicicleta;
import entradaDeDatos.*;

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
    Map<String,String> mapaVientos;
    Reloj reloj;
    float viento;
    private Vector<Bicicleta> vectorBicis;

    /**
     * se recibe el vector de bicis y el reloj
     * @param bicis
     * @param rel
     */

    public Viento(Vector<Bicicleta> bicis,Reloj rel) {
	viento = 0;
	fichero = new EntradaFichero();
	mapaVientos = new HashMap<String,String>();
	vectorBicis = bicis;
	reloj = rel;
    }
    
    /**
     * añade el viento al mapaVientos con la hora, tipo de viento (AFAVO,ENCONTRA,NULO) y
     * su velocidad
     * @param hora
     * @param tipo
     * @param velocidad
     */
    public void setViento(String hora,String tipo,String velocidad)
    {
	mapaVientos.put(hora, tipo + "#" + velocidad);
	
    }
   
    /**
     * devuelve el tipo y la velocidad en este formato tipo#velocidad
     * @param hora
     * @return
     */
    public String getViento(String hora)
    {
	return mapaVientos.get(hora);
	
    }


    @Override
    public void ejecuta() {
	
	/**
	 * si la hora actual, esta en nuestro mapa de vientos, asignaremos el viento
	 * a las bicicletas
	 */
	if(mapaVientos.containsKey(reloj.devuelveTiempoEnString()))
	{
	    String[] tipo = mapaVientos.get(reloj.devuelveTiempoEnString()).split("#");
	    int i = 0;
	    for(i = 0; i < vectorBicis.size();i++)
	    {
		
		switch(tipo[0])
		{
		case "AFAVOR":
		    	viento = Float.parseFloat(tipo[1]);
		    break;
		case "ENCONTRA":
		    viento = Float.parseFloat(tipo[1]) *-1;
		    break;
		case "NULO":
		    viento = 0;
		    break;
		}
		vectorBicis.elementAt(i).setFactorViento(viento);
	    }
	    
	}
	else
	{
	    int i = 0;
	    for(i = 0; i < vectorBicis.size();i++)
	    {
		vectorBicis.elementAt(i).setFactorViento(viento);
	    }
	}
    }
}