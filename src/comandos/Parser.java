package comandos;

import java.util.ArrayList;

/**
 * 
 * Esta clase convierte los strings que se le introduce como mensaje en órdenes
 * que el sistema pueda entender.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */
public class Parser {

    private ArrayList<InterfazCommand> lista_de_comandos;

    public Parser() {
	lista_de_comandos = new ArrayList<InterfazCommand>();

	lista_de_comandos.add(new ComandoAsignaCadencia(0, 0));
	lista_de_comandos.add(new ComandoAyuda());
	lista_de_comandos.add(new ComandoCambiaPinon(0, 0));
	lista_de_comandos.add(new ComandoCambiaPlato(0, 0));
	lista_de_comandos.add(new ComandoCurva(0, 0));
	lista_de_comandos.add(new ComandoFrenar(0, 0));
	lista_de_comandos.add(new ComandoIncompleto(""));
	lista_de_comandos.add(new ComandoNinguno());
	lista_de_comandos.add(new ComandoPendiente(0, 0));
	lista_de_comandos.add(new ComandoViento(null, null, null));
	lista_de_comandos.add(new ComandoClembuterol());

	lista_de_comandos.add(new ComandoDesconocido());

    }

    /**
     * Recibe un string y devuelve un comando valido con los parametros
     * correctamente establecidos Si el comando no esta en la lista , devuelve
     * ComandoDesconocido.
     * 
     * @param texto_a_parsear
     *            String que contiene un 'comando'.
     * @return Comando valido
     */
    public InterfazCommand parse(String texto_a_parsear) {
	InterfazCommand comando = new ComandoDesconocido();

	for (InterfazCommand c : lista_de_comandos) {
	    if ((comando = c.parse(texto_a_parsear)) != null) {
		return comando;
	    }
	}

	return comando;
    }

}
