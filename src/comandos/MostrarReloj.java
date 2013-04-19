package comandos;

import tiempo.Reloj;

public class MostrarReloj implements InterfazCommand {
    Reloj mireloj;
    public MostrarReloj(Reloj rel) {
	mireloj = rel;
    }

    public void ejecuta() {

    }

    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("mostrarreloj"))
	{
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	 
	// mireloj.mostrarReloj();
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
	return null;
    }
    public String getNombreComando()
    {
	return "mostrarreloj";
    }
}
