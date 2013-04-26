package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import persona.Ciclista;

import comandos.Comandero;
import comandos.Parser;
import constantes.Constantes;
import entradaDeDatos.Escuchador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * esta clase corresponde a la interfaz grafica de la aplicacion
 * 
 * @author juancly
 * 
 */
public class Ventana extends JFrame implements InterfaceEjecuta {

    private Comandero comandero;

    private static final long serialVersionUID = -8170475180669923771L;

    private JPanel contentPane;
    private JPanel contentPrincipal;
    private JPanel contentLienzo;
    private JTextField tFreloj;
    private JTextField tFcomando;
    private JTextArea tFconsola;
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
    private JScrollPane sbrText;
    Lienzo lienzo;
    Escuchador escuchador;
    private String textoAnteriorScroll ;
    public Ventana(Comandero nuevo_comandero, Lienzo lien) {

	textoAnteriorScroll = "";
	comandero = nuevo_comandero;
	lienzo = lien;
	escuchador = new Escuchador(comandero);
	init();
    }

    private void init()
    {
	crearGUI();
    }
    /**
     * este metodo,crea y coloca los componentes de la interfaz grafica.
     */
    private void crearGUI() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);


	contentPrincipal = crearJPanel(contentPrincipal,0,0,0,0);
	colocarJPanelEnJFrame(contentPrincipal);
	
	contentPane = crearJPanel(contentPrincipal,0,0,Constantes.ANCHO_VENTANA,Constantes.ALTO_VENTANA / 2);
	
	colocarJPanelEnJPanel(contentPane,contentPrincipal);
	

	contentLienzo = crearJPanel(contentPrincipal,0,contentPane.getHeight(),
		Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA / 2);
	colocarJPanelEnJPanel(contentLienzo,contentPrincipal);

	contentLienzo.add(lienzo);

	JLabel lblCiclista0 = null;
	lblCiclista0  = crearJLabel(lblCiclista0,"Ciclista0",Constantes.X_INICIAL, Constantes.Y_INICIAL,
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	colocarJLabelEnJPanel(lblCiclista0, contentPane);

	textArea_ciclista0 = crearJTextArea(textArea_ciclista0,lblCiclista0.getX(),
		lblCiclista0.getHeight(), Constantes.ANCHO_TEXTBOX,Constantes.ALTO_TEXTBOX);
	colocarJTextAreaEnJPanel(textArea_ciclista0,contentPane);
	
	JButton botonDisCad0 = null;
	botonDisCad0 = crearJButton(botonDisCad0,Constantes.CADENCIA_MENOS,textArea_ciclista0.getWidth()
		+ textArea_ciclista0.getX(), textArea_ciclista0.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
		    
	
	escuchador.asignaMouseClicked(botonDisCad0,"asignacadencia 0 "+Constantes.BAJA_CADENCIA);
	
	colocarJButtonEnJPanel(botonDisCad0,contentPane);
//
	JButton botonAumCad0 = null;
	botonAumCad0 = crearJButton(botonAumCad0,Constantes.CADENCIA_MAS,textArea_ciclista0.getWidth()
		+ textArea_ciclista0.getX(), botonDisCad0.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumCad0,"asignacadencia 0 "+Constantes.SUBE_CADENCIA);
	
	colocarJButtonEnJPanel(botonAumCad0,contentPane);

	//
	JButton botonDisPin0 = null;
	botonDisPin0 = crearJButton(botonDisPin0,Constantes.PINON_MENOS,textArea_ciclista0.getWidth()
		+ textArea_ciclista0.getX(), botonAumCad0.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPin0,"bajapinon 0");
	
	colocarJButtonEnJPanel(botonDisPin0,contentPane);
	//
	JButton botonAumPin0 = null;
	botonAumPin0 = crearJButton(botonAumPin0,Constantes.PINON_MAS,textArea_ciclista0.getWidth()
		+ textArea_ciclista0.getX(), botonDisPin0.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPin0,"subepinon 0");
	colocarJButtonEnJPanel(botonAumPin0,contentPane);

	//
	JButton botonDisPla0 = null;
	botonDisPla0 = crearJButton(botonDisPla0,Constantes.PLATO_MENOS,botonDisCad0.getWidth() + botonDisCad0.getX(),
		textArea_ciclista0.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPla0,"bajaplato 0");
	
	colocarJButtonEnJPanel(botonDisPla0,contentPane);

	//

	JButton botonAumPla0 = null;
	botonAumPla0 = crearJButton(botonAumPla0,Constantes.PLATO_MAS,botonAumCad0.getWidth() + botonAumCad0.getX(),
		botonAumCad0.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPla0,"subeplato 0");
	
	colocarJButtonEnJPanel(botonAumPla0,contentPane);
	
	//
	JButton botonFrenaPoco0 = null;
	botonFrenaPoco0 = crearJButton(botonFrenaPoco0,Constantes.FRENO_MENOS,botonDisPin0.getWidth() + botonDisPin0.getX(),
		botonDisPin0.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaPoco0,"frenar 0 1");
	
	colocarJButtonEnJPanel(botonFrenaPoco0,contentPane);

	//

	JButton botonFrenaMas0 = null;
	botonFrenaMas0 = crearJButton(botonFrenaMas0,Constantes.FRENO_MAS,botonAumPin0.getWidth() + botonAumPin0.getX(),
		botonAumPin0.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaMas0,"frenar 0 1");	  
	colocarJButtonEnJPanel(botonFrenaMas0,contentPane);
	
	JLabel lblCiclista1 = null;
	lblCiclista1  = crearJLabel(lblCiclista1,"Ciclista1",
		textArea_ciclista0.getX() + textArea_ciclista0.getWidth() + 2
		* Constantes.ANCHO_BOTON, lblCiclista0.getY(),
	Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	colocarJLabelEnJPanel(lblCiclista1, contentPane);
//
	textArea_ciclista1 = crearJTextArea(textArea_ciclista1,textArea_ciclista0.getX()
		+ textArea_ciclista0.getWidth() + 2 * Constantes.ANCHO_BOTON,
		textArea_ciclista0.getY(), Constantes.ANCHO_TEXTBOX,
		Constantes.ALTO_TEXTBOX);
	colocarJTextAreaEnJPanel(textArea_ciclista1,contentPane);
	//
	JButton botonDisCad1 = null;
	botonDisCad1 = crearJButton(botonDisCad1,Constantes.CADENCIA_MENOS,textArea_ciclista1.getWidth()
		+ textArea_ciclista1.getX(), textArea_ciclista1.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
		    
	escuchador.asignaMouseClicked(botonDisCad1,"asignacadencia 1 "+Constantes.BAJA_CADENCIA);
	
	colocarJButtonEnJPanel(botonDisCad1,contentPane);
//
	JButton botonAumCad1 = null;
	botonAumCad1 = crearJButton(botonAumCad1,Constantes.CADENCIA_MAS,textArea_ciclista1.getWidth()
		+ textArea_ciclista1.getX(), botonDisCad1.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumCad1,"asignacadencia 1 "+Constantes.SUBE_CADENCIA);
	
	colocarJButtonEnJPanel(botonAumCad1,contentPane);
	//
	JButton botonDisPin1 = null;
	botonDisPin1 = crearJButton(botonDisPin1,Constantes.PINON_MENOS,textArea_ciclista1.getWidth()
		+ textArea_ciclista1.getX(), botonAumCad1.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPin1,"bajapinon 1");
	
	colocarJButtonEnJPanel(botonDisPin1,contentPane);
	//
	JButton botonAumPin1 = null;
	botonAumPin1 = crearJButton(botonAumPin1,Constantes.PINON_MAS,textArea_ciclista1.getWidth()
		+ textArea_ciclista1.getX(), botonDisPin1.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPin1,"subepinon 1");
	colocarJButtonEnJPanel(botonAumPin1,contentPane);

	//
	JButton botonDisPla1 = null;
	botonDisPla1 = crearJButton(botonDisPla1,Constantes.PLATO_MENOS,botonDisCad1.getWidth() + botonDisCad1.getX(),
		textArea_ciclista1.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPla1,"bajaplato 1");
	
	colocarJButtonEnJPanel(botonDisPla1,contentPane);

	//

	JButton botonAumPla1 = null;
	botonAumPla1 = crearJButton(botonAumPla1,Constantes.PLATO_MAS,botonAumCad1.getWidth() + botonAumCad1.getX(),
		botonAumCad1.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPla1,"subeplato 1");
	
	colocarJButtonEnJPanel(botonAumPla1,contentPane);
	
	//
	JButton botonFrenaPoco1 = null;
	botonFrenaPoco1 = crearJButton(botonFrenaPoco1,Constantes.FRENO_MENOS,botonDisPin1.getWidth() + botonDisPin1.getX(),
		botonDisPin1.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaPoco1,"frenar 1 1");
	
	colocarJButtonEnJPanel(botonFrenaPoco1,contentPane);

	//

	JButton botonFrenaMas1 = null;
	botonFrenaMas1 = crearJButton(botonFrenaMas1,Constantes.FRENO_MAS,botonAumPin1.getWidth() + botonAumPin1.getX(),
		botonAumPin1.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaMas1,"frenar 1 1");	  
	colocarJButtonEnJPanel(botonFrenaMas1,contentPane);

	
	JLabel lblCiclista_2 = new JLabel("Ciclista2");
	lblCiclista_2.setBounds(
		textArea_ciclista1.getX() + textArea_ciclista1.getWidth() + 2
			* Constantes.ANCHO_BOTON, lblCiclista1.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista_2);

	textArea_ciclista2 = new JTextArea();
	textArea_ciclista2.setBounds(textArea_ciclista1.getX()
		+ textArea_ciclista1.getWidth() + 2 * Constantes.ANCHO_BOTON,
		textArea_ciclista1.getY(), Constantes.ANCHO_TEXTBOX,
		Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista2);
	
	JButton botonDisCad2 = null;
	botonDisCad2 = crearJButton(botonDisCad2,Constantes.CADENCIA_MENOS,textArea_ciclista2.getWidth()
		+ textArea_ciclista2.getX(), textArea_ciclista2.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
		    
	escuchador.asignaMouseClicked(botonDisCad2,"asignacadencia 2 "+Constantes.BAJA_CADENCIA);
	
	colocarJButtonEnJPanel(botonDisCad2,contentPane);
//
	JButton botonAumCad2 = null;
	botonAumCad2 = crearJButton(botonAumCad2,Constantes.CADENCIA_MAS,textArea_ciclista2.getWidth()
		+ textArea_ciclista2.getX(), botonDisCad2.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumCad2,"asignacadencia 2 "+Constantes.SUBE_CADENCIA);
	
	colocarJButtonEnJPanel(botonAumCad2,contentPane);
	//
	JButton botonDisPin2 = null;
	botonDisPin2 = crearJButton(botonDisPin2,Constantes.PINON_MENOS,textArea_ciclista2.getWidth()
		+ textArea_ciclista2.getX(), botonAumCad2.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPin2,"bajapinon 2");
	
	colocarJButtonEnJPanel(botonDisPin2,contentPane);
	//
	JButton botonAumPin2 = null;
	botonAumPin2 = crearJButton(botonAumPin2,Constantes.PINON_MAS,textArea_ciclista2.getWidth()
		+ textArea_ciclista2.getX(), botonDisPin2.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPin2,"subepinon 2");
	colocarJButtonEnJPanel(botonAumPin2,contentPane);

	//
	JButton botonDisPla2 = null;
	botonDisPla2 = crearJButton(botonDisPla2,Constantes.PLATO_MENOS,botonDisCad2.getWidth() + botonDisCad2.getX(),
		textArea_ciclista2.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPla2,"bajaplato 2");
	
	colocarJButtonEnJPanel(botonDisPla2,contentPane);

	//

	JButton botonAumPla2 = null;
	botonAumPla2 = crearJButton(botonAumPla2,Constantes.PLATO_MAS,botonAumCad2.getWidth() + botonAumCad2.getX(),
		botonAumCad2.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPla2,"subeplato 2");
	
	colocarJButtonEnJPanel(botonAumPla2,contentPane);
	
	//
	JButton botonFrenaPoco2 = null;
	botonFrenaPoco2 = crearJButton(botonFrenaPoco2,Constantes.FRENO_MENOS,botonDisPin2.getWidth() + botonDisPin2.getX(),
		botonDisPin2.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaPoco2,"frenar 2 1");
	
	colocarJButtonEnJPanel(botonFrenaPoco2,contentPane);

	//

	JButton botonFrenaMas2 = null;
	botonFrenaMas2 = crearJButton(botonFrenaMas2,Constantes.FRENO_MAS,botonAumPin2.getWidth() + botonAumPin2.getX(),
		botonAumPin2.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaMas2,"frenar 2 1");	  
	colocarJButtonEnJPanel(botonFrenaMas2,contentPane);

	
	JLabel lblCiclista3 = new JLabel("Ciclista3");
	lblCiclista3.setBounds(textArea_ciclista0.getX(), lblCiclista0.getY()
		+ lblCiclista0.getHeight() + textArea_ciclista0.getHeight(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista3);

	textArea_ciclista3 = new JTextArea();
	textArea_ciclista3.setBounds(lblCiclista3.getX(),
		lblCiclista3.getHeight() + lblCiclista3.getY(),
		Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista3);
//////
	JButton botonDisCad3 = null;
	botonDisCad3 = crearJButton(botonDisCad3,Constantes.CADENCIA_MENOS,textArea_ciclista3.getWidth()
		+ textArea_ciclista3.getX(), textArea_ciclista3.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
		    
	
	escuchador.asignaMouseClicked(botonDisCad3,"asignacadencia 3 "+Constantes.BAJA_CADENCIA);
	
	colocarJButtonEnJPanel(botonDisCad3,contentPane);
//
	JButton botonAumCad3 = null;
	botonAumCad3 = crearJButton(botonAumCad3,Constantes.CADENCIA_MAS,textArea_ciclista3.getWidth()
		+ textArea_ciclista3.getX(), botonDisCad3.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumCad3,"asignacadencia 3 "+Constantes.SUBE_CADENCIA);
	
	colocarJButtonEnJPanel(botonAumCad3,contentPane);

	//
	JButton botonDisPin3 = null;
	botonDisPin3 = crearJButton(botonDisPin3,Constantes.PINON_MENOS,textArea_ciclista3.getWidth()
		+ textArea_ciclista3.getX(), botonAumCad3.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPin3,"bajapinon 3");
	
	colocarJButtonEnJPanel(botonDisPin3,contentPane);
	//
	JButton botonAumPin3 = null;
	botonAumPin3 = crearJButton(botonAumPin3,Constantes.PINON_MAS,textArea_ciclista3.getWidth()
		+ textArea_ciclista3.getX(), botonDisPin3.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPin3,"subepinon 3");
	colocarJButtonEnJPanel(botonAumPin3,contentPane);

	//
	JButton botonDisPla3 = null;
	botonDisPla3 = crearJButton(botonDisPla3,Constantes.PLATO_MENOS,botonDisCad3.getWidth() + botonDisCad3.getX(),
		textArea_ciclista3.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPla3,"bajaplato 3");
	
	colocarJButtonEnJPanel(botonDisPla3,contentPane);

	//

	JButton botonAumPla3 = null;
	botonAumPla3 = crearJButton(botonAumPla3,Constantes.PLATO_MAS,botonAumCad3.getWidth() + botonAumCad3.getX(),
		botonAumCad3.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPla3,"subeplato 3");
	
	colocarJButtonEnJPanel(botonAumPla3,contentPane);
	
	//
	JButton botonFrenaPoco3 = null;
	botonFrenaPoco3 = crearJButton(botonFrenaPoco3,Constantes.FRENO_MENOS,botonDisPin3.getWidth() + botonDisPin3.getX(),
		botonDisPin3.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaPoco3,"frenar 3 1");
	
	colocarJButtonEnJPanel(botonFrenaPoco3,contentPane);

	//

	JButton botonFrenaMas3 = null;
	botonFrenaMas3 = crearJButton(botonFrenaMas3,Constantes.FRENO_MAS,botonAumPin3.getWidth() + botonAumPin3.getX(),
		botonAumPin3.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaMas3,"frenar 3 1");	  
	colocarJButtonEnJPanel(botonFrenaMas3,contentPane);
	
	JLabel lblCiclista_4 = new JLabel("Ciclista4");
	lblCiclista_4.setBounds(
		textArea_ciclista3.getX() + textArea_ciclista3.getWidth() + 2
			* Constantes.ANCHO_BOTON, lblCiclista3.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista_4);

	textArea_ciclista4 = new JTextArea();
	textArea_ciclista4.setBounds(textArea_ciclista3.getX()
		+ textArea_ciclista3.getWidth() + 2 * Constantes.ANCHO_BOTON,
		textArea_ciclista3.getY(), Constantes.ANCHO_TEXTBOX,
		Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista4);

	JButton botonDisCad4 = null;
	botonDisCad4 = crearJButton(botonDisCad4,Constantes.CADENCIA_MENOS,textArea_ciclista4.getWidth()
		+ textArea_ciclista4.getX(), textArea_ciclista4.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
		    
	escuchador.asignaMouseClicked(botonDisCad4,"asignacadencia 4 "+Constantes.BAJA_CADENCIA);
	
	colocarJButtonEnJPanel(botonDisCad4,contentPane);
//
	JButton botonAumCad4 = null;
	botonAumCad4 = crearJButton(botonAumCad4,Constantes.CADENCIA_MAS,textArea_ciclista4.getWidth()
		+ textArea_ciclista4.getX(), botonDisCad4.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumCad4,"asignacadencia 4 "+Constantes.SUBE_CADENCIA);
	
	colocarJButtonEnJPanel(botonAumCad4,contentPane);
	//
	JButton botonDisPin4 = null;
	botonDisPin4 = crearJButton(botonDisPin4,Constantes.PINON_MENOS,textArea_ciclista4.getWidth()
		+ textArea_ciclista4.getX(), botonAumCad4.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPin4,"bajapinon 4");
	
	colocarJButtonEnJPanel(botonDisPin4,contentPane);
	//
	JButton botonAumPin4 = null;
	botonAumPin4 = crearJButton(botonAumPin4,Constantes.PINON_MAS,textArea_ciclista4.getWidth()
		+ textArea_ciclista4.getX(), botonDisPin4.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPin4,"subepinon 4");
	colocarJButtonEnJPanel(botonAumPin4,contentPane);

	//
	JButton botonDisPla4 = null;
	botonDisPla4 = crearJButton(botonDisPla4,Constantes.PLATO_MENOS,botonDisCad4.getWidth() + botonDisCad4.getX(),
		textArea_ciclista4.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPla4,"bajaplato 4");
	
	colocarJButtonEnJPanel(botonDisPla4,contentPane);

	//

	JButton botonAumPla4 = null;
	botonAumPla4 = crearJButton(botonAumPla4,Constantes.PLATO_MAS,botonAumCad4.getWidth() + botonAumCad4.getX(),
		botonAumCad4.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPla4,"subeplato 4");
	
	colocarJButtonEnJPanel(botonAumPla4,contentPane);
	
	//
	JButton botonFrenaPoco4 = null;
	botonFrenaPoco4 = crearJButton(botonFrenaPoco4,Constantes.FRENO_MENOS,botonDisPin4.getWidth() + botonDisPin4.getX(),
		botonDisPin4.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaPoco4,"frenar 4 1");
	
	colocarJButtonEnJPanel(botonFrenaPoco4,contentPane);

	//

	JButton botonFrenaMas4 = null;
	botonFrenaMas4 = crearJButton(botonFrenaMas4,Constantes.FRENO_MAS,botonAumPin4.getWidth() + botonAumPin4.getX(),
		botonAumPin4.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaMas4,"frenar 4 1");	  
	colocarJButtonEnJPanel(botonFrenaMas4,contentPane);
	
	JLabel lblCiclista_5 = new JLabel("Ciclista5");
	lblCiclista_5.setBounds(
		textArea_ciclista4.getX() + textArea_ciclista4.getWidth() + 2
			* Constantes.ANCHO_BOTON, lblCiclista_4.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista_5);

	textArea_ciclista5 = new JTextArea();
	textArea_ciclista5.setBounds(textArea_ciclista4.getX()
		+ textArea_ciclista4.getWidth() + 2 * Constantes.ANCHO_BOTON,
		textArea_ciclista4.getY(), Constantes.ANCHO_TEXTBOX,
		Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista5);

	JButton botonDisCad5 = null;
	botonDisCad5 = crearJButton(botonDisCad5,Constantes.CADENCIA_MENOS,textArea_ciclista5.getWidth()
		+ textArea_ciclista5.getX(), textArea_ciclista5.getY(),
		Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
		    
	escuchador.asignaMouseClicked(botonDisCad5,"asignacadencia 5 "+Constantes.BAJA_CADENCIA);
	
	colocarJButtonEnJPanel(botonDisCad5,contentPane);
//
	JButton botonAumCad5 = null;
	botonAumCad5 = crearJButton(botonAumCad5,Constantes.CADENCIA_MAS,textArea_ciclista5.getWidth()
		+ textArea_ciclista5.getX(), botonDisCad5.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumCad5,"asignacadencia 5 "+Constantes.SUBE_CADENCIA);
	
	colocarJButtonEnJPanel(botonAumCad5,contentPane);
	//
	JButton botonDisPin5 = null;
	botonDisPin5 = crearJButton(botonDisPin5,Constantes.PINON_MENOS,textArea_ciclista5.getWidth()
		+ textArea_ciclista5.getX(), botonAumCad5.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPin5,"bajapinon 5");
	
	colocarJButtonEnJPanel(botonDisPin5,contentPane);
	//
	JButton botonAumPin5 = null;
	botonAumPin5 = crearJButton(botonAumPin5,Constantes.PINON_MAS,textArea_ciclista5.getWidth()
		+ textArea_ciclista5.getX(), botonDisPin5.getY()
		+ Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPin5,"subepinon 5");
	colocarJButtonEnJPanel(botonAumPin5,contentPane);

	//
	JButton botonDisPla5 = null;
	botonDisPla5 = crearJButton(botonDisPla5,Constantes.PLATO_MENOS,botonDisCad5.getWidth() + botonDisCad5.getX(),
		textArea_ciclista5.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonDisPla5,"bajaplato 5");
	
	colocarJButtonEnJPanel(botonDisPla5,contentPane);

	//

	JButton botonAumPla5 = null;
	botonAumPla5 = crearJButton(botonAumPla5,Constantes.PLATO_MAS,botonAumCad5.getWidth() + botonAumCad5.getX(),
		botonAumCad5.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonAumPla5,"subeplato 5");
	
	colocarJButtonEnJPanel(botonAumPla5,contentPane);
	
	//
	JButton botonFrenaPoco5 = null;
	botonFrenaPoco5 = crearJButton(botonFrenaPoco5,Constantes.FRENO_MENOS,botonDisPin5.getWidth() + botonDisPin5.getX(),
		botonDisPin5.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaPoco5,"frenar 5 1");
	
	colocarJButtonEnJPanel(botonFrenaPoco5,contentPane);

	//

	JButton botonFrenaMas5 = null;
	botonFrenaMas5 = crearJButton(botonFrenaMas5,Constantes.FRENO_MAS,botonAumPin5.getWidth() + botonAumPin5.getX(),
		botonAumPin5.getY(), Constantes.ANCHO_BOTON,
		Constantes.ALTO_BOTON);
	escuchador.asignaMouseClicked(botonFrenaMas5,"frenar 5 1");	  
	colocarJButtonEnJPanel(botonFrenaMas5,contentPane);
	
	lblTiempo = crearJLabel(lblTiempo,"Tiempo",textArea_ciclista3.getX(),
		textArea_ciclista3.getY() + textArea_ciclista3.getHeight(), 70,
		15);

	colocarJLabelEnJPanel(lblTiempo,contentPane);

	tFreloj = crearJTextField(tFreloj,lblTiempo.getX(),
		lblTiempo.getY() + lblTiempo.getHeight(), 114, 19);
	tFreloj.setEditable(false);
	
	colocarJTextFieldEnJPanel(tFreloj,contentPane);

	cadena = "";

	lblComandos = crearJLabel(lblComandos,"Comandos",textArea_ciclista4.getX(),
		textArea_ciclista4.getY() + textArea_ciclista4.getHeight(),
		114, 15);
	
	colocarJLabelEnJPanel(lblComandos,contentPane);
	tFcomando = crearJTextField(tFcomando,lblComandos.getX(), lblComandos.getY()
		+ lblComandos.getHeight(), Constantes.ANCHO_TEXTBOX,
		Constantes.ALTO_TEXTBOX);
	escuchador.asignaKeyPressed(tFcomando, tFcomando.getText());
	
	colocarJTextFieldEnJPanel(tFcomando,contentPane);

	JLabel lblConsola = crearJLabel(lblComandos,"Consola",textArea_ciclista5.getX(),
		textArea_ciclista4.getY() + textArea_ciclista4.getHeight(),
		114, 15);
	
	colocarJLabelEnJPanel(lblConsola,contentPane);

	tFconsola = crearJTextArea(tFconsola,lblConsola.getX(),
		lblConsola.getY() + lblConsola.getHeight(),
		Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	

	tFconsola.setLineWrap(true);
	sbrText = crearJScrollPane(sbrText,tFconsola,lblConsola.getX(),
		lblConsola.getY() + lblConsola.getHeight(),
		Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	
	colocarJScrollPaneEnJPanel(sbrText,contentPane);
	this.setVisible(true);

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
	    String mens = tFconsola.getText().toString() + mensaje;
	    
	    if(!mensaje.equalsIgnoreCase("")) 
	    {
		tFconsola.setText(mens + "\n");
		
	    }
	    break;

	}
    }

    /**
     * metodo heredado de la interfazEjecuta, el cual se ejecuta, cada vuelta
     * del bucle principal
     */
    @Override
    public void ejecuta() {

	textArea_ciclista0.setText("");

	textArea_ciclista1.setText("");

	textArea_ciclista2.setText("");
	textArea_ciclista3.setText("");
	textArea_ciclista4.setText("");

	textArea_ciclista5.setText("");
        //tFconsola.setText("");
	tFreloj.setText("");
	//comprobamos que texto que se escribio antes, no corresponde con el texto 
	//actual, para poder mover el scrollBar y que no se mueva a no ser que se 
	//introduzca un nuevo comando
	if(!textoAnteriorScroll.equalsIgnoreCase( tFconsola.getText()))
	{
	    sbrText.getVerticalScrollBar().setValue(sbrText.getVerticalScrollBar().getMaximum());
	}
	textoAnteriorScroll  = tFconsola.getText();
    }
    private void colocarJButtonEnJPanel(JButton bt,JPanel destino)
    {
	destino.add(bt);
    }
    private void colocarJScrollPaneEnJPanel(JScrollPane sc,JPanel destino)
    {
	destino.add(sc);
    }
    private void colocarJPanelEnJFrame(JPanel panel)
    {
	setContentPane(panel);
    }
    private void colocarJPanelEnJPanel(JPanel origen,JPanel destino)
    {
	destino.add(origen);
    }
    private void colocarJTextAreaEnJPanel(JTextArea origen,JPanel destino)
    {
	destino.add(origen);
    }
    private void colocarJTextFieldEnJPanel(JTextField origen,JPanel destino)
    {
	destino.add(origen);
    }
    private void colocarJLabelEnJPanel(JLabel origen,JPanel destino)
    {
	destino.add(origen);
    }
    private JPanel crearJPanel(JPanel panel,int x,int y,int ancho,int alto)
    {
	panel = new JPanel();
	panel.setLayout(null);
	panel.setBounds(x, y, ancho,alto);
	panel.setBorder(new EmptyBorder(0, 0, 0, 0));
	
	return panel;
    }
    private JLabel crearJLabel(JLabel label,String nombre,int x,int y,int ancho,int alto)
    {
	label = new JLabel(nombre);
	label.setBounds(x, y,ancho, alto);
	
	return label;
    }
    private JTextArea crearJTextArea(JTextArea text,int x,int y,int ancho,int alto)
    {
	text = new JTextArea();
	text.setBounds(x,y, ancho,alto);
	return text;
    }
    private JTextField crearJTextField(JTextField text,int x,int y,int ancho,int alto)
    {
	text = new JTextField();
	text.setBounds(x,y, ancho,alto);
	return text;
    }
    private JButton crearJButton(JButton bt,String texto,int x,int y,int ancho,int alto)
    {
	bt = new JButton();
	bt.setBounds(x,y, ancho,alto);
	
	bt.setText(texto);
	bt.setVisible(true);
	bt.setBounds(x,y,ancho,alto);
	return bt;
    }
    private JScrollPane crearJScrollPane(JScrollPane scroll,JTextArea tf,int x, int y, int ancho, int alto)
    {
	scroll = new JScrollPane(tf);
	scroll = new JScrollPane(tFconsola);
	scroll.setBounds(x,y,ancho,alto);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	return scroll;
    }
}
