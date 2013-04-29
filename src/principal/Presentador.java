package principal;

import java.util.ArrayList;

import persona.Ciclista;
import tiempo.Reloj;
import factoresExternos.Curva;
import factoresExternos.Pendiente;
import factoresExternos.Viento;

public class Presentador {

    private ArrayList<Ciclista> lista_de_ciclistas;
    private Reloj reloj;
    private Curva curva;
    private Viento viento;
    private Pendiente pendiente;

    public Presentador(ArrayList<Ciclista> nueva_lista_ciclistas,
	    Reloj nuevo_reloj, Curva nueva_curva, Viento nuevo_viento,
	    Pendiente nueva_pendiente) {
	lista_de_ciclistas = nueva_lista_ciclistas;
	reloj = nuevo_reloj;
	curva = nueva_curva;
	viento = nuevo_viento;
	pendiente = nueva_pendiente;
    }

    public Ciclista getCiclista(int id) {
	Ciclista ciclista_a_devolver = null;
	for (Ciclista c : lista_de_ciclistas) {

	    if (c.getIdentificador_ciclista() == id) {
		ciclista_a_devolver = c;
	    }
	}
	return ciclista_a_devolver;
    }

    public Reloj getReloj() {
	return reloj;
    }

    public Curva getCurva() {
	return curva;
    }

    public Pendiente getPendiente() {
	return pendiente;
    }

    public Viento getViento() {
	return viento;
    }
}
