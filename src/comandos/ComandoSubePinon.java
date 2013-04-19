package comandos;

import persona.Ciclista;

public class ComandoSubePinon implements InterfazCommand {
    Ciclista cic;
    
    public ComandoSubePinon(Ciclista micic) {
	cic = micic;
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("subepinon"))
	{
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	
	cic.aumentaPinon();
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
	return "pinon subido en el ciclista" + cic.getIdentificador_ciclista()
		+ "\npinon actual :" + cic.getPinonActualBici();
    }
    public String getNombreComando()
    {
	return "subepinon";
    }
}
