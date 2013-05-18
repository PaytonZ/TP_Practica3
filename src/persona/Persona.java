package persona;

import constantes.Constantes;

/**
 * 
 * Esta clase representa una persona física con todos su atributos
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 */
public class Persona {
    protected double peso;
    protected double masa;

    /**
     * devuelve el peso
     * 
     * @return devuelve el peso
     */
    public double getPeso() {
	return peso;
    }

    public void persona(double nueva_masa) {
	masa = nueva_masa;
	peso = masa * Constantes.FUERZA_G;
    }

    /**
     * asigna el peso
     * 
     * @param el
     *            peso
     */
    public void setPeso(double miPeso) {
	peso = miPeso;
    }

}