package comandos;

import persona.Ciclista;

public class ComandoFrenar implements InterfazInstruccion {
    Ciclista cic;

    public ComandoFrenar() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor,double tiempo) {

	cic = (Ciclista) o;
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

}