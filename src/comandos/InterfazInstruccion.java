package comandos;

public interface InterfazInstruccion {

    public void parse();

    public void execute(Object o);

    public void configurarContexto();
    
    public String getInformacionInstruccion();

    public void obtenerAyuda();

}
