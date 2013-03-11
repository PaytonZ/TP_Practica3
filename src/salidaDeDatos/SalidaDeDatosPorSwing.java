package salidaDeDatos;

import java.awt.BorderLayout;

import javax.swing.*;


public class SalidaDeDatosPorSwing {

    
   
    
    public void Prueba(){
	
	//1. Declarar - definir
	 JFrame marco=new JFrame("main");
	    JFrame panel= new JFrame();
	    JButton boton = new JButton("trollebus.");
	    
	    
	    marco.setLayout(new BorderLayout());
	    //2. Añadir componentes	    
	    marco.getLayeredPane().add(boton);
	 
	    
	    //3. Tamaño
	   marco.pack();
	    //4. Poner liseners.
	  
	    //5. poner visible
	    marco.setVisible(true);
	  
    }
    
    public static void main(String[] args) {
	
	new SalidaDeDatosPorSwing().Prueba();
    }

}
