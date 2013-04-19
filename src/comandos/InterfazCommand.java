package comandos;

public interface InterfazCommand {

    public boolean parse(String nombre);

    public void execute();

    public void configurarContexto();

    public String getInformacionInstruccion();

    public void obtenerAyuda();

}
