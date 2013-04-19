package comandos;

public class ComandoNinguno implements InterfazCommand {
    public ComandoNinguno() {
	// System.out.println("hola");
    }

    @Override
    public boolean parse(String nombre)
    {
	boolean iguales = false;
	if(nombre.equalsIgnoreCase("ninguno"))
	{
	    iguales = true;
	}
	return iguales;
    }
    @Override
    public void execute() {

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
	// System.out.print("hola");
	return "";
    }
    public String getNombreComando()
    {
	return "ninguno";
    }
}
