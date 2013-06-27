package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.Presentador;
import factoresExternos.Pendiente;

public class ComandoPendiente implements InterfazCommand {

    /**
     * @uml.property name="pK"
     */
    private int PK;
    /**
     * @uml.property name="pend"
     */
    private int pend;
    /**
     * @uml.property name="pendiente"
     * @uml.associationEnd
     */
    private Pendiente pendiente;
    /**
     * @uml.property name="identificador_ciclista"
     */
    private int identificador_ciclista;
    /**
     * @uml.property name="ciclista"
     * @uml.associationEnd readOnly="true"
     */
    private Ciclista ciclista;

    public ComandoPendiente(int miPK, int mipend) {
	PK = miPK;
	pend = mipend;
	// TODO Auto-generated constructor stub
    }

    @Override
    public void configurarContexto(Presentador presentador) {

	pendiente = presentador.getPendiente();

    }

    @Override
    public void execute() {
	pendiente.setPendiente(PK, pend);

    }

    @Override
    public String getInformacionInstruccion() {
	return "pendiente anadida en el metro " + PK + "\n con desnivel del "
		+ pend + " por ciento";

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "pendiente <punto_km> <desnivel>";
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
}
