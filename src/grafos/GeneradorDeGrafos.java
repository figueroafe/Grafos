package grafos;


public class GeneradorDeGrafos {

	/**
	 * Generador de grafos aleatorios dados N y el porcentaje de adyacencia
	 * 
	 * @param cantNodos
	 * @param porcAdy
	 * @return
	 * @throws Exception
	 */
	public Grafo generarGrafoAleatorioConPorcentajeDeAdyacencia(int cantNodos, double porcAdy) {

		NodoAdyacencia[] vecNodos;
		NodoAdyacencia nodoAdy;
		boolean grafoCorrecto = false;
		int gradoMax = 0;
		int gradoMin = 100000;
		Grafo grafo;

		int cantAristas = (int) (((porcAdy) * ((cantNodos * (cantNodos - 1)) / 2)) / 100);
		MatrizSimetrica mat = new MatrizSimetrica(cantNodos);

		// Calculo de tamaño para armar el vector de nodos
		int tam = (cantNodos * (cantNodos - 1)) / 2;
		vecNodos = new NodoAdyacencia[tam];

		while (!grafoCorrecto) {

			// Genero aleatoriamente una ponderacion a cada nodo para luego
			// ordenarlo y quedarme con la cantidad que necesito
			int k = 0;
			for (int i = 0; i < cantNodos - 1; i++)
				for (int j = i + 1; j < cantNodos; j++) {
					nodoAdy = new NodoAdyacencia(i, j, Math.random());
					vecNodos[k] = nodoAdy;
					k++;
				}

			// Ordeno por la adyacencia generada
			NodoAdyacencia aux;

			for (int i = 0; i < (tam - 1); i++)
				for (int j = i + 1; j < tam; j++)
					if (vecNodos[i].getAdya() < vecNodos[j].getAdya()) {
						aux = vecNodos[j];
						vecNodos[j] = vecNodos[i];
						vecNodos[i] = aux;
					}

			// Cargo la matriz de adyacencia con la cantidad de nodos que me
			// sirven para cumplir con el % de adyacencia
			for (int i = 0; i < cantAristas; i++)
				mat.setValor(vecNodos[i].getF(), vecNodos[i].getC(), true);

			int[] grados = new int[cantNodos];
			int suma;
			// Calculo los grados de cada nodo
			for (int i = 0; i < cantNodos - 1; i++) {
				suma = 0;
				for (int j = i + 1; j < cantNodos; j++)
					if (mat.getValor(i, j) == true && i != j)
						suma++;
				grados[i] = suma;
			}

			// Calculo de grado maximo y minimo
			for (int j = 0; j < cantNodos - 1; j++) {
				if (grados[j] > gradoMax)
					gradoMax = grados[j];

				if (grados[j] < gradoMin)
					gradoMin = grados[j];
			}

			// Verifico que el grado minimo no sea 0. Si sucede eso, vuelvo
			// a generar porque habria nodos desconectados. No seria conexo
			if (gradoMin != 0)
				grafoCorrecto = true;
			else
				gradoMin = 100000;
		}

		grafo = new Grafo(cantNodos, mat, cantAristas, porcAdy, gradoMax, gradoMin);

		return grafo;

	}

	/**
	 * Generador de grafos regulares dados N y el grado.
	 * 
	 * @param cantNodos
	 * @param grado
	 * @return
	 * @throws GrafoInvalidoException
	 */
	public Grafo generarGrafoRegularGradoN(int cantNodos, int grado) {

		MatrizSimetrica mat = new MatrizSimetrica(cantNodos);
		int adyacencia = 0;
		int cantAristas = 0;
		int salto_max = (grado / 2) - 1;
		int i = 0;
		int j = 1;
		int salto = 0;

		while (salto <= salto_max) {
			while (i < cantNodos) {
				mat.setValor(i, j, true);
				cantAristas++;

				i++;
				j++;
				if (j == cantNodos)
					j = 0;
			}
			salto++;
			j = salto + 1;
			i = 0;
		}

		if (cantNodos % 2 == 0 && (grado % 2 != 0 || grado == 1)) {
			j = cantNodos / 2;
			cantAristas += j;
			for (i = 0; i <= cantNodos / 2; i++) {
				mat.setValor(i, j, true);
				j++;

			}
		}

		adyacencia = (cantAristas * 100) / (cantNodos * (cantNodos - 1) / 2);

		Grafo grafo = new Grafo(cantNodos, mat, cantAristas, adyacencia, 0, 0);
		return grafo;
	}

	/**
	 * Generador de grafos regulares dados N y el porcentaje de adyacencia.
	 * 
	 * @param cantNodos
	 * @param porAdy
	 * @return
	 */
	public Grafo generarGrafoRegularConPorcentajeDeAdyacencia(int cantNodos, int porAdy) {

		int cantAristas = (int) (porAdy * ((cantNodos * (cantNodos - 1)) / 2) / 100);
		int grado = cantAristas * 2 / cantNodos;
		MatrizSimetrica mat = new MatrizSimetrica(cantNodos);
		int salto_max = (grado / 2) - 1;
		int i = 0;
		int j = 1;
		int salto = 0;

		if (cantNodos % 2 != 0 && grado % 2 != 0)
			grado = grado - 1;

		while (salto <= salto_max) {
			while (i < cantNodos) {
				mat.setValor(i, j, true);
				i++;
				j++;
				if (j == cantNodos)
					j = 0;
			}
			salto++;
			j = salto + 1;
			i = 0;
		}

		if (cantNodos % 2 == 0 && (grado % 2 != 0 || grado == 1)) {
			j = cantNodos / 2;
			for (i = 0; i <= cantNodos / 2; i++) {
				mat.setValor(i, j, true);
				j++;
			}
		}

		return new Grafo(cantNodos, mat, cantAristas, porAdy, 0, 0);

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
		return new Grafo(cantNodos, matriz, cantAristas, (cantAristas * 100) / ((cantNodos * (cantNodos - 1)) / 2), 0, 0);
	}

	/**
	 * Generador de grafos aleatorios dados N y una probabilidad para cada arista.
	 * 
	 * @param cantNodos
	 * @param probabilidad
	 * @return
	 * @throws GrafoNoConexoException
	 */
	public Grafo generadorGrafoAleatorioConProbabilidadEnArista(int cantNodos, double probabilidad) {

		int cantAristas = 0;
		boolean grafoCorrecto = false;
		int gradoMax = 0;
		int gradoMin = 100000;
		int[] grados = new int[cantNodos];
		int suma = 0;
		int adyacencia = 0;
		MatrizSimetrica mat = new MatrizSimetrica(cantNodos);

		while (!grafoCorrecto) {
			// Cargo aleatoriamente
			for (int i = 0; i < cantNodos - 1; i++)
				for (int j = i + 1; j < cantNodos; j++)
					if (Math.random() < probabilidad) {
						mat.setValor(i, j, true);
						cantAristas++;
					}

			// Calculo de grados de cada nodo
			for (int i = 0; i < cantNodos - 1; i++) {
				suma = 0;
				for (int j = i + 1; j < cantNodos; j++)
					if (mat.getValor(i, j) == true && i != j)
						suma++;
				grados[i] = suma;
			}

			// Calculo de variables del grafo
			adyacencia = ((cantAristas * 100) / (cantNodos * (cantNodos - 1) / 2));

			// Calculo de grado maximo y minimo
			for (int j = 0; j < cantNodos - 1; j++) {
				if (grados[j] > gradoMax)
					gradoMax = grados[j];
				if (grados[j] < gradoMin)
					gradoMin = grados[j];
			}

			// Verifico que el grado minimo no sea 0. Si sucede eso, vuelvo
			// a generar porque habria nodos desconectados.
			if (gradoMin != 0)
				grafoCorrecto = true;
			else {
				gradoMin = 100000;
				cantAristas = 0;
			}
		}

		return new Grafo(cantNodos, mat, cantAristas, adyacencia, gradoMin, gradoMax);
	}
}
