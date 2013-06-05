package comandos;

import principal.Presentador;
import factoresExternos.Curva;

public class ComandoCurva implements InterfazCommand {

    /**
	 * @uml.property  name="pK"
	 */
    private int PK;
    /**
	 * @uml.property  name="velMax"
	 */
    private int velMax;
    /**
	 * @uml.property  name="curva"
	 * @uml.associationEnd  
	 */
    private Curva curva;

    public ComandoCurva(int miPK, int velocidadMax) {
	PK = miPK;
	velMax = velocidadMax;
	// TODO Auto-generated constructor stub
    }

    @Override
    public void configurarContexto(Presentador presentador) {

	curva = presentador.getCurva();

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
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "curva <punto_km> <vel_max>";
    }

    @Override
    public InterfazCommand parse(String nombre) {

	int nuevo_pk;
	int nueva_vel_max;
	String atributos[] = nombre.split("\\s");
	InterfazCommand c = null;
	if (atributos.length >= 3) {
	    if (atributos[0].equalsIgnoreCase("curva")) {
		nuevo_pk = Integer.parseInt(atributos[1]);
		if (nuevo_pk >= 0) {
		    nueva_vel_max = Integer.parseInt(atributos[2]);
		    if (nueva_vel_max >= 0) {
			c = new ComandoCurva(nuevo_pk, nueva_vel_max);
		    }

		}
	    }
	}
	return c;

    }

}
