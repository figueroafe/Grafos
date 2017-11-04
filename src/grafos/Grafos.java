package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Grafos {

	private MatrizSimetrica matriz;
	private int cantNodos;
	private int cantAristas;
	private double porcentAdy;
	private int gradoMax;
	private int gradoMin;
	private int cantColores;
	private ArrayList<Nodo> nodos;

	public Grafos(String path) {

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

}
