package grafos;


public class NodoAdyacencia
{
	private int f;
	private int c;
	private double adya;
	
	public NodoAdyacencia(int f, int c, double a)
	{
		this.f = f;
		this.c = c;
		this.adya = a;
	}

	public int getF() {
		return f;
	}

	public int getC() {
		return c;
	}

	public double getAdya() {
		return adya;
	}	
}
