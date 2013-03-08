package factoresExternos;

public enum MiViento {

    A_FAVOR(1), EN_CONTRA(-1), LATERAL(0), DESCONOCIDO(0);

    int factor;

    MiViento(int nuevo_factor) {
	factor = nuevo_factor;
    }

    /**
     * A través de un string , determina si es miembro o no del conjunto y
     * devuelve un valor válido en TODOS los casos.
     * 
     * @param viento
     *            String a comprobar si es miembro del conjunto
     * @return MiViento Un miembro de la conjunto válido
     */
    public static MiViento existe(String viento) {
	MiViento viento_valido = DESCONOCIDO;

	for (MiViento v : MiViento.values()) {
	    if (viento.equalsIgnoreCase(v.name())) {
		viento_valido = v;
	    }
	}

	return viento_valido;
    }

    public int getFactor() {
	return existe(this.name()).factor;

    }

}
