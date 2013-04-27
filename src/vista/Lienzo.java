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
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

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
    double[] matriz;
    Graphics g;
    Vector<Ciclista> cic;
    public Lienzo(Vector<Ciclista> micic) {
	FACTORESCALA = 10;
	cic = micic;
	contentPane = new JPanel();
	contentPane.setLayout(null);
	setBounds(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA / 2);
	
	entrada = new EntradaFichero();
	matriz = entrada.convertirAArrayFichero("carretera.txt", ":;");
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
	int y = Constantes.ALTO_VENTANA / 4;

	int i = 0;
	
	 
	while (x < matriz[matriz.length - 3] / FACTORESCALA) {
            //pintamos el cielo
    	    
	    Polygon polygonCielo ;
	    polygonCielo = creaPoligono(new Point(x,0),new Point(x, y-1),new Point((int) matriz[i + 2] / FACTORESCALA, (y- (int) matriz[i + 1])-1),new Point((int) matriz[i + 2] / FACTORESCALA, 0));
	    g.setColor(Color.CYAN);
	    g.fillPolygon(polygonCielo);
	    
	  //pintamos el suelo
    	    g.setColor(Color.green);
    	    Polygon polygonSuelo ;
    	    polygonSuelo = creaPoligono(new Point(x, Constantes.ALTO_VENTANA),new Point(x, y+1),new Point((int) matriz[i + 2] / FACTORESCALA, (y- (int) matriz[i + 1])+1),new Point((int) matriz[i + 2] / FACTORESCALA, Constantes.ALTO_VENTANA));

	    g.fillPolygon(polygonSuelo);
	    
	    //pintamos la carretera
	    g.setColor(Color.BLACK);
	    g.drawLine((int) x, y, ((int) matriz[i + 2]) / FACTORESCALA, y
		    - (int) matriz[i + 1]);
	 
	   
	    
	    x = ((int) matriz[i + 2]) / FACTORESCALA;
	    y = y - (int) matriz[i + 1];
	    i += 2;
	}
	//pintamos la ultima parte del cielo
	Polygon polygonCielo ;
	    polygonCielo = creaPoligono(new Point(x,0),new Point(x, y-1),new Point((int) matriz[i + 2] / FACTORESCALA, (y- (int) matriz[i + 1])-1),new Point((int) matriz[i + 2] / FACTORESCALA, 0));
	    g.setColor(Color.CYAN);
	    g.fillPolygon(polygonCielo);
	    
	//pintamos la ultima parte del suelo
	    g.setColor(Color.green);
    	    Polygon polygonSuelo ;
    	    polygonSuelo = creaPoligono(new Point(x, Constantes.ALTO_VENTANA),new Point(x, y+1),new Point((int) matriz[i + 2] / FACTORESCALA, (y- (int) matriz[i + 1])+1),new Point((int) matriz[i + 2] / FACTORESCALA, Constantes.ALTO_VENTANA));

	    g.fillPolygon(polygonSuelo);
	    
	//pintamos la ultima parte de la carretera
	g.setColor(Color.BLACK);
	g.drawLine((int) x, y, (int) matriz[matriz.length - 1] / FACTORESCALA,
		y - (int) matriz[matriz.length - 2]);
	
	// aqui se pondra la informacion del ciclista para que se vaya pintando,
	// ahora solo se pinta un punto en pantalla
	for (i = 0; i < cic.size(); i++) {
	    g.setColor(colores[i]);
	 
	    g.fillOval((int) cic.elementAt(i).getBici().getEspacioRecorrido()/ FACTORESCALA,
		    20, Constantes.ANCHO_PUNTO, Constantes.ANCHO_PUNTO);
	  
	}
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