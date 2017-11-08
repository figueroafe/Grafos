package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
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
					if (matriz.getValor(i, j) && i != j) {
						grado++;
					}
				}
				this.nodos.add(new Nodo(i + 1, 0, grado));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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
		System.out.println("GRADOS: \t" + this.gradoMax + "\t" + this.gradoMin);
	}

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

	public boolean esAdyacente(int nodoA, int nodoB) {
		return matriz.getValor(nodoA, nodoB);
	}

	public ArrayList<Integer> nodosAdyacentesA(int nodo) {
		ArrayList<Integer> nodosAdy = new ArrayList<Integer>();

		for (int i = 0; i < matriz.getDimension(); i++) {
			if (esAdyacente(nodo, i) && nodo != i) {
				nodosAdy.add(i);
			}
		}
		return nodosAdy;
	}

}
