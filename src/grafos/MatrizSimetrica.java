package grafos;

public class MatrizSimetrica {

	private boolean[] matriz;
	private int dimension;// cantNodos
	private int orden; // orden de la matriz
	private int tamVector;

	/**
	 * Contructor de la clase implementada en un vector
	 * 
	 * @param dimension
	 */
	public MatrizSimetrica(int dimension) {
		this.dimension = dimension;
		Double aux;
		if (dimension < 0)
			dimension = 1;
		this.tamVector = (dimension * (dimension - 1)) / 2;
		matriz = new boolean[this.tamVector];
		aux = ((1 + Math.sqrt(1 + 8 * matriz.length)) / 2);
		this.orden = aux.intValue();
	}

	/**
	 * seteamos el valor true o infinito de acuerdo a la fila/columna
	 * 
	 * @param fila
	 * @param colum
	 * @param valor
	 */
	public void setValor(int fila, int colum, boolean valor) {
		if (fila == colum)
			return;

		int i;
		if (fila > colum)
			i = (colum * this.orden) + fila
					- ((colum * colum) + (3 * colum) + 2) / 2;
		else
			i = (fila * this.orden) + colum - ((fila * fila) + (3 * fila) + 2)
					/ 2;
		matriz[i] = valor;

	}

	public boolean setValor(int i, boolean valor) {
		return matriz[i] = valor;
	}

	/**
	 * Devuelve el valor true o infinito de la pocion de la matriz simetrica
	 * 
	 * @param fila
	 * @param colum
	 * @return
	 */
	public boolean getValor(int fila, int colum) {
		if (fila == colum)
			return true;

		int i;
		if (fila > colum)
			i = (colum * this.orden) + fila	- ((colum * colum) + (3 * colum) + 2) / 2;
		else
			i = (fila * this.orden) + colum - ((fila * fila) + (3 * fila) + 2)	/ 2;
		
		return matriz[i];
	}

	public boolean getValor(int i) {
		return matriz[i];
	}

	public int getDimension() {
		return dimension;
	}

	public void mostrarMatriz() {
		System.out.print(" ");
		for (int i = 0; i < dimension; i++) {
			System.out.print("|" + (i+1) + "\t");
		}
		System.out.println("|");
		for (int i = 0; i < dimension; i++) {
			System.out.print(i+1);
			for (int j = 0; j < dimension; j++) {
				System.out.print("|" + getValor(i, j) + "\t");
			}
			System.out.println("|");
		}
	}
}
