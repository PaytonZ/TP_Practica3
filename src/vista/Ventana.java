
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

    private JPanel contentPane;
    private JTextField tFreloj;
    private JTextField tFcomando;
    private String cadena;
    JTextArea textArea_ciclista0;
    JTextArea textArea_ciclista1;
    JTextArea textArea_ciclista2;
    JTextArea textArea_ciclista3;
    JTextArea textArea_ciclista4;
    JTextArea textArea_ciclista5;
    private JLabel lblComandos;
    private JLabel lblTiempo;

    public Ventana(Parser nuevo_parser) {

	parser = nuevo_parser;

	init();
    }

    private void init() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 885, 600);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textArea_ciclista0 = new JTextArea();
	textArea_ciclista0.setBounds(12, 29, 278, 98);
	contentPane.add(textArea_ciclista0);
	
	textArea_ciclista1 = new JTextArea();
	textArea_ciclista1.setBounds(302, 29, 278, 98);
	contentPane.add(textArea_ciclista1);
	
	tFreloj = new JTextField();
	tFreloj.setEditable(false);
	tFreloj.setBounds(400, 291, 114, 19);
	contentPane.add(tFreloj);
	tFreloj.setColumns(10);
	cadena = "";
	tFcomando = new JTextField();
	tFcomando.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			if(e.getKeyCode() == 10)
			{
			    	parser.setInstruccion(tFcomando.getText());
				tFcomando.setText("");
			}
		}
	});
	tFcomando.setBounds(206, 349, 453, 43);
	contentPane.add(tFcomando);
	tFcomando.setColumns(10);
	
	textArea_ciclista2 = new JTextArea();
	textArea_ciclista2.setBounds(592, 29, 278, 98);
	contentPane.add(textArea_ciclista2);
	
	JLabel lblCiclista = new JLabel("Ciclista0");
	lblCiclista.setBounds(12, 2, 70, 15);
	contentPane.add(lblCiclista);
	
	JLabel lblCiclista_1 = new JLabel("Ciclista1");
	lblCiclista_1.setBounds(302, 2, 70, 15);
	contentPane.add(lblCiclista_1);
	
	JLabel lblCiclista_2 = new JLabel("Ciclista2");
	lblCiclista_2.setBounds(592, 2, 70, 15);
	contentPane.add(lblCiclista_2);
	
	textArea_ciclista5 = new JTextArea();
	textArea_ciclista5.setBounds(592, 166, 278, 98);
	contentPane.add(textArea_ciclista5);
	
	JLabel lblCiclista_5 = new JLabel("Ciclista5");
	lblCiclista_5.setBounds(592, 139, 70, 15);
	contentPane.add(lblCiclista_5);
	
	textArea_ciclista4 = new JTextArea();
	textArea_ciclista4.setBounds(302, 166, 278, 98);
	contentPane.add(textArea_ciclista4);
	
	JLabel lblCiclista_4 = new JLabel("Ciclista4");
	lblCiclista_4.setBounds(302, 139, 70, 15);
	contentPane.add(lblCiclista_4);
	
	textArea_ciclista3 = new JTextArea();
	textArea_ciclista3.setBounds(12, 166, 278, 98);
	contentPane.add(textArea_ciclista3);
	
	JLabel lblCiclista_3 = new JLabel("Ciclista3");
	lblCiclista_3.setBounds(12, 139, 70, 15);
	contentPane.add(lblCiclista_3);
	
	lblComandos = new JLabel("Comandos");
	lblComandos.setBounds(206, 322, 114, 15);
	contentPane.add(lblComandos);
	
	lblTiempo = new JLabel("Tiempo");
	lblTiempo.setBounds(312, 293, 70, 15);
	contentPane.add(lblTiempo);
	this.setVisible(true);

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
	    /*
	case "consola":
	    tFconsola.setText(mensaje);
	    break;*/

	}

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
/*
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

	parser = nuevo_parser;

	init();
    }

    private void init() {
	GridLayout layout = new GridLayout(0, 2, 10, 10);

	// Panel general

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 865, 558);
	panel_general = new JPanel();
	panel_general.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(panel_general);
	panel_general.setLayout(layout);

	// Añadir ciclistas.
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

	// Añadir reloj

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
	tFconsola = new JTextField();
	panel_consola.add(new JLabel("Consola"), BorderLayout.NORTH);
	panel_consola.add(tFconsola, BorderLayout.CENTER);

	panel_general.add(panel_consola);

	// Añadir consola // output

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
	case "consola":
	    tFconsola.setText(mensaje);
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
	
	tFreloj.setText("");

    }
}*/