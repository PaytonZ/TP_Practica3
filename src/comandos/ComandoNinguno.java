package comandos;

import principal.Presentador;

public class ComandoNinguno implements InterfazCommand {
    public ComandoNinguno() {
    }

    @Override
    public void configurarContexto(Presentador presentador) {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute() {
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

    @Override
    public InterfazCommand parse(String nombre) {
	// TODO Auto-generated method stub
	return null;
    }

}
