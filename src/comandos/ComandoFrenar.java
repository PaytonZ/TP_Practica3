package comandos;

import persona.Ciclista;

public class ComandoFrenar implements InterfazCommand {
    Ciclista cic;
    double valor;
    double tiempo;
    public ComandoFrenar(Ciclista miciclista, double mivalor, double mitiempo) {
	cic = miciclista;
	valor = mivalor;
	tiempo = mitiempo;
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("frenar"))
	{
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() 
    {

	
	cic.frenar(valor, tiempo);

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

	return "freno aplicado en ciclista" + cic.getIdentificador_ciclista();
    }
    public String getNombreComando()
    {
	return "frenar";
    }
}