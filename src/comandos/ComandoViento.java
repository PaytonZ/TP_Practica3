package comandos;

import factoresExternos.Viento;
import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoViento implements InterfazCommand {

    Viento viento;
    String tipoViento;
    String hora;
    String velocidad;

    public ComandoViento(Viento miviento, String mihora, String tipo,
	    String mivelocidad) {
	viento = miviento;
	velocidad = mivelocidad;
	tipoViento = tipo;
	hora = mihora;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	return null;
    }

    @Override
    public void execute() {
	viento.setViento(hora, tipoViento, velocidad);
	// TODO Auto-generated method stub

    }

   
    @Override
    public String getInformacionInstruccion() {
	return "Aviso de viento " + tipoViento + " con velocidad\n" + velocidad
		+ " m/s a las " + hora;

    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }

 
}
