package comandos;

import java.util.StringTokenizer;

import principal.Presentador;
import factoresExternos.Viento;

public class ComandoViento implements InterfazCommand {

    Viento viento;
    String tipoViento;
    String hora;
    String velocidad;

    public ComandoViento(String mihora, String tipo, String mivelocidad) {

	velocidad = mivelocidad;
	tipoViento = tipo;
	hora = mihora;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	StringTokenizer args = new StringTokenizer(nombre, "\n\r ");
	InterfazCommand c = null;
	if (args.nextToken().equalsIgnoreCase("viento")) {
	    if (args.countTokens() == 3) {

		hora = args.nextToken();
		tipoViento = args.nextToken();
		velocidad = args.nextToken();
		c = new ComandoViento(hora, tipoViento, velocidad);
	    }

	    else if (args.countTokens() == 2) {
		hora = args.nextToken();
		tipoViento = args.nextToken();
		velocidad = "0";

		if (tipoViento.equalsIgnoreCase("NULO")) {
		    c = new ComandoViento(hora, "NULO", "0");
		}

	    } else {
		c = new ComandoIncompleto(this.obtenerAyuda());
	    }
	}
	return c;
    }

    @Override
    public void execute() {
	viento.setViento(hora, tipoViento, velocidad);
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	return "Aviso de viento " + tipoViento + " con velocidad\n" + velocidad
		+ " m/s a las " + hora;

    }

    @Override
    public void configurarContexto(Presentador presentador) {
	viento = presentador.getViento();

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "viento <hora> <tipo> <velocidad>";
    }

}
