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
    private JPanel contentPane;
    EntradaFichero entrada;
    Graphics g;
    Vector<Ciclista> cic;
    TreeMap<Integer,Integer> arbol;
    public Lienzo(Vector<Ciclista> micic) {
	
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
	java.util.Iterator<Entry<Integer, Integer>> itaux = arbol.entrySet().iterator();
	if(it.hasNext())
	{
	    itaux.next();
	}
	while (itaux.hasNext()) 
	{
	    	
	    	
		Entry<Integer, Integer> tramoini = it.next();
		
		
		if(it.hasNext())
		{
		    
		    Entry<Integer, Integer> tramofin = itaux.next();
		
		//pintamos la carretera
		
		    g.setColor(Color.BLACK);
		    g.drawLine((int) x, y, tramofin.getKey() / Constantes.FACTORESCALA, y
			    - tramoini.getValue());
		
		    
		
		//pintamos el cielo
		Polygon polygonCielo ;
	        polygonCielo = creaPoligono(new Point(x,0),new Point(x, y-1),new Point((int) tramofin.getKey() / Constantes.FACTORESCALA, (y- tramoini.getValue())-1),new Point(tramofin.getKey() / Constantes.FACTORESCALA, 0));
		Polygon polygon = new Polygon();
		
		pintaPoligono(polygonCielo,g,Color.CYAN);
	       
	        
		
		//pintamos el suelo
	    	
	    	Polygon polygonSuelo ;
	    	polygonSuelo = creaPoligono(new Point(x, Constantes.ALTO_VENTANA),new Point(x, y+1),new Point((int)tramofin.getKey() / Constantes.FACTORESCALA, (y- (int) tramoini.getValue())+1),new Point((int) tramofin.getKey() / Constantes.FACTORESCALA, Constantes.ALTO_VENTANA));
	    	pintaPoligono(polygonSuelo,g,Color.GREEN);
		    
		x = tramofin.getKey() / Constantes.FACTORESCALA;
		y = y - tramoini.getValue();
		}
		System.out.println(x + " " + y);
		    
		    
	}
	

	// aqui se pondra la informacion del ciclista para que se vaya pintando,
	// ahora solo se pinta un punto en pantalla
	//for (i = 0; i < cic.size(); i++) {
	for (i = 0; i < cic.size(); i++) {
	    g.setColor(colores[i]);
	    
	    g.fillOval((int) (cic.elementAt(i).getBici().getEspacioRecorrido()/ Constantes.FACTORESCALA) - Constantes.ANCHO_PUNTO_CICLISTA/2,
		    calculaYparaPuntoCiclista(cic.elementAt(i), arbol), Constantes.ANCHO_PUNTO_CICLISTA, Constantes.ANCHO_PUNTO_CICLISTA);
	  
	}
	
    }
    private int calculaYparaPuntoCiclista(Ciclista cic,TreeMap<Integer,Integer> ar)
    {
	int yresu = 0;
	int dify = 0;
	int yacum =Constantes.ALTO_VENTANA / 4;
	boolean encontrado = false;
	java.util.Iterator<Entry<Integer, Integer>> it = ar.entrySet().iterator();
	java.util.Iterator<Entry<Integer, Integer>> itaux = ar.entrySet().iterator();
	if(it.hasNext())
	{
	    itaux.next();
	}
	while (itaux.hasNext() && !encontrado) 
	{
	    	
	    	
		Entry<Integer, Integer> tramoini = it.next();
		
		
		if(it.hasNext())
		{
		    
		    Entry<Integer, Integer> tramofin = itaux.next();
		    
		  
		    if(cic.getBici().getEspacioRecorrido() >= tramoini.getKey() &&
			    cic.getBici().getEspacioRecorrido() < tramofin.getKey())
		    {
			encontrado = true;
			
			int metro_en_el_tramo_del_ciclista = (int) (cic.getBici().getEspacioRecorrido() - tramoini.getKey()  );
			int diftramos = tramofin.getKey() - tramoini.getKey();
			
			    
			    dify =  tramoini.getValue();
			
			int yfintramo = yacum + dify;
			yresu  = metro_en_el_tramo_del_ciclista * dify/diftramos;
			//yresu = (yresu + yinitramo)  -Constantes.ANCHO_PUNTO_CICLISTA;
			 //yresu = yfintramo  - Constantes.ANCHO_PUNTO_CICLISTA;
			yresu  = yacum - (metro_en_el_tramo_del_ciclista * dify/diftramos) - Constantes.ANCHO_PUNTO_CICLISTA/2;
			//yresu = iniy ;
			System.out.println("yinitramo " + yacum +" " + yfintramo + " " + dify + " " + yresu);
		   	
		    }
		  //  
		}
		System.out.println(yacum);
		yacum= yacum - tramoini.getValue();
		
		
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
   
    private void pintaPoligono(Polygon p,Graphics mig,Color col)
    {
	mig.setColor(col);
	mig.fillPolygon(p);
    }
    @Override
    public void ejecuta() {
	// TODO Auto-generated method stub
	repaint();
    }

}