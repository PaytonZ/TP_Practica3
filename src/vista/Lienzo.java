package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import persona.Ciclista;

import constantes.Constantes;

import entradaDeDatos.EntradaFichero;

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
    final int FACTORESCALA;
    private JPanel contentPane;
    EntradaFichero entrada;
    Graphics g;
    Vector<Ciclista> cic;
    TreeMap<Integer,Integer> arbol;
    public Lienzo(Vector<Ciclista> micic) {
	FACTORESCALA = 10;
	cic = micic;
	contentPane = new JPanel();
	contentPane.setLayout(null);
	setBounds(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA / 2);
	
	entrada = new EntradaFichero();
	//matriz = entrada.convertirAArrayFichero("carretera.txt", ":;");
	arbol = entrada.convertirFicheroAArbol("carretera.txt", ":;");
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

	int i = 0;
	
	java.util.Iterator<Entry<Integer, Integer>> it = arbol.entrySet().iterator();
	
	while (it.hasNext()) 
	{
		Entry<Integer, Integer> tramo = it.next();
		
		//pintamos la carretera
		
		g.setColor(Color.BLACK);
		g.drawLine((int) x, y, tramo.getKey() / FACTORESCALA, y
		- tramo.getValue());
		
		//pintamos el cielo
		Polygon polygonCielo ;
	        polygonCielo = creaPoligono(new Point(x,0),new Point(x, y-1),new Point((int) tramo.getKey() / FACTORESCALA, (y- tramo.getValue())-1),new Point(tramo.getKey() / FACTORESCALA, 0));
		g.setColor(Color.CYAN);
		g.fillPolygon(polygonCielo);
		  
		
		//pintamos el suelo
	    	g.setColor(Color.green);
	    	Polygon polygonSuelo ;
	    	polygonSuelo = creaPoligono(new Point(x, Constantes.ALTO_VENTANA),new Point(x, y+1),new Point((int)tramo.getKey() / FACTORESCALA, (y- (int) tramo.getValue())+1),new Point((int) tramo.getKey() / FACTORESCALA, Constantes.ALTO_VENTANA));

		g.fillPolygon(polygonSuelo);
		    
		x = tramo.getKey() / FACTORESCALA;
		y = y - tramo.getValue();
		
		
		    
		    
	}
	

	// aqui se pondra la informacion del ciclista para que se vaya pintando,
	// ahora solo se pinta un punto en pantalla
	for (i = 0; i < cic.size(); i++) {
	    g.setColor(colores[i]);
	    
	    g.fillOval((int) cic.elementAt(i).getBici().getEspacioRecorrido()/ FACTORESCALA,
		    calculaYparaPuntoCiclista(cic.elementAt(i), arbol), Constantes.ANCHO_PUNTO, Constantes.ANCHO_PUNTO);
	  
	}
	
    }
    private int calculaYparaPuntoCiclista(Ciclista cic,TreeMap<Integer,Integer> ar)
    {
	int yresu = 0;
	int y =Constantes.ALTO_VENTANA / 4;
	boolean encontrado = false;
	java.util.Iterator<Entry<Integer, Integer>> it = ar.entrySet().iterator();
	
	while (it.hasNext() && !encontrado) 
	{
	   
	    	
		Entry<Integer, Integer> tramoini = it.next();
		java.util.Iterator<Entry<Integer, Integer>> itaux = it;
		
		if(it.hasNext())
		{
		    Entry<Integer, Integer> tramofin = it.next();
		    if(cic.getBici().getEspacioRecorrido() >= tramoini.getKey() &&
			    cic.getBici().getEspacioRecorrido() < tramofin.getKey())
		    {
			
			encontrado = true;
		    }
		    yresu = y - tramoini.getValue();
		}
		it = itaux;
	}
	
	return yresu;
    }
    private Polygon creaPoligono(Point p1,Point p2,Point p3, Point p4)
    {
	 Polygon polygon = new Polygon();
	 polygon.addPoint(p1.x,p1.y);
	 polygon.addPoint(p2.x,p2.y);
	 polygon.addPoint(p3.x,p3.y);
	 polygon.addPoint(p4.x,p4.y);
	return polygon;
    }
   
    @Override
    public void ejecuta() {
	// TODO Auto-generated method stub
	repaint();
    }

}