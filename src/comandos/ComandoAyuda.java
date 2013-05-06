package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.Presentador;

public class ComandoAyuda implements InterfazCommand {

    private Ciclista ciclista;
    private int identificador_ciclista;

    public ComandoAyuda() {

    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	StringTokenizer comandosYatributos = new StringTokenizer(nombre,
		"\n\r ");
	if (comandosYatributos.nextToken().equalsIgnoreCase("ayuda")) {

	    c = new ComandoAyuda();

	}
	return c;
    }

    @Override
    public void execute() {

    }

    @Override
    public void configurarContexto(Presentador presentador) {

    }

    @Override
    public String obtenerAyuda() {
	return "";
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	return "asignacadencia <num_ciclista> <cadencia> \n "
		+ "bajapinon <num_ciclista> \n" + "bajaplato <num_ciclista> \n"
		+ "subeplato <num_ciclista> \n" + "subepinon <num_ciclista> \n"
		+ "frenar <num_ciclista> <cantidad> <tiempo>";
    }

}
