package comandos;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoBajaPlato implements InterfazCommand {
    Ciclista cic;

    public ComandoBajaPlato(Ciclista miciclista) {
	cic = miciclista;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	
	return null;
    }

    @Override
    public void execute() {

	cic.disminuyePlato();// TODO Auto-generated method stub

    }

   
    @Override
    public String obtenerAyuda() {
	return null;
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "plato bajado en el ciclista" + cic.getIdentificador_ciclista()
		+ "\n plato actual :" + cic.getPlatoActualBici();
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	// TODO Auto-generated method stub
	
    }

    
}
