package testGrafo;

import org.junit.Test;

import grafos.Grafos;

public class GrafoTest {
	
	
	
	@Test
	public void leerGrafo(){
		Grafos grafo = new Grafos("IN/grafo.in");
		
		System.out.println("aristas " +grafo.getCantAristas());
		System.out.println("nodos "+grafo.getCantNodos());
		System.out.println("%ady "+grafo.getPorcentAdy());
		System.out.println("max "+grafo.getGradoMax());
		System.out.println("min "+grafo.getGradoMin());
		
		for(int i=0; i < grafo.getNodos().size();i++ )
			System.out.println("NODO->"+grafo.getNodos().get(i).getNumero());
	}

}
