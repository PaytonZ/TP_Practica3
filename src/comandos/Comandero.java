package comandos;

import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;


import java.util.LinkedList;
import java.util.Queue;

import entradaDeDatos.SuperLectura;

import principal.Presentador;

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

    Presentador presentador;
    Queue<InterfazCommand> cola_de_comandos;
    Parser parser;
    String salida_de_datos;
    SuperLectura entrada_de_datos_por_fichero;

    public Comandero(Presentador nuevo_presentador,
	    String ruta_del_fichero) {
	presentador = nuevo_presentador;
	parser = new Parser();
	cola_de_comandos = new LinkedList<InterfazCommand>();
	entrada_de_datos_por_fichero = new SuperLectura(ruta_del_fichero);
	cargarComandosDesdeFichero();
    }

    private void cargarComandosDesdeFichero() {
	String entrada_de_comandos = "";
	String[] lista_de_comandos_por_procesar;

	entrada_de_comandos = entrada_de_datos_por_fichero
		.leerHastaFinalDeFichero();

	lista_de_comandos_por_procesar = entrada_de_comandos.split("\n");

	for (String comando : lista_de_comandos_por_procesar) {
	    recibir_comando(comando);
	}

    }

    @Override
    public void ejecuta() {

	if (!cola_de_comandos.isEmpty()) {
	    InterfazCommand siguiente_comando_a_ejecutar = cola_de_comandos
		    .poll();
	    siguiente_comando_a_ejecutar.configurarContexto(presentador);
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
