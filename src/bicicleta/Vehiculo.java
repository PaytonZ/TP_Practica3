package bicicleta;

/**
 * Clase que representa un vehículo en la realidad
 * 
 * @author Juan Carlos Marco
 * @author Juan Luis Perez
 */
public class Vehiculo {
    protected float velocidad;
    protected int numruedas;

    protected int direccion = 0;
    protected float peso = 0;

    protected float espaciorecorrido;

    public Vehiculo() {
	velocidad = 0;
	espaciorecorrido = 0;
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
     * devuelve el rumbo
     * 
     * @return el rumbo actual
     */
    public float getDireccion() {
	return direccion;
    }

    /**
     * este metodo asigna una velocidad a la variable de clase velocidad
     * 
     * @param velocidad
     */
    public void setVelocidad(float v) {
	velocidad = v;
    }

    /**
     * devuelve la velocidad actual
     * 
     * @return la velocidad actual
     */
    public float getVelocidad() {
	return velocidad;
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
     * este metodo suma a la velocidad el aumento
     * 
     * @param la
     *            nueva velocidad, despues de haber sumado el aumento a la
     *            velocidad actual
     */
    public void acelerar(float aumento) {
	velocidad = velocidad + aumento;
    }

    public float calcularAceleracion(float vinicial, float vfinal, int tiempo) {
	float aceleracion = 0;

	aceleracion = (vfinal - vinicial) / tiempo;
	return aceleracion;
    }

    public float calcularVelocidadFinal(float vinicial, float aceleracion,
	    int tiempo) {
	float vfinal = 0;

	vfinal = vinicial + aceleracion * tiempo;
	return vfinal;
    }

    public float calcularEspacioRecorrido(float vinicial, int tiempo,
	    float aceleracion) {

	float espacio = 0;
	espacio = vinicial * tiempo + (1 / 2) * aceleracion * (tiempo * tiempo);
	return espacio;
    }

}
