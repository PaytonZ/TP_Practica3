package comandos;

import persona.Ciclista;

public class ComandoDisminuyeCadencia implements InterfazInstruccion {
    Ciclista cic;
    public ComandoDisminuyeCadencia() {

    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	cic = (Ciclista) o;
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

    @Override
    public String getInformacionInstruccion() 
    {
	// TODO Auto-generated method stub
	return "cadencia disminuida en el ciclista " + cic.getIdentificador_ciclista() 
		+ "\ncadencia actual :" + cic.getCadencia();
    }
}
