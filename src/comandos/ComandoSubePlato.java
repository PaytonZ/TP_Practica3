package comandos;

import persona.Ciclista;

public class ComandoSubePlato implements InterfazInstruccion {
    Ciclista cic;

    public ComandoSubePlato() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor,double t) {
	// TODO Auto-generated method stub
	cic = (Ciclista) o;
	cic.aumentaPlato();
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
	return "plato subido en el ciclista" + cic.getIdentificador_ciclista()
		+ "\nplato actual :" + cic.getPlatoActualBici();
    }

}
