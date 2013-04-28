package comandos;

import java.util.StringTokenizer;

import factoresExternos.Curva;
import factoresExternos.Viento;
import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoCurva implements InterfazCommand {

    double PK;
    double velMax;
    Curva curva;
    int identificador_ciclista;
    Ciclista ciclista;

    public ComandoCurva(double miPK, double velocidadMax) {
	PK = miPK;
	velMax = velocidadMax;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	StringTokenizer args = new StringTokenizer(nombre, "\n\r ");
	InterfazCommand c = null;
	if (args.nextToken().equalsIgnoreCase("curva")) {
	    if (args.countTokens() == 2) {

		double PK = Double.valueOf(args.nextToken());
		double velMax = Double.valueOf(args.nextToken());

		c = new ComandoCurva(PK, velMax);
	    } else {
		c = new ComandoIncompleto(this.obtenerAyuda());
	    }
	}
	return c;
    }

    @Override
    public void execute() {
	curva.setCurva(PK, velMax);

    }

    @Override
    public String getInformacionInstruccion() {
	return "curva añadida en el metro " + PK
		+ "\n con velocidad maxima de " + velMax + " m/s";

    }

    @Override
    public void configurarContexto(CiclistaManager cm) {

	curva = cm.getCurva();

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "curva <punto_km> <velmax>";
    }

}
