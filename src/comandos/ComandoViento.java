package comandos;

import principal.Presentador;
import constantes.Constantes;
import factoresExternos.Viento;

public class ComandoViento implements InterfazCommand {

    /**
     * @uml.property name="viento"
     * @uml.associationEnd
     */
    private Viento viento;
    /**
     * @uml.property name="tipoViento"
     */
    private double velViento;
    /**
     * @uml.property name="hora"
     */
    private String hora;

    public ComandoViento(String mihora, double velocidad) {

	velViento = velocidad;
	hora = mihora;
	// TODO Auto-generated constructor stub
    }

    @Override
    public void configurarContexto(Presentador presentador) {
	viento = presentador.getViento();

    }

    @Override
    public void execute() {
	viento.setViento(hora, velViento);
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	String frase = "";
	if(velViento >0)
	    
	frase = "Aviso de viento ENCONTRA con velocidad   " + velViento  + " a las " + hora;
	
	if(velViento ==0)
	    
		frase = "Aviso de viento NULO  a las " + hora;
	if(velViento <0)
	    
	    frase = "Aviso de viento AFAVOR con velocidad   " + velViento *-1  + " a las " + hora;
	
		
	return frase;

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "viento <hh:mm:ss> <tipo>";
    }

    @Override
    // Viento HORA ESTADO KMS/H
    public InterfazCommand parse(String nombre) {

	double velViento = 0;
	String hora;
	InterfazCommand c = null;

	String[] atributos = nombre.split("\\s");
	if (atributos.length >= 3) 
	{
	    if (atributos[0].equalsIgnoreCase("viento")) 
	    {
		hora = atributos[1];
		System.out.println(atributos[1]);
		
		if(atributos.length == 3)
		{
		    if(atributos[2].equalsIgnoreCase(Constantes.VIENTO_NULO))
			{
			    velViento = 0;
			}
		    c = new ComandoViento(hora, velViento);
		}
		else
		
		{
		    	if (atributos[2].equalsIgnoreCase(Constantes.VIENTO_A_FAVOR.toString()))
			{
			    velViento = Double.parseDouble(atributos[3]);
			    velViento = velViento * -1;
			}
			else if(atributos[2].equalsIgnoreCase(Constantes.VIENTO_EN_CONTRA))
			{
			    velViento = Double.parseDouble(atributos[3]);
			    
			}
		    	 c = new ComandoViento(hora, velViento);
		}
	    
	    }
	}
	return c;
    }

}
