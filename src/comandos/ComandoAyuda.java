package comandos;

import java.util.ArrayList;
import java.util.StringTokenizer;

import persona.Ciclista;
import principal.Presentador;

public class ComandoAyuda implements InterfazCommand {

    private ArrayList<InterfazCommand> lista_comandos;
    private String salida;

    public ComandoAyuda(ArrayList<InterfazCommand> nueva_lista_comandos) {

	lista_comandos = nueva_lista_comandos;
    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	String atributos[] = nombre.split("\\n");

	if (atributos.length >= 0) {
	    if (atributos[0].equalsIgnoreCase("ayuda")) {
		c = this;
	    }
	}

	return c;
    }

    @Override
    public void execute() {

	salida = "";
	for (InterfazCommand c : lista_comandos) {
	    salida += c.obtenerAyuda() + "\n";
	}
    }

    @Override
    public void configurarContexto(Presentador presentador) {

    }

    @Override
    public String obtenerAyuda() {

	return "ayuda";
    }

    @Override
    public String getInformacionInstruccion() {
	return salida;
    }

}
