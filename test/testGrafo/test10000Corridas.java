package testGrafo;

import grafos.GeneradorDeGrafos;
import grafos.Grafo;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class test10000Corridas {

	/**
	 * Algoritmo secuencial
	 * 
	 * @throws Exception
	 */
	//@Test
	public void ejecutarCasosDePruebaAl40PorcientoColoreoSecuencial() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/NoRegular/40_porciento_adyacencia.in");
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/40_porciento_adyacencia_Secuencial.out"));

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), i);
			else
				frecuencias.put(grafo.getCantColores(), 1);
			System.out.println("Iteracion: " + i);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 40% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");

		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl60PorcientoColoreoSecuencial() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/60_porciento_adyacencia_Secuencial.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/NoRegular/60_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 60% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl90PorcientoColoreoSecuencial() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/90_porciento_adyacencia_Secuencial.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/NoRegular/90_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 90% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	///@Test
	public void ejecutarCasosDePruebaAl50PorcientoColoreoSecuencialrEGULAR() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/50_porciento_adyacencia_Regular_Secuencial.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/Regular/50_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 90% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	///@Test
	public void ejecutarCasosDePruebaAl75PorcientoColoreoSecuencialrEGULAR() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/75_porciento_adyacencia_Regular_Secuencial.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/Regular/75_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoSecuencial();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 75% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
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

	// @Test
	public void ejecutarCasosDePruebaAl40PorcientoColoreoMatula() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		int nroCromatico = 0;

		Grafo grafo = new Grafo("IN/NoRegular/40_porciento_adyacencia.in");
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/40_porciento_adyacencia_Matula.out"));

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
			System.out.println("CORRIDA: " + i);
		}

		System.out.println("1000 corridas Algoritmo Matula al 40% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");

		salida.close();
	}

//	@Test
	public void ejecutarCasosDePruebaAl60PorcientoColoreoMatula() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/60_porciento_adyacencia_Matula.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/NoRegular/60_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("1000 corridas Algoritmo Matula al 60% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl90PorcientoColoreoMatula() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/90_porciento_adyacencia_Matula.out"));
		int nroCromatico = 0;
		GeneradorDeGrafos generador;
		Grafo grafo = new Grafo("IN/NoRegular/90_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Matula al 90% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	@Test
	public void ejecutarCasosDePruebaAl50PorcientoColoreoMatularEGULAR() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/50_porciento_adyacencia_Regular_Matula.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/Regular/50_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 50% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	///@Test
	public void ejecutarCasosDePruebaAl75PorcientoColoreoMatularEGULAR() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/75_porciento_adyacencia_Regular_Matula.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/Regular/75_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoMatula();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 75% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
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

	//@Test
	public void ejecutarCasosDePruebaAl40PorcientoColoreoWellPowell() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		int nroCromatico = 0;
		GeneradorDeGrafos generador;
		Grafo grafo = new Grafo("IN/NoRegular/40_porciento_adyacencia.in");

		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/40_porciento_adyacencia_Well-Powell.out"));
		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Well-Powell al 40% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");

		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl60PorcientoColoreoWellPowell() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/60_porciento_adyacencia_Well-Powell.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/NoRegular/60_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Matula al 60% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl90PorcientoColoreoWellPowell() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/90_porciento_adyacencia_Well-Powell.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/NoRegular/90_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Well-Powell al 90% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl50PorcientoColoreoWellPowellrEGULAR() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/50_porciento_adyacencia_Regular_Well-Powell.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/Regular/50_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 50% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}

	//@Test
	public void ejecutarCasosDePruebaAl75PorcientoColoreoWellPowellrEGULAR() throws Exception {

		Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
		PrintWriter salida = new PrintWriter(new File("OUT/Casos1000Corridas/75_porciento_adyacencia_Regular_Well-Powell.out"));
		int nroCromatico = 0;
		Grafo grafo = new Grafo("IN/Regular/75_porciento_adyacencia.in");

		for (int i = 0; i < 10000; i++) {

			grafo.AlgoritmoWellPowell();
			nroCromatico = grafo.getCantColores();

			if (frecuencias.containsKey(grafo.getCantColores()))
				frecuencias.put(grafo.getCantColores(), frecuencias.get(grafo.getCantColores()) + 1);
			else
				frecuencias.put(grafo.getCantColores(), 1);
			
			System.out.println("Iteracion: "+i);
		}

		System.out.println("10000 corridas Algoritmo Secuencial al 75% de adyacencia");
		for (Integer key : frecuencias.keySet()) {
			salida.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			System.out.println("Cantidad colores: " + key + "\t\t" + "Iteracion N°: " + frecuencias.get(key));
			if (key < nroCromatico)
				nroCromatico = key;
		}
		salida.println("Numero Cromatico: " + nroCromatico);
		System.out.println("Numero Cromatico: " + nroCromatico);
		System.out.println("FIN\n\n");
		salida.close();
	}
}
