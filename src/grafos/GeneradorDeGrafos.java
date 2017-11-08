package grafos;

import java.util.Random;

public class GeneradorDeGrafos {

	/**
	 * Generador de grafos aleatorios dados N y una probabilidad para cada
	 * arista.
	 * 
	 * @param cantNodos
	 * @param probabilidad
	 * @return
	 * @throws GrafoNoConexoException
	 */
	public Grafo generadorGrafoAleatorioConProbabilidadEnArista(int cantNodos,
			double probabilidad) throws Exception {
		Random random = new Random();
		MatrizSimetrica mat = new MatrizSimetrica(cantNodos);
		int maxAristas = mat.getDimension();
		int cantAristas = 0;

		for (int i = 0; i < maxAristas; i++) {
			double porc = random.nextDouble();
			if (porc < probabilidad) {
				mat.setValor(i, true);
				cantAristas++;
			} else
				mat.setValor(i, false);
		}

		double porcAdyReal = (cantAristas * 100) / maxAristas;
		Grafo grafo = new Grafo(cantNodos, mat, cantAristas, porcAdyReal);
		if (grafo.esConexo())
			return grafo;
		else
			throw new Exception("Grafo no conexo");
	}

	/**
	 * Generador de grafos aleatorios dados N y el porcentaje de adyacencia
	 * 
	 * @param cantNodos
	 * @param porcAdy
	 * @return
	 * @throws Exception
	 */
	public Grafo generarGrafoAleatorioConPorcentajeDeAdyacencia(int cantNodos,
			double porcAdy) throws Exception {
		Random random = new Random();
		MatrizSimetrica mat = new MatrizSimetrica(cantNodos);
		int rand;
		int maxAristas = (cantNodos * (cantNodos - 1)) / 2;
		Double aux = (porcAdy * mat.getDimension()) / 100;
		int cantAristas = (int) Math.round(aux);
		System.out.println(maxAristas + "\t" + cantAristas);
		for (int i = 0; i < cantAristas; i++) {
			rand = random.nextInt(maxAristas);
			if (mat.getValor(rand) == true)
				i--;
			else
				mat.setValor(rand, true);
		}
		double porcAdyReal = (cantAristas * 100) / maxAristas;
		Grafo grafo = new Grafo(cantNodos, mat, cantAristas, porcAdyReal);
		if (grafo.esConexo())
			return grafo;
		else
			throw new Exception("Grafo no conexo");

	}

	/**
	 * Generador de grafos regulares dados N y el grado.
	 * 
	 * @param cantNodos
	 * @param grado
	 * @return
	 * @throws GrafoInvalidoException
	 */
	public Grafo generarGrafoRegularGradoN(int cantNodos, int grado)
			throws Exception {
		if (grado >= cantNodos || cantNodos <= 0 || grado < 0)
			throw new Exception("Grafo invalido");
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		int cantAristas = 0;

		if (cantNodos % 2 == 0) { // par
			if (grado % 2 == 1) {
				int saltoImpar = (cantNodos / 2);
				for (int i = 0; i < cantNodos / 2; i++) {
					matriz.setValor(i, i + saltoImpar, true);
					cantAristas++;
				}
			}
			int saltoNodo = 1;
			for (int g = 0; g < grado / 2; g++) {
				for (int i = 0; i < cantNodos; i++) {
					matriz.setValor(i, (i + saltoNodo) % 6, true);
					cantAristas++;
				}
				saltoNodo++;
			}
		} else { // impar
			if (grado % 2 == 1)
				throw new Exception("Grafo invalido");
		}
		Grafo grafo = new Grafo(cantNodos, matriz, cantAristas,
				(cantAristas * 100) / ((cantNodos * (cantNodos - 1)) / 2));
		return grafo;
	}

	/**
	 * Generador de grafos regulares dados N y el porcentaje de adyacencia.
	 * 
	 * @param cantNodos
	 * @param porAdy
	 * @return
	 */
	public Grafo generarGrafoRegularConPorcentajeDeAdyacencia(int cantNodos,
			int porAdy) {
		int grado = (porAdy * (cantNodos - 1)) / 100;
		if (cantNodos < 1 || grado < 0 || grado >= cantNodos
				|| (cantNodos != 1 && grado == 0)
				|| (cantNodos != 2 && grado == 1)
				|| (cantNodos % 2 != 0 && grado % 2 != 0)) {
			System.out.println("no se puede generar el grafo");
			return null;
		}

		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);

		// Camino externo.
		for (int x = 0; x < cantNodos - 1; x++)
			matriz.setValor(x, x + 1, true);
		if (cantNodos > 2) { // Si hay un nodo no necesita aristas. Si hay dos,
								// la unica arista la completa en el for
								// anterior.
			matriz.setValor(0, cantNodos - 1, true);
			grado -= 2; // Coloco todas las aristas entre grafos consecutivos,
						// entonces cada nodo ya tiene 2 aristas.
			// Cruz.
			if (grado % 2 != 0) {
				for (int x = 0; x < cantNodos / 2; x++)
					matriz.setValor(x, x + (cantNodos / 2), true);
				grado--;
			}
			// Salteando.
			int cantVeces = grado / 2;
			int saltear = 2;
			for (int x = 0; x < cantVeces; x++) {
				for (int nodoActual = 0; nodoActual < cantNodos; nodoActual++) {
					int aux = nodoActual + saltear;
					if (aux > cantNodos - 1)
						aux -= cantNodos;
					matriz.setValor(nodoActual, aux, true);
				}
				saltear++;
			}
		}
		return new Grafo(cantNodos, matriz, (cantNodos * grado) / 2, porAdy);
	}

	/**
	 * Generador de grafos n-partitos, dados N y n.
	 * 
	 * @param cantNodos
	 * @param n
	 * @return
	 * @throws GrafoInvalidoException
	 */
	public Grafo generarGrafoNPartito(int cantNodos, int n) throws Exception {
		if (cantNodos % n != 0)
			throw new Exception("Grafo invalido");

		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		final int aristasContiguas = (cantNodos / n) - 1;
		int aux = aristasContiguas;
		int cantAristas = 0;
		for (int i = 0; i < cantNodos; i++) {
			if (aux > 0) {
				matriz.setValor(i, i + 1, true);
				cantAristas++;
				aux--;
			} else
				aux = aristasContiguas;
		}
		return new Grafo(cantNodos, matriz, cantAristas, (cantAristas * 100)
				/ ((cantNodos * (cantNodos - 1)) / 2));
	}
}
