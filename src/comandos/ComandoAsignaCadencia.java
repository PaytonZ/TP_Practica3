package comandos;

import persona.Ciclista;
import principal.Presentador;
import constantes.Constantes;

public class ComandoAsignaCadencia implements InterfazCommand {
    /**
     * @uml.property name="ciclista"
     * @uml.associationEnd
     */
    private Ciclista ciclista;
    /**
     * @uml.property name="cadencia"
     */
    private double cadencia;
    /**
     * @uml.property name="identificador_ciclista"
     */
    private int identificador_ciclista;

    public ComandoAsignaCadencia(double nueva_cadencia,
	    int nuevo_identificador_ciclista) {

	cadencia = nueva_cadencia;
	identificador_ciclista = nuevo_identificador_ciclista;
    }

    @Override
    public void configurarContexto(Presentador presentador) {

	ciclista = presentador.getCiclista(identificador_ciclista);

    }

    @Override
    public void execute() {

	if (cadencia == Constantes.SUBIR) {
	    if (ciclista.getCadencia() < 2)

		ciclista.setCadencia(ciclista.getCadencia() + 1);
	} else if (cadencia == Constantes.BAJAR) {
	    if (ciclista.getCadencia() > 0)

		ciclista.setCadencia(ciclista.getCadencia() - 1);
	} else if (cadencia <= 2 && cadencia >= 0) {
	    ciclista.setCadencia(cadencia);
	}

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub

	return "cadencia cambiada en el ciclista "
		+ ciclista.getIdentificador_ciclista() + "\ncadencia actual :"
		+ ciclista.getCadencia();
    }

    @Override
    public String obtenerAyuda() {
	return "ciclista <num_ciclista> cadencia <0 a 120 pedaladas> periodo <periodo en minutos>";

    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	int num_ciclista;
	double cadencia;
	double periodo;

	
	String[] atributos = nombre.split("\\s");
	if (atributos.length == 6
	&& atributos[0].equalsIgnoreCase("ciclista")
	&& Integer.parseInt(atributos[1]) >= 0
	&& Integer.parseInt(atributos[1]) < Constantes.NUM_ACT_CICLISTAS
	&& atributos[2].equalsIgnoreCase("cadencia")) 
	{

			cadencia = Double.parseDouble(atributos[3]);
			num_ciclista = Integer.parseInt(atributos[1]);
			
			if (cadencia >= 0 && cadencia <= 120) {
			    if (atributos[4].equalsIgnoreCase("periodo")) {
				periodo = Double.parseDouble(atributos[5]);

				if (periodo > 0 && periodo <= 1) {
				    cadencia = cadencia / (periodo * 60);
				    c = new ComandoAsignaCadencia(cadencia,
					    num_ciclista);
				}
			    }

			} else if (cadencia == Constantes.SUBIR) {

			    if (atributos[4].equalsIgnoreCase("periodo")) {
				periodo = Double.parseDouble(atributos[5]);

				if (periodo > 0 && periodo <= 1) {
				    cadencia = cadencia / (periodo * 60);
				    c = new ComandoAsignaCadencia(
					    Constantes.SUBIR, num_ciclista);
				}
			    }
			} 
			else if (cadencia == Constantes.BAJAR) {
			    if (atributos[4].equalsIgnoreCase("periodo")) {
				periodo = Double.parseDouble(atributos[5]);

				if (periodo > 0 && periodo <= 1) {
				    cadencia = cadencia / (periodo * 60);
				    c = new ComandoAsignaCadencia(
					    Constantes.BAJAR, num_ciclista);
				}
			    }
		
			}
	}
	return c;

    }

}
