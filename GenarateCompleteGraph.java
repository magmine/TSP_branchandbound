import  java.util.*;
public class GenarateCompleteGraph {
	
	public void	generateGraph(Graph G){
		fillGraph(G);
	}
	
	public Graph generateGraph(Integer nVertexes) {
		Graph G = new Graph(nVertexes);
		fillGraph(G);
		return G;	
	}
	
	public Graph generateGraph() {
		Integer nVertexes = ((int) Math.random())%100 + 5;
		Graph G = new Graph(nVertexes);
		fillGraph(G);
		return G;	
	}
	
	private void fillGraph(Graph G) {
		G.initialise();
		Integer nVertexes = G.getnV();
		for (int i = 0; i < nVertexes - 1; i++) {
			G.setEdge(i, i, 0);
			for (int j = i + 1; j < nVertexes; j++) {
				int rand = ((int) Math.random())%100 + 1;
				G.setEdge(i, j, rand);
				G.setEdge(j, i, rand);
			}
		}
	}
}
