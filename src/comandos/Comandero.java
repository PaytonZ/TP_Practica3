package comandos;

import interfaceMain.InterfaceEjecuta;

import java.util.LinkedList;
import java.util.Queue;

import principal.CiclistaManager;

import entradaDeDatos.*;

public class Comandero implements InterfaceEjecuta {

    CiclistaManager cm;
    Queue<InterfazCommand> cola_de_comandos;
    Parser parser;

    public Comandero(CiclistaManager nuevo_cm, Parser nuevo_parser) {
	cm = nuevo_cm;
	parser = nuevo_parser;
	cola_de_comandos = new LinkedList<InterfazCommand>();

    }

    @Override
    public void ejecuta() {

	if (!cola_de_comandos.isEmpty()) {
	    InterfazCommand siguiente_comando_a_ejecutar = cola_de_comandos
		    .poll();
	    siguiente_comando_a_ejecutar.configurarContexto(cm);
	    siguiente_comando_a_ejecutar.execute();
	}
    }

    public void recibir_comando(String comando) {
	InterfazCommand c = parser.parse(comando);
	if (c != null) {
	    cola_de_comandos.add(c);
	}
    }

}
