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
    private String tipoViento;
    /**
     * @uml.property name="hora"
     */
    private String hora;

    public ComandoViento(String mihora, String tipo) {

	tipoViento = tipo;
	hora = mihora;
	// TODO Auto-generated constructor stub
    }

    @Override
    public void configurarContexto(Presentador presentador) {
	viento = presentador.getViento();

    }

    @Override
    public void execute() {
	viento.setViento(hora, tipoViento);
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	return "Aviso de viento " + tipoViento + " a las " + hora;

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return "viento <hh:mm:ss> <tipo>";
    }

    @Override
    // Viento HORA ESTADO KMS/H
    public InterfazCommand parse(String nombre) {

	String tipoviento;
	String hora;
	InterfazCommand c = null;

	String[] atributos = nombre.split("\\s");
	if (atributos.length >= 2) {
	    if (atributos[0].equalsIgnoreCase("viento")) {
		hora = atributos[1];
		if (atributos[3].equalsIgnoreCase(Constantes.VIENTO_A_FAVOR
			.toString())
			|| atributos[3]
				.equalsIgnoreCase(Constantes.VIENTO_EN_CONTRA)
			|| atributos[3]
				.equalsIgnoreCase(Constantes.VIENTO_NULO)) {
		    tipoviento = atributos[3];
		    c = new ComandoViento(hora, tipoviento);

		}
	    }
	}
	return c;
    }

}
