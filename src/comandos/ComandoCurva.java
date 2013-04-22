package comandos;

import factoresExternos.Curva;
import factoresExternos.Viento;
import persona.Ciclista;

public class ComandoCurva implements InterfazCommand{

    double PK ;
    double velMax;
    Curva curva;
    public ComandoCurva(Curva micurva,double miPK,double velocidadMax) {
	PK = miPK;
	velMax = velocidadMax;
	curva = micurva;
	// TODO Auto-generated constructor stub
    }
    @Override
    public boolean parse(String nombre) {
	boolean iguales = false;
	if (nombre.equalsIgnoreCase("curva")) {
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	curva.setCurva(PK, velMax);
	
    }

    @Override
    public void configurarContexto() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void obtenerAyuda() {
	// TODO Auto-generated method stub
	
    }

}
