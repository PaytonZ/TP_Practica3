package comandos;

import principal.CiclistaManager;

public class ComandoIncompleto implements InterfazCommand {

    String ayudacomando;

    public ComandoIncompleto(String miayudacomando) {
	ayudacomando = miayudacomando;
    }

    @Override
    public InterfazCommand parse(String nombre) {
	return null;

    }

    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "comando incompleto\n" + ayudacomando;
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub

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
