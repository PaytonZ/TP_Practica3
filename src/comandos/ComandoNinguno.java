package comandos;

import principal.CiclistaManager;

public class ComandoNinguno implements InterfazCommand {
    public ComandoNinguno() {
    }

    @Override
    public InterfazCommand parse(String nombre) {
	// TODO Auto-generated method stub
	return null;
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
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }

}
