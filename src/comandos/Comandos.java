package comandos;

public enum Comandos {
    // RELOJ(new MostrarReloj()),
    NINGUNO(new ComandoNinguno()), DESCONOCIDO(new ComandoDesconocido()), ASIGNACADENCIA(
	    new ComandoAsignaCadencia()), SUBEPINON(new ComandoSubePinon()), BAJAPINON(
	    new ComandoBajaPinon()), SUBEPLATO(new ComandoSubePlato()), BAJAPLATO(
	    new ComandoBajaPlato()), AYUDA(new ComandoAyuda());

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

		comando_valido = c;
	    }
	}

	return comando_valido;
    }

}
