
package comandos;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import persona.Ciclista;

import vista.Ventana;
import entradaDeDatos.SuperLectura;

/**
 * 
 * Esta clase convierte los strings que se le introduce como mensaje en órdenes
 * que el sistema pueda entender.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Parser 
{
   
    ArrayList<InterfazCommand> array ;
    private String num_ciclista;
    private InterfazCommand instruccion;
    String cadena;
    StringTokenizer comandosYatributos;
    String comandoElegido;
    Vector<Object> vector;
    public Parser(Vector<Object> mivector)
    {
	instruccion = new ComandoNinguno();
	vector = mivector;
	array = new ArrayList<InterfazCommand>();
	
	
	array.add(new ComandoAsignaCadencia(null,0));
	array.add(new ComandoAyuda());
	array.add(new ComandoBajaPinon(null));
	array.add(new ComandoBajaPlato(null));
	array.add(new ComandoDesconocido());
	array.add(new ComandoFrenar(null,0,0));
	array.add(new ComandoIncompleto());
	array.add(new ComandoNinguno());
	array.add(new ComandoSubePinon(null));
	array.add(new ComandoSubePlato(null));
	
	
    }
   
    /**
     * Este metodo, formatea una entrada en ordenes capaces de ser
     * entendidas El formato de los comandos es el siguiente: comando parametro
     * donde comando es una instruccion creada en el sistema y el parametro se
     * refiere al numero de ciclista al que va destinada esa orden
     * 
     * @param comando
     * @return
     */
    public InterfazCommand compruebaComando(String cadena) 
    {
	
	comandosYatributos = new StringTokenizer(cadena, "\n\r ");
	
	if(existeCommand())
	{
	    
	    asignaAtributos(comandoElegido,comandosYatributos);
	}
	else
	{
	    asignaAtributos("desconocido",comandosYatributos);
	}
	
	
	return null;
	
    }
    public boolean existeCommand()
    {
	
	
	Iterator<InterfazCommand> it  = array.iterator();
	String comando = "";
	boolean encontrado = false;
	//cogemos el primer token que deberia corresponder al comando
	if(comandosYatributos.hasMoreTokens())
	{
	    comando = comandosYatributos.nextToken();
	}
	while(it.hasNext() && !encontrado)
	{
	   InterfazCommand comand = (InterfazCommand) it.next();
	   
	   if(comand.parse(comando))
	   {
	       comandoElegido = comando;
	       encontrado = true;
	   }
	   
	  
	}
	return encontrado;
    }

    public void asignaAtributos(String comando,StringTokenizer args)
    {
	
	switch(comando)
	{
	    case "asignacadencia":
		
        	 if(args.countTokens() != 2)
        	 {
        	    instruccion = new ComandoIncompleto();		    
        	 }
        	 else
        	 {
        	    	
        	    int numciclista = Integer.parseInt(args.nextToken());
        	    String auxpar1 = args.nextToken();
        	    
        	    double param1= 0;
        	   
        	    if(auxpar1.equalsIgnoreCase("+"))
        	    {
        		auxpar1 = ((Ciclista)vector.elementAt(numciclista)).getCadencia();
        		param1 = Double.parseDouble(auxpar1) + 1;
        		
        		//par1 = Integer.parseInt(((Ciclista)vector.elementAt(numciclista)).getCadencia()) + 1;
        	    }
        	    else if(auxpar1.equalsIgnoreCase("-"))
        	    {
        		auxpar1 = ((Ciclista)vector.elementAt(numciclista)).getCadencia();
        		param1 = Double.parseDouble(auxpar1) - 1;
        		
        	    }
        	    else
        	    {
        		param1= Double.parseDouble(auxpar1);
        	    }
        	    instruccion = new ComandoAsignaCadencia((Ciclista) vector.elementAt(numciclista),(int)param1);
        		
        	 }
        	 instruccion.execute();
        	 break;
	    
	    case "ayuda":
		
        	 if(args.countTokens() != 0)
        	 {
        	     instruccion = new ComandoIncompleto();		    
        	 }
        	 else
        	 {
        	     instruccion = new ComandoAyuda();
        	 }
        	 instruccion.execute();
        	    
        	 break;
	    
	    case "bajapinon":
		
		if(args.countTokens() != 1)
    		{
    		    instruccion = new ComandoIncompleto();		    
    		}
    		else
    		{
    			
    		    int numciclista = Integer.parseInt(args.nextToken());
    		    instruccion = new ComandoBajaPinon((Ciclista) vector.elementAt(numciclista));
    			
    		}
    		instruccion.execute();
    		
    		break;
    		
	    case "bajaplato":
		
		if(args.countTokens() != 1)
		{
		    instruccion = new ComandoIncompleto();		    
		}
		else
		{
			
		    int numciclista = Integer.parseInt(args.nextToken());
		    instruccion = new ComandoBajaPlato((Ciclista) vector.elementAt(numciclista));
			
		}
		instruccion.execute();
		
		break;	
		
	    case "desconocido":
		
		instruccion = new ComandoDesconocido();
			
		
		instruccion.execute();
		
		break;
		
	    case "frenar":
		
		if(args.countTokens() != 3)
		{
		    instruccion = new ComandoIncompleto();		    
		}
		else
		{
			
		    int numciclista = Integer.parseInt(args.nextToken());
		    int par1 = Integer.parseInt(args.nextToken());
		    int par2 = Integer.parseInt(args.nextToken());
		    instruccion = new ComandoFrenar((Ciclista) vector.elementAt(numciclista),par1,par2);
			
		}
		instruccion.execute();
		
		break;
		
	    case "incompleto":
		
		instruccion = new ComandoIncompleto();
			
		
		instruccion.execute();
		
		break;
		
	    case "ninguno":
		
		instruccion = new ComandoNinguno();
			
		
		instruccion.execute();
		
		break;
		
	    case "subepinon":
		
		if(args.countTokens() != 1)
		{
		    instruccion = new ComandoIncompleto();		    
		}
		else
		{
			
		    int numciclista = Integer.parseInt(args.nextToken());
		    instruccion = new ComandoSubePinon((Ciclista) vector.elementAt(numciclista));
			
		}
		instruccion.execute();
		
		break;
		
	    case "subeplato":
		
		if(args.countTokens() != 1)
		{
		    instruccion = new ComandoIncompleto();		    
		}
		else
		{
			
		    int numciclista = Integer.parseInt(args.nextToken());
		    instruccion = new ComandoSubePlato((Ciclista) vector.elementAt(numciclista));
			
		}
		instruccion.execute();
		
		break;	    
	}

    }
    public String getInstruccion() {
	
	return instruccion.getInformacionInstruccion();
	
    }
}