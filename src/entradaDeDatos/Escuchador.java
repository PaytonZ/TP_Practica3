package entradaDeDatos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import comandos.Comandero;

public class Escuchador {

    /**
	 * @uml.property  name="comandero"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Comandero comandero;

    public Escuchador(Comandero micomandero)

    {
	comandero = micomandero;
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

    public void asignaMouseClicked(JButton bt, final String comando) {
	bt.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		comandero.recibir_comando(comando);
	    }
	});
    }

}
