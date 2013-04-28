package principal;

import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

import java.awt.Container;
import java.util.ArrayList;
import persona.Ciclista;
import tiempo.Reloj;

import vista.Lienzo;
import vista.SalidaDeDatosPorSwing;
import vista.Ventana;
import bicicleta.Bicicleta;
import java.util.*;

import org.hamcrest.core.IsInstanceOf;

import constantes.Constantes;
import mapas.MiMapa;
import comandos.Comandero;
/*
 import comandos.Comandos;
 import comandos.InterfazOrden;*/
import comandos.Parser;

import entradaDeDatos.EntradaFichero;
import factoresExternos.Curva;
import factoresExternos.Pendiente;
import factoresExternos.Viento;

/**
 * Clase Principal del programa
 * 
 * @author Juan Carlos Marco
 * @author Juan Luis Perez
 * @author Emilio Alvarez Pinerio
 * 
 */

public class CiclistaManager {

    private ArrayList<InterfaceEjecuta> listaejecuta;
    private ArrayList<InterfaceSalida> listasalida;
    private Comandero comandero;

    SalidaDeDatosPorSwing output;
    private Vector<Ciclista> vectorCiclistas;
    private Vector<Bicicleta> vectorBicis;
    Curva curva;
    Viento viento;
    Pendiente pendiente;
    Reloj reloj;

    /*
     * java CiclistaManager.java numero_de_ciclistas chero_de_comandos
     * medida_del_tiempo cambio_de_plato cambio_de_piñon radio_rueda
     */
    public static void main(String args[]) {

	CiclistaManager manager = new CiclistaManager();

	manager.inicia();
	manager.ejecuta();
	manager.finaliza();

    }

    private void inicia() {
	listaejecuta = new ArrayList<InterfaceEjecuta>();
	listasalida = new ArrayList<InterfaceSalida>();
	vectorCiclistas = new Vector<Ciclista>();
	vectorBicis = new Vector<Bicicleta>();

	int dientesporpinon[] = { Constantes.NUM_PIN_0, Constantes.NUM_PIN_1,
		Constantes.NUM_PIN_2, Constantes.NUM_PIN_3,
		Constantes.NUM_PIN_4, Constantes.NUM_PIN_5 };
	int dientesporplato[] = { Constantes.NUM_PLA_0, Constantes.NUM_PLA_1,
		Constantes.NUM_PLA_2 };
	Bicicleta bici0 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR);
	Bicicleta bici1 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR);
	Bicicleta bici2 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR);
	Bicicleta bici3 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR);
	Bicicleta bici4 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR);
	Bicicleta bici5 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR);
	reloj = new Reloj();
	Ciclista ciclista0 = new Ciclista(bici0, 0);
	Ciclista ciclista1 = new Ciclista(bici1, 1);
	Ciclista ciclista2 = new Ciclista(bici2, 2);
	Ciclista ciclista3 = new Ciclista(bici3, 3);
	Ciclista ciclista4 = new Ciclista(bici4, 4);
	Ciclista ciclista5 = new Ciclista(bici5, 5);

	vectorBicis.add(bici0);
	vectorBicis.add(bici1);
	vectorBicis.add(bici2);
	vectorBicis.add(bici3);
	vectorBicis.add(bici4);
	vectorBicis.add(bici5);

	viento = new Viento(vectorBicis, reloj);
	curva = new Curva(vectorBicis);
	pendiente = new Pendiente(vectorBicis);

	vectorCiclistas.add(ciclista0);
	vectorCiclistas.add(ciclista1);
	vectorCiclistas.add(ciclista2);
	vectorCiclistas.add(ciclista3);
	vectorCiclistas.add(ciclista4);
	vectorCiclistas.add(ciclista5);

	comandero = new Comandero(this, new Parser());
	Lienzo lienzo = new Lienzo(vectorCiclistas);
	Ventana ventana = new Ventana(comandero, lienzo);

	listaejecuta.add(reloj);
	listaejecuta.add(ciclista0);
	listaejecuta.add(ciclista1);
	listaejecuta.add(ciclista2);
	listaejecuta.add(ciclista3);
	listaejecuta.add(ciclista4);
	listaejecuta.add(ciclista5);
	listaejecuta.add(lienzo);
	listaejecuta.add(comandero);
	listaejecuta.add(ventana);
	listaejecuta.add(viento);
	listaejecuta.add(curva);
	listaejecuta.add(pendiente);

	listasalida.add(reloj);
	listasalida.add(ciclista0);
	listasalida.add(ciclista1);
	listasalida.add(ciclista2);
	listasalida.add(ciclista3);
	listasalida.add(ciclista4);
	listasalida.add(ciclista5);
	listasalida.add(comandero);

	output = new SalidaDeDatosPorSwing(ventana, listasalida);

    }

    private void ejecuta() {
	int contador = 0; // Contara los segundos de ejecucion del programa
	int limite = 300; // Se establecera el limite en SEGUNDOS de la
			  // ejecucion del programa

	while (contador < limite) {

	    for (InterfaceEjecuta c : listaejecuta) {
		c.ejecuta();
	    }

	    output.mostrarObjetos();

	    contador++;
	}
    }

    private void finaliza() {

    }

    public Ciclista getCiclista(int identificador) {
	Ciclista ciclista_a_devolver = null;
	for (InterfaceEjecuta c : listaejecuta)

	{
	    if (c instanceof Ciclista) {
		if (identificador == ((Ciclista) c).getIdentificador_ciclista()) {
		    ciclista_a_devolver = (Ciclista) c;
		}
	    }

	}
	return ciclista_a_devolver;

    }

    public Curva getCurva() {

	return curva;

    }

    public Pendiente getPendiente() {

	return pendiente;

    }

    public Reloj getReloj() {

	return reloj;

    }

    public Viento getViento() {

	return viento;

    }

}
