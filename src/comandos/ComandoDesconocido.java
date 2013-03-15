package comandos;

public class ComandoDesconocido implements InterfazInstruccion {
  
    public ComandoDesconocido() {
	
    }
    
    @Override
    public void parse() {
	// TODO Auto-generated method stub

    }

    @Override
    public void execute(Object o) {
	 //System.out.println("DESCONOCIDO");
	// TODO Auto-generated method stub
	
    }

    @Override
    public void configurarContexto() {
	// TODO Auto-generated method stub

    }

    @Override
    public void obtenerAyuda() {
	// TODO Auto-generated method stub

    }
    @Override
    public String getInformacionInstruccion() 
    {
	// TODO Auto-generated method stub
	return "comando desconocido";
    }

}
