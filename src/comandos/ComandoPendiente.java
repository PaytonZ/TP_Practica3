package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.Presentador;
import factoresExternos.Pendiente;

public class ComandoPendiente implements InterfazCommand {

    int PK;
    int pend;
    Pendiente pendiente;
    int identificador_ciclista;
    Ciclista ciclista;

    public ComandoPendiente(int miPK, int mipend) {
	PK = miPK;
	pend = mipend;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	StringTokenizer args = new StringTokenizer(nombre, "\n\r ");
	InterfazCommand c = null;
	if (args.nextToken().equalsIgnoreCase("pendiente")) {
	    if (args.countTokens() == 2) {

		PK = Integer.valueOf(args.nextToken());
		pend = Integer.valueOf(args.nextToken());

		c = new ComandoPendiente(PK, pend);
	    } else {
		c = new ComandoIncompleto(this.obtenerAyuda());
	    }
	}
	return c;
    }

    @Override
    public void execute() {
	pendiente.setPendiente(PK, pend);

    }

    @Override
    public String getInformacionInstruccion() {
	return "pendiente añadida en el metro " + PK + "\n con desnivel del "
		+ pend + " por ciento";

    }

    @Override
    public void configurarContexto(Presentador presentador) {

	pendiente = presentador.getPendiente();

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "pendiente <punto_km> <desnivel>";
    }
}
