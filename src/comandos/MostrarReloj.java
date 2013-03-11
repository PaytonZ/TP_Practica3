package comandos;

import tiempo.Reloj;

public class MostrarReloj implements InterfazInstruccion {

   
    public MostrarReloj(Reloj rel) {
	// System.out.println("ESTOY DENTRO DEL METODO RELOJ");
    }

    public void ejecuta() {

    }

    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	Reloj mireloj = (Reloj) o;
	mireloj.mostrarReloj();
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
}
