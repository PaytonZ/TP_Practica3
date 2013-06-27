package bicicleta;

import constantes.Constantes;
import factoresExternos.Carretera;
import interfaceMain.InterfaceSalida;

/**
 * 
 * Bicicleta estándar . Hereda de Vehiculo
 * 
 * @author Juan Carlos Marco y Juan Luis Perez
 */
public class Bicicleta extends Vehiculo implements InterfaceSalida {

    // almacena el numero de pedales, ya que puede haber tandems
    /**
     * @uml.property name="numpedales"
     */
    protected int numpedales = 2;

    /**
     * @uml.property name="numsillin"
     */
    protected int numsillin = 1;
    // el numero actual del pinon y plato activos

    /**
     * @uml.property name="pinonact"
     */
    private int pinonact = 0;
    /**
     * @uml.property name="platoact"
     */
    private int platoact = 0;

    // los dientes que tiene cada plato y pinon
    /**
     * @uml.property name="dientesplato" multiplicity="(0 -1)" dimension="1"
     */
    protected int dientesplato[];
    /**
     * @uml.property name="dientespinon" multiplicity="(0 -1)" dimension="1"
     */
    protected int dientespinon[];

    // Cada pedalada, la rueda de traccion, arrastrada por el pinon, recorrera
    // un espacio que
    // dependera
    // de la relacion plato / pinon
    /**
     * @uml.property name="relaciontransmision"
     */
    protected double relaciontransmision;

    // y del radio de la rueda
    /**
     * @uml.property name="radiorueda"
     */
    protected double radiorueda;

    // EspacioporcadaPedalada = RecorridoLinealDelaRueda * RelaciondeTransmisin
    /**
     * @uml.property name="espaciorecorrido"
     */
    private double espaciorecorrido;
    /**
     * @uml.property name="espacioporpedalada"
     */
    private double espacioporpedalada;
    /**
     * @uml.property name="cadencia"
     */
    protected double cadencia;
    /**
     * @uml.property name="factorpendiente"
     */
    protected double factorpendiente;
    /**
     * @uml.property name="factorviento"
     */
    protected double factorviento;
    /**
     * @uml.property name="carretera"
     * @uml.associationEnd multiplicity="(1 1)"
     *                     inverse="bici:factoresExternos.Carretera"
     */
    protected double recorridoLinealDeLaRueda ;
    private Carretera carretera;
    /**
     * @uml.property name="velocidad_anterior"
     */
    private double velocidad_anterior;
    /**
     * @uml.property name="aceleracion"
     */
    private double aceleracion;
    /**
     * @uml.property name="freno"
     */
    private double freno;
    
    private boolean campeon ;

    public Bicicleta(int numeropinones, int numeroplatos,
	    int midientepinon[], int midienteplato[], double radio, double masa) {

	super(masa);
	campeon = false;
	dientesplato = new int[numeroplatos];
	dientespinon = new int[numeropinones];
	numruedas = 2;
	dientesplato[getPlatoAct()] = 5;
	espacioporpedalada = 0;
	velocidad_anterior = 0;
	velocidad = 0;
	aceleracion = 0;
	freno = 0;
	
	
	recorridoLinealDeLaRueda = radio * Math.PI;
	// asignamos el numero de dientes a cada piñon y a cada plato

	setAsignaNumeroDientesPinon(midientepinon);

	setAsignaNumeroDientesPlato(midienteplato);

	
	//setCarretera(new Carretera("carretera.txt", this));

	
    }

    public void acelerarbici(double _aceleracion) {
	
	aceleracion += _aceleracion;
	

    }


    public void calculaEspacioPorCadaPedalada() {
	espacioporpedalada = recorridoLinealDeLaRueda
		* relaciontransmision;
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
    public void calculaEspacioRecorrido() 
    {

	// asignamos la relacion de marchas actuales
	calculaRelacionTransmision();
	// calculamos la aceleracion
	calculaVelocidad();
	calculaEspacioPorCadaPedalada();
	
	espaciorecorrido = espaciorecorrido + velocidad;
	    
	if(espaciorecorrido >= Constantes.MAX_METROS_CARRETERA)
	{
	    campeon = true;
	}
	aceleracion = 0;
    }

   
    public void calculaVelocidad()
    {
	
	
	velocidad = espacioporpedalada *  cadencia - aceleracion - freno;
		
	
	if(velocidad < 0)
	{
	    velocidad = 0;
	}
    }
    
    public boolean getCampeon()
    {
	return campeon;
    }
    public void frena(double cantidadfreno)
    {
	//System.out.println(cantidadfreno);
	freno = freno + cantidadfreno;
    }
    public void calculaRelacionTransmision() {

	relaciontransmision = ((double) dientesplato[getPlatoAct()] / (double) dientespinon[getPinonAct()]);

    }



    /**
     * @return
     * @uml.property name="cadencia"
     */
    public double getCadencia() {
	return cadencia;
    }

    /**
     * @return the carretera
     * @uml.property name="carretera"
     */
    public Carretera getCarretera() {
	return carretera;
    }

    public int[] getDientesPinon() {
	return dientespinon;
    }

    public int getDientesPinon(int pinon) {
	return dientespinon[pinon];
    }

    public int[] getDientesPlato() {
	return dientesplato;
    }

    public int getDientesPlato(int plato) {
	return dientesplato[plato];
    }

    @Override
    public double getDireccion() {
	return direccion;
    }

    /**
     * @return the espacioporpedalada
     */
    public double getEspacioRecorrido() {
	return espaciorecorrido;
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

    public double getFactorPendiente() {
	return factorpendiente;
    }

    public double getFactorViento() {
	return factorviento;

    }

   

    /**
     * @return
     * @uml.property name="numpedales"
     */
    public int getNumpedales() {
	return numpedales;
    }

    /**
     * @return
     * @uml.property name="numsillin"
     */
    public int getNumsillin() {
	return numsillin;
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

    public int getPinonAct() {
	return pinonact;
    }

    public int getPlatoAct() {
	return platoact;
    }

    public double getRadioRueda() {
	return radiorueda;
    }

    /**
     * sirve para asignar el numero de pedales
     * 
     * @param numero
     */
    public double getRecorridoLinealDeLaRueda() {
	return recorridoLinealDeLaRueda;
    }

    public double getRelacionTransmision() {
	return relaciontransmision;
    }

    public double getVelocidad()
    {
	return velocidad;
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

	mensaje += String.valueOf(  velocidad);
	mensaje += "#velocidad" + ",";

	mensaje += String.valueOf(getEspacioRecorrido());
	mensaje += "#distancia" + ",";

	mensaje += String.valueOf(getCadencia());
	mensaje += "#cadencia" + ",";

	return mensaje;

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
     * @param micadencia
     * @uml.property name="cadencia"
     */
    public void setCadencia(double micadencia) {

	if(micadencia >=0)
	{
	    cadencia = micadencia;
	}

    }

    /**
     * @param carretera
     *            the carretera to set
     * @uml.property name="carretera"
     */
    public void setCarretera(Carretera carretera) {
	this.carretera = carretera;
    }

    /**
     * @param espacioporpedalada
     *            the espacioporpedalada to set
     */
    public void setEspacioPorPedalada(double espacioporpedalada) {
	this.espaciorecorrido = espacioporpedalada;
    }

    public void setFactorPendiente(double fact) {
	factorpendiente = fact;
    }

    public void setFactorViento(double fact) {
	factorviento = fact;
    }

    /**
     * @param fre
     * @uml.property name="freno"
     */
    public void setFreno(double fre) {
	freno = fre;
    }

    /**
     * @param numpedales
     * @uml.property name="numpedales"
     */
    public void setNumpedales(int numpedales) {
	this.numpedales = numpedales;
    }

    /**
     * @param numsillin
     * @uml.property name="numsillin"
     */
    public void setNumsillin(int numsillin) {
	this.numsillin = numsillin;
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
	    if (getPinonAct() < dientespinon.length - 1) {
		setPinonact(getPinonAct() + 1);
	    }
	}
	// disminuimos el pinon
	if (accion == 'd') {
	    if (getPinonAct() > 0) {
		setPinonact(getPinonAct() - 1);
	    }
	}
    }

    /**
     * @param pinonact
     *            the pinonact to set
     * @uml.property name="pinonact"
     */
    public void setPinonact(int pinonact) {
	this.pinonact = pinonact;
    }

    public void setPinonAct(int pinonact) {
	this.setPinonact(pinonact);
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
	    if (getPlatoAct() < dientesplato.length - 1) {
		setPlatoact(getPlatoAct() + 1);
	    }
	}
	// disminuimos el pinon
	if (accion == 'd') {
	    if (getPlatoAct() > 0) {
		setPlatoact(getPlatoAct() - 1);
	    }
	}
    }

    /**
     * @param platoact
     *            the platoact to set
     * @uml.property name="platoact"
     */
    public void setPlatoact(int platoact) {
	this.platoact = platoact;
    }

    public void setPlatoAct(int platoact) {
	this.setPlatoact(platoact);
    }

    public void setRadioRueda(double radiorueda) {
	this.radiorueda = radiorueda;
    }

    public void setVelocidad(double vel) {
	velocidad = vel;
    }

}
