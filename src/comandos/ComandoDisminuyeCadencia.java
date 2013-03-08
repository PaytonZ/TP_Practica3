package comandos;

import persona.Ciclista;
import interfaceMain.InterfaceEjecuta;

public class ComandoDisminuyeCadencia implements InterfazInstruccion {
    public ComandoDisminuyeCadencia() {

    }


    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	Ciclista cic = (Ciclista) o;
	cic.disminuirCadencia();
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
