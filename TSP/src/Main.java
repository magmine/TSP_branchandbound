import java.util.*;
public class Main {
	//private Integer nv = 5;
	public static void main(String[] args) {
		Graph G = new Graph(5);
		//GenarateCompleteGraph GCG = new GenarateCompleteGraph();
		//Graph G = GCG.generateGraph(15);
		/*G.initialise();
		G.setEdge(0, 1, 3);
		G.setEdge(0, 2, 5);
		G.setEdge(0, 3, 1);
		G.setEdge(0, 4, 3);
		G.setEdge(1, 2, 1);
		G.setEdge(1, 4, 4);
		G.setEdge(2, 3, 6);
		G.setEdge(3, 4, 2);*/
		BranchBound bb = new BranchBound(G);
		Solution sol = bb.branchAndBound();
		System.out.println("La solution: "+  sol.getCost() + " ; \n" + sol.getPath());
	}

}
