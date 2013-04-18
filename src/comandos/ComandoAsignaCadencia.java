package comandos;

import persona.Ciclista;

public class ComandoAsignaCadencia implements InterfazInstruccion {
    Ciclista cic;

    public ComandoAsignaCadencia() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor) {

	cic = (Ciclista) o;
	System.out.println(valor);
	cic.setCadencia(valor);

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
		+ cic.getIdentificador_ciclista() + "\ncadencia actual :"
		+ cic.getCadencia();
    }

}
