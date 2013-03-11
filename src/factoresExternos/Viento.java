package factoresExternos;

import bicicleta.Bicicleta;
import entradaDeDatos.*;

/**
 * esta clase crea una carretera a partir de un fichero
 * 
 * @author juancly
 * 
 */

public class Viento{

    EntradaFichero fichero;
    String vientos;
    Bicicleta bici;
    double[] matriz;
    final double FACTORVIENTO = 0.1;
    int tramo;
    /**
     * recibe la direccion de la ruta en la que se encuentra el fichero de
     * carretera
     * 
     * @param miruta
     */

    public Viento(String miruta,Bicicleta mibici) {
	vientos = miruta;
	fichero = new EntradaFichero();
	matriz = fichero.convertirAArrayFichero(vientos, ":;");
	bici = mibici;
	tramo = 0;
    }

    /**
     * la matriz resultante es del tipo entero y su composicion es la siguiente
     * matriz[0] = metro en el que cambia la pendiente matriz[1] =pendiente que
     * ira desde 90 hasta -90
     */
    public double[] getMatriz() {

	return matriz;
    }

    public void calculaFactor() {
	
	double cadencia;
	cadencia = bici.getCadencia();
	if(tramo+2 < matriz.length)
	{
	   //aplicamos el factor de la pendiente del tramo en el que se encuentra la bici
	    if(bici.getEspacioRecorrido() >= matriz[tramo] && 
		    bici.getEspacioRecorrido() <matriz[tramo+2])
	    {
		 
		 bici.setFactorViento(matriz[tramo+1] * FACTORVIENTO);
	    }
	    else
	    {
		
		tramo = tramo +2;
		bici.setFactorViento(matriz[tramo+1] * FACTORVIENTO);
	    }
	   
	}
	
    }
}