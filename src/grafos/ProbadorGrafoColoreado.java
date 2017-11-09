package grafos;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ProbadorGrafoColoreado {

	private Grafo grafoOriginal;
	private Map<Integer, Integer> salidaColoreada; // asocio nodo con numero de
													// color
	private boolean nodosRepetidos;
	private boolean nodosSinPintar;
	private boolean nodosAdyacentesIgualColor;

	public ProbadorGrafoColoreado(String grafoIn, String grafoColoreado) {
		try {

			grafoOriginal = new Grafo(grafoIn);

			Scanner sc = new Scanner(new File(grafoColoreado));
			sc.useLocale(Locale.ENGLISH);

			int cantNodos = sc.nextInt();
			int cantColores = sc.nextInt();
			int cantAristas = sc.nextInt();
			double porcentAdy = sc.nextDouble();
			int gradoMax = sc.nextInt();
			int gradoMin = sc.nextInt();

			salidaColoreada = new HashMap<Integer, Integer>();

			for (int i = 0; i < cantNodos; i++) {
				int nodo = sc.nextInt();
				int color = sc.nextInt();
				if (salidaColoreada.containsKey(nodo))
					nodosRepetidos = true;
				else
					salidaColoreada.put(nodo, color);
			}

			for (Integer key : salidaColoreada.keySet()) {
				if (!(salidaColoreada.get(key).compareTo(0) > 0)) {
					nodosSinPintar = true;
					break;
				}
			}

			for (int i = 1; i <= cantNodos; i++) {
				for (int j = i; j <= cantNodos; j++) {
					if (grafoOriginal.getValor(i - 1, j - 1) == true && i != j) {
						if (salidaColoreada.get(i).equals(
								salidaColoreada.get(j))) {
							nodosAdyacentesIgualColor = true;
						}
					}
				}
			}

			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verificamos si esta bien coloreado el grafo
	 * 
	 * @return
	 */
	public boolean verificar() {

		if (hayNodosAdyacentesIgualColor() || hayNodosRepetidos()
				|| hayNodosSinPintar())
			// System.out.println("Grafo MAL coloreado");
			return false;
		else
			return true;
		// System.out.println("Grafo BIEN coloreado");
	}

	public boolean hayNodosRepetidos() {
		return nodosRepetidos;
	}

	public boolean hayNodosSinPintar() {
		return nodosSinPintar;
	}

	public boolean hayNodosAdyacentesIgualColor() {
		return nodosAdyacentesIgualColor;
	}

}
