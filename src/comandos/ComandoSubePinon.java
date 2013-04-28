package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoSubePinon implements InterfazCommand {
    Ciclista ciclista;

    int identificador_ciclista;

    public ComandoSubePinon(int nuevo_identificador_ciclista) {
	identificador_ciclista = nuevo_identificador_ciclista;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	InterfazCommand c = null;
	StringTokenizer comandosYatributos = new StringTokenizer(nombre,
		"\n\r ");
	if (comandosYatributos.nextToken().equalsIgnoreCase("subepinon")) {
	    if (comandosYatributos.countTokens() == 1) {

		int numciclista = Integer.parseInt(comandosYatributos
			.nextToken());

		c = new ComandoSubePinon(numciclista);
	    } else {
		c = new ComandoIncompleto(this.obtenerAyuda());
	    }
	}
	return c;
    }

    @Override
    public void execute() {

	ciclista.aumentaPinon();
	// TODO Auto-generated method stub

    }

    public String getNombreComando() {
	return "subepinon";
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	ciclista = cm.getCiclista(identificador_ciclista);

    }

    @Override
    public String obtenerAyuda() {
	return "subepinon <num_ciclista>";
	// TODO Auto-generated method stub
    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "pinon subido en el ciclista"
		+ ciclista.getIdentificador_ciclista() + "\npinon actual :"
		+ ciclista.getPinonActualBici();
    }
}
