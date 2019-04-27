import java.util.*;

public class Graph {
	/**
	 * Number of vertexes
	 */
	private Integer nV;
	private ArrayList<ArrayList<Integer>> adjMatrix;
	private ArrayList<ArrayList<Boolean>> isVisitedEdge;
	private ArrayList<Boolean> isVisitedVertex;

	public Graph(Integer nV) {
		super();
		this.nV = nV;
		adjMatrix = new ArrayList<ArrayList<Integer>>(nV);
		isVisitedEdge = new ArrayList<ArrayList<Boolean>>(nV);
		isVisitedVertex = new ArrayList<Boolean>();
		for (int i = 0; i < nV; i++) {
			adjMatrix.add(new ArrayList<Integer>());
			isVisitedEdge.add(new ArrayList<Boolean>());
		}
	}
	
	public Integer getnV() {
		return nV;
	}

	public void setnV(Integer nV) {
		this.nV = nV;
	}



	public void initialise() {
		
		Boolean f;
		f = false;
		for (int i = 0; i < nV; i++) {
			isVisitedVertex.add(f);
			for (int j = 0; j < nV; j++) {
				adjMatrix.get(i).add(-1);
				isVisitedEdge.get(i).add(f);
			}
		}
	}
	
	
	public void restartVisitingVertex() {
		for (int i = 0; i < nV; i++)
			isVisitedVertex.set(i, false);
	}
	/*public void restartVisitingVertex() {
		for (int i = 0; i < nV; i++)
			for (int j = 0; j < nV; j++)
				isVisitedEdge.get(i).set(j, false);
	}*/
	
	public void setEdgeVisited(Integer v1, Integer v2, Boolean val) {
		isVisitedEdge.get(v1).set(v2, val);
		isVisitedEdge.get(v2).set(v1, val);
	}
	
	public void setVertexVisited(Integer v, Boolean val) {
		isVisitedVertex.set(v, val);
	}
	
	public Boolean isVertexVisited(Integer v) {
		return isVisitedVertex.get(v);
	}
	
	public Boolean isEdgeVisited(Integer v1, Integer v2) {
		return isVisitedEdge.get(v1).get(v2);
	}
	
	public void setEdge(Integer v1, Integer v2, Integer val) {
		adjMatrix.get(v1).set(v2, val);
		adjMatrix.get(v2).set(v1, val);
		adjMatrix.get(v1).set(v1, 0);
	}
	
	public Integer getEdgeLength(Integer v1, Integer v2) {
		return adjMatrix.get(v1).get(v2);
	}
}
