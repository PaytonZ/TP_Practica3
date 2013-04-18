package comandos;

public class ComandoNinguno implements InterfazInstruccion {
    public ComandoNinguno() {
	// System.out.println("hola");
    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o, double valor) {

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
	return "faltan parametros";
    }

}
