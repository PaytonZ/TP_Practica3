package comandos;

import persona.Ciclista;
import principal.Presentador;
import constantes.Constantes;

public class ComandoAsignaCadencia implements InterfazCommand {
    private Ciclista ciclista;
    private double cadencia;
    private int identificador_ciclista;

    public ComandoAsignaCadencia(double nueva_cadencia,
	    int nuevo_identificador_ciclista) {

	cadencia = nueva_cadencia;
	identificador_ciclista = nuevo_identificador_ciclista;
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
    public void configurarContexto(Presentador presentador) {

	ciclista = presentador.getCiclista(identificador_ciclista);

    }

    @Override
    public String obtenerAyuda() {
	return "ciclista <num_ciclista> cadencia <cadencia> periodo <periodo>";

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub

	return "cadencia cambiada en el ciclista "
		+ ciclista.getIdentificador_ciclista() + "\ncadencia actual :"
		+ ciclista.getCadencia();
    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	int num_ciclista;
	double cadencia;
	double periodo;

	String[] atributos = nombre.split("\\s");
	if (atributos.length >= 5) {
	    if (atributos[0].equalsIgnoreCase("ciclista")) {
		num_ciclista = Integer.parseInt(atributos[1]);
		if (num_ciclista >= 0
			&& num_ciclista < Constantes.MAX_CICLISTAS) {
		    if (atributos[2].equalsIgnoreCase("cadencia")) {

			cadencia = Double.parseDouble(atributos[3]);
			if (cadencia >= 0 && cadencia <= 120) {
			    if (atributos[4].equalsIgnoreCase("periodo")) {
				periodo = Double.parseDouble(atributos[5]);
				
				if (periodo > 0 && periodo <= 1) {
				    cadencia = cadencia / (periodo * 60);
				    c = new ComandoAsignaCadencia(cadencia,
					    num_ciclista);
				}
			    }

			}
		    }
		}
	    }
	}
	return c;

    }

}
