package ui;

import interfaceMain.InterfaceEjecuta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class Ventana extends JFrame implements InterfaceEjecuta{

    private JPanel contentPane;
    private JTextField tFreloj;
    private JTextField tFcomando;
    private String cadena;
    JTextArea textArea_0;
    JTextArea textArea_1;
    JTextArea textArea_2;
    JTextArea textArea_3;
    JTextArea textArea_4;
    JTextArea textArea_5;
    private JLabel lblComandos;
    private JLabel lblTiempo;

    /**
     * Create the frame.
     */
    public Ventana() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 865, 558);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textArea_0 = new JTextArea();
	textArea_0.setBounds(12, 29, 278, 98);
	contentPane.add(textArea_0);
	
	textArea_1 = new JTextArea();
	textArea_1.setBounds(302, 29, 278, 98);
	contentPane.add(textArea_1);
	
	tFreloj = new JTextField();
	tFreloj.setEditable(false);
	tFreloj.setBounds(400, 291, 114, 19);
	contentPane.add(tFreloj);
	tFreloj.setColumns(10);
	cadena = "";
	tFcomando = new JTextField();
	tFcomando.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == 10)
		    {
			cadena = tFcomando.getText();
			tFcomando.setText("");
		    }
		}
	});
	tFcomando.setBounds(206, 349, 453, 43);
	contentPane.add(tFcomando);
	tFcomando.setColumns(10);
	
	textArea_2 = new JTextArea();
	textArea_2.setBounds(592, 29, 278, 98);
	contentPane.add(textArea_2);
	
	JLabel lblCiclista = new JLabel("Ciclista0");
	lblCiclista.setBounds(12, 2, 70, 15);
	contentPane.add(lblCiclista);
	
	JLabel lblCiclista_1 = new JLabel("Ciclista1");
	lblCiclista_1.setBounds(302, 2, 70, 15);
	contentPane.add(lblCiclista_1);
	
	JLabel lblCiclista_2 = new JLabel("Ciclista2");
	lblCiclista_2.setBounds(592, 2, 70, 15);
	contentPane.add(lblCiclista_2);
	
	textArea_5 = new JTextArea();
	textArea_5.setBounds(592, 166, 278, 98);
	contentPane.add(textArea_5);
	
	JLabel lblCiclista_5 = new JLabel("Ciclista5");
	lblCiclista_5.setBounds(592, 139, 70, 15);
	contentPane.add(lblCiclista_5);
	
	textArea_4 = new JTextArea();
	textArea_4.setBounds(302, 166, 278, 98);
	contentPane.add(textArea_4);
	
	JLabel lblCiclista_4 = new JLabel("Ciclista4");
	lblCiclista_4.setBounds(302, 139, 70, 15);
	contentPane.add(lblCiclista_4);
	
	textArea_3 = new JTextArea();
	textArea_3.setBounds(12, 166, 278, 98);
	contentPane.add(textArea_3);
	
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
    public void ponTextoEnTextArea(int id,String mensaje)
    {
	switch(id)
	{
	case 0:textArea_0.setText(textArea_0.getText()+"\n"+mensaje);
		break;
	case 1:textArea_1.setText(textArea_1.getText()+"\n"+mensaje);
		break;
	case 2:textArea_2.setText(textArea_2.getText()+"\n"+mensaje);
	break;
	case 3:textArea_3.setText(textArea_3.getText()+"\n"+mensaje);
	break;
	case 4:textArea_4.setText(textArea_4.getText()+"\n"+mensaje);
	break;
	case 5:textArea_5.setText(textArea_5.getText()+"\n"+mensaje);
	break;
	case 6:tFreloj.setText(mensaje);
	break;
	
	}
    }
   public String dameInstruccion()
   {
       String miInstruccion = "";
       miInstruccion = cadena;
       cadena = "";
       return miInstruccion;
   }
@Override
public void ejecuta() {
    // TODO Auto-generated method stub
    textArea_0.setText("");
    textArea_1.setText("");
    textArea_2.setText("");
    textArea_3.setText("");
    textArea_4.setText("");
    textArea_5.setText("");
    tFreloj.setText("");
}
}
