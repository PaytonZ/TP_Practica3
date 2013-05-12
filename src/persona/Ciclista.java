package persona;

import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;
import bicicleta.Bicicleta;
import constantes.Constantes;

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
    private double fuerza_ciclista;
    private double tiempoFrenado;
    private double cantidadFreno;
    private boolean muerto;
    public Ciclista(Bicicleta nueva_bici, int id) {
	cadencia = 1;
	setBici(nueva_bici);
	identificador_ciclista = id;
	cantidadFreno = 0;
	tiempoFrenado = 0;
	fuerza_ciclista = 100;
	muerto=false;
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
	
	//Si el ciclista esta muerto no se ejecuta y su velocidad es 0
	if(!muerto){
	    pedalear(cadencia);
	    bici.calculaEspacioRecorrido();
	    bici.calculaVelocidadActual();
        
	    if (tiempoFrenado > 0) {
        	bici.frenar((float) cantidadFreno);
        	tiempoFrenado--;
	    }
        
	    // Modificado para que se acabe la fuerza en ejecucion
	   // fuerza_ciclista -= ((masa + getBici().getMasa()) * getBici()
        		//.getVelocidad()) / 10;
	    setFuerza_ciclista(fuerza_ciclista-(((masa + getBici().getMasa()) * getBici()
        		.getVelocidad()) / 5));
	}else{
	    bici.setVelocidad(0);
	}
    }

    /**
     * @param muerto the muerto to set
     */
    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
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

    public int getIdentificador_ciclista() {
	return identificador_ciclista;
    }

    public String getPinonActualBici() {
	return String.valueOf(bici.getPinonAct());
    }

    public String getPlatoActualBici() {
	return String.valueOf(bici.getPlatoAct());
    }

    public double getCadencia() {
	return cadencia;
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

	return "ciclista" + identificador_ciclista + "%" + bici.muestra()
		+ "Fuerza:" + fuerza_ciclista + "#,";
    }

    public void setCadencia(double nueva_cadencia) {
	if (nueva_cadencia > 2) {
	    nueva_cadencia = 2;

	}
	cadencia = nueva_cadencia;
    }

    /**
     * @return the fuerza_ciclista
     */
    public double getFuerza_ciclista() {
	return fuerza_ciclista;
    }

    public void setCantidadFreno(double fren) {
	cantidadFreno = fren;
    }

    public void setTiempoFreno(double time) {
	tiempoFrenado = time;
    }

    /** Si esta muerto no hace nada
     * Si la fuerza <=0 lo mata
     * si fuerza >0 actualiza la fuerza
     * @param fuerza_ciclista
     *            the fuerza_ciclista to set
     */
    public void setFuerza_ciclista(double fuerza_ciclista) {
	if(fuerza_ciclista<=0&&!muerto){
	    this.fuerza_ciclista = 0;
	    this.muerto=true;
	}
	else if(!muerto)
	    this.fuerza_ciclista = fuerza_ciclista;
    }

    public void cambiaPlato(int nuevo_plato) {
	if (nuevo_plato >= 0 && nuevo_plato < Constantes.NUM_PLATOS) {
	    bici.setPlatoact(nuevo_plato);
	}
    }

    public void cambiaPinon(int nuevo_pinon) {
	if (nuevo_pinon >= 0 && nuevo_pinon < Constantes.NUM_PINONES) {

	    bici.setPinonact(nuevo_pinon);
	}
    }

}
