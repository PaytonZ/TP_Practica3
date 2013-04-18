package comandos;

public class ComandoAyuda implements InterfazInstruccion {

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor,double t) {
	// TODO Auto-generated method stub

    }

    @Override
    public void configurarContexto() {
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	/*
	 * NINGUNO(new ComandoNinguno()), DESCONOCIDO(new ComandoDesconocido()),
	 * AUMENTACADENCIA(new ComandoAumentaCadencia()), DISMINUYECADENCIA(new
	 * ComandoDisminuyeCadencia()), SUBEPINON(new ComandoSubePinon()),
	 * BAJAPINON(new ComandoBajaPinon()), SUBEPLATO(new ComandoSubePlato()),
	 * BAJAPLATO(new ComandoBajaPlato()), AYUDA(new ComandoAyuda());
	 */
	return "asignacadencia <num_ciclista> <cadencia> \n "
		+ "bajapinon <num_ciclista> \n" + "bajaplato <num_ciclista> \n"
		+ "subeplato <num_ciclista> \n" + "subepinon <num_ciclista> \n" +
		"frenar <num_ciclista> <cantidad> <tiempo>";

    }

    @Override
    public void obtenerAyuda() {
	// TODO Auto-generated method stub

    }

}
