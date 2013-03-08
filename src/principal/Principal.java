package principal;

//import operacionesConFicheros.*;
import interfaceMain.InterfaceEjecuta;
import interfaceMain.InterfaceSalida;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persona.Ciclista;
import salidaDeDatos.SalidaDeDatos;
import tiempo.Reloj;
import bicicleta.Bicicleta;
import java.util.*;

import mapas.MiMapa;
import comandos.InterfazInstruccion;
/*
import comandos.Comandos;
import comandos.InterfazOrden;*/
import comandos.Parser;

import entradaDeDatos.EntradaTeclado;
import entradaDeDatos.EntradaFichero;
import entradaDeDatos.SuperLectura;
import factoresExternos.*;

/**
* Clase Principal del programa
*
* @author Juan Carlos Marco, Juan Luis Perez, Emilio Álvarez Piñeiro 
*
*/

public class Principal {

    private ArrayList<Object> listaejecuta;
    private ArrayList<Object> listasalida;
    private Parser Parsercomandos;
    private Vector<Object> vectorobjetos;
    InterfaceEjecuta parser;
    // SalidaDeDatos salida;

    public static void main(String args[])
    {

        Principal p = new Principal();
        p.inicia();
        p.ejecuta();
        p.finaliza();

    }

    public void inicia()
    {
        listaejecuta = new ArrayList<Object>();
        listasalida = new ArrayList<Object>();
        vectorobjetos = new Vector<Object>();
        int dientesporpinon[] = { 17, 16, 15, 14, 13, 12 };
        int dientesporplato[] = { 36, 40, 44 };
        Bicicleta bici1 = new Bicicleta(dientesporpinon.length,
        dientesporplato.length, 1, dientesporpinon, dientesporplato,
        0.6858);
        Bicicleta bici2 = new Bicicleta(dientesporpinon.length,
                dientesporplato.length, 1, dientesporpinon, dientesporplato,
                0.6858);
        Reloj reloj = new Reloj();
        Ciclista ciclista1 = new Ciclista((Bicicleta) bici1);
        Ciclista ciclista2 = new Ciclista((Bicicleta) bici2);
        vectorobjetos.add(ciclista1);
        vectorobjetos.add(ciclista2);
        
        parser =   new Parser(vectorobjetos);
        //EntradaTeclado entrada = new EntradaTeclado();
        //InterfaceEjecuta carretera1 = new Carretera("carretera.txt",bici1);
        //Parser comandos = new Parser();
        //InterfaceEjecuta parser = new Parser(ciclista1);
        
        listaejecuta.add(ciclista1);
        listaejecuta.add(ciclista2);
        listaejecuta.add(reloj);
        listaejecuta.add(bici1);
        listaejecuta.add(bici2);
        listaejecuta.add(parser);
        //listaejecuta.add(carretera1);
        
        //Parser comandos = new Parser(SuperLectura.CrearLectorPorTeclado());
        
        listasalida.add(reloj);
        listasalida.add(bici1);
        listasalida.add(ciclista1);
        listasalida.add(bici2);
        listasalida.add(ciclista2);

       
        //listaobjetos.add(e)
    }

    public void ejecuta()
    {
        int contador = 0; // Contara los segundos de ejecucion del programa
        int limite = 300; // Se establecera el limite en SEGUNDOS de la ejecucion
        // del programa
        EntradaFichero entrada = new EntradaFichero();
        MiMapa<Double,Double> mapa = new MiMapa<Double,Double>
        (entrada.cargarFicheroEnStringTokenizer("carretera.txt",":;"));
        
        
    
        
        while (contador < limite)
        {
            //System.out.println(mapa.getElemento(0));
            for (Object c : listaejecuta)
            {
        	((InterfaceEjecuta) c).ejecuta();
            }
        
            for (Object c : listasalida)
            {
        	((InterfaceSalida) c).muestra();
            }
            
            contador++;
        }
    }

    public void finaliza()
    {

    }

}