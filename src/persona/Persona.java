package persona;

/**
 * 
 * Esta clase representa una persona física con todos su atributos
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 */
public class Persona {
    protected float peso;
    protected float altura;

    public void persona() {

    }

    /**
     * asigna el peso
     * 
     * @param el
     *            peso
     */
    public void setPeso(float miPeso) {
	peso = miPeso;
    }

    /**
     * devuelve el peso
     * 
     * @return devuelve el peso
     */
    public float getPeso() {
	return peso;
    }

    /**
     * asigna la altura
     * 
     * @param miAltura
     */
    public void setAltura(float miAltura) {
	altura = miAltura;
    }

    /**
     * devuelve la altura
     * 
     * @return devuelve la altura
     */
    public float getAltura() {
	return altura;
    }

}