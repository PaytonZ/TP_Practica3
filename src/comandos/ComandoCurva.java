package comandos;

import factoresExternos.Curva;
import factoresExternos.Viento;
import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoCurva implements InterfazCommand {

    double PK;
    double velMax;
    Curva curva;

    public ComandoCurva(Curva micurva, double miPK, double velocidadMax) {
	PK = miPK;
	velMax = velocidadMax;
	curva = micurva;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	return null;
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
	// TODO Auto-generated method stub

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }

}
