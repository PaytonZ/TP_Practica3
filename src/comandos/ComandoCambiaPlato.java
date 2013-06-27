package comandos;

import persona.Ciclista;
import principal.Presentador;
import constantes.Constantes;

public class ComandoCambiaPlato implements InterfazCommand {
    /**
     * @uml.property name="ciclista"
     * @uml.associationEnd
     */
    private Ciclista ciclista;
    /**
     * @uml.property name="identificador_ciclista"
     */
    private int identificador_ciclista;
    /**
     * @uml.property name="plato"
     */
    private int plato;

    public ComandoCambiaPlato(int nuevo_identificador_ciclista, int nuevo_plato) {

	identificador_ciclista = nuevo_identificador_ciclista;
	plato = nuevo_plato;
    }

    @Override
    public void configurarContexto(Presentador presentador) {
	ciclista = presentador.getCiclista(identificador_ciclista);

    }

    @Override
    public void execute() {

	if (plato == Constantes.SUBIR) {
	    plato = ciclista.getBici().getPlatoAct();
	    if (plato < Constantes.NUM_PLATOS)
		ciclista.cambiaPlato(plato + 1);
	} else if (plato == Constantes.BAJAR) {
	    plato = ciclista.getBici().getPlatoAct();
	    if (plato > 0)
		ciclista.cambiaPlato(plato - 1);
	} else {
	    ciclista.cambiaPlato(plato);
	}

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "Plato cambiado en el ciclista "
		+ ciclista.getIdentificador_ciclista() + "\n plato actual :"
		+ ciclista.getPlatoActualBici();
    }

    @Override
    public String obtenerAyuda() {
	return "bicicleta <num_bicicleta> cambia plato <num_pinon>";

    }

    @Override
    public InterfazCommand parse(String nombre) {

	int id_ciclista;
	int nuevo_plato;
	InterfazCommand c = null;

	String[] atributos = nombre.split("\\s");
	if (atributos.length ==5 
	&& atributos[0].equalsIgnoreCase("bicicleta")
	&& Integer.parseInt(atributos[1]) >= 0
	&& Integer.parseInt(atributos[1]) < Constantes.NUM_ACT_CICLISTAS
	&& atributos[2].equalsIgnoreCase("cambia")
	&& atributos[3].equalsIgnoreCase("plato")) 
	{
		    id_ciclista = Integer.parseInt(atributos[1]);
		    nuevo_plato = Integer.parseInt(atributos[4]);
		    if (nuevo_plato >= 0 && nuevo_plato < Constantes.NUM_PLATOS) {
			c = new ComandoCambiaPlato(id_ciclista, nuevo_plato);
		    }
		    if (nuevo_plato == Constantes.SUBIR) {

			c = new ComandoCambiaPlato(id_ciclista,
				Constantes.SUBIR);
		    }

		    if (nuevo_plato == Constantes.BAJAR) {

			c = new ComandoCambiaPlato(id_ciclista,
				Constantes.BAJAR);
		    }
	
	}
	return c;

    }

}
