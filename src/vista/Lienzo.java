package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entradaDeDatos.EntradaFichero;


public class Lienzo extends JFrame 
{
    final int FACTORESCALA;
    private JPanel contentPane;
    EntradaFichero entrada;
    double [] matriz;
    /**
     * Launch the application.
     */
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    Lienzo frame = new Lienzo();
                    frame.setVisible(true);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Lienzo()
    {
	FACTORESCALA = 10;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setAutoscrolls(true);
        setBounds(0,0,1300,600);
        entrada = new EntradaFichero();
        matriz = entrada.convertirAArrayFichero("carretera.txt", ":;");
    }
    
    public void paint (Graphics g)
    {
        super.paint(g);
        
        int x = 10;
        int y = 400;

        int i = 0;
        while( x < matriz[matriz.length-3]/FACTORESCALA)
        {
            g.drawLine((int) x, y, ((int)matriz[i+2])/FACTORESCALA, y-(int)matriz[i+1]);
            x = ((int)matriz[i+2])/FACTORESCALA;
            y = y-(int)matriz[i+1];
            i = i +2;
        }
        g.drawLine((int) x, y, (int)matriz[matriz.length-1]/FACTORESCALA, y-(int)matriz[matriz.length-2]);
        
    }
}