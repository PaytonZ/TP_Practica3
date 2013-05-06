package comandos;

import principal.Presentador;

public class ComandoDesconocido implements InterfazCommand {

    public ComandoDesconocido() {

    }

    @Override
    public InterfazCommand parse(String nombre) {
	InterfazCommand c = null;

	c = new ComandoDesconocido();

	return c;

    }

    @Override
    public void execute() {

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "comando desconocido";
    }

    @Override
    public void configurarContexto(Presentador presentador) {
	// TODO Auto-generated method stub

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }

}
