package comandos;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoSubePlato implements InterfazCommand {
    Ciclista cic;

    public ComandoSubePlato(Ciclista micic) {
	cic = micic;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	return null;
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub

	cic.aumentaPlato();
    }



    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "plato subido en el ciclista" + cic.getIdentificador_ciclista()
		+ "\nplato actual :" + cic.getPlatoActualBici();
    }

    public String getNombreComando() {
	return "subeplato";
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
