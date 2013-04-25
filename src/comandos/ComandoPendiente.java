package comandos;

import factoresExternos.Viento;
import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoPendiente implements InterfazCommand {

    public ComandoPendiente() {
    }

    @Override
    public InterfazCommand parse(String nombre) {
	return null;
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }



}
