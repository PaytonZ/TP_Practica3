package principal;

import entradaDeDatos.EntradaFichero;
import entradaDeDatos.SuperLectura;
import factoresExternos.Curva;
import factoresExternos.Pendiente;
import factoresExternos.Viento;
import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

import persona.Ciclista;
import tiempo.Reloj;
import vista.Lienzo;
import vista.SalidaDeDatosPorSwing;
import vista.Ventana;
import bicicleta.Bicicleta;

import comandos.Comandero;

import constantes.Constantes;

/**
 * Clase Principal del programa
 * 
 * @author Juan Carlos Marco
 * @author Juan Luis Perez
 * @author Emilio Alvarez Pinerio
 * 
 */

public class CiclistaManager {

    ArrayList<Bicicleta>lista_de_bicis ;
    public static void main(String args[]) {

	CiclistaManager manager = new CiclistaManager();
	
	manager.procesarArgs(args);
	
	manager.inicia();
	manager.ejecuta();
	manager.finaliza();

    }

    /**
     * @uml.property name="listaejecuta"
     * @uml.associationEnd multiplicity="(0 -1)" elementType="persona.Ciclista"
     */
    private ArrayList<InterfaceEjecuta> listaejecuta;
    /**
     * @uml.property name="listasalida"
     * @uml.associationEnd multiplicity="(0 -1)" elementType="persona.Ciclista"
     */
    private ArrayList<InterfaceSalida> listasalida;

    /**
     * @uml.property name="comandero"
     * @uml.associationEnd
     */
    private Comandero comandero;
    /**
     * @uml.property name="output"
     * @uml.associationEnd
     */
    private SalidaDeDatosPorSwing output;
    /**
     * @uml.property name="curva"
     * @uml.associationEnd
     */
    private Curva curva;
    /**
     * @uml.property name="viento"
     * @uml.associationEnd
     */
    private Viento viento;
    /**
     * @uml.property name="pendiente"
     * @uml.associationEnd
     */
    private Pendiente pendiente;

    /**
     * @uml.property name="reloj"
     * @uml.associationEnd
     */
    private Reloj reloj;

    
   
    @SuppressWarnings("static-access")
    private void inicia() {

	listaejecuta = new ArrayList<InterfaceEjecuta>();
	listasalida = new ArrayList<InterfaceSalida>();

	int dientesporpinon[] = { Constantes.NUM_PIN_0, Constantes.NUM_PIN_1,
		Constantes.NUM_PIN_2, Constantes.NUM_PIN_3,
		Constantes.NUM_PIN_4, Constantes.NUM_PIN_5 };
	int dientesporplato[] = { Constantes.NUM_PLA_0, Constantes.NUM_PLA_1,
		Constantes.NUM_PLA_2 };
	lista_de_bicis = new ArrayList<Bicicleta>();
	ArrayList<Ciclista> lista_de_ciclistas = new ArrayList<Ciclista>();
	reloj = new Reloj().getReloj();
	double fuerzaCiclista[] = {Constantes.FUERZA_CICLISTA0,
				Constantes.FUERZA_CICLISTA1,
				Constantes.FUERZA_CICLISTA2,
				Constantes.FUERZA_CICLISTA3,
				Constantes.FUERZA_CICLISTA4,
				Constantes.FUERZA_CICLISTA5};
	for(int i = 0; i < Constantes.NUM_ACT_CICLISTAS;i++)
	{
	    lista_de_bicis.add(new Bicicleta(dientesporpinon.length,
		dientesporplato.length, dientesporpinon, dientesporplato,
		Constantes.RADIORUEDA, Constantes.MASA_BICICLETA_ESTANDAR));
	    lista_de_ciclistas.add(new Ciclista(lista_de_bicis.get(i), i, fuerzaCiclista[i]));
	}

	viento = new Viento(lista_de_ciclistas, reloj);
	curva = new Curva(lista_de_ciclistas);
	pendiente = new Pendiente(lista_de_ciclistas);

	Presentador presentador = new Presentador(lista_de_ciclistas, reloj,
		curva, viento, pendiente);

	comandero = new Comandero(presentador, Constantes.FICHERO_DE_COMANDOS);
	Lienzo lienzo = new Lienzo(lista_de_ciclistas, pendiente, curva);
	Ventana ventana = new Ventana(comandero, lienzo);

	listaejecuta.add(reloj);
	for(int i = 0; i < Constantes.NUM_ACT_CICLISTAS;i++)
	{
	    listaejecuta.add(lista_de_ciclistas.get(i));
	}
	listaejecuta.add(lienzo);
	listaejecuta.add(comandero);
	listaejecuta.add(ventana);
	listaejecuta.add(viento);
	listaejecuta.add(curva);
	listaejecuta.add(pendiente);

	listasalida.add(reloj);
	for(int i = 0; i < Constantes.NUM_ACT_CICLISTAS;i++)
	{
	    listasalida.add(lista_de_ciclistas.get(i));
	}
	listasalida.add(comandero);

	output = new SalidaDeDatosPorSwing(ventana, listasalida);

    }

    private void ejecuta() {
	int contador = 0; // Contara los segundos de ejecucion del programa
	int limite = Constantes.LIMITETIEMPO; // Se establecera el limite en SEGUNDOS de la
			  // ejecucion del programa
/*PRUEBAS BUILDER
	ArrayList<InterfazDeTiposCiclista> listaejecutatipo = new ArrayList<InterfazDeTiposCiclista>();
	
	int dientesporpinon[] = { Constantes.NUM_PIN_0, Constantes.NUM_PIN_1,
		Constantes.NUM_PIN_2, Constantes.NUM_PIN_3,
		Constantes.NUM_PIN_4, Constantes.NUM_PIN_5 };
	int dientesporplato[] = { Constantes.NUM_PLA_0, Constantes.NUM_PLA_1,
		Constantes.NUM_PLA_2 };
	BuilderConcretoTonto build = new BuilderConcretoTonto(new Bicicleta(dientesporpinon.length,
		dientesporplato.length, 1, dientesporpinon, dientesporplato,
		0.6858, Constantes.MASA_BICICLETA_ESTANDAR),1,100);
	
	InterfazDeTiposCiclista cic = build.getCiclistaTonto();
	listaejecutatipo.add(cic);
	*/
	//cic.ejecutaTareas();
	boolean fin = false;
	while (contador < limite && fin == false) {

	    for (InterfaceEjecuta c : listaejecuta) {
		c.ejecuta();
	    }
	   
	    for(Bicicleta b : lista_de_bicis)
	    {
		if(b.getCampeon() == true)
		{
		    fin = true;
		}
	    }
	    output.mostrarObjetos();

	    contador++;
	    
	    //TIPOS BUILDER
	    /*
	    for(InterfazDeTiposCiclista c: listaejecutatipo)
	    {
		System.out.print("entra");
		c.ejecutaTareas();
	    }*/
	}
    }

    private void finaliza() {

    }

    private boolean condicionesDeFinal() {
	return false;
    }

    /*
     * java CiclistaManager.java numero_de_ciclistas fichero_de_comandos
     */
    private void procesarArgs(String args[]) {
	
	TreeMap<Integer, Integer> arbol;
	EntradaFichero entrada = new EntradaFichero();
	arbol = entrada.convertirFicheroAArbol("carretera.txt",":;");
	Iterator<Entry<Integer, Integer>> it = arbol.entrySet().iterator();
	
	while (it.hasNext())
	{
	    Constantes.METROSELEGIDOS = it.next().getKey();
	    Constantes.asignaMetros();
	}
	    
	    try
	    {
		Constantes.NUM_ACT_CICLISTAS = Integer.valueOf(args[0]);
		Constantes.FICHERO_DE_COMANDOS = args[1];
		Constantes.IMPULSO_RELOJ_SEGUNDOS = Integer.valueOf(args[2]);
		Constantes.PINPLATO = Integer.valueOf(args[3]);
		Constantes.PINPINON = Integer.valueOf(args[4]);
		Constantes.RADIORUEDA = Double.valueOf(args[5]);
		Constantes.asignaPlatos();
		Constantes.asignaPinones();
		
	    }
	    catch(Exception e)
	    {
		Constantes.NUM_ACT_CICLISTAS = 6;
		Constantes.FICHERO_DE_COMANDOS = "comandos.tsp";
		Constantes.IMPULSO_RELOJ_SEGUNDOS = 1;
		Constantes.PINPLATO = 20;
		Constantes.PINPINON = 30;
		Constantes.RADIORUEDA = 0.4;
		Constantes.asignaPlatos();
		Constantes.asignaPinones();
	    }
	    
	

    }
}
