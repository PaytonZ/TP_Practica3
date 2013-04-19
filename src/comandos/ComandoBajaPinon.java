package comandos;

import persona.Ciclista;

public class ComandoBajaPinon implements InterfazCommand {
    Ciclista cic;

    public ComandoBajaPinon(Ciclista miciclista) {
	cic = miciclista;
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("bajapinon"))
	{
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	
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

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "pinon bajado en el ciclista" + cic.getIdentificador_ciclista()
		+ "\n pinon actual :" + cic.getPinonActualBici();
    }

    public String getNombreComando()
    {
	return "bajapinon";
    }
}
