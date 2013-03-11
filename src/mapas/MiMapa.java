package mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import entradaDeDatos.EntradaFichero;
/**
 * 
 * Esta clase genera el circuito de la práctica , mediante un tipo Mapa de Java.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */
public class MiMapa <T,E>
{
    
    Map<T,E> mapa;
    EntradaFichero fichero;
    List <T> lista;
    /**
    * constructor de MiMapa, el cual genera un mapa dado un StringTokenizer
    * @param tokens
    */
    public MiMapa(StringTokenizer tokens)
    {
      
        
        lista = new ArrayList<T>();
        Map<T,E> mapa = new HashMap<T,E>();
        int i = 0;
        T clave = null;
        int j = 0;
        while(tokens.hasMoreTokens())
        {
            if(i % 2 == 0)
            {
        	clave = (T) tokens.nextToken();
            
            }
            if(i%2 == 1)
            {
                
                mapa.put(clave, (E) tokens.nextToken());
                lista.add(j,clave);
                
                j++;
            }
        
        
            i++;
        }


    }
    /**
    * se devuelve el mapa
    * @return
    */
    public Map<T, E> getMapa()
    {
	return mapa;

    }
    /**dada una clave, se devuelve la informacion oportuna
    *
    * @param ele
    * @return
    */
    public E getElemento(int ele)
    {
        return (E) lista.get(ele);
        
    }
   
    
}