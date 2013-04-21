package comandos;

public class ComandoAyuda implements InterfazCommand {

    @Override
    public boolean parse(String nombre) {
	boolean iguales = false;
	if (nombre.equalsIgnoreCase("ayuda")) {
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub
	// System.out.print("asdf");
    }

    @Override
    public void configurarContexto() {
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {

	return "asignacadencia <num_ciclista> <cadencia> \n "
		+ "bajapinon <num_ciclista> \n" + "bajaplato <num_ciclista> \n"
		+ "subeplato <num_ciclista> \n" + "subepinon <num_ciclista> \n"
		+ "frenar <num_ciclista> <cantidad> <tiempo>";

    }

    @Override
    public void obtenerAyuda() {
	// TODO Auto-generated method stub

    }

}
