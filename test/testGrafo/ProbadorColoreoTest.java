package testGrafo;

import grafos.Grafo;
import grafos.ProbadorGrafoColoreado;

import org.junit.Assert;
import org.junit.Test;

public class ProbadorColoreoTest {

	@Test
	public void verificamosColoreoGrafoConSecuencial() {
		Grafo grafo = new Grafo("IN/grafo.in");
		grafo.AlgoritmoSecuencial();
		grafo.grabarGrafoColoreado("OUT/coloreoSecuencial.out");

		ProbadorGrafoColoreado probador = new ProbadorGrafoColoreado(
				"IN/grafo.in", "OUT/coloreoSecuencial.out");
		Assert.assertEquals(true, probador.verificar());
	}

	@Test
	public void verificamosColoreoGrafoConWellPowell() {
		Grafo grafo = new Grafo("IN/grafo.in");
		grafo.AlgoritmoWellPowell();
		grafo.grabarGrafoColoreado("OUT/coloreoWell-Powell.out");

		ProbadorGrafoColoreado probador = new ProbadorGrafoColoreado(
				"IN/grafo.in", "OUT/coloreoWell-Powell.out");
		Assert.assertEquals(true, probador.verificar());
	}

	@Test
	public void verificamosColoreoGrafoMatula() {
		Grafo grafo = new Grafo("IN/grafo.in");
		grafo.AlgoritmoSecuencial();
		grafo.grabarGrafoColoreado("OUT/coloreoMatula.out");

		ProbadorGrafoColoreado probador = new ProbadorGrafoColoreado(
				"IN/grafo.in", "OUT/coloreoMatula.out");
		Assert.assertEquals(true, probador.verificar());
	}

}
