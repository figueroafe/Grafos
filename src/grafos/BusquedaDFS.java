package grafos;

public class BusquedaDFS {
	private boolean[] marca;    // marca[v] = is there an s-v path
	private int count;  
	
	public BusquedaDFS(Grafo g, int s) {
		marca = new boolean[g.getCantidadNodos()];
		dfs(g,s);
	}
	
	private void dfs(Grafo grafo, int v) {
       count++;
       marca[v] = true;
       for (int w : grafo.nodosAdyacentesA(v)) {
           if (!marca[w]) {
               dfs(grafo, w);
           }
       }
	}	
	
	public boolean marca(int v) {
        return marca[v];
    }
}
