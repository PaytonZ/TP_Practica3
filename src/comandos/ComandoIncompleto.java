package comandos;

public class ComandoIncompleto implements InterfazCommand {

    public ComandoIncompleto() {

    }

    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("incompleto"))
	{
	    iguales = true;
	}
	return iguales;
    }
    @Override
    public void execute() {
	// System.out.println("DESCONOCIDO");
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
	return "comando incompleto";
    }
    public String getNombreComando()
    {
	return "incompleto";
    }
}
