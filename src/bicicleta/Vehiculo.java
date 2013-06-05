package bicicleta;

import constantes.Constantes;

/**
 * Clase que representa un vehículo en la realidad
 * 
 * @author Juan Carlos Marco
 * @author Juan Luis Perez
 */
public class Vehiculo {

    /**
	 * @uml.property  name="velocidad"
	 */
    protected double velocidad;
    /**
	 * @uml.property  name="numruedas"
	 */
    protected int numruedas;

    /**
	 * @uml.property  name="direccion"
	 */
    protected double direccion = 0;
    /**
	 * @uml.property  name="peso"
	 */
    protected double peso;
    /**
	 * @uml.property  name="masa"
	 */
    private double masa;

    /**
	 * @uml.property  name="espaciorecorrido"
	 */
    protected double espaciorecorrido;

    public Vehiculo(double nueva_masa) {
	velocidad = 0;
	espaciorecorrido = 0;
	setMasa(nueva_masa);
	peso = getMasa() * Constantes.FUERZA_G;
    }

    /**
     * este metodo suma a la velocidad el aumento
     * 
     * @param la
     *            nueva velocidad, despues de haber sumado el aumento a la
     *            velocidad actual
     */
  

    public float calcularAceleracion(float vinicial, float vfinal, int tiempo) {
	float aceleracion = 0;

	aceleracion = (vfinal - vinicial) / tiempo;
	return aceleracion;
    }

    public float calcularEspacioRecorrido(float vinicial, int tiempo,
	    float aceleracion) {

	float espacio = 0;
	espacio = vinicial * tiempo + (1 / 2) * aceleracion * (tiempo * tiempo);
	return espacio;
    }

    public float calcularVelocidadFinal(float vinicial, float aceleracion,
	    int tiempo) {
	float vfinal = 0;

	vfinal = vinicial + aceleracion * tiempo;
	return vfinal;
    }

    /**
     * este metodo decrementa a la velocidad actual el decremento
     * 
     * @param la
     *            nueva velocidad, despues de aplicarla el decremento
     */
    public void frenar(float decremento) {
	velocidad = velocidad - decremento;
    }

    /**
	 * devuelve el rumbo
	 * @return  el rumbo actual
	 * @uml.property  name="direccion"
	 */
    public double getDireccion() {
	return direccion;
    }

    /**
	 * @return  the masa
	 * @uml.property  name="masa"
	 */
    public double getMasa() {
	return masa;
    }

    /**
	 * devuelve la velocidad actual
	 * @return  la velocidad actual
	 * @uml.property  name="velocidad"
	 */
    public double getVelocidad() {
	return velocidad;
    }

    /**
     * asigna el rumbo a seguir , el cual sera desde 0 a 359
     * 
     * @param un
     *            rumbo
     */

    public void setDireccion(int d) {
	if (direccion >= 0 && direccion < 360) {
	    direccion = d;
	}
    }

    /**
	 * @param masa  the masa to set
	 * @uml.property  name="masa"
	 */
    public void setMasa(double masa) {
	this.masa = masa;
    }

    /**
     * este metodo asigna una velocidad a la variable de clase velocidad
     * 
     * @param velocidad
     */
    public void setVelocidad(float v) {
	velocidad = v;
    }

}
