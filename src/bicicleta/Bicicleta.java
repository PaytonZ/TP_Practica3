package bicicleta;

import factoresExternos.Carretera;
import vista.SalidaDeDatosPorSwing;
import vista.Ventana;
import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

/**
 * 
 * Bicicleta estándar . Hereda de Vehiculo
 * 
 * @author Juan Carlos Marco y Juan Luis Perez
 */
public class Bicicleta extends Vehiculo implements InterfaceSalida {

    // almacena el numero de pedales, ya que puede haber tandems
    protected int numpedales = 2;

    protected int numsillin = 1;
    // el numero actual del pinon y plato activos

    protected int pinonact = 0;
    protected int platoact = 0;

    // los dientes que tiene cada plato y pinon
    protected int dientesplato[];
    protected int dientespinon[];

    // Cada pedalada, la rueda de traccion, arrastrada por el pinon, recorrera
    // un espacio que
    // dependera
    // de la relacion plato / pinon
    protected double relaciontransmision;

    // y del radio de la rueda
    protected double radiorueda;

    // EspacioporcadaPedalada = RecorridoLinealDelaRueda * RelaciondeTransmisin
    private double espaciorecorrido;
    private double espacioporpedalada;
    protected double cadencia;
    protected double factorpendiente;
    protected double factorviento;
    private Carretera carretera;
    double velocidad_anterior;
    double aceleracion;

    public Bicicleta(int numeropinones, int numeroplatos, double radiorueda,
	    int midientepinon[], int midienteplato[], double radio, double masa) {

	super(masa);
	dientesplato = new int[numeroplatos];
	dientespinon = new int[numeropinones];
	numruedas = 2;
	dientesplato[platoact] = 5;
	espacioporpedalada = 0;
	velocidad_anterior = 0;
	velocidad = 0;
	aceleracion = 0;
	// asignamos el numero de dientes a cada piñon y a cada plato

	setAsignaNumeroDientesPinon(midientepinon);

	setAsignaNumeroDientesPlato(midienteplato);

	setRadioRueda((double) radio);
	factorpendiente = 0;
	setCarretera(new Carretera("carretera.txt", this));
	//setViento(new Viento("vientos.txt", this));
    }

    /**
     * devuelve el numero de pedales
     * 
     * @return numpedales
     */
    public int getPedales() {
	return numpedales;
    }

    /**
     * devuelve el peso
     * 
     * @return
     */
    public double getPeso() {
	return peso;
    }

    /**
     * asigna el numero de dientes correspondiente al pinon o plato,
     * 
     * @param numerodientes
     *            es el array que contiene el numero de dientes por pinon o
     *            plato que queremos asignar
     * 
     * @param array
     *            sirve para introducir el array de pinones al cual se le va a
     *            asignar el numero de dientes
     */
    public void setAsignaNumeroDientesPinon(int numerodientes[]) {
	int i = 0;
	boolean compruebadientes = true;
	if (dientespinon.length == numerodientes.length) {

	    i = 1;
	    while (i < dientespinon.length && compruebadientes) {

		if (numerodientes[i - 1] <= numerodientes[i]) {

		    compruebadientes = false;
		}
		i++;
	    }
	    i = 0;

	    if (!compruebadientes) {
		System.out
			.println("Los dientes no se asignaron correctamente porque el "
				+ "piñon siguiente tenia mas dientes que el anterior");
	    } else {
		while (i < dientespinon.length && compruebadientes) {

		    dientespinon[i] = numerodientes[i];
		    i++;
		}
	    }
	} else {
	    System.out
		    .print("no se pueden asignar dientes porque los array de piñones no tienen la "
			    + "misma longitud");
	}
    }

    /**
     * asigna a los platos de la bicicleta, el numero de dientes del array
     * 
     * @param numerodientes
     *            trae el numero de dientes por plato
     */
    public void setAsignaNumeroDientesPlato(int numerodientes[]) {
	int i = 0;
	boolean compruebadientes = true;
	if (dientesplato.length == numerodientes.length) {

	    i = 1;
	    while (i < dientesplato.length && compruebadientes) {

		if (numerodientes[i - 1] >= numerodientes[i]) {

		    compruebadientes = false;
		}
		i++;
	    }
	    i = 0;

	    if (!compruebadientes) {
		System.out
			.println("Los dientes no se asignaron correctamente porque el "
				+ "plato siguiente tenia menos dientes que el anterior");
	    } else {
		while (i < dientesplato.length && compruebadientes) {

		    dientesplato[i] = numerodientes[i];
		    i++;
		}
	    }
	} else {
	    System.out
		    .print("no se pueden asignar dientes porque los array no tienen la "
			    + "misma longitud");
	}
    }

    /**
     * Este metodo recibe la cadencia del ciclista . Realizará los cálculos
     * pertinentes pertenciencientes al Movimiento Rectilineo Uniformente
     * Acelerado ( MRUA ) y devolverá una modificacion de la velocidad de la
     * bicicleta.
     * 
     * @param cadencia
     *            pedaladas por segundo que manda el ciclista
     */
    public void calculaEspacioRecorrido() {

	double velocidad_maxima;

	velocidad_maxima = velocidad * cadencia;

	if (velocidad < velocidad_maxima) {

	}
	// velocidad = (double) (( 2 *Math.PI *getRadioRueda() *
	// getRelacionTransmision() )* getCadencia());

	// asignamos la relacion de marchas actuales
	calculaRelacionTransmision();
	// calculamos la aceleracion

	calculaEspacioPorCadaPedalada();
	calculaVelocidadActual();
	calculaAceleracion();
	espaciorecorrido = espaciorecorrido + velocidad;
    }

    public void calculaAceleracion() {
	aceleracion = velocidad - velocidad_anterior;

    }

    /**
     * sirve para asignar el numero de pedales
     * 
     * @param numero
     */
    public double getRecorridoLinealDeLaRueda() {
	return radiorueda * Math.PI;
    }

    public void calculaEspacioPorCadaPedalada() {
	espacioporpedalada = getRecorridoLinealDeLaRueda()
		* getRelacionTransmision();
    }

    public void frenar(double cantidad, double tiempo) {
	/**
	 * implementar
	 */
    }

    public void calculaVelocidadActual() {
	// la velocidad es el radio de la rueda * 2 PI * relacion de la
	// transmision * cadencia de pedaleo
	/*
	 * velocidad = ((2 * Math.PI * radiorueda * relaciontransmision)
	 * cadencia - factorpendiente - factorviento);
	 */
	// velocidad =aceleracion + velocidad_anterior;

	velocidad = espacioporpedalada * cadencia - factorpendiente
		+ factorviento;
	velocidad_anterior = velocidad;

    }

    public void setPedales(int numero) {
	numpedales = numero;
    }

    /**
     * este metodo asigna un peso
     * 
     */
    public void setPeso(double pesos) {
	peso = pesos;
    }

    /**
     * sirve para aumentar o disminuir el pinon que se quiere usar
     * 
     * @param accion
     *            'a' = aumentar , 'd' = disminuir
     */
    public void setPinon(char accion) {
	// aumentamos el pinon

	if (accion == 'a') {
	    if (pinonact < dientespinon.length - 1) {
		pinonact++;
	    }
	}
	// disminuimos el pinon
	if (accion == 'd') {
	    if (pinonact > 0) {
		pinonact--;
	    }
	}
    }

    public double getDireccion() {
	return direccion;
    }

    /**
     * sirve para aumentar o disminuir el plato que se quiere usar
     * 
     * @param accion
     *            'a' = aumentar , 'd' = disminuir
     */
    public void setPlato(char accion) {
	// aumentamos el pinon
	if (accion == 'a') {
	    if (platoact < dientesplato.length - 1) {
		platoact++;
	    }
	}
	// disminuimos el pinon
	if (accion == 'd') {
	    if (platoact > 0) {
		platoact--;
	    }
	}
    }

    /**
     * este metodo esta heredado de la clase InterfazEjecuta, y todo lo que haya
     * en el, se ejecutara cuando se realice el for each de la lista
     * correspondiente
     */
    /*
     * @Override public void ejecuta() { // TODO Auto-generated method stub
     * //carretera.calculaFactor(); //viento.calculaFactor();
     * calculaEspacioRecorrido(); calculaVelocidadActual();
     * getCarretera().calculaFactor(); getViento().calculaFactor(); }
     */

    /**
     * @return the espacioporpedalada
     */
    public double getEspacioRecorrido() {
	return espaciorecorrido;
    }

    /**
     * @param espacioporpedalada
     *            the espacioporpedalada to set
     */
    public void setEspacioPorPedalada(double espacioporpedalada) {
	this.espaciorecorrido = espacioporpedalada;
    }

    public int getNumpedales() {
	return numpedales;
    }

    public void setNumpedales(int numpedales) {
	this.numpedales = numpedales;
    }

    public int getNumsillin() {
	return numsillin;
    }

    public void setNumsillin(int numsillin) {
	this.numsillin = numsillin;
    }

    public int getPinonAct() {
	return pinonact;
    }

    public void setPinonAct(int pinonact) {
	this.pinonact = pinonact;
    }

    public int getPlatoAct() {
	return platoact;
    }

    public void setPlatoAct(int platoact) {
	this.platoact = platoact;
    }

    public int getDientesPlato(int plato) {
	return dientesplato[plato];
    }

    public int getDientesPinon(int pinon) {
	return dientespinon[pinon];
    }

    public int[] getDientesPlato() {
	return dientesplato;
    }

    public int[] getDientesPinon() {
	return dientespinon;
    }

    public double getRelacionTransmision() {
	return relaciontransmision;
    }

    public void calculaRelacionTransmision() {

	relaciontransmision = ((double) dientesplato[platoact] / (double) dientespinon[pinonact]);

    }

    public double getRadioRueda() {
	return radiorueda;
    }

    public void setRadioRueda(double radiorueda) {
	this.radiorueda = radiorueda;
    }

    public double getLongitudRueda() {
	double longitudrueda = 1;
	// longitudrueda = 2 *
	return longitudrueda;
    }

    /**
     * este metodo esta heredado de la clase InterfazSalida, y todo lo que haya
     * en el, se mostrara cuando se realice el for each de la lista
     * correspondiente
     * 
     * @return
     */
    @Override
    public String muestra() {

	String mensaje = "";

	mensaje += String.valueOf(getVelocidad());
	mensaje += "#velocidad" + ",";

	mensaje += String.valueOf(getEspacioRecorrido());
	mensaje += "#distancia" + ",";

	mensaje += String.valueOf(getCadencia());
	mensaje += "#cadencia" + ",";

	return mensaje;

    }

    public void setCadencia(double micadencia) {

	cadencia = (micadencia >= 0) ? micadencia : -micadencia;

    }

    public double getCadencia() {
	return cadencia;
    }

    public void setFactorPendiente(double fact) {
	factorpendiente = fact;
    }

    public double getFactorPendiente() {
	return factorpendiente;
    }

    public void setFactorViento(double fact) {
	factorviento = fact;
    }

    public double getFactorViento() {
	return factorviento;

    }

    /**
     * @return the carretera
     */
    public Carretera getCarretera() {
	return carretera;
    }

    /**
     * @param carretera
     *            the carretera to set
     */
    public void setCarretera(Carretera carretera) {
	this.carretera = carretera;
    }
    
    public void setVelocidad(double vel)
    {
	velocidad = vel;
    }

  

}