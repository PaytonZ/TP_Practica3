package comandos;

import interfaceMain.InterfaceEjecuta;
import factoresExternos.MiViento;

public enum Comandos  {
   // RELOJ(new MostrarReloj()), 
    NINGUNA(new ComandoNinguno()), 
    DESCONOCIDO(new ComandoDesconocido()),
    AUMENTACADENCIA(new ComandoAumentaCadencia()), 
    DISMINUYECADENCIA(new ComandoDisminuyeCadencia()), 
    SUBEMARCHA(new ComandoSubeMarcha()), 
    BAJAMARCHA(new ComandoBajaMarcha()), 
    SUBEPLATO(new ComandoSubePlato()), 
    BAJAPLATO( new ComandoBajaPlato());

    Comandos(InterfazInstruccion nueva_instruccion) {
	instruccion = nueva_instruccion;
    }

    InterfazInstruccion instruccion;

    public InterfazInstruccion getInstruccion() {
	return instruccion;
    }

    public static Comandos existe(String comando) {
	Comandos comando_valido = DESCONOCIDO;

	for (Comandos c : Comandos.values()) {

	    if (comando.equalsIgnoreCase(c.name())) {
		// prueba para comprobar que lo leido por teclado corresponde a
		// un comando
		//System.out.println(c.name());
		comando_valido = c;
	    }
	}

	return comando_valido;
    }


}
