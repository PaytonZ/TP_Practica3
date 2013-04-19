package vista;

import interfaceMain.InterfaceEjecuta;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import comandos.Parser;
import constantes.Constantes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame implements InterfaceEjecuta {

    private Parser parser;

    private static final long serialVersionUID = -8170475180669923771L;

    private JPanel contentPane;
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

    public Ventana(Parser nuevo_parser) {

	parser = nuevo_parser;

	init();
    }

    private void init() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 1366, 768);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textArea_ciclista0 = new JTextArea();
	textArea_ciclista0.setBounds(0, 29, Constantes.ANCHO_TEXTBOX,Constantes.ALTO_TEXTBOX );
	contentPane.add(textArea_ciclista0);
	
	JButton botonDisCad0 = new JButton();
	botonDisCad0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 0 -");
		}
	});
	botonDisCad0.setText("Caden-");
	botonDisCad0.setVisible(true);
	botonDisCad0.setBounds(textArea_ciclista0.getWidth()+textArea_ciclista0.getX(), textArea_ciclista0.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisCad0);
	
	JButton botonAumCad0 = new JButton();
	botonAumCad0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 0 +");
		}
	});
	botonAumCad0.setText("Caden+");
	botonAumCad0.setVisible(true);
	botonAumCad0.setBounds(textArea_ciclista0.getWidth()+textArea_ciclista0.getX(), botonDisCad0.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumCad0);
	
	
	JButton botonDisPin0 = new JButton();
	botonDisPin0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajapinon 0");
		}
	});
	botonDisPin0.setText("Piñon -");
	botonDisPin0.setVisible(true);
	botonDisPin0.setBounds(textArea_ciclista0.getWidth()+textArea_ciclista0.getX(), botonAumCad0.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPin0);
	
	JButton botonAumPin0 = new JButton();
	botonAumPin0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subepinon 0");
		}
	});
	botonAumPin0.setText("Piñon +");
	botonAumPin0.setVisible(true);
	botonAumPin0.setBounds(textArea_ciclista0.getWidth()+textArea_ciclista0.getX(), botonDisPin0.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPin0);
	
	JButton botonDisPla0 = new JButton();
	botonDisPla0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajaplato 0");
		}
	});
	botonDisPla0.setText("Plato -");
	botonDisPla0.setVisible(true);
	botonDisPla0.setBounds(botonDisCad0.getWidth()+botonDisCad0.getX(),  textArea_ciclista0.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPla0);
	
	JButton botonAumPla0 = new JButton();
	botonAumPla0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subeplato 0");
		}
	});
	botonAumPla0.setText("Plato +");
	botonAumPla0.setVisible(true);
	botonAumPla0.setBounds(botonAumCad0.getWidth()+botonAumCad0.getX(),botonAumCad0.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPla0);
	
	JButton botonFrenaPoco0 = new JButton();
	botonFrenaPoco0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 0 1");
		}
	});
	botonFrenaPoco0.setText("Frenar -");
	botonFrenaPoco0.setVisible(true);
	botonFrenaPoco0.setBounds(botonDisPin0.getWidth()+botonDisPin0.getX(), botonDisPin0.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaPoco0);
	
	JButton botonFrenaMas0 = new JButton();
	botonFrenaMas0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 0 1");
		}
	});
	botonFrenaMas0.setText("Frenar +");
	botonFrenaMas0.setVisible(true);
	botonFrenaMas0.setBounds(botonAumPin0.getWidth()+botonAumPin0.getX(), botonAumPin0.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaMas0);
	
	textArea_ciclista1 = new JTextArea();
	textArea_ciclista1.setBounds(textArea_ciclista0.getWidth()+2*Constantes.ANCHO_BOTON, textArea_ciclista0.getY(), Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista1);
	
	JButton botonDisCad1 = new JButton();
	botonDisCad1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 1 -");
		}
	});
	botonDisCad1.setText("Caden-");
	botonDisCad1.setVisible(true);
	botonDisCad1.setBounds(textArea_ciclista1.getWidth()+textArea_ciclista1.getX(), textArea_ciclista1.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisCad1);
	
	JButton botonAumCad1 = new JButton();
	botonAumCad1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 1 +");
		}
	});
	botonAumCad1.setText("Caden+");
	botonAumCad1.setVisible(true);
	botonAumCad1.setBounds(textArea_ciclista1.getWidth()+textArea_ciclista1.getX(), botonDisCad1.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumCad1);
	
	
	JButton botonDisPin1 = new JButton();
	botonDisPin1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajapinon 1");
		}
	});
	botonDisPin1.setText("Piñon -");
	botonDisPin1.setVisible(true);
	botonDisPin1.setBounds(textArea_ciclista1.getWidth()+textArea_ciclista1.getX(), botonAumCad1.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPin1);
	
	JButton botonAumPin1 = new JButton();
	botonAumPin1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subepinon 1");
		}
	});
	botonAumPin1.setText("Piñon +");
	botonAumPin1.setVisible(true);
	botonAumPin1.setBounds(textArea_ciclista1.getWidth()+textArea_ciclista1.getX(), botonDisPin1.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPin1);
	
	JButton botonDisPla1 = new JButton();
	botonDisPla1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajaplato 1");
		}
	});
	botonDisPla1.setText("Plato -");
	botonDisPla1.setVisible(true);
	botonDisPla1.setBounds(botonDisCad1.getWidth()+botonDisCad1.getX(),  textArea_ciclista1.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPla1);
	
	JButton botonAumPla1 = new JButton();
	botonAumPla1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subeplato 1");
		}
	});
	botonAumPla1.setText("Plato +");
	botonAumPla1.setVisible(true);
	botonAumPla1.setBounds(botonAumCad1.getWidth()+botonAumCad1.getX(),botonAumCad1.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPla1);
	
	JButton botonFrenaPoco1 = new JButton();
	botonFrenaPoco1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 1 1");
		}
	});
	botonFrenaPoco1.setText("Frenar -");
	botonFrenaPoco1.setVisible(true);
	botonFrenaPoco1.setBounds(botonDisPin1.getWidth()+botonDisPin1.getX(), botonDisPin1.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaPoco1);
	
	JButton botonFrenaMas1 = new JButton();
	botonFrenaMas1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 1 1");
		}
	});
	botonFrenaMas1.setText("Frenar +");
	botonFrenaMas1.setVisible(true);
	botonFrenaMas1.setBounds(botonAumPin1.getWidth()+botonAumPin1.getX(), botonAumPin1.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaMas1);
	
	textArea_ciclista2 = new JTextArea();
	textArea_ciclista2.setBounds(textArea_ciclista1.getX()+textArea_ciclista1.getWidth()+2*Constantes.ANCHO_BOTON, textArea_ciclista1.getY(), Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista2);
	
	JButton botonDisCad2 = new JButton();
	botonDisCad2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 2 -");
		}
	});
	botonDisCad2.setText("Caden-");
	botonDisCad2.setVisible(true);
	botonDisCad2.setBounds(textArea_ciclista2.getWidth()+textArea_ciclista2.getX(), textArea_ciclista2.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisCad2);
	
	JButton botonAumCad2 = new JButton();
	botonAumCad2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 2 +");
		}
	});
	botonAumCad2.setText("Caden+");
	botonAumCad2.setVisible(true);
	botonAumCad2.setBounds(textArea_ciclista2.getWidth()+textArea_ciclista2.getX(), botonDisCad2.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumCad2);
	
	
	JButton botonDisPin2 = new JButton();
	botonDisPin2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajapinon 2");
		}
	});
	botonDisPin2.setText("Piñon -");
	botonDisPin2.setVisible(true);
	botonDisPin2.setBounds(textArea_ciclista2.getWidth()+textArea_ciclista2.getX(), botonAumCad2.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPin2);
	
	JButton botonAumPin2 = new JButton();
	botonAumPin2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subepinon 2");
		}
	});
	botonAumPin2.setText("Piñon +");
	botonAumPin2.setVisible(true);
	botonAumPin2.setBounds(textArea_ciclista2.getWidth()+textArea_ciclista2.getX(), botonDisPin2.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPin2);
	
	JButton botonDisPla2 = new JButton();
	botonDisPla2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajaplato 2");
		}
	});
	botonDisPla2.setText("Plato -");
	botonDisPla2.setVisible(true);
	botonDisPla2.setBounds(botonDisCad2.getWidth()+botonDisCad2.getX(),  textArea_ciclista2.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPla2);
	
	JButton botonAumPla2 = new JButton();
	botonAumPla2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subeplato 2");
		}
	});
	botonAumPla2.setText("Plato +");
	botonAumPla2.setVisible(true);
	botonAumPla2.setBounds(botonAumCad2.getWidth()+botonAumCad2.getX(),botonAumCad2.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPla2);
	
	JButton botonFrenaPoco2 = new JButton();
	botonFrenaPoco2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 2 2");
		}
	});
	botonFrenaPoco2.setText("Frenar -");
	botonFrenaPoco2.setVisible(true);
	botonFrenaPoco2.setBounds(botonDisPin2.getWidth()+botonDisPin2.getX(), botonDisPin2.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaPoco2);
	
	JButton botonFrenaMas2 = new JButton();
	botonFrenaMas2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 2 2");
		}
	});
	botonFrenaMas2.setText("Frenar +");
	botonFrenaMas2.setVisible(true);
	botonFrenaMas2.setBounds(botonAumPin2.getWidth()+botonAumPin2.getX(), botonAumPin2.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaMas2);
	
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
			    	parser.compruebaComando(tFcomando.getText());
				tFcomando.setText("");
			}
		}
	});
	tFcomando.setBounds(206, 349, 453, 43);
	contentPane.add(tFcomando);
	tFcomando.setColumns(10);
	
	
	
	JLabel lblCiclista = new JLabel("Ciclista0");
	lblCiclista.setBounds(textArea_ciclista0.getX(), 0,Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista);
	
	JLabel lblCiclista_1 = new JLabel("Ciclista1");
	lblCiclista_1.setBounds(textArea_ciclista1.getX(), 0, Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista_1);
	
	JLabel lblCiclista_2 = new JLabel("Ciclista2");
	lblCiclista_2.setBounds(textArea_ciclista2.getX(), 0, Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista_2);
	
	
	
	
	
	JLabel lblCiclista_3 = new JLabel("Ciclista3");
	lblCiclista_3.setBounds(lblCiclista.getX(), textArea_ciclista0.getHeight()+lblCiclista.getHeight()+lblCiclista.getY(), Constantes.ANCHO_BOTON, Constantes.ALTO_BOTON);
	contentPane.add(lblCiclista_3);
	
	textArea_ciclista3 = new JTextArea();
	textArea_ciclista3.setBounds(0, textArea_ciclista0.getHeight()+lblCiclista_3.getHeight()*2, Constantes.ANCHO_TEXTBOX,Constantes.ALTO_TEXTBOX );
	contentPane.add(textArea_ciclista3);
	
	JButton botonDisCad3 = new JButton();
	botonDisCad3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 3 -");
		}
	});
	botonDisCad3.setText("Caden-");
	botonDisCad3.setVisible(true);
	botonDisCad3.setBounds(textArea_ciclista3.getWidth()+textArea_ciclista3.getX(), textArea_ciclista3.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisCad3);
	
	JButton botonAumCad3 = new JButton();
	botonAumCad3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 3 +");
		}
	});
	botonAumCad3.setText("Caden+");
	botonAumCad3.setVisible(true);
	botonAumCad3.setBounds(textArea_ciclista3.getWidth()+textArea_ciclista3.getX(), botonDisCad3.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumCad3);
	
	
	JButton botonDisPin3 = new JButton();
	botonDisPin3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajapinon 3");
		}
	});
	botonDisPin3.setText("Piñon -");
	botonDisPin3.setVisible(true);
	botonDisPin3.setBounds(textArea_ciclista3.getWidth()+textArea_ciclista3.getX(), botonAumCad3.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPin3);
	
	JButton botonAumPin3 = new JButton();
	botonAumPin3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subepinon 3");
		}
	});
	botonAumPin3.setText("Piñon +");
	botonAumPin3.setVisible(true);
	botonAumPin3.setBounds(textArea_ciclista3.getWidth()+textArea_ciclista3.getX(), botonDisPin3.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPin3);
	
	JButton botonDisPla3 = new JButton();
	botonDisPla3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajaplato 3");
		}
	});
	botonDisPla3.setText("Plato -");
	botonDisPla3.setVisible(true);
	botonDisPla3.setBounds(botonDisCad3.getWidth()+botonDisCad3.getX(),  textArea_ciclista3.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPla3);
	
	JButton botonAumPla3 = new JButton();
	botonAumPla3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subeplato 3");
		}
	});
	botonAumPla3.setText("Plato +");
	botonAumPla3.setVisible(true);
	botonAumPla3.setBounds(botonAumCad3.getWidth()+botonAumCad3.getX(),botonAumCad3.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPla3);
	
	JButton botonFrenaPoco3 = new JButton();
	botonFrenaPoco3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 3 1");
		}
	});
	botonFrenaPoco3.setText("Frenar -");
	botonFrenaPoco3.setVisible(true);
	botonFrenaPoco3.setBounds(botonDisPin3.getWidth()+botonDisPin3.getX(), botonDisPin3.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaPoco3);
	
	JButton botonFrenaMas3 = new JButton();
	botonFrenaMas3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 3 1");
		}
	});
	botonFrenaMas3.setText("Frenar +");
	botonFrenaMas3.setVisible(true);
	botonFrenaMas3.setBounds(botonAumPin3.getWidth()+botonAumPin3.getX(), botonAumPin3.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaMas3);
	
	textArea_ciclista5 = new JTextArea();
	textArea_ciclista5.setBounds(592, 166, 278, 100);
	contentPane.add(textArea_ciclista5);
	
	JLabel lblCiclista_5 = new JLabel("Ciclista5");
	lblCiclista_5.setBounds(592, 139, 70, 15);
	contentPane.add(lblCiclista_5);
	
	textArea_ciclista4 = new JTextArea();
	textArea_ciclista4.setBounds(textArea_ciclista3.getWidth()+2*Constantes.ANCHO_BOTON, textArea_ciclista3.getY(), Constantes.ANCHO_TEXTBOX, Constantes.ALTO_TEXTBOX);
	contentPane.add(textArea_ciclista4);
	
	JButton botonDisCad4 = new JButton();
	botonDisCad4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 4 -");
		}
	});
	botonDisCad4.setText("Caden-");
	botonDisCad4.setVisible(true);
	botonDisCad4.setBounds(textArea_ciclista4.getWidth()+textArea_ciclista4.getX(), textArea_ciclista4.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisCad4);
	
	JButton botonAumCad4 = new JButton();
	botonAumCad4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("asignacadencia 4 +");
		}
	});
	botonAumCad4.setText("Caden+");
	botonAumCad4.setVisible(true);
	botonAumCad4.setBounds(textArea_ciclista4.getWidth()+textArea_ciclista4.getX(), botonDisCad4.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumCad4);
	
	
	JButton botonDisPin4 = new JButton();
	botonDisPin4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajapinon 4");
		}
	});
	botonDisPin4.setText("Piñon -");
	botonDisPin4.setVisible(true);
	botonDisPin4.setBounds(textArea_ciclista4.getWidth()+textArea_ciclista4.getX(), botonAumCad4.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPin4);
	
	JButton botonAumPin4 = new JButton();
	botonAumPin4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subepinon 4");
		}
	});
	botonAumPin4.setText("Piñon +");
	botonAumPin4.setVisible(true);
	botonAumPin4.setBounds(textArea_ciclista4.getWidth()+textArea_ciclista4.getX(), botonDisPin4.getY()+Constantes.ALTO_BOTON, Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPin4);
	
	JButton botonDisPla4 = new JButton();
	botonDisPla4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("bajaplato 4");
		}
	});
	botonDisPla4.setText("Plato -");
	botonDisPla4.setVisible(true);
	botonDisPla4.setBounds(botonDisCad4.getWidth()+botonDisCad4.getX(),  textArea_ciclista4.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonDisPla4);
	
	JButton botonAumPla4 = new JButton();
	botonAumPla4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("subeplato 4");
		}
	});
	botonAumPla4.setText("Plato +");
	botonAumPla4.setVisible(true);
	botonAumPla4.setBounds(botonAumCad4.getWidth()+botonAumCad4.getX(),botonAumCad4.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonAumPla4);
	
	JButton botonFrenaPoco4 = new JButton();
	botonFrenaPoco4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 4 4");
		}
	});
	botonFrenaPoco4.setText("Frenar -");
	botonFrenaPoco4.setVisible(true);
	botonFrenaPoco4.setBounds(botonDisPin4.getWidth()+botonDisPin4.getX(), botonDisPin4.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaPoco4);
	
	JButton botonFrenaMas4 = new JButton();
	botonFrenaMas4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    parser.compruebaComando("frenar 4 4");
		}
	});
	botonFrenaMas4.setText("Frenar +");
	botonFrenaMas4.setVisible(true);
	botonFrenaMas4.setBounds(botonAumPin4.getWidth()+botonAumPin4.getX(), botonAumPin4.getY(), Constantes.ANCHO_BOTON,Constantes.ALTO_BOTON);
	contentPane.add(botonFrenaMas4);
	
	JLabel lblCiclista_4 = new JLabel("Ciclista4");
	lblCiclista_4.setBounds(302, 139, 70, 15);
	contentPane.add(lblCiclista_4);
	
	lblComandos = new JLabel("Comandos");
	lblComandos.setBounds(206, 322, 114, 15);
	contentPane.add(lblComandos);
	
	lblTiempo = new JLabel("Tiempo");
	lblTiempo.setBounds(312, 293, 70, 15);
	contentPane.add(lblTiempo);
	
	JLabel label = new JLabel("Salida");
	label.setBounds(206, 430, 114, 15);
	contentPane.add(label);
	
	tFconsola = new JTextArea();
	tFconsola.setColumns(10);
	tFconsola.setBounds(206, 457, 453, 43);
	contentPane.add(tFconsola);
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
	textArea_ciclista3.setText("");
	textArea_ciclista4.setText("");

	textArea_ciclista5.setText("");
	tFconsola.setText(parser.getInstruccion());
	tFreloj.setText("");

    }
}
