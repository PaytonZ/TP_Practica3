package comandos;

import java.util.ArrayList;

import principal.Presentador;

public class ComandoAyuda implements InterfazCommand {

    /**
	 * @uml.property  name="lista_comandos"
	 */
    private ArrayList<InterfazCommand> lista_comandos;
    /**
	 * @uml.property  name="salida"
	 */
    private String salida;

    public ComandoAyuda(ArrayList<InterfazCommand> nueva_lista_comandos) {

	lista_comandos = nueva_lista_comandos;
    }

    @Override
    public void configurarContexto(Presentador presentador) {

    }

    @Override
    public void execute() {

	salida = "";
	for (InterfazCommand c : lista_comandos) {
	    salida += c.obtenerAyuda() + "\n";
	}
    }

    @Override
    public String getInformacionInstruccion() {
	return salida;
    }

    @Override
    public String obtenerAyuda() {

	return "ayuda";
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

}
