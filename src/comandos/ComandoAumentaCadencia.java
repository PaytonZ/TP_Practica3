package comandos;

import persona.Ciclista;

public class ComandoAumentaCadencia implements InterfazInstruccion {
    Ciclista cic;
    public ComandoAumentaCadencia() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	
	cic = (Ciclista) o;
	
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

    @Override
    public String getInformacionInstruccion() 
    {
	// TODO Auto-generated method stub
	
	return "cadencia aumentada en el ciclista " + cic.getIdentificador_ciclista() 
		+ "\ncadencia actual :" + cic.getCadencia();
    }

}
