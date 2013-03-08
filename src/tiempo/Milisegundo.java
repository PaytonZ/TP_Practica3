package tiempo;

/**
 * esta clase cuenta los milisegundos actuales de ejecucion.
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 * 
 */
public class Milisegundo {
    private long milisegundosactuales;
    private long milisegundos;

    /**
     * este metodo cuenta milisegundos y devuelve 1 cuando se cuenta un segundo
     * 
     * @return Si ha transcurrido un segundo
     */
    public int devuelveSegundo() {
	// variable para obtener el tiempo al iniciar el metodo
	milisegundosactuales = System.currentTimeMillis();
	int segundo = 0;
	while (segundo <= 1) {
	    // Metodo para obtener el tiempo actual

	    milisegundos = System.currentTimeMillis();
	    if (milisegundosactuales == milisegundos) {
		// 1000 milisegundos = 1 segundo
		milisegundosactuales = milisegundos + 1000;

		// System.out.println(segundo);
		segundo++;
	    }
	    // metodo para evitar que se detenga el contador
	    else if ((milisegundosactuales + 1000) < milisegundos) {
		milisegundosactuales = System.currentTimeMillis();
	    }
	}
	return 1;

    }
}
