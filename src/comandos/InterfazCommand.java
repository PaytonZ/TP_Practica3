package comandos;

/**
 * esta interfaz, contiene todos los metodos que debe tener un comando
 * 
 * @author juancly
 * 
 */
public interface InterfazCommand {

    public boolean parse(String nombre);

    public void execute();

    public void configurarContexto();

    public String getInformacionInstruccion();

    public void obtenerAyuda();

}
