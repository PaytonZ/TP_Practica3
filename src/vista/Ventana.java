package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import comandos.Parser;

public class Ventana extends JFrame implements InterfaceEjecuta {
    
   private Parser parser;

    private static final long serialVersionUID = -8170475180669923771L;
    
    private JPanel panel_general;
    private JTextField tFreloj;
    private JTextField tFcomando;
    private JTextField tFconsola;
    private String cadena;
    private JTextArea textArea_ciclista0;
    private JTextArea textArea_ciclista1;
    private JTextArea textArea_ciclista2;
    private JTextArea textArea_ciclista3;
    private JTextArea textArea_ciclista4;
    private JTextArea textArea_ciclista5;
    private JLabel lblComandos;
    private JLabel lblTiempo;
    private JLabel lblconsola;

    public Ventana(Parser nuevo_parser) {
	
	parser= nuevo_parser;
	
	init();
    }
    
private void init() {
	GridLayout layout = new GridLayout(0, 2, 10, 10);
	
//Panel general
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 865, 558);
	panel_general = new JPanel();
	panel_general.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(panel_general);
	panel_general.setLayout(layout);

	//Añadir ciclistas.
	JPanel panel_ciclista0 = new JPanel();
	textArea_ciclista0 = new JTextArea();
	panel_ciclista0.setLayout(new BorderLayout());
	panel_ciclista0.add(new JLabel("Ciclista0"), BorderLayout.NORTH);
	panel_ciclista0.add(textArea_ciclista0, BorderLayout.CENTER);

	panel_general.add(panel_ciclista0);

	JPanel panel_ciclista1 = new JPanel();
	textArea_ciclista1 = new JTextArea();
	panel_ciclista1.setLayout(new BorderLayout());
	panel_ciclista1.add(new JLabel("Ciclista1"), BorderLayout.NORTH);
	panel_ciclista1.add(textArea_ciclista1, BorderLayout.CENTER);

	panel_general.add(panel_ciclista1);

	JPanel panel_ciclista2 = new JPanel();
	textArea_ciclista2 = new JTextArea();
	panel_ciclista2.setLayout(new BorderLayout());
	panel_ciclista2.add(new JLabel("Ciclista2"), BorderLayout.NORTH);
	panel_ciclista2.add(textArea_ciclista2, BorderLayout.CENTER);

	panel_general.add(panel_ciclista2);

	//Añadir reloj
	
	JPanel panel_reloj = new JPanel();

	tFreloj = new JTextField();

	panel_reloj.setLayout(new BorderLayout());
	panel_reloj.add(new JLabel("Tiempo"), BorderLayout.NORTH);
	panel_reloj.add(tFreloj, BorderLayout.CENTER);

	panel_general.add(panel_reloj);

	JPanel panel_comandos = new JPanel();

	tFcomando = new JTextField();

	panel_comandos.setLayout(new BorderLayout());
	panel_comandos.add(new JLabel("Comandos"), BorderLayout.NORTH);
	panel_comandos.add(tFcomando, BorderLayout.CENTER);
	tFcomando.addKeyListener(new KeyAdapter() {

	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    cadena = tFcomando.getText();
		    parser.dameComando(cadena);
		    tFcomando.setText("");
		    
		}
	    }
	});
	
	panel_general.add(panel_comandos);
	
	JPanel panel_consola = new JPanel();
	panel_consola.setLayout(new BorderLayout());
	tFconsola= new JTextField();
	panel_consola.add(new JLabel("Consola"), BorderLayout.NORTH);
	panel_consola.add(tFconsola, BorderLayout.CENTER);

	
	panel_general.add(panel_consola);

	//Añadir consola // output
	
	setVisible(true);
	
    }

    public void ponTextoEnTextArea(String id, String mensaje) {

	switch (id) {
	case "ciclista0":
	    textArea_ciclista0.setText(textArea_ciclista0.getText() + "\n"
		    + mensaje);
	    break;
	case "ciclista1":
	    textArea_ciclista1.setText(textArea_ciclista1.getText() + "\n"
		    + mensaje);
	    break;
	case "ciclista2":
	    textArea_ciclista2.setText(textArea_ciclista2.getText() + "\n"
		    + mensaje);
	    break;
	case "ciclista3":
	    textArea_ciclista3.setText(textArea_ciclista3.getText() + "\n"
		    + mensaje);
	    break;
	case "ciclista4":
	    textArea_ciclista4.setText(textArea_ciclista4.getText() + "\n"
		    + mensaje);
	    break;
	case "ciclista5":
	    textArea_ciclista5.setText(textArea_ciclista5.getText() + "\n"
		    + mensaje);
	    break;
	case "reloj":
	    tFreloj.setText(mensaje);
	    break;

	}

    }

    public String dameInstruccion() {
	String miInstruccion = "";
	miInstruccion = cadena;
	cadena = "";
	return miInstruccion;
    }

    public void añadirCiclista() {

    }

    @Override
    public void ejecuta() {

	textArea_ciclista0.setText("");
	textArea_ciclista1.setText("");

	textArea_ciclista2.setText("");
	/*
	 * textArea_ciclista3.setText(""); textArea_ciclista4.setText("");
	 * textArea_ciclista5.setText("");
	 */
	tFreloj.setText("");

    }
}
