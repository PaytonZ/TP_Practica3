package comandos;

import java.util.StringTokenizer;

import constantes.Constantes;

import persona.Ciclista;
import principal.Presentador;
import factoresExternos.Curva;

public class ComandoCurva implements InterfazCommand {

    private double PK;
    private double velMax;
    private Curva curva;

    public ComandoCurva(double miPK, double velocidadMax) {
	PK = miPK;
	velMax = velocidadMax;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {

	double nuevo_pk;
	double nueva_vel_max;
	String atributos[] = nombre.split("\\s");
	InterfazCommand c = null;
	if (atributos.length >= 3) {
	    if (atributos[0].equalsIgnoreCase("curva")) {
		nuevo_pk = Double.parseDouble(atributos[1]);
		if (nuevo_pk >= 0) {
		    nueva_vel_max = Double.parseDouble(atributos[2]);
		    if (nueva_vel_max >= 0) {
			c = new ComandoCurva(nuevo_pk, nueva_vel_max);
		    }

		}
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
    public void configurarContexto(Presentador presentador) {

	curva = presentador.getCurva();

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "curva <punto_km> <velmax>";
    }

}
