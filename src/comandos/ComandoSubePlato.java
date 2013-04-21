package comandos;

import persona.Ciclista;

public class ComandoSubePlato implements InterfazCommand {
    Ciclista cic;

    public ComandoSubePlato(Ciclista micic) {
	cic = micic;
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean parse(String nombre) {
	boolean iguales = false;
	if (nombre.equalsIgnoreCase("subeplato")) {
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub

	cic.aumentaPlato();
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
	return "plato subido en el ciclista" + cic.getIdentificador_ciclista()
		+ "\nplato actual :" + cic.getPlatoActualBici();
    }

    public String getNombreComando() {
	return "subeplato";
    }
}
