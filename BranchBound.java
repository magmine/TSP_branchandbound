import java.util.*;
public class BranchBound {
	private Graph graph;
	private Integer nVertex;
	private Solution sol = new Solution(Integer.MAX_VALUE);

	public BranchBound(Graph graph) {
		super();
		this.graph = graph;
		nVertex = graph.getnV();
	}

	public BranchBound(int nVertex) {
		super();
		graph = new Graph(nVertex);
		this.nVertex = nVertex;
	}
	
	public Solution branchAndBound() {
		Solution tempSol = new Solution();
		dfs(0, 0, tempSol);
		return sol;
	}
	
	private Solution dfs(Integer vertex, Integer parentVertex, Solution tempSol) {
		graph.setVertexVisited(vertex, true);
		tempSol.pathAddVertex(vertex);
		if (vertex != parentVertex)
			tempSol.setCost(tempSol.getCost() + graph.getEdgeLength(parentVertex, vertex));
		if(tempSol.pathSize() == nVertex) {
			if (graph.getEdgeLength(0, vertex) < 0) {
				//tempSol.pathRemoveVertex();
				graph.setVertexVisited(vertex, false);
				return tempSol;
			}
			if ((tempSol.getCost() + graph.getEdgeLength(0, vertex)) <= sol.getCost()) {
				sol = new Solution(tempSol);
				sol.setCost(tempSol.getCost() + graph.getEdgeLength(0, vertex));
				graph.setVertexVisited(vertex, false);
				return tempSol;
			}
		}
		
		if(tempSol.getCost() > sol.getCost())
			return tempSol;
		for (int i = 0; i < nVertex; i++) {
			if (!graph.isVertexVisited(i)) {
				if (graph.getEdgeLength(vertex, i) < 0)
					continue;
				tempSol = dfs(i, vertex, tempSol);
				tempSol.pathRemoveVertex();
				tempSol.setCost(tempSol.getCost() - graph.getEdgeLength(i, vertex));
				graph.setVertexVisited(i, false);
			}
		}
		graph.setVertexVisited(vertex, false);
		return tempSol;
	}
}
