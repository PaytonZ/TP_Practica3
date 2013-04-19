package comandos;

import persona.Ciclista;

public class ComandoAsignaCadencia implements InterfazCommand {
    Ciclista miciclista;
    double micadencia;
    public ComandoAsignaCadencia(Ciclista cic, double cadencia) {
	miciclista = cic;
	micadencia = cadencia;
	// TODO Auto-generated constructor stub
    }

   

    @Override
    public void execute() {
	miciclista.setCadencia(micadencia);

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
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub

	return "cadencia aumentada en el ciclista "
		+ miciclista.getIdentificador_ciclista() + "\ncadencia actual :"
		+ miciclista.getCadencia();
    }
    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("asignacadencia"))
	{
	    iguales = true;
	}
	return iguales;
    }


}
