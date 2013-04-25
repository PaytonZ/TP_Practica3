package comandos;

import principal.CiclistaManager;

public class ComandoAyuda implements InterfazCommand {

    @Override
    public InterfazCommand parse(String nombre) {
	return null;
	
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub
	// System.out.print("asdf");
    }



    @Override
    public String getInformacionInstruccion() {

	return "asignacadencia <num_ciclista> <cadencia> \n "
		+ "bajapinon <num_ciclista> \n" + "bajaplato <num_ciclista> \n"
		+ "subeplato <num_ciclista> \n" + "subepinon <num_ciclista> \n"
		+ "frenar <num_ciclista> <cantidad> <tiempo>";

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
