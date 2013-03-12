package salidaDeDatos;

import java.util.ArrayList;

import ui.Ventana;

import interfaceMain.InterfaceSalida;

/**
 * Esta clase sera la encargada de mostrar la informacion al usuario
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 * 
 */

public class SalidaDeDatosPorSwing {

    // este arraylist, contiene todos los objetos que se mostraran en el metodo
    // mostrarObjeto()
    ArrayList<Object> milista = new ArrayList<Object>();
    Ventana miventana ;
    public SalidaDeDatosPorSwing(Ventana ventana) {
	miventana = ventana;
    }

    public SalidaDeDatosPorSwing(ArrayList<Object> lista) {
	
	milista = lista;
    }

    
    public void mostrarPorVentana(String mensaje,int id) {

	StringBuffer mensajefinal = new StringBuffer();
	int posicionempiezaformato = 0;

	// buscamos la posicion a partir de la cual empieza el formato
	while (posicionempiezaformato < mensaje.length()
		&& mensaje.charAt(posicionempiezaformato) != '#') {
	    posicionempiezaformato++;

	}
	// como ya sabemos donde empieza el formato, ahora solo comparamos para
	// sacar la salida formateada
	// con dicho formato
	switch (mensaje.substring(posicionempiezaformato + 1).toString()) {
	case "cadencia": {
	    mensajefinal.append(mensaje.substring(0, posicionempiezaformato)
		    + " pedaladas por segundo ");
	    break;
	}
	case "velocidad": {
	    mensajefinal.append("Velocidad actual:"
		    + mensaje.substring(0, posicionempiezaformato) + " m/s ");
	    break;
	}
	case "distancia": {
	    mensajefinal.append("Distancia recorrida:"
		    + mensaje.substring(0, posicionempiezaformato) + " m ");
	    break;
	}
	case "hh:mm:ss": {
	    int caractermensaje = 0;
	    while (caractermensaje < posicionempiezaformato) {
		if (mensaje.charAt(caractermensaje) == ' ') {
		    mensajefinal.insert(caractermensaje, ":");

		} else {
		    mensajefinal.insert(caractermensaje,
			    mensaje.charAt(caractermensaje));
		}

		caractermensaje++;
	    }

	    break;
	}
	}
	miventana.ponTextoEnTextArea(id, mensajefinal.toString());
	//System.out.println(mensajefinal.toString());
    }
    /**
     * este metodo hace un for each del arraylist dela propia clase y ejecuta el
     * metodo muestra de los objetos que contiene
     */
    public void mostrarObjetos() {
	for (Object listaobjetos : milista) {

	    ((InterfaceSalida) listaobjetos).muestra();

	}


    }
}


