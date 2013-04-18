package comandos;

import persona.Ciclista;

public class ComandoSubePinon implements InterfazInstruccion {
    Ciclista cic;

    public ComandoSubePinon() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor) {
	cic = (Ciclista) o;
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

}
