package comandos;

import persona.Ciclista;
import principal.CiclistaManager;

public class ComandoSubePinon implements InterfazCommand {
    Ciclista cic;

    public ComandoSubePinon(Ciclista micic) {
	cic = micic;
	// TODO Auto-generated constructor stub
    }

    @Override
    public InterfazCommand parse(String nombre) {
	return null;
    }

    @Override
    public void execute() {

	cic.aumentaPinon();
	// TODO Auto-generated method stub

    }

    @Override
    public String getInformacionInstruccion() {
	// TODO Auto-generated method stub
	return "pinon subido en el ciclista" + cic.getIdentificador_ciclista()
		+ "\npinon actual :" + cic.getPinonActualBici();
    }

    public String getNombreComando() {
	return "subepinon";
    }

    @Override
    public void configurarContexto(CiclistaManager cm) {
	// TODO Auto-generated method stub

    }

    @Override
    public String obtenerAyuda() {
	// TODO Auto-generated method stub
	return null;
    }
}
