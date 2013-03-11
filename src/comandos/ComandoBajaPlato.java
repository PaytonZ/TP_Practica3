package comandos;

import persona.Ciclista;

public class ComandoBajaPlato implements InterfazInstruccion {

    public ComandoBajaPlato() {
	// TODO Auto-generated constructor stub
    }



    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	Ciclista cic = (Ciclista) o;
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

}
