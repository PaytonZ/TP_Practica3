package comandos;

import factoresExternos.Viento;
import persona.Ciclista;

public class ComandoPendiente implements InterfazCommand {

    public ComandoPendiente() {
    }

    @Override
    public boolean parse(String nombre) {
	boolean iguales = false;
	if (nombre.equalsIgnoreCase("pendiente")) {
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub

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
