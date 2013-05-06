package comandos;

import persona.Ciclista;
import principal.Presentador;
import constantes.Constantes;

public class ComandoCambiaPlato implements InterfazCommand {
    private Ciclista ciclista;
    private int identificador_ciclista;
    private int plato;

    public ComandoCambiaPlato(int nuevo_identificador_ciclista, int nuevo_plato) {

	identificador_ciclista = nuevo_identificador_ciclista;
	plato = nuevo_plato;
    }

    @Override
    public InterfazCommand parse(String nombre) {

	int id_ciclista;
	int nuevo_plato;
	InterfazCommand c = null;

	String[] atributos = nombre.split("\\s");
	if (atributos.length >= 4) {
	    if (atributos[0].equalsIgnoreCase("bicicleta")) {
		id_ciclista = Integer.parseInt(atributos[1]);
		if (atributos[2].equalsIgnoreCase("cambia")
			&& atributos[3].equalsIgnoreCase("plato")) {
		    nuevo_plato = Integer.parseInt(atributos[4]);
		    if (nuevo_plato >= 0 && nuevo_plato < Constantes.NUM_PLATOS) {
			c = new ComandoCambiaPlato(id_ciclista, nuevo_plato);
		    }
		}
	    }
	}
	return c;

    }

    @Override
    public void execute() {

	ciclista.cambiaPlato(plato);

    }

    @Override
    public void configurarContexto(Presentador presentador) {
	ciclista = presentador.getCiclista(identificador_ciclista);

    }

    @Override
    public String obtenerAyuda() {
	return "bicicleta <num_bicicleta> cambia plato <num_pinon>";
	

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "Plato cambiado en el ciclista "
		+ ciclista.getIdentificador_ciclista() + "\n plato actual :"
		+ ciclista.getPlatoActualBici();
    }

}
