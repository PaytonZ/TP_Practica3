package comandos;

import java.util.StringTokenizer;

import principal.CiclistaManager;

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
	// System.out.println("DESCONOCIDO");
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "comando desconocido";
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
