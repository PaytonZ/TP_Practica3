package comandos;

import persona.Ciclista;

public class ComandoSubePlato implements InterfazInstruccion {

    public ComandoSubePlato() {
	// TODO Auto-generated constructor stub
    }

 

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	// TODO Auto-generated method stub
	Ciclista cic = (Ciclista) o;
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

}
