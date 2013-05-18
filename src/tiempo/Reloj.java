package tiempo;

/**
 * Clase especializada de contador que maneja horas , minutos y segundos
 * @author Juan Carlos Marco y Juan Luis Pérez
 *
 */
import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;
import vista.Ventana;

public class Reloj extends Contador implements InterfaceEjecuta,
	InterfaceSalida {

    private Milisegundo milisegundo = new Milisegundo();
    private Contador segundo = new Contador();
    private Contador minuto = new Contador();
    private Contador hora = new Contador();
    private Ventana ventana;

    public Reloj() {

    }

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
    /*
     * public void mostrarReloj() { int tiempo[] = new int[3]; tiempo =
     * devuelveTiempo(); System.out.println("hora " + tiempo[2] + " minuto " +
     * tiempo[1] + " segundo " + tiempo[0]); }
     */

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
     * este metodo devuelve el tiempo actual en un array , el cual contiene en
     * tiempo[0] = segundos, tiempo[1] = minutos, tiempo[2] = horas
     * 
     * @return
     */
    public String devuelveTiempoEnString() {
	String tiempo = String.valueOf(hora.getUnidad());
	tiempo = tiempo + ":" + String.valueOf(minuto.getUnidad());
	tiempo = tiempo + ":" + String.valueOf(segundo.getUnidad());
	return tiempo;
    }

    /**
     * este metodo esta heredado de la clase InterfazEjecuta, y todo lo que haya
     * en el, se ejecutara cuando se realice el for each de la lista
     * correspondiente
     */
    @Override
    public void ejecuta() {

	cuentaReloj();

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
	mensaje += "reloj" + "%";

	// SalidaDeDatosPorSwing salida = new SalidaDeDatosPorSwing(); int
	int tiempo[] = new int[3];
	tiempo = devuelveTiempo();

	mensaje += String
		.valueOf(tiempo[2] + " " + tiempo[1] + " " + tiempo[0])
		+ "#hh:mm:ss";

	return mensaje;

    }

}