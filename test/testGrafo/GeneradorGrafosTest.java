package testGrafo;

import org.junit.Test;

import grafos.GeneradorDeGrafos;
import grafos.Grafo;

public class GeneradorGrafosTest {

	@Test
	public void generadorNoRegularAl40() {
		GeneradorDeGrafos generador = new GeneradorDeGrafos();
		generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 40).grabarGrafoIN("IN/NoRegular/40_porciento_adyacencia.in");
	}

	@Test
	public void generadorNoRegularAl60() throws Exception {
		GeneradorDeGrafos generador = new GeneradorDeGrafos();
		generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 60).grabarGrafoIN("IN/NoRegular/60_porciento_adyacencia.in");
	}

	@Test
	public void generadorNoRegularAl90() throws Exception {
		GeneradorDeGrafos generador = new GeneradorDeGrafos();
		generador.generarGrafoAleatorioConPorcentajeDeAdyacencia(600, 90).grabarGrafoIN("IN/NoRegular/90_porciento_adyacencia.in");
	}

	@Test
	public void generadorRegularAl50() {
		GeneradorDeGrafos generador = new GeneradorDeGrafos();
		generador.generarGrafoRegularConPorcentajeDeAdyacencia(1000, 50).grabarGrafoIN("IN/Regular/50_porciento_adyacencia.in");
	}

	@Test
	public void generadorRegularAl75() {
		GeneradorDeGrafos generador = new GeneradorDeGrafos();
		generador.generarGrafoRegularConPorcentajeDeAdyacencia(1000, 75).grabarGrafoIN("IN/Regular/75_porciento_adyacencia.in");
	}


}
