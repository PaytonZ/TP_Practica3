package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoBajaPlato implements InterfazCommand {
    Ciclista cic;
    int identificador_ciclista;
    public ComandoBajaPlato(int nuevo_identificador_ciclista) {
	identificador_ciclista = nuevo_identificador_ciclista;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {

	InterfazCommand c = null;
	StringTokenizer comandosYatributos = new StringTokenizer(nombre,
		"\n\r ");
	if (comandosYatributos.nextToken().equalsIgnoreCase("bajaplato")) {
	    if (comandosYatributos.countTokens() == 1) {

		int numciclista = Integer.parseInt(comandosYatributos
			.nextToken());

		c = new ComandoBajaPlato(numciclista); 
		
	    }
	}
	return c;
    }

    @Override
    public void execute() {

	cic.disminuyePlato();// TODO Auto-generated method stub

    }

    @Override
    public String obtenerAyuda() {
	return null;
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "plato bajado en el ciclista" + cic.getIdentificador_ciclista()
		+ "\n plato actual :" + cic.getPlatoActualBici();
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	// TODO Auto-generated method stub

    }

}
