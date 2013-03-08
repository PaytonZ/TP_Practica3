package comandos;

import interfaceMain.InterfaceEjecuta;
import persona.Ciclista;

public class ComandoAumentaCadencia implements InterfazInstruccion {
 
    public ComandoAumentaCadencia() {
	// TODO Auto-generated constructor stub
    }

 

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	
	Ciclista cic = (Ciclista) o;
	cic.aumentarCadencia();
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
