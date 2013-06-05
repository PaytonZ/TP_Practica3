package vista;

import interfaceMain.InterfaceSalida;

import java.util.ArrayList;

import constantes.Constantes;

/**
 * Esta clase sera la encargada de mostrar la informacion al usuario
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 * 
 */

public class SalidaDeDatosPorSwing {

    // este arraylist, contiene todos los objetos que se mostraran en el metodo
    // mostrarObjeto()
    /**
	 * @uml.property  name="lista_salida"
	 */
    private ArrayList<InterfaceSalida> lista_salida;
    /**
	 * @uml.property  name="miventana"
	 * @uml.associationEnd  
	 */
    private Ventana miventana;

    public SalidaDeDatosPorSwing(ArrayList<InterfaceSalida> lista) {

	lista_salida = lista;
    }

    public SalidaDeDatosPorSwing(Ventana vent,
	    ArrayList<InterfaceSalida> lista_o) {
	lista_salida = lista_o;
	miventana = vent;
    }

    /**
     * este metodo hace un for each del arraylist dela propia clase y ejecuta el
     * metodo muestra de los objetos que contiene
     */

    /* Formatos admitidos : ciclistaX , reloj , consola */

    public void mostrarObjetos() {
	String salida;
	String[] aux, mensaje_final;
	String id;

	for (InterfaceSalida listaobjetos : lista_salida) {

	    salida = listaobjetos.muestra();

	    aux = salida.split("%");
	    id = aux[0];
	    mensaje_final = aux[1].split(",");
	    salida = "";
	    for (int i = 0; i < mensaje_final.length; i++) {

		mostrarPorVentana(mensaje_final[i], id);

	    }

	}

    }

    /**
     * este metodo recibe un String con los datos a mostrar y con el formato
     * inclusive y es capaz de sacarlo formateado de dicha forma
     * 
     * @param mensaje
     *            contiene el mensaje a mostrar y el formato a usar funciona de
     *            la siguiente manera : mensaje = "mensaje#formato"
     */
    public void mostrarPorPantalla(String mensaje) {

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
	System.out.println(mensajefinal.toString());
    }

    /**
     * este metodo saca por pantalla el mensaje introducido con el formato
     * indicado, el cual debe de existir en el propio metodo
     * 
     * @param mensaje
     *            La informacion a mostrar
     * @param formato
     *            El formato para mostrar la informacion
     */
    public void mostrarPorPantalla(String mensaje, String formato) {

	StringBuffer mensajefinal = new StringBuffer();

	switch (formato) {
	case "cadencia": {
	    mensajefinal.append(mensaje + " pedaladas por segundo ");
	    break;
	}
	case "velocidad": {
	    mensajefinal.append("Velocidad actual:" + mensaje + " m/s ");
	    break;
	}

	case "hh:mm:ss": {
	    int i = 0;
	    while (i < mensaje.length()) {
		if (mensaje.charAt(i) == ' ') {
		    mensajefinal.insert(i, ":");

		} else {
		    mensajefinal.insert(i, mensaje.charAt(i));
		}

		i++;
	    }

	    break;
	}
	}

	System.out.println(mensajefinal.toString());
    }

    public void mostrarPorVentana(String mensaje, String id) {

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

	    + // mensaje.substring(0, posicionempiezaformato) + " m/s ");
		    mensaje.substring(0, mensaje.indexOf(".")
			    + Constantes.NUM_DECIMALES + 1) + " m/s ");

	    break;
	}
	case "distancia": {
	    mensajefinal.append("Distancia recorrida:" + // mensaje.substring(0,
							 // posicionempiezaformato)
							 // + " m ");
		    mensaje.substring(0, mensaje.indexOf(".")
			    + Constantes.NUM_DECIMALES + 1) + " m ");
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
	default:
	    mensajefinal = mensajefinal.append(mensaje.substring(0,
		    posicionempiezaformato));
	    break;

	}

	miventana.ponTextoEnTextArea(id, mensajefinal.toString());
	// System.out.println(mensajefinal.toString());
    }

}
