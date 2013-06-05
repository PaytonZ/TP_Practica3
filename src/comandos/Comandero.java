package comandos;

import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

import java.util.LinkedList;
import java.util.Queue;

import principal.Presentador;
import entradaDeDatos.SuperLectura;

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

    /**
	 * @uml.property  name="presentador"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Presentador presentador;
    /**
	 * @uml.property  name="cola_de_comandos"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="comandos.InterfazCommand"
	 */
    private Queue<InterfazCommand> cola_de_comandos;
    /**
	 * @uml.property  name="parser"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Parser parser;
    /**
	 * @uml.property  name="salida_de_datos"
	 */
    private String salida_de_datos;
    /**
	 * @uml.property  name="entrada_de_datos_por_fichero"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private SuperLectura entrada_de_datos_por_fichero;

    public Comandero(Presentador nuevo_presentador, String ruta_del_fichero) {
	presentador = nuevo_presentador;
	parser = new Parser();
	cola_de_comandos = new LinkedList<InterfazCommand>();
	entrada_de_datos_por_fichero = new SuperLectura(ruta_del_fichero);
	cargarComandosDesdeFichero();
    }

    /**
     * Lee todos los comandos de un fichero dado y lo introduce en la cola.
     */
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
	    procesarComando(cola_de_comandos.poll());
	}
	String comando_por_fichero = entrada_de_datos_por_fichero.leerLinea();
	if (comando_por_fichero != "") {
	    recibir_comando(comando_por_fichero);
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

    /**
     * Procesa un comando dado
     * 
     * @param comando
     *            El comando para ser procesado.
     */
    private void procesarComando(InterfazCommand comando) {
	comando.configurarContexto(presentador);
	comando.execute();
	salida_de_datos = comando.getInformacionInstruccion();
    }

    /**
     * Función principal del Parser. Recibe un String de cualquier fuente , y lo
     * transforma mediante el uso del parser en un comando valido El cual añade
     * a la cola
     * 
     * @param comando
     *            El String que contiene el comando.
     */
    public void recibir_comando(String comando) {
	InterfazCommand c = parser.parse(comando);
	if (c != null) {
	    cola_de_comandos.add(c);
	}

    }

}
