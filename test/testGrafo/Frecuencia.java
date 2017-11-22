package testGrafo;

public class Frecuencia {

	private int frecuencia;
	private int iteracion;
	private int cantColores;

	public Frecuencia(int frecuencia, int iteracion, int cantColores) {
		super();
		this.frecuencia = frecuencia;
		this.iteracion = iteracion;
		this.cantColores = cantColores;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public int getIteracion() {
		return iteracion;
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
	}

	public int getCantColores() {
		return cantColores;
	}

	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}

}
