package comandos;

import java.util.StringTokenizer;

import persona.Ciclista;

public class ComandoAsignaCadencia implements InterfazCommand {
    Ciclista ciclista;
    double cadencia;
    int identificador_ciclista;

    public ComandoAsignaCadencia(double nueva_cadencia, int nuevo_identificador_ciclista) {
	
	cadencia= nueva_cadencia;
	identificador_ciclista= nuevo_identificador_ciclista;
       }

    @Override
    public void execute() {
	if (cadencia <= 2 && cadencia >= 0)
	    ciclista.setCadencia
	    (cadencia);

	

    }

    @Override
    public void configurarContexto() {
	

    }

    @Override
    public void obtenerAyuda() {
	

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub

	return "cadencia aumentada en el ciclista "
		+ ciclista.getIdentificador_ciclista()
		+ "\ncadencia actual :" + ciclista.getCadencia();
    }

    @Override
    public InterfazCommand parse(String nombre) {
	
	StringTokenizer comandosYatributos = new StringTokenizer(nombre, "\n\r ");
	int numciclista = -1;
	double cadencia = 0;
	
	if (comandosYatributos.nextToken().equalsIgnoreCase("asignacadencia")) {
	    if (comandosYatributos.countTokens() == 3) {
		numciclista = Integer.parseInt(comandosYatributos.nextToken());
		String auxpar1 = comandosYatributos.nextToken();
		 cadencia = Double.parseDouble(auxpar1);
					
	}
}
	
	return new ComandoAsignaCadencia(cadencia, numciclista );
   
  }

}
