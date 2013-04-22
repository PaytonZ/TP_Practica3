package comandos;

import factoresExternos.Viento;
import persona.Ciclista;

public class ComandoViento implements InterfazCommand{

    Viento viento;
    String tipoViento ;
    String hora;
    String velocidad;
    
    public ComandoViento(Viento miviento,String mihora,String tipo,String mivelocidad) {
	viento = miviento;
	velocidad = mivelocidad;
	tipoViento = tipo;
	hora = mihora;
	// TODO Auto-generated constructor stub
    }
    @Override
    public boolean parse(String nombre) {
	boolean iguales = false;
	if (nombre.equalsIgnoreCase("viento")) {
	    iguales = true;
	}
	return iguales;
    }

    @Override
    public void execute() {
	viento.setViento(hora, tipoViento,velocidad);
	// TODO Auto-generated method stub
	
    }

    @Override
    public void configurarContexto() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void obtenerAyuda() {
	// TODO Auto-generated method stub
	
    }

}
