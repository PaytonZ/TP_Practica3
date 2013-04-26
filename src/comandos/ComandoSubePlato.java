package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoSubePlato implements InterfazCommand {
    Ciclista ciclista;
    int identificador_ciclista;

    public ComandoSubePlato(int nuevo_identificador_ciclista) {

	identificador_ciclista = nuevo_identificador_ciclista;
    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	StringTokenizer comandosYatributos = new StringTokenizer(nombre,
		"\n\r ");
	if (comandosYatributos.nextToken().equalsIgnoreCase("subeplato")) {
	    if (comandosYatributos.countTokens() == 1) {

		int numciclista = Integer.parseInt(comandosYatributos
			.nextToken());

		c = new ComandoSubePlato(numciclista);
	    }
	    else
	    {
		c = new ComandoIncompleto(this.obtenerAyuda());
	    }
	}
	return c;
    }

    @Override
    public void execute() {

	ciclista.aumentaPlato();

    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	ciclista = cm.getCiclista(identificador_ciclista);

    }

    @Override
    public String obtenerAyuda() {
	return "subeplato <num_ciclista>";
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "plato subido en el ciclista"
		+ ciclista.getIdentificador_ciclista() + "\n plato actual :"
		+ ciclista.getPlatoActualBici();
    }
}
