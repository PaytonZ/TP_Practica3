package entradaDeDatos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import comandos.Comandero;
import constantes.Constantes;

public class Escuchador {

    Comandero comandero;

    public Escuchador(Comandero micomandero)

    {
	comandero = micomandero;
    }

    public void asignaMouseClicked(JButton bt, final String comando) {
	bt.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		comandero.recibir_comando(comando);
	    }
	});
    }

    public void asignaKeyPressed(JTextField ta, final String comando) {
	final JTextField tb = ta;
	tb.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
		    comandero.recibir_comando(tb.getText());
		    tb.setText("");
		}
	    }
	});
	ta = tb;
    }

}
