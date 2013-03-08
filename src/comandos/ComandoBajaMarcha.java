package comandos;

import persona.Ciclista;
import interfaceMain.InterfaceEjecuta;

public class ComandoBajaMarcha implements InterfazInstruccion {

    public ComandoBajaMarcha() {
	// TODO Auto-generated constructor stub
    }

  

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	Ciclista cic = (Ciclista) o;
	cic.disminuyePinon();
	// TODO Auto-generated method stub

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
