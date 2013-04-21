package comandos;

import persona.Ciclista;

public class ComandoBajaPlato implements InterfazCommand {
    Ciclista cic;

    public ComandoBajaPlato(Ciclista miciclista) {
	cic = miciclista;
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean parse(String nombre) {
	boolean iguales = false;
	if (nombre.equalsIgnoreCase("bajaplato")) {
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {

	cic.disminuyePlato();// TODO Auto-generated method stub

    }

    @Override
    public void configurarContexto() {
	// TODO Auto-generated method stub

    }

    @Override
    public void obtenerAyuda() {
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "plato bajado en el ciclista" + cic.getIdentificador_ciclista()
		+ "\n plato actual :" + cic.getPlatoActualBici();
    }

    public String getNombreComando() {
	return "bajaplato";
    }
}
