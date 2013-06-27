package tiempo;

import constantes.Constantes;

/**
 * esta clase cuenta los milisegundos actuales de ejecucion.
 * 
 * @author Juan Carlos Marco y Juan Luis Pérez
 * 
 */
public class Milisegundo {
    /**
     * @uml.property name="milisegundosactuales"
     */
    private double milisegundosactuales;
    /**
     * @uml.property name="milisegundos"
     */
    private double milisegundos;

    /**
     * este metodo cuenta milisegundos y devuelve 1 cuando se cuenta un segundo
     * 
     * @return Si ha transcurrido un segundo
     */
    public int devuelveSegundo() {
	// variable para obtener el tiempo al iniciar el metodo
	milisegundosactuales = System.currentTimeMillis();
	int segundo = 0;
	if(Constantes.IMPULSO_RELOJ_SEGUNDOS == 1)
	{
		while (segundo <= 1) {
		    // Metodo para obtener el tiempo actual

		    milisegundos = System.currentTimeMillis();
		    if (milisegundosactuales == milisegundos) {
			// 1000 milisegundos = 1 segundo
			milisegundosactuales = milisegundos
				+ Constantes.IMPULSO_RELOJ_MILISEGUNDOS;

			// System.out.println(segundo);
			segundo++;
		    }
		    // metodo para evitar que se detenga el contador
		    else if ((milisegundosactuales + Constantes.IMPULSO_RELOJ_MILISEGUNDOS) < milisegundos) {
			milisegundosactuales = System.currentTimeMillis();
		    }
		}
	}
	else
	{	int impulso = 0;
		while (impulso <= Constantes.IMPULSO_RELOJ_SEGUNDOS) {
		    // Metodo para obtener el tiempo actual

		    impulso ++;
		 
		}
	}
	return 1;

    }
}
