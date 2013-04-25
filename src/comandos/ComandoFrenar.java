package comandos;

import persona.Ciclista;
import principal.CiclistaManager;

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
    public InterfazCommand parse(String nombre) {
	return null;
	
    }

    @Override
    public void execute() {

	cic.frenar(valor, tiempo);



    }

   

    @Override
    public String getInformacionInstruccion() {
	

	return "freno aplicado en ciclista" + cic.getIdentificador_ciclista();
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }

   
}