package comandos;

import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

import java.util.LinkedList;
import java.util.Queue;

import principal.CiclistaManager;
import vista.SalidaDeDatosPorSwing;

import entradaDeDatos.*;

/**
 * 
 * Esta clase es la encargada la gestion de los comandos. Recibe un string por
 * mensaje , utiliza la clase parser para identificar cual es el adecuado y lo
 * añade a una cola FIFO para que se ejecute uno cada vez.
 * 
 * @author Juan Carlos Marco
 * @author Juan Luis Perez
 * @author Emilio Alvarez Pinerio
 * 
 */
public class Comandero implements InterfaceEjecuta, InterfaceSalida {

    CiclistaManager cm;
    Queue<InterfazCommand> cola_de_comandos;
    Parser parser;
    String salida_de_datos;

    public Comandero(CiclistaManager nuevo_cm, Parser nuevo_parser) {
	cm = nuevo_cm;
	parser = nuevo_parser;
	cola_de_comandos = new LinkedList<InterfazCommand>();

    }

    @Override
    public void ejecuta() {

	if (!cola_de_comandos.isEmpty()) {
	    InterfazCommand siguiente_comando_a_ejecutar = cola_de_comandos.poll();
	    siguiente_comando_a_ejecutar.configurarContexto(cm);
	    siguiente_comando_a_ejecutar.execute();
	    salida_de_datos = siguiente_comando_a_ejecutar
		    .getInformacionInstruccion();
	}
    }

    public void recibir_comando(String comando) {
	InterfazCommand c = parser.parse(comando);
	if (c != null) {
	    cola_de_comandos.add(c);
	}

    }

    @Override
    public String muestra() {
	String salida = "";
	if (salida_de_datos != null) {
	    salida = salida_de_datos;
	    salida_de_datos = "";

	}
	return "consola" + "%" + salida + "#" + ",";
    }

}
