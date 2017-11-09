package testGrafo;

import org.junit.Test;

import grafos.Grafo;

public class GrafoTest {

	@Test
	public void leerGrafo() {
		Grafo grafo = new Grafo("IN/grafo.in");
		grafo.mostrarGrafo();
	}

}
