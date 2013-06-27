package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JPanel;


import persona.Ciclista;
import constantes.Constantes;
import entradaDeDatos.EntradaFichero;
import factoresExternos.Curva;
import factoresExternos.Pendiente;

/**
 * Esta clase genera la representación del mapa mediante Swing , utilizando un
 * archivo de texto
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Lienzo extends Canvas implements InterfaceEjecuta {

    private static final long serialVersionUID = 1L;
    /**
     * @uml.property name="contentPane"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private JPanel contentPane;
    /**
     * @uml.property name="entrada"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private EntradaFichero entrada;
    /**
     * @uml.property name="g"
     */
    private Graphics g;
    /**
     * @uml.property name="lista_de_ciclistas"
     */
    private ArrayList<Ciclista> lista_de_ciclistas;
    /*
     * @uml.property name="pendiente"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private Pendiente pendiente;
    /**
     * @uml.property name="arbol"
     * @uml.associationEnd multiplicity="(0 -1)" elementType="java.lang.Integer"
     */
    private TreeMap<Integer, Integer> arbol;
    /**
     * @uml.property name="curva"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private Curva curva;

    public Lienzo(ArrayList<Ciclista> micic, Pendiente pen, Curva curv) {

	curva = curv;
	lista_de_ciclistas = micic;
	contentPane = new JPanel();
	contentPane.setLayout(null);
	setBounds(0, 0, Constantes.ANCHO_PANEL_LIENZO,
		Constantes.ALTO_VENTANA / 2);// Modificado para pruebas de
					     // lienzo

	entrada = new EntradaFichero();
	pendiente = pen;
	pendiente.setArbol(entrada
		.convertirFicheroAArbol("carretera.txt", ":;"));
	arbol = pendiente.getArbol();
	// matriz = entrada.convertirAArrayFichero("carretera.txt", ":;");

    }

    /**
     * Este metodo calcula la y correspondiente al punto x del ciclista, para
     * asi pintarlo encima de la linea de la carretera
     * 
     * @param cic
     * @param ar
     * @return
     */
    private int calculaYparaPuntoCiclista(Ciclista cic,
	    TreeMap<Integer, Integer> ar) {
	int yresu = 0;
	int dify = 0;
	int yacum = Constantes.ALTO_VENTANA / 4;
	boolean encontrado = false;
	Iterator<Entry<Integer, Integer>> it = ar.entrySet().iterator();
	Iterator<Entry<Integer, Integer>> itaux = ar.entrySet().iterator();
	if (it.hasNext()) {
	    itaux.next();
	}
	while (itaux.hasNext() && !encontrado) {

	    Entry<Integer, Integer> tramoini = it.next();

	    if (it.hasNext()) {

		Entry<Integer, Integer> tramofin = itaux.next();

		if (cic.getBici().getEspacioRecorrido() >= tramoini.getKey()
			&& cic.getBici().getEspacioRecorrido() < tramofin
				.getKey()) {
		    encontrado = true;

		    int metro_en_el_tramo_del_ciclista = (int) (cic.getBici()
			    .getEspacioRecorrido() - tramoini.getKey());
		    int diftramos = tramofin.getKey() - tramoini.getKey();

		    dify = tramoini.getValue();

		    int yfintramo = yacum + dify;
		    yresu = metro_en_el_tramo_del_ciclista * dify / diftramos;
		    yresu = yacum
			    - (metro_en_el_tramo_del_ciclista * dify / diftramos)
			    - Constantes.ANCHO_PUNTO_CICLISTA / 2;

		}

	    }
	    yacum = yacum - tramoini.getValue();

	}

	return yresu;
    }

    private Polygon creaPoligono(Point p1, Point p2, Point p3, Point p4) {
	Polygon polygon = new Polygon();
	polygon.addPoint(p1.x, p1.y);
	polygon.addPoint(p2.x, p2.y);
	polygon.addPoint(p3.x, p3.y);
	polygon.addPoint(p4.x, p4.y);
	return polygon;
    }

    @Override
    public void ejecuta() {
	// TODO Auto-generated method stub
	arbol = pendiente.getArbol();

	try {
	    repaint();
	} catch (Exception e) {
	    // No hacer nada con la excepcion capturada.
	}
    }

    @Override
    public void paint(Graphics g) {

	Color colores[] = new Color[6];
	colores[0] = Constantes.COLOR_CIC_0;
	colores[1] = Constantes.COLOR_CIC_1;
	colores[2] = Constantes.COLOR_CIC_2;
	colores[3] = Constantes.COLOR_CIC_3;
	colores[4] = Constantes.COLOR_CIC_4;
	colores[5] = Constantes.COLOR_CIC_5;

	super.paint(g);

	int x = 0;
	int xfin = 0;
	int y = Constantes.ALTO_VENTANA / 4;
	int yfin = 0;
	double x_aux = 0;
	int i = 0;
	int max = arbol.lastEntry().getKey();
	Iterator<Entry<Integer, Integer>> it = arbol.entrySet().iterator();
	Iterator<Entry<Integer, Integer>> itaux = arbol.entrySet().iterator();
	if (it.hasNext()) {
	    itaux.next();
	}
	while (itaux.hasNext()) {

	    Entry<Integer, Integer> tramoini = it.next();

	    if (it.hasNext()) {

		Entry<Integer, Integer> tramofin = itaux.next();

		// pintamos la carretera

		g.setColor(Color.BLACK);
		// g.drawLine(x, y, (tramofin.getKey() /
		// max)*Constantes.ANCHO_VENTANA, y
		// - tramoini.getValue());
		g.drawLine(
			(int) x_aux,
			y,
			(int) ((tramofin.getKey() / (double) max) * Constantes.ANCHO_PANEL_LIENZO),
			y - tramoini.getValue());
		// System.out.println(x_aux);
		// System.out.println((int)((tramofin.getKey()/(double)max)*Constantes.ANCHO_PANEL_LIENZO));

		// pintamos el cielo
		Polygon polygonCielo;
		polygonCielo = creaPoligono(
			new Point((int) x_aux, 0),
			new Point((int) x_aux, y - 1),
			new Point(
				(int) ((tramofin.getKey() / (double) max) * Constantes.ANCHO_PANEL_LIENZO),
				(y - tramoini.getValue()) - 1),
			new Point(
				(int) ((tramofin.getKey() / (double) max) * Constantes.ANCHO_PANEL_LIENZO),
				0));
		Polygon polygon = new Polygon();

		pintaPoligono(polygonCielo, g, Color.CYAN);

		// pintamos el suelo

		Polygon polygonSuelo;
		polygonSuelo = creaPoligono(
			new Point((int) x_aux, Constantes.ALTO_VENTANA),
			new Point((int) x_aux, y + 1),
			new Point(
				(int) ((tramofin.getKey() / (double) max) * Constantes.ANCHO_PANEL_LIENZO),
				(y - tramoini.getValue()) + 1),
			new Point(
				(int) ((tramofin.getKey() / (double) max) * Constantes.ANCHO_PANEL_LIENZO),
				Constantes.ALTO_VENTANA));
		pintaPoligono(polygonSuelo, g, Color.GREEN);

		x = tramofin.getKey() / Constantes.FACTORESCALA;
		y = y - tramoini.getValue();
		x_aux = (tramofin.getKey() / (double) max)
			* Constantes.ANCHO_PANEL_LIENZO;
	    }

	}

	// pintamos los PK de las curvas

	Iterator<Entry<Integer, Integer>> itcurva = curva.getArbolCurvas()
		.entrySet().iterator();
	while (itcurva.hasNext()) {
	    Entry<Integer, Integer> tramocurva = itcurva.next();
	    g.setColor(Color.red);
	    double xcurva = ((double) tramocurva.getKey() / max);
	    xcurva = xcurva * Constantes.ANCHO_PANEL_LIENZO - 1;
	    g.drawLine((int) xcurva, 0, (int) xcurva, Constantes.ALTO_VENTANA);
	    g.drawString("Curva ",
		    (int) xcurva - 80, 30);
	    g.drawString("metro " + tramocurva.getKey(),
		    (int) xcurva - 80, 40);
	    g.drawString("vel max " + tramocurva.getValue(),
		    (int) xcurva - 80, 50);

	}
	
	Iterator<Entry<Integer, Integer>> itpend = pendiente.getArbol().entrySet().iterator();
	
	while (itpend.hasNext()) {
	    Entry<Integer, Integer> tramo = itpend.next();
	    g.setColor(Color.orange);
	    double xpend = ((double) tramo.getKey() / max);
	    xpend = xpend* Constantes.ANCHO_PANEL_LIENZO;
	    g.drawLine((int) xpend, 0, (int) xpend, Constantes.ALTO_VENTANA);
	    g.drawString("Pendiente",
		    (int) xpend - 100, 300);
	    g.drawString("metro " + tramo.getKey(),
		    (int) xpend - 100, 310);
	    g.drawString("porcentaje " + tramo.getValue()+"%",
		    (int) xpend - 100, 320);

	}
	// aqui se pondra la informacion del ciclista para que se vaya pintando,
	// ahora solo se pinta un punto en pantalla
	// for (i = 0; i < cic.size(); i++) {
	int id_color_ciclista = 0;
	for (Ciclista c : lista_de_ciclistas) {
	    g.setColor(colores[id_color_ciclista]);

	    if (calculaYparaPuntoCiclista(c, arbol) == 0)
		y = Constantes.ALTO_VENTANA / 4
			- Constantes.ANCHO_PUNTO_CICLISTA / 2;
	    else
		y = calculaYparaPuntoCiclista(c, arbol);
	    g.fillOval(
		    (int) ((c.getBici().getEspacioRecorrido() / max) * Constantes.ANCHO_PANEL_LIENZO)
			    - Constantes.ANCHO_PUNTO_CICLISTA / 2, y,
		    Constantes.ANCHO_PUNTO_CICLISTA,
		    Constantes.ANCHO_PUNTO_CICLISTA);

	    id_color_ciclista++;

	}
	
	

    }

    private void pintaPoligono(Polygon p, Graphics mig, Color col) {
	mig.setColor(col);
	mig.fillPolygon(p);
    }

}