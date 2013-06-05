package persona;

import constantes.Constantes;

/**
 * 
 * Esta clase representa una persona física con todos su atributos
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 */
public class Persona {
    /**
	 * @uml.property  name="peso"
	 */
    protected double peso;
    /**
	 * @uml.property  name="masa"
	 */
    protected double masa;

    /**
	 * devuelve el peso
	 * @return  devuelve el peso
	 * @uml.property  name="peso"
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
	 * @param el  peso
	 * @uml.property  name="peso"
	 */
    public void setPeso(double miPeso) {
	peso = miPeso;
    }

}