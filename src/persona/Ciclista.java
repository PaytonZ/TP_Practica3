package persona;

import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;
import bicicleta.*;

/**
 * Esta clase representa una especializacion de persona , ciclista , es decir ,
 * persona que conduce una bicicleta y conoce su interfaz
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 * 
 */
public class Ciclista extends Persona implements InterfaceEjecuta,
	InterfaceSalida {
    private double cadencia; // numero de pedaladas por segundo
    private Bicicleta bici;
    private int identificador_ciclista;

    public Ciclista(Bicicleta nueva_bici, int id) {
	cadencia = 1;
	setBici(nueva_bici);
	identificador_ciclista = id;

    }

    /**
     * Acción básica del ciclista. Mandará un mensaje a su bicicleta con las
     * pedaladas por segundo. Si ha alcanzado la velocidad máxima ( relacionada
     * con la relaciones de piñones y demás especificaciones de la bicicleta )
     * el pedaleo no tendrá efecto
     * 
     */
    public void pedalear(double cadencia) {

	getBici().setCadencia(cadencia);

    }

    /*
     * // asigna un rumbo que se enviara a la bicicleta public void setRumbo(int
     * d, Bicicleta bici) { bici.setDireccion(d); }
     */

    /**
     * este metodo envia la accion a la bicicleta de cambiar piñon,
     * 
     * @param accion
     *            si es una 'a' aumentara piñon, si es 'd' disminuira piñon
     */
    public void cambiarPinon(char accion) {

	if (accion == 'a') {
	    bici.setPinon('a');
	}
	if (accion == 'd') {
	    bici.setPinon('d');
	}
    }

    public void aumentaPinon() {
	cambiarPinon('a');
    }

    public void disminuyePinon() {
	cambiarPinon('d');
    }

    /**
     * este metodo envia la accion a la bicicleta de cambiar plato,
     * 
     * @param accion
     *            si es una 'a' aumentara plato, si es 'd' disminuira plato
     */
    public void cambiarPlato(char accion) {

	if (accion == 'a') {
	    bici.setPlato('a');
	}
	if (accion == 'd') {
	    bici.setPlato('d');
	}
    }

    public void aumentaPlato() {
	cambiarPlato('a');

    }

    public void disminuyePlato() {
	cambiarPlato('d');

    }

    /**
     * este metodo esta heredado de la clase InterfazEjecuta, y todo lo que haya
     * en el, se ejecutara cuando se realice el for each de la lista
     * correspondiente
     */
    @Override
    public void ejecuta() {
	// setCadencia('a'); en un futuro servira para aumentar o disminuir la
	// cadencia
	pedalear(cadencia);
	bici.calculaEspacioRecorrido();
	bici.calculaVelocidadActual();
	bici.getCarretera().calculaFactor();
	bici.getViento().calculaFactor();
	// cambiarPlato('d');
	// cambiarPinon('a');

    }

    /**
     * devuelve la bicicleta usada por el ciclista
     * 
     * @return the bici
     */
    public Bicicleta getBici() {
	return bici;
    }

    /**
     * asigna bicicleta al ciclista
     * 
     * @param bici
     *            the bici to set
     */
    public void setBici(Bicicleta mibici) {
	this.bici = mibici;
    }

    /**
     * este metodo esta heredado de la clase InterfazSalida, y todo lo que haya
     * en el, se mostrara cuando se realice el for each de la lista
     * correspondiente
     * 
     * @return
     */
    /*
     * @Override public String muestra() {
     * 
     * return ""; }
     */
    /*
     * public void setCadencia(char accion) { if (accion == 'a') { //
     * if(cadencia < maximocadencia) cadencia++; } else if (accion == 'd') { if
     * (cadencia > 0) { cadencia--; }
     * 
     * } bici.setCadencia(cadencia); }
     * 
     * public void aumentarCadencia() { setCadencia('a'); }
     * 
     * public void disminuirCadencia() { setCadencia('d'); }
     * 
     * /**
     * 
     * @return the identificador_ciclista
     */

    public int getIdentificador_ciclista() {
	return identificador_ciclista;
    }

    public String getPinonActualBici() {
	return String.valueOf(bici.getPinonAct());
    }

    public String getPlatoActualBici() {
	return String.valueOf(bici.getPlatoAct());
    }

    public String getCadencia() {
	return String.valueOf(cadencia);
    }

    /**
     * @param identificador_ciclista
     *            the identificador_ciclista to set
     */
    public void setIdentificador_ciclista(int nuevo_identificador_ciclista) {
	identificador_ciclista = nuevo_identificador_ciclista;
    }

    @Override
    public String muestra() {

	return "ciclista" + identificador_ciclista + "%" + bici.muestra();
    }

    public void setCadencia(double nueva_cadencia) {
	if(nueva_cadencia >2)
	{
	    nueva_cadencia = 2;
	    
	    
	}
	cadencia = nueva_cadencia;
    }
    public void frenar(double cantidad,double tiempo)
    {
	bici.frenar(cantidad, tiempo);
    }
}
