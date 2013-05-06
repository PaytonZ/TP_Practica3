package comandos;

import java.util.StringTokenizer;

import constantes.Constantes;

import persona.Ciclista;
import principal.Presentador;

public class ComandoFrenar implements InterfazCommand {
    private Ciclista cic;
    private double tiempo;
    private int id;

    public ComandoFrenar(int nuevo_identificador_ciclista, double mitiempo) {
	id = nuevo_identificador_ciclista;

	tiempo = mitiempo;
	// TODO Auto-generated constructor stub
    }

    @Override
    // ciclista n frena
    // CANTIDAD en tiempo
    public InterfazCommand parse(String nombre) {
	InterfazCommand c = null;
	int num_ciclista;
	double tiempo;
	String[] atributos = nombre.split("\\s");
	if (atributos.length >= 4) {

	    if (atributos[0].equalsIgnoreCase("ciclista")) {
		num_ciclista = Integer.parseInt(atributos[1]);
		if (num_ciclista >= 0
			&& num_ciclista < Constantes.MAX_CICLISTAS) {
		    if (atributos[3].equalsIgnoreCase("frena")) {
			tiempo = Double.parseDouble(atributos[3]);
			if (tiempo >= 0 && tiempo <= 1) {
			    c = new ComandoFrenar(num_ciclista, tiempo);
			}

		    }
		}
	    }
	}

	return c;

    }

    @Override
    public void execute() {

    }

    @Override
    public String getInformacionInstruccion() {

	return "freno aplicado en ciclista" + cic.getIdentificador_ciclista();
    }

    @Override
    public void configurarContexto(Presentador presentador) {

	cic = presentador.getCiclista(id);

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "frenar <id ciclista> <valor> <tiempo>";
    }

}