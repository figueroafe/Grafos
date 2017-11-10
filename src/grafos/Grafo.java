package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Grafo {

	private MatrizSimetrica matriz;
	private int cantNodos;
	private int cantAristas;
	private double porcentAdy;
	private int gradoMax;
	private int gradoMin;
	private int cantColores;
	private ArrayList<Nodo> nodos;

	/**
	 * Constructor de la clase a partir de un archivo IN
	 * 
	 * @param path
	 */
	public Grafo(String path) {

		try {
			Scanner sc = new Scanner(new File(path));
			sc.useLocale(Locale.ENGLISH);

			this.cantNodos = sc.nextInt();
			this.cantAristas = sc.nextInt();
			this.porcentAdy = sc.nextDouble();
			this.gradoMax = sc.nextInt();
			this.gradoMin = sc.nextInt();

			this.matriz = new MatrizSimetrica(this.cantNodos);
			// Lleno la matriz simetrica con true en donde hay aristas
			for (int i = 0; i < this.cantAristas; i++) {
				int nodoIni = sc.nextInt();
				int nodoFin = sc.nextInt();

				this.matriz.setValor(nodoIni - 1, nodoFin - 1, true);
			}

			this.nodos = new ArrayList<Nodo>();
			// Recorro la matriz y guardo en nodo el grado de cada nodo
			for (int i = 0; i < matriz.getDimension(); i++) {
				int grado = 0;
				for (int j = 0; j < matriz.getDimension(); j++) {
					if (matriz.getValor(i, j) && i != j) 
						grado++;
				}
				this.nodos.add(new Nodo(i + 1, 0, grado));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor de la calse mediante parametros de nodo, matriz,aristas y
	 * %ady
	 * 
	 * @param cantNodos
	 * @param mat
	 * @param cantAristas
	 * @param porcAdy
	 */
	public Grafo(int cantNodos, MatrizSimetrica mat, int cantAristas,
			double porcAdy) {
		this.cantNodos = cantNodos;
		this.matriz = mat;
		this.cantAristas = cantAristas;
		this.porcentAdy = porcAdy;
		this.nodos = new ArrayList<Nodo>();
		calcularGrados(); // Maximo y minimo
		completarGrados(); // Para todos los nodos
	}

	/**
	 * Obtienen los grados de un grafo
	 */
	public void calcularGrados() {
		this.gradoMax = 1;
		int aux;
		for (int f = 0; f < cantNodos; f++) {
			aux = 0;
			for (int c = 0; c < cantNodos; c++) {
				if (getValor(f, c) == true)
					aux++;
			}
			if (aux > this.gradoMax)
				this.gradoMax = aux;
		}
		this.gradoMax--;
		this.gradoMin = this.gradoMax;
		for (int f = 0; f < cantNodos; f++) {
			aux = 0;
			for (int c = 0; c < cantNodos; c++) {
				if (getValor(f, c) == true)
					aux++;
			}
			if (aux < this.gradoMin)
				this.gradoMin = aux;
		}
		this.gradoMin--;
//		System.out.println("GRADOS: \t" + this.gradoMax + "\t" + this.gradoMin);
	}

	/**
	 * Muestra por pantalla los datos de un grafo
	 */
	public void mostrarGrafo() {
		System.out.println("Cantidad Nodos   " + this.getCantNodos());
		System.out.println("Cantidad Aristas " + this.getCantAristas());
		System.out.println("Porcentaje Ady   " + this.getPorcentAdy());
		System.out.println("Grado Max        " + this.getGradoMax());
		System.out.println("Grado Min        " + this.getGradoMin());
		System.out.println("Cantidad colores " + this.getCantColores());

		for (int i = 0; i < this.getNodos().size(); i++)
			System.out.println("NODO->" + this.getNodos().get(i).getNumero());
		System.out.println("Matriz Simetrica:");
		this.getMatriz().mostrarMatriz();
	}

	/**
	 * Calcula si un grafo es conexo
	 * 
	 * @return
	 */
	public boolean esConexo() {
		boolean result = true;
		BusquedaDFS busqueda = new BusquedaDFS(this, 0);
		for (int i = 0; i < cantNodos; i++) {
			if (!busqueda.marca(i)) {
				result = false;
				break;
			}
		}
		return result;
	}

	public int getCantidadNodos() {
		return this.cantNodos;
	}

	/**
	 * calcula si dos nodos son adyacentes o no
	 * 
	 * @param nodoA
	 * @param nodoB
	 * @return
	 */
	public boolean esAdyacente(int nodoA, int nodoB) {
		return matriz.getValor(nodoA, nodoB);
	}

	/**
	 * devuelve los nodos adyacentes a un Nodo x
	 * 
	 * @param nodo
	 * @return
	 */
	public ArrayList<Integer> nodosAdyacentesA(int nodo) {
		ArrayList<Integer> nodosAdy = new ArrayList<Integer>();

		for (int i = 0; i < matriz.getDimension(); i++) {
			if (esAdyacente(nodo, i) && nodo != i) {
				nodosAdy.add(i);
			}
		}
		return nodosAdy;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * Algoritmos de coloreo
	 * 
	 * 
	 * 
	 */
	/**
	 * Algorito de coloreo Secuencial
	 * 
	 * @param grafo
	 */
	public void AlgoritmoSecuencial2() {
		int color;
		this.cantColores = 0;

		for (int i = 0; i < this.cantNodos; i++) {
			color = 1;
			while (!puedeColorear(i, color)){
				color++;
			}
			this.nodos.get(i).setColor(color);
			if (color > this.cantColores)
				this.cantColores = color;
		}

	}

	public void AlgoritmoSecuencial(){
		Collections.shuffle(nodos);
		AlgoritmoSecuencial2();
	}
	
	/**
	 * Algoritmo de coloreo Well-Powell
	 */
	public void AlgoritmoWellPowell() {
		this.ordenarGradoDescendente(this.nodos, 0, nodos.size() - 1);
		this.AlgoritmoSecuencial();
	}

	/**
	 * Algoritmo de coloreo Matula
	 */
	public void AlgoritmoMatula() {
		this.ordenarGradoAscendente(this.nodos, 0, nodos.size() - 1);
		this.AlgoritmoSecuencial();
	}

	
	/**
	 * Ordena los nodos de menor a mayor grado
	 * 
	 * @param nodo
	 * @param nodoIzq
	 * @param nodoDer
	 */
	private void ordenarGradoAscendente(ArrayList<Nodo> nodo, int nodoIzq,
			int nodoDer) {
		Nodo pivote = nodos.get((nodoIzq + nodoDer) / 2);
		Nodo aux;
		int izq = nodoIzq;
		int der = nodoDer;
		do {
			while (nodos.get(izq).getGrado() < pivote.getGrado())
				izq++;
			while (nodos.get(der).getGrado() > pivote.getGrado())
				der--;
			if (izq <= der) {
				aux = nodo.get(izq);
				nodo.set(izq, nodo.get(der));
				nodo.set(der, aux);
				izq++;
				der--;
			}
		} while (izq <= der);
		if (nodoIzq < der)
			ordenarGradoAscendente(nodos, nodoIzq, der);
		if (izq < nodoDer)
			ordenarGradoAscendente(nodos, izq, nodoDer);
	}

	/**
	 * Ordena los nodos de mayor a menor grado
	 * 
	 * @param nodo
	 * @param nodoIzq
	 * @param nodoDer
	 */
	private void ordenarGradoDescendente(ArrayList<Nodo> nodo, int nodoIzq,
			int nodoDer) {
		Nodo pivote = nodos.get((nodoIzq + nodoDer) / 2);
		Nodo aux;
		int izq = nodoIzq;
		int der = nodoDer;
		do {
			while (nodo.get(izq).getGrado() > pivote.getGrado())
				izq++;
			while (nodo.get(der).getGrado() < pivote.getGrado())
				der--;
			if (izq <= der) {
				aux = nodo.get(izq);
				nodo.set(izq, nodo.get(der));
				nodo.set(der, aux);
				izq++;
				der--;
			}
		} while (izq <= der);
		if (nodoIzq < der)
			ordenarGradoDescendente(nodo, nodoIzq, der);
		if (izq < nodoDer)
			ordenarGradoDescendente(nodo, izq, nodoDer);
	}

	/**
	 * verifica si se pueden colorear un nodo
	 * 
	 * @param nodo
	 * @param color
	 * @return
	 */
	private boolean puedeColorear(int nodo, int color) {
		int i = 0;
		// Si el nodo fue coloreado
		if (this.nodos.get(nodo).getColor() != 0)
			return false;

		while (i < this.cantNodos) {
			//si el nodo a colorear es adyacente a un nodo ya pintado, no se colorea
			if (this.nodos.get(i).getColor() == color && i != nodo) {
				if (esAdyacente(this.nodos.get(i).getNumero()-1,
						this.nodos.get(nodo).getNumero()-1))
					return false;
			}
			i++;
		}
		return true;
	}

	/**
	 * Generar out de grafo coloreado
	 * 
	 * @param archivo
	 */
	public void grabarGrafoColoreado(String archivoOut) {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new File(archivoOut));

			salida.println(this.cantNodos + " " + this.cantColores + " "
					+ this.cantAristas + " " + this.porcentAdy + " "
					+ this.gradoMax + " " + this.gradoMin);

			for (int i = 0; i < this.cantNodos; i++)
				salida.println(this.nodos.get(i).getNumero() + " "
						+ nodos.get(i).getColor());

			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generar IN de grafo 
	 * 
	 * @param archivo
	 */
	public void grabarGrafoIN(String archivo) {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new File(archivo));

			salida.println(this.cantNodos + " " + this.cantAristas + " " + this.porcentAdy + " "
					+ this.gradoMax + " " + this.gradoMin);

//			for (int i = 0; i < this.cantNodos; i++)
//				salida.println(this.nodos.get(i).getNumero() + " "+ nodos.get(i).getColor());
//			
			
            for(int fila = 0; fila < this.cantNodos; fila++) {
            	for(int colum = fila+1 ; colum < this.cantNodos ; colum++) {
            		if(this.getValor(fila, colum) == true) {
            			salida.println((fila+1)+" "+(colum+1));
            		}
            	}
            }

			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * Getters y Setters
	 * 
	 * 
	 * 
	 */

	public void completarGrados() {
		int grado = 0;
		for (int f = 0; f < cantNodos; f++) {
			grado = 0;
			for (int c = 0; c < cantNodos; c++) {
				if (getValor(f, c) == true)
					grado++;
			}
			nodos.add(new Nodo(f + 1, 0, grado));
		}
	}

	public int getGradoMax() {
		return gradoMax;
	}

	public void setGradoMax(int gradoMax) {
		this.gradoMax = gradoMax;
	}

	public int getGradoMin() {
		return gradoMin;
	}

	public void setGradoMin(int gradoMin) {
		this.gradoMin = gradoMin;
	}

	public MatrizSimetrica getMatriz() {
		return matriz;
	}

	public void setMatriz(MatrizSimetrica matriz) {
		this.matriz = matriz;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public double getPorcentAdy() {
		return porcentAdy;
	}

	public void setPorcentAdy(double porcentAdy) {
		this.porcentAdy = porcentAdy;
	}

	public int getCantColores() {
		return cantColores;
	}

	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	public boolean getValor(int fila, int colum) {
		return matriz.getValor(fila, colum);
	}
}
