package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	contentPane.setAutoscrolls(true);
	setBounds(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA / 2);
	entrada = new EntradaFichero();
	matriz = entrada.convertirAArrayFichero("carretera.txt", ":;");
    }

    @Override
    public void paint(Graphics g) {
	super.paint(g);

	int x = 0;
	int y = Constantes.ALTO_VENTANA / 4;

	int i = 0;
	while (x < matriz[matriz.length - 3] / FACTORESCALA) {
	    g.drawLine((int) x, y, ((int) matriz[i + 2]) / FACTORESCALA, y
		    - (int) matriz[i + 1]);
	    x = ((int) matriz[i + 2]) / FACTORESCALA;
	    y = y - (int) matriz[i + 1];
	    i += 2;
	}
	g.drawLine((int) x, y, (int) matriz[matriz.length - 1] / FACTORESCALA,
		y - (int) matriz[matriz.length - 2]);

	// aqui se pondra la informacion del ciclista para que se vaya pintando,
	// ahora solo se pinta un punto en pantalla
	for (i = 0; i < cic.size(); i++) {
	    g.drawLine((int) cic.elementAt(i).getBici().getEspacioRecorrido(),
		    20, (int) cic.elementAt(i).getBici().getEspacioRecorrido(),
		    20);
	}
    }

    @Override
    public void ejecuta() {
	// TODO Auto-generated method stub
	repaint();
    }

}