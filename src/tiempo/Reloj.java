package tiempo;

/**
 * Clase especializada de contador que maneja horas , minutos y segundos
 * @author Juan Carlos Marco y Juan Luis Pérez
 *
 */
import salidaDeDatos.SalidaDeDatos;
import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

public class Reloj extends Contador implements InterfaceEjecuta,
	InterfaceSalida {

    Milisegundo milisegundo = new Milisegundo();
    Contador segundo = new Contador();
    Contador minuto = new Contador();
    Contador hora = new Contador();

    /**
     * este metodo realiza la operacion de ir incrementando segundos, minutos y
     * horas
     */
    public void cuentaReloj() {
	segundo.incremento(milisegundo.devuelveSegundo());
	minuto.incremento(segundo.pasoUnidad(60));
	hora.incremento(minuto.pasoUnidad(60));

    }

    /**
     * este metodo muestra por consola el cronometraje actual
     */
    public void mostrarReloj() {
	int tiempo[] = new int[3];
	tiempo = devuelveTiempo();
	System.out.println("hora " + tiempo[2] + " minuto " + tiempo[1]
		+ " segundo " + tiempo[0]);
    }

    /**
     * este metodo devuelve el tiempo actual en un array , el cual contiene en
     * tiempo[0] = segundos, tiempo[1] = minutos, tiempo[2] = horas
     * 
     * @return
     */
    public int[] devuelveTiempo() {
	int tiempo[] = new int[3];
	tiempo[0] = segundo.getUnidad();
	tiempo[1] = minuto.getUnidad();
	tiempo[2] = hora.getUnidad();
	return tiempo;
    }

    /**
     * devuelve el tiempo actual en segundos
     * 
     * @return
     */
    public int devuelveSegundos() {
	int segundos = 0;
	segundos = segundo.getUnidad() + minuto.getUnidad() * 60
		+ hora.getUnidad() * 3600;
	return segundos;
    }

    /**
     * este metodo esta heredado de la clase InterfazEjecuta, y todo lo que haya
     * en el, se ejecutara cuando se realice el for each de la lista
     * correspondiente
     */
    public void ejecuta() {

	cuentaReloj();

    }

    /**
     * este metodo esta heredado de la clase InterfazSalida, y todo lo que haya
     * en el, se mostrara cuando se realice el for each de la lista
     * correspondiente
     */
    public void muestra() {
	// mostrarReloj();

	SalidaDeDatos salida = new SalidaDeDatos();
	int tiempo[] = new int[3];
	tiempo = devuelveTiempo();
	String mensaje;
	mensaje = String.valueOf(tiempo[2] + " " + tiempo[1] + " " + tiempo[0]);
	salida.mostrarPorPantalla(mensaje + "#hh:mm:ss");
    }

}
