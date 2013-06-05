package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import comandos.Comandero;

import constantes.Constantes;
import entradaDeDatos.Escuchador;

/**
 * esta clase corresponde a la interfaz grafica de la aplicacion
 * 
 * @author juancly
 * 
 */
public class Ventana extends JFrame implements InterfaceEjecuta {

    /**
	 * @uml.property  name="comandero"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Comandero comandero;

    private static final long serialVersionUID = -8170475180669923771L;

    /**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  
	 */
    private JPanel contentPane;
    /**
	 * @uml.property  name="contentPrincipal"
	 * @uml.associationEnd  
	 */
    private JPanel contentPrincipal;
    /**
	 * @uml.property  name="contentLienzo"
	 * @uml.associationEnd  
	 */
    private JPanel contentLienzo;
    /**
	 * @uml.property  name="tFreloj"
	 * @uml.associationEnd  
	 */
    private JTextField tFreloj;
    /**
	 * @uml.property  name="tFcomando"
	 * @uml.associationEnd  
	 */
    private JTextField tFcomando;
    /**
	 * @uml.property  name="tFconsola"
	 * @uml.associationEnd  
	 */
    private JTextArea tFconsola;
    /**
	 * @uml.property  name="cadena"
	 */
    private String cadena;

    /**
	 * @uml.property  name="lblComandos"
	 * @uml.associationEnd  
	 */
    private JLabel lblComandos;
    /**
	 * @uml.property  name="lblTiempo"
	 * @uml.associationEnd  
	 */
    private JLabel lblTiempo;
    /**
	 * @uml.property  name="lblconsola"
	 * @uml.associationEnd  readOnly="true"
	 */
    private JLabel lblconsola;
    /**
	 * @uml.property  name="sbrText"
	 * @uml.associationEnd  
	 */
    private JScrollPane sbrText;
    /**
	 * @uml.property  name="lienzo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Lienzo lienzo;
    /**
	 * @uml.property  name="escuchador"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Escuchador escuchador;
    /**
	 * @uml.property  name="textoAnteriorScroll"
	 */
    private String textoAnteriorScroll;

    /**
	 * @uml.property  name="textAreas"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JTextArea textAreas[];
    /**
	 * @uml.property  name="lblCiclistas"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JLabel lblCiclistas[];
    /**
	 * @uml.property  name="botonAumCad"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonAumCad[];
    /**
	 * @uml.property  name="botonDisCad"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonDisCad[];
    /**
	 * @uml.property  name="botonDisPin"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonDisPin[];
    /**
	 * @uml.property  name="botonAumPin"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonAumPin[];
    /**
	 * @uml.property  name="botonDisPla"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonDisPla[];
    /**
	 * @uml.property  name="botonAumPla"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonAumPla[];
    /**
	 * @uml.property  name="botonFrenaPoco"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonFrenaPoco[];
    /**
	 * @uml.property  name="botonFrenaMas"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JButton botonFrenaMas[];
    /**
	 * @uml.property  name="color" multiplicity="(0 -1)" dimension="1"
	 */
    private Color color[];
    /**
	 * @uml.property  name="barras"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private JProgressBar barras[];

    public Ventana(Comandero nuevo_comandero, Lienzo lien) {
	textAreas = new JTextArea[Constantes.MAX_CICLISTAS];
	lblCiclistas = new JLabel[Constantes.MAX_CICLISTAS];
	botonDisCad = new JButton[Constantes.MAX_CICLISTAS];
	botonAumCad = new JButton[Constantes.MAX_CICLISTAS];
	botonDisPin = new JButton[Constantes.MAX_CICLISTAS];
	botonAumPin = new JButton[Constantes.MAX_CICLISTAS];
	botonDisPla = new JButton[Constantes.MAX_CICLISTAS];
	botonAumPla = new JButton[Constantes.MAX_CICLISTAS];
	botonFrenaPoco = new JButton[Constantes.MAX_CICLISTAS];
	botonFrenaMas = new JButton[Constantes.MAX_CICLISTAS];
	barras = new JProgressBar[Constantes.MAX_CICLISTAS];
	color = new Color[Constantes.MAX_CICLISTAS];
	textoAnteriorScroll = "";
	comandero = nuevo_comandero;
	lienzo = lien;
	escuchador = new Escuchador(comandero);
	init();
    }

    private void colocarJButtonEnJPanel(JButton bt, JPanel destino) {
	destino.add(bt);
    }

    private void colocarJLabelEnJPanel(JLabel origen, JPanel destino) {
	destino.add(origen);
    }

    private void colocarJPanelEnJFrame(JPanel panel) {
	setContentPane(panel);
    }

    private void colocarJPanelEnJPanel(JPanel origen, JPanel destino) {
	destino.add(origen);
    }

    private void colocarJScrollPaneEnJPanel(JScrollPane sc, JPanel destino) {
	destino.add(sc);
    }

    private void colocarJTextAreaEnJPanel(JTextArea origen, JPanel destino) {
	destino.add(origen);
    }

    private void colocarJTextFieldEnJPanel(JTextField origen, JPanel destino) {
	destino.add(origen);
    }

    /**
     * este metodo,crea y coloca los componentes de la interfaz grafica.
     */
    private void crearGUI() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setBounds(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

	contentPrincipal = crearJPanel(contentPrincipal, 0, 0, 0, 0);
	colocarJPanelEnJFrame(contentPrincipal);

	contentPane = crearJPanel(contentPrincipal, 0, 0,
		Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA / 2);

	colocarJPanelEnJPanel(contentPane, contentPrincipal);
	
	contentLienzo = crearJPanel(contentPrincipal, 0,
		contentPane.getHeight(), Constantes.ANCHO_VENTANA/2, //Modificado para pruebas de lienzo
		Constantes.ALTO_VENTANA / 2);
	colocarJPanelEnJPanel(contentLienzo, contentPrincipal);

	contentLienzo.add(lienzo);
	color[0] = Constantes.COLOR_CIC_0;
	color[1] = Constantes.COLOR_CIC_1;
	color[2] = Constantes.COLOR_CIC_2;
	color[3] = Constantes.COLOR_CIC_3;
	color[4] = Constantes.COLOR_CIC_4;
	color[5] = Constantes.COLOR_CIC_5;
	int i = 0;
	int y = Constantes.Y_INICIAL;
	for (i = 0; i < Constantes.MAX_CICLISTAS; i++) {
	    if (i > 2) {
		y = lblCiclistas[i % 3].getY() + Constantes.ALTO_TEXTBOX
			+ Constantes.ALTO_BOTON;
	    }
	    lblCiclistas[i] = null;
	    lblCiclistas[i] = crearJLabel(
		    lblCiclistas[i],
		    "Ciclista" + i,
		    Constantes.X_INICIAL
			    + i
			    % 3
			    * (Constantes.ANCHO_TEXTBOX + Constantes.ANCHO_BOTON * 2),
		    y, Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON, color[i]);
	    colocarJLabelEnJPanel(lblCiclistas[i], contentPane);

	    /* TEXT AREA DE CICLISTA */
	    textAreas[i] = crearJTextArea(textAreas[i], lblCiclistas[i].getX(),
		    lblCiclistas[i].getHeight() + y, Constantes.ANCHO_TEXTBOX,
		    Constantes.ALTO_TEXTBOX - Constantes.ALTO_BOTON);
	    colocarJTextAreaEnJPanel(textAreas[i], contentPane);

	    /* BARRA DE PROGESO */
	    barras[i] = new JProgressBar(0, 10000);
	    barras[i].setBounds(textAreas[i].getX(), textAreas[i].getY()
		    + Constantes.ALTO_TEXTBOX - Constantes.ALTO_BOTON,
		    Constantes.ANCHO_TEXTBOX, Constantes.ALTO_BOTON);
	    barras[i].setValue(10000);
	    barras[i].setString("100%");
	    barras[i].setStringPainted(true);
	    contentPane.add(barras[i]);

	    /* BOTON DISMINUYE CADENCIA */
	    botonDisCad[i] = null;
	    botonDisCad[i] = crearJButton(botonDisCad[i],
		    Constantes.CADENCIA_MENOS, textAreas[i].getWidth()
			    + textAreas[i].getX(), textAreas[i].getY(),
		    Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);

	    // escuchador.asignaMouseClicked(botonDisCad[i], "asignacadencia " +
	    // i
	    // + " " + Constantes.BAJAR);
	    /* Implementacion de prueba que funciona */
	    escuchador.asignaMouseClicked(botonDisCad[i], "ciclista " + i
		    + " cadencia " + Constantes.BAJAR + " periodo " + 1);
	    colocarJButtonEnJPanel(botonDisCad[i], contentPane);

	    /* BOTON AUMENTA CADENCIA */
	    botonAumCad[i] = null;
	    botonAumCad[i] = crearJButton(botonAumCad[i],
		    Constantes.CADENCIA_MAS, textAreas[i].getWidth()
			    + textAreas[i].getX(), botonDisCad[i].getY()
			    + Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		    Constantes.ALTO_BOTON);

	    // escuchador.asignaMouseClicked(botonAumCad[i], "asignacadencia " +
	    // i
	    // + " " + Constantes.SUBIR);
	    /* Implementacion de prueba que funciona */
	    escuchador.asignaMouseClicked(botonAumCad[i], "ciclista " + i
		    + " cadencia " + Constantes.SUBIR + " periodo " + 1);
	    colocarJButtonEnJPanel(botonAumCad[i], contentPane);

	    /* BOTON DISMINUYE PINON */
	    botonDisPin[i] = null;
	    botonDisPin[i] = crearJButton(botonDisPin[i],
		    Constantes.PINON_MENOS, textAreas[i].getWidth()
			    + textAreas[i].getX(), botonAumCad[i].getY()
			    + Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		    Constantes.ALTO_BOTON);

	    escuchador.asignaMouseClicked(botonDisPin[i], "bicicleta " + i
		    + " cambia pinon " + Constantes.BAJAR);

	    colocarJButtonEnJPanel(botonDisPin[i], contentPane);

	    /* BOTON AUMENTA PINON */
	    botonAumPin[i] = null;
	    botonAumPin[i] = crearJButton(botonAumPin[i], Constantes.PINON_MAS,
		    textAreas[i].getWidth() + textAreas[i].getX(),
		    botonDisPin[i].getY() + Constantes.ALTO_BOTON,
		    Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	    escuchador.asignaMouseClicked(botonAumPin[i], "bicicleta " + i
		    + " cambia pinon " + Constantes.SUBIR);
	    colocarJButtonEnJPanel(botonAumPin[i], contentPane);

	    /* BOTON DISMINUYE PLATO */
	    botonDisPla[i] = null;
	    botonDisPla[i] = crearJButton(botonDisPla[i],
		    Constantes.PLATO_MENOS, botonDisCad[i].getWidth()
			    + botonDisCad[i].getX(), textAreas[i].getY(),
		    Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	    escuchador.asignaMouseClicked(botonDisPla[i], "bicicleta " + i
		    + " cambia plato " + Constantes.BAJAR);

	    colocarJButtonEnJPanel(botonDisPla[i], contentPane);

	    /* BOTON AUMENTA PLATO */
	    botonAumPla[i] = null;
	    botonAumPla[i] = crearJButton(botonAumPla[i], Constantes.PLATO_MAS,
		    botonAumCad[i].getWidth() + botonAumCad[i].getX(),
		    botonAumCad[i].getY(), Constantes.ANCHO_BOTON,
		    Constantes.ALTO_BOTON);
	    escuchador.asignaMouseClicked(botonAumPla[i], "bicicleta " + i
		    + " cambia plato " + Constantes.SUBIR);

	    colocarJButtonEnJPanel(botonAumPla[i], contentPane);

	    /* BOTON FRENA POCO */
	    botonFrenaPoco[i] = null;
	    botonFrenaPoco[i] = crearJButton(botonFrenaPoco[i],
		    Constantes.FRENO_MENOS, botonDisPin[i].getWidth()
			    + botonDisPin[i].getX(), botonDisPin[i].getY(),
		    Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	    // escuchador.asignaMouseClicked(botonFrenaPoco[i], "frenar " + i
	    // + " 1");
	    /* Implementacion de prueba que funciona */
	    escuchador.asignaMouseClicked(botonFrenaPoco[i], "ciclista " + i
		    + " frena " + 0.1);

	    colocarJButtonEnJPanel(botonFrenaPoco[i], contentPane);

	    /* BOTON FRENA MAS */
	    botonFrenaMas[i] = null;
	    botonFrenaMas[i] = crearJButton(botonFrenaMas[i],
		    Constantes.FRENO_MAS, botonAumPin[i].getWidth()
			    + botonAumPin[i].getX(), botonAumPin[i].getY(),
		    Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	    // escuchador.asignaMouseClicked(botonFrenaMas[i], "frenar " + i
	    // + " 1");
	    /* Implementacion de prueba que funciona */
	    escuchador.asignaMouseClicked(botonFrenaMas[i], "ciclista " + i
		    + " frena " + 1);

	    colocarJButtonEnJPanel(botonFrenaMas[i], contentPane);
	}

	lblTiempo = crearJLabel(lblTiempo, "Tiempo", textAreas[3].getX(),
		textAreas[3].getY() + textAreas[3].getHeight()
			+ Constantes.ALTO_BOTON, 70, 15, Color.black);

	colocarJLabelEnJPanel(lblTiempo, contentPane);

	tFreloj = crearJTextField(tFreloj, lblTiempo.getX(), lblTiempo.getY()
		+ lblTiempo.getHeight(), 114, 19);
	tFreloj.setEditable(false);

	colocarJTextFieldEnJPanel(tFreloj, contentPane);

	cadena = "";

	lblComandos = crearJLabel(lblComandos, "Comandos", textAreas[4].getX(),
		textAreas[4].getY() + textAreas[4].getHeight()
			+ Constantes.ALTO_BOTON, 114, 15, Color.black);

	colocarJLabelEnJPanel(lblComandos, contentPane);
	tFcomando = crearJTextField(tFcomando, lblComandos.getX(),
		lblComandos.getY() + lblComandos.getHeight(),
		Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	escuchador.asignaKeyPressed(tFcomando, tFcomando.getText());

	colocarJTextFieldEnJPanel(tFcomando, contentPane);

	JLabel lblConsola = crearJLabel(lblComandos, "Consola",
		textAreas[5].getX(),
		textAreas[4].getY() + textAreas[4].getHeight()
			+ Constantes.ALTO_BOTON, 114, 15, Color.black);

	colocarJLabelEnJPanel(lblConsola, contentPane);

	tFconsola = crearJTextArea(tFconsola, lblConsola.getX(),
		lblConsola.getY() + lblConsola.getHeight(),
		Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);

	tFconsola.setLineWrap(true);
	sbrText = crearJScrollPane(sbrText, tFconsola, lblConsola.getX(),
		lblConsola.getY() + lblConsola.getHeight(),
		Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);

	colocarJScrollPaneEnJPanel(sbrText, contentPane);

	this.setVisible(true);

    }

    private JButton crearJButton(JButton bt, String texto, int x, int y,
	    int ancho, int alto) {
	bt = new JButton();
	bt.setBounds(x, y, ancho, alto);

	bt.setText(texto);
	bt.setVisible(true);
	bt.setBounds(x, y, ancho, alto);
	return bt;
    }

    private JLabel crearJLabel(JLabel label, String nombre, int x, int y,
	    int ancho, int alto, Color color) {
	label = new JLabel(nombre);
	label.setBounds(x, y, ancho, alto);
	label.setForeground(color);
	return label;
    }

    private JPanel crearJPanel(JPanel panel, int x, int y, int ancho, int alto) {
	panel = new JPanel();
	panel.setLayout(null);
	panel.setBounds(x, y, ancho, alto);
	panel.setBorder(new EmptyBorder(0, 0, 0, 0));

	return panel;
    }

    private JScrollPane crearJScrollPane(JScrollPane scroll, JTextArea tf,
	    int x, int y, int ancho, int alto) {
	scroll = new JScrollPane(tf);
	scroll.setBounds(x, y, ancho, alto);
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	return scroll;
    }

    private JTextArea crearJTextArea(JTextArea text, int x, int y, int ancho,
	    int alto) {
	text = new JTextArea();
	text.setBounds(x, y, ancho, alto);
	return text;
    }

    private JTextField crearJTextField(JTextField text, int x, int y,
	    int ancho, int alto) {
	text = new JTextField();
	text.setBounds(x, y, ancho, alto);
	return text;
    }

    /**
     * metodo heredado de la interfazEjecuta, el cual se ejecuta, cada vuelta
     * del bucle principal
     */
    @Override
    public void ejecuta() {

	textAreas[0].setText("");

	textAreas[1].setText("");

	textAreas[2].setText("");
	textAreas[3].setText("");
	textAreas[4].setText("");

	textAreas[5].setText("");
	// tFconsola.setText("");
	tFreloj.setText("");
	// comprobamos que texto que se escribio antes, no corresponde con el
	// texto
	// actual, para poder mover el scrollBar y que no se mueva a no ser que
	// se
	// introduzca un nuevo comando

	// A veces da este error
	// at javax.swing.BufferStrategyPaintManager.flushAccumulatedRegion

	if (!textoAnteriorScroll.equalsIgnoreCase(tFconsola.getText())) {
	    sbrText.getVerticalScrollBar().setValue(
		    sbrText.getVerticalScrollBar().getMaximum());
	}
	textoAnteriorScroll = tFconsola.getText();
    }

    private void init() {
	crearGUI();
    }

    private String obtenFuerzadelMensaje(String mensaje, int id) {
	if (mensaje.contains("Fuerza:")) {
	    String fuerza = mensaje.substring(mensaje.indexOf(":") + 1);
	    String fuerza_res=fuerza.substring(0, fuerza.indexOf(":"));
	    double fuerza_restante= Double.parseDouble(fuerza_res);
	    double fuerza_inicial= Double.parseDouble(fuerza.substring(fuerza.indexOf(":")+1));
	    String mensajeBarra= String.valueOf((fuerza_restante/fuerza_inicial) * 100);
	    barras[id].setValue((int) ((fuerza_restante/fuerza_inicial) * 10000));
	    if (fuerza_res.length() > 3)
		barras[id].setString(mensajeBarra.substring(0, 4) + "%");
	    else
		barras[id].setString("0%");

	}

	return "";

    }

    /**
     * este metodo , asigna un texto al textArea de ciclista que se quiera
     * 
     * @param id
     * @param mensaje
     */
    public void ponTextoEnTextArea(String id, String mensaje) {

	switch (id) {
	case "ciclista0":
	    if (mensaje.contains("Fuerza"))
		obtenFuerzadelMensaje(mensaje, 0);
	    else
		textAreas[0].setText(textAreas[0].getText() + "\n" + mensaje);
	    break;
	case "ciclista1":
	    if (mensaje.contains("Fuerza"))
		obtenFuerzadelMensaje(mensaje, 1);
	    else
		textAreas[1].setText(textAreas[1].getText() + "\n" + mensaje);
	    break;
	case "ciclista2":
	    if (mensaje.contains("Fuerza"))
		obtenFuerzadelMensaje(mensaje, 2);
	    else
		textAreas[2].setText(textAreas[2].getText() + "\n" + mensaje);
	    break;
	case "ciclista3":
	    if (mensaje.contains("Fuerza"))
		obtenFuerzadelMensaje(mensaje, 3);
	    else
		textAreas[3].setText(textAreas[3].getText() + "\n" + mensaje);
	    break;
	case "ciclista4":
	    if (mensaje.contains("Fuerza"))
		obtenFuerzadelMensaje(mensaje, 4);
	    else
		textAreas[4].setText(textAreas[4].getText() + "\n" + mensaje);
	    break;
	case "ciclista5":
	    if (mensaje.contains("Fuerza"))
		obtenFuerzadelMensaje(mensaje, 5);
	    else
		textAreas[5].setText(textAreas[5].getText() + "\n" + mensaje);
	    break;

	case "reloj":
	    tFreloj.setText(mensaje);
	    break;
	case "consola":
	    String mens = tFconsola.getText().toString() + mensaje;

	    if (!mensaje.equalsIgnoreCase("")) {
		tFconsola.setText(mens + "\n");

	    }
	    break;

	}
    }
}