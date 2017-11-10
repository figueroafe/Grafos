package testGrafo;

import grafos.GeneradorDeGrafos;
import grafos.Grafo;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class test1000Corridas {
	
	
//	@Test
	public void ejecutarCasosDePruebaAl40PorcientoColoreoSecuencial() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		int nroCromatico=0;
		GeneradorDeGrafos generador = new GeneradorDeGrafos();
		Grafo grafo;
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/40_porciento_adyacencia_Secuencial.out"));		
		for(int i=0; i < 10000; i++) {

			
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 40)
					.grabarGrafoIN("IN/NoRegular/40_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/40_porciento_adyacencia.in");
			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Secuencial al 40% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		
		salida.close();
	}
	
//	@Test
	public void ejecutarCasosDePruebaAl60PorcientoColoreoSecuencial() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/60_porciento_adyacencia_Secuencial.out"));		
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 60)
					.grabarGrafoIN("IN/NoRegular/60_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/60_porciento_adyacencia.in");
			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("10000 corridas Algoritmo Secuencial al 60% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

//	@Test
	public void ejecutarCasosDePruebaAl90PorcientoColoreoSecuencial() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/90_porciento_adyacencia_Secuencial.out"));		
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 90)
					.grabarGrafoIN("IN/NoRegular/90_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/90_porciento_adyacencia.in");
			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Secuencial al 90% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	
	/**
	 * 
	 * 
	 * 
	 * Algoritmo Matula
	 * 
	 * 
	 */
	
	@Test
	public void ejecutarCasosDePruebaAl40PorcientoColoreoMatula() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		int nroCromatico=0;
		GeneradorDeGrafos  generador = new GeneradorDeGrafos();

		Grafo grafo;
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/40_porciento_adyacencia_Matula.out"));		
		for(int i=0; i < 10000; i++) {

//			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 40)
//					.grabarGrafoIN("IN/NoRegular/40_porciento_adyacencia.in");
			grafo = generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 40);
			
//			grafo = new Grafo("IN/NoRegular/40_porciento_adyacencia.in");
			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
			System.out.println("CORRIDA: "+i);
		}
		
		System.out.println("1000 corridas Algoritmo Matula al 40% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		
		salida.close();
	}
	
//	@Test
	public void ejecutarCasosDePruebaAl60PorcientoColoreoMatula() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/60_porciento_adyacencia_Matula.out"));		
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 60)
					.grabarGrafoIN("IN/NoRegular/60_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/60_porciento_adyacencia.in");
			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Matula al 60% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl90PorcientoColoreoMatula() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/90_porciento_adyacencia_Matula.out"));		
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 90)
					.grabarGrafoIN("IN/NoRegular/90_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/90_porciento_adyacencia.in");
			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Matula al 90% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	/**
	 * 
	 * 
	 * 
	 * Algoritmo Well-Powell
	 * 
	 * 
	 */
	
//	@Test
	public void ejecutarCasosDePruebaAl40PorcientoColoreoWellPowell() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/40_porciento_adyacencia_Well-Powell.out"));		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 40)
					.grabarGrafoIN("IN/NoRegular/40_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/40_porciento_adyacencia.in");
			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Well-Powell al 40% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		
		salida.close();
	}
	
	//@Test
	public void ejecutarCasosDePruebaAl60PorcientoColoreoWellPowell() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/60_porciento_adyacencia_Well-Powell.out"));		
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 60)
					.grabarGrafoIN("IN/NoRegular/60_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/60_porciento_adyacencia.in");
			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Matula al 60% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl90PorcientoColoreoWellPowell() throws Exception{
				
		Map<Integer,Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/90_porciento_adyacencia_Well-Powell.out"));		
		int nroCromatico=0;
		GeneradorDeGrafos generador;
		Grafo grafo;
		
		for(int i=0; i < 10000; i++) {

			generador = new GeneradorDeGrafos();
			generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 90)
					.grabarGrafoIN("IN/NoRegular/90_porciento_adyacencia.in");

			grafo = new Grafo("IN/NoRegular/90_porciento_adyacencia.in");
			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();
			
			
			if(frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores())+1 );
			else
				frecuencias.put(grafo.getCantColores(), 1 );
		}
		
		System.out.println("1000 corridas Algoritmo Well-Powell al 90% de adyacencia");
		for(Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			System.out.println("Cantidad colores: "+key + " " + "Frecuencia: "+frecuencias.get(key)/10000.);
			if( key < nroCromatico)
				nroCromatico = key; 
		}
		salida.println("Numero Cromatico: "+nroCromatico);
		System.out.println("Numero Cromatico: "+nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

}
