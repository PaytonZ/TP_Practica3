package comandos;

import persona.Ciclista;
import principal.Presentador;

public class ComandoClembuterol implements InterfazCommand {

    private int id_ciclista;
    private Ciclista ciclista;

    public ComandoClembuterol(int nuevo_id_ciclista) {
	id_ciclista = nuevo_id_ciclista;
    }

    @Override
    public void configurarContexto(Presentador presentador) {
	ciclista = presentador.getCiclista(id_ciclista);

    }

    @Override
    public void execute() {

	ciclista.setFuerza_ciclista(ciclista.getFuerzaCiclistaTotal());

    }

    @Override
    public String getInformacionInstruccion() {
	return "Clembuterol suministrado a ciclista "
		+ ciclista.getIdentificador_ciclista();

    }

    @Override
    public String obtenerAyuda() {
	return "ciclista <num_ciclista> clembuterol";

    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	int num_ciclista;

	String[] atributos = nombre.split("\\s");
	if (atributos.length >= 2) {
	    if (atributos[0].equalsIgnoreCase("ciclista")) {
		num_ciclista = Integer.parseInt(atributos[1]);
		if (atributos[2].equalsIgnoreCase("clembuterol")) {
		    c = new ComandoClembuterol(num_ciclista);
		}

	    }
	}
	return c;

    }

}
