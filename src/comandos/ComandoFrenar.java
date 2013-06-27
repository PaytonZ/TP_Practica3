package comandos;

import persona.Ciclista;
import principal.Presentador;
import constantes.Constantes;

public class ComandoFrenar implements InterfazCommand {
    /**
     * @uml.property name="cic"
     * @uml.associationEnd
     */
    private Ciclista cic;
    /**
     * @uml.property name="tiempo"
     */
    private double tiempo;
    
    private double cantidad;
    /**
     * @uml.property name="id"
     */
    private int id;

    public ComandoFrenar(int nuevo_identificador_ciclista, double mitiempo, double _cantidad) {
	id = nuevo_identificador_ciclista;
	cantidad = _cantidad;
	tiempo = mitiempo;
	// TODO Auto-generated constructor stub
    }

    @Override
    public void configurarContexto(Presentador presentador) {

	cic = presentador.getCiclista(id);

    }

    @Override
    public void execute() {
	cic.setTiempoFreno(tiempo);
	cic.setCantidadFreno(cantidad);

    }

    @Override
    public String getInformacionInstruccion() {

	return "freno aplicado en ciclista" + cic.getIdentificador_ciclista();
    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "ciclista <num_ciclista> frena <cantidad> en <tiempo>";
    }

    @Override
    // ciclista n frena
    // CANTIDAD en tiempo
    public InterfazCommand parse(String nombre) {
	InterfazCommand c = null;
	int num_ciclista;
	double tiempo=0;
	double cantidad=0;
	String[] atributos = nombre.split("\\s");
	int i = 0;
	
	if (atributos.length == 6
	    && atributos[0].equalsIgnoreCase("ciclista")
	    && Integer.parseInt(atributos[1]) >= 0
	    && Integer.parseInt(atributos[1])< Constantes.NUM_ACT_CICLISTAS 
	    && atributos[2].equalsIgnoreCase("frena")
	    && Integer.parseInt(atributos[3]) >= 0
	    && atributos[4].equalsIgnoreCase("en")
	    && Integer.parseInt(atributos[5]) >0)
	    {
	    		num_ciclista = Integer.parseInt(atributos[1]);
	    		cantidad = Integer.parseInt(atributos[3]);
			tiempo = Double.parseDouble(atributos[5]);
			if (tiempo > 0)
			{
			    if(cantidad == 0)
			    {
				c = new ComandoFrenar(num_ciclista, tiempo, 0);
			    }
			    else
			    {
				c = new ComandoFrenar(num_ciclista, tiempo, 1/cantidad);
			    }
			    
			}

	    }
	

	return c;

    }

}