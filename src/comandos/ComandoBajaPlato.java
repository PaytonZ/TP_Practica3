package comandos;

import persona.Ciclista;

public class ComandoBajaPlato implements InterfazInstruccion {
    Ciclista cic;

    public ComandoBajaPlato() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor,double t) {
	cic = (Ciclista) o;
	cic.disminuyePlato();// TODO Auto-generated method stub

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
	return "plato bajado en el ciclista" + cic.getIdentificador_ciclista()
		+ "\n plato actual :" + cic.getPlatoActualBici();
    }

}
