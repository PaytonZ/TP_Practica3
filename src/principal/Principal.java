package principal;

//import operacionesConFicheros.*;
import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

import java.util.ArrayList;
import persona.Ciclista;
import tiempo.Reloj;
import vista.Console;
import vista.SalidaDeDatosPorSwing;
import vista.Ventana;
import bicicleta.Bicicleta;
import java.util.*;

import mapas.MiMapa;
/*
 import comandos.Comandos;
 import comandos.InterfazOrden;*/
import comandos.Parser;

import entradaDeDatos.EntradaFichero;

/**
 * Clase Principal del programa
 * 
 * @author Juan Carlos Marco, Juan Luis Perez, Emilio Ã�lvarez PiÃ±eiro
 * 
 */

public class Principal {

    private ArrayList<InterfaceEjecuta> listaejecuta;
    private ArrayList<InterfaceSalida> listasalida;
    private Vector<Object> vectorobjetos;

    SalidaDeDatosPorSwing output;

    public static void main(String args[]) {

	Principal p = new Principal();
	p.inicia();
	p.ejecuta();
	p.finaliza();

    }

    public void inicia() {
	listaejecuta = new ArrayList<InterfaceEjecuta>();
	listasalida = new ArrayList<InterfaceSalida>();
	vectorobjetos = new Vector<Object>();

	int dientesporpinon[] = { 17, 16, 15, 14, 13, 12 };
	int dientesporplato[] = { 36, 40, 44 };
	Bicicleta bici0 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858);
	Bicicleta bici1 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858);
	Bicicleta bici2 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858);
	Bicicleta bici3 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858);
	Bicicleta bici4 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858);
	Bicicleta bici5 = new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858);

	Reloj reloj = new Reloj();
	Ciclista ciclista0 = new Ciclista(bici0, 0);
	Ciclista ciclista1 = new Ciclista(bici1, 1);
	Ciclista ciclista2 = new Ciclista(bici2, 2);
	Ciclista ciclista3 = new Ciclista(bici3, 3);
	Ciclista ciclista4 = new Ciclista(bici4, 4);
	Ciclista ciclista5 = new Ciclista(bici5, 5);
	vectorobjetos.add(ciclista0);
	vectorobjetos.add(ciclista1);
	vectorobjetos.add(ciclista2);
	vectorobjetos.add(ciclista3);
	vectorobjetos.add(ciclista4);
	vectorobjetos.add(ciclista5);

	Ventana ventana = new Ventana(new Parser(vectorobjetos));

	listaejecuta.add(reloj);
	listaejecuta.add(ciclista0);
	listaejecuta.add(ciclista1);
	listaejecuta.add(ciclista2);
	listaejecuta.add(ciclista3);
	listaejecuta.add(ciclista4);
	listaejecuta.add(ciclista5);
	listaejecuta.add(bici0);
	listaejecuta.add(bici1);
	listaejecuta.add(bici2);
	listaejecuta.add(bici3);
	listaejecuta.add(bici4);
	listaejecuta.add(bici5);

	// listaejecuta.add(parser);
	listaejecuta.add(ventana);

	listasalida.add(reloj);

	listasalida.add(ciclista0);
	listasalida.add(ciclista1);
	listasalida.add(ciclista2);

	/*
	 * listasalida.add(bici3); listasalida.add(ciclista3);
	 * listasalida.add(bici4); listasalida.add(ciclista4);
	 * listasalida.add(bici5); listasalida.add(ciclista5);
	 */

	output = new SalidaDeDatosPorSwing(ventana, listasalida);

    }

    public void ejecuta() {
	int contador = 0; // Contara los segundos de ejecucion del programa
	int limite = 300; // Se establecera el limite en SEGUNDOS de la
			  // ejecucion
	// del programa
	EntradaFichero entrada = new EntradaFichero();
	new MiMapa<Double, Double>(entrada.cargarFicheroEnStringTokenizer(
		"carretera.txt", ":;"));

	while (contador < limite) {
	   
	    for (InterfaceEjecuta c : listaejecuta) {
		c.ejecuta();
	    }

	    output.mostrarObjetos();

	    contador++;
	}
    }

    public void finaliza() {

    }

}