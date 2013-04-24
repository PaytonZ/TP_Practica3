package comandos;

import principal.CiclistaManager;

/**
 * esta interfaz, contiene todos los metodos que debe tener un comando
 * 
 * @author juancly
 * 
 */
public interface InterfazCommand {

    public InterfazCommand parse(String nombre);

    public void execute();

    public void configurarContexto(CiclistaManager cm);

    public String getInformacionInstruccion();

    public String obtenerAyuda();

}
