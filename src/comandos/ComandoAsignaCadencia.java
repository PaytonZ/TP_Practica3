package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoAsignaCadencia implements InterfazCommand {
    Ciclista ciclista;
    double cadencia;
    int identificador_ciclista;

    public ComandoAsignaCadencia(double nueva_cadencia,
	    int nuevo_identificador_ciclista) {

	cadencia = nueva_cadencia;
	identificador_ciclista = nuevo_identificador_ciclista;
    }

    @Override
    public void execute() {

	if (cadencia <= 2 && cadencia >= 0)
	    ciclista.setCadencia(cadencia);

    }

    @Override
    public void configurarContexto(CiclistaManager cm) {

	ciclista = cm.getCiclista(identificador_ciclista);

    }

    @Override
    public String obtenerAyuda() {
	return "asignacadencia <numero_de_ciclista> <nueva_cadencia>";

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub

	return "cadencia aumentada en el ciclista "
		+ ciclista.getIdentificador_ciclista() + "\ncadencia actual :"
		+ ciclista.getCadencia();
    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	StringTokenizer comandosYatributos = new StringTokenizer(nombre,
		"\n\r ");
	int numciclista = -1;
	double nueva_cadencia = 0;

	if (comandosYatributos.nextToken().equalsIgnoreCase("asignacadencia")) {
	    if (comandosYatributos.countTokens() == 2) {
		numciclista = Integer.parseInt(comandosYatributos.nextToken());
		// String auxpar1 = comandosYatributos.nextToken();
		nueva_cadencia = Integer.parseInt(comandosYatributos
			.nextToken());
		c = new ComandoAsignaCadencia(nueva_cadencia, numciclista);
	    }
	}

	return c;

    }

}
