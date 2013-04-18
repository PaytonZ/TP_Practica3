package comandos;

import persona.Ciclista;

public class ComandoBajaPinon implements InterfazInstruccion {
    Ciclista cic;

    public ComandoBajaPinon() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor,double t) {
	cic = (Ciclista) o;
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

}
