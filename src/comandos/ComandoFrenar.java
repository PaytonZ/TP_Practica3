package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoFrenar implements InterfazCommand {
    Ciclista cic;
    double valor;
    int tiempo;
    int id;
    public ComandoFrenar(int nuevo_identificador_ciclista, double mivalor, int mitiempo) {
	id = nuevo_identificador_ciclista;
	valor = mivalor;
	tiempo = mitiempo;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	InterfazCommand c = null;
	StringTokenizer comandosYatributos = new StringTokenizer(nombre,
		"\n\r ");
	

	if (comandosYatributos.nextToken().equalsIgnoreCase("frenar")) {
	    if (comandosYatributos.countTokens() == 3) {
		id = Integer.parseInt(comandosYatributos.nextToken());
		// String auxpar1 = comandosYatributos.nextToken();
		valor = Integer.parseInt(comandosYatributos
			.nextToken());
		tiempo = Integer.parseInt(comandosYatributos
			.nextToken());
		c = new ComandoFrenar(id, valor,tiempo);
	    }
	    else
	    {
		c = new ComandoIncompleto(this.obtenerAyuda());
	    }
		
	}

	return c;

    }

    @Override
    public void execute() {

	cic.setCantidadFreno(valor);
	cic.setTiempoFreno(tiempo);

    }

    @Override
    public String getInformacionInstruccion() {

	return "freno aplicado en ciclista" + cic.getIdentificador_ciclista();
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {

	cic= cm.getCiclista(id);

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "frenar <id ciclista> <valor> <tiempo>";
    }

}