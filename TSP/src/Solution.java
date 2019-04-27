import java.util.*;

public class Solution {
	private Integer cost;
	private Stack<Integer> path;
	
	public Solution() {
		super();
		cost = 0;
		path = new Stack<Integer>();
	}
	
	public Solution(Integer cost, Stack<Integer> path) {
		super();
		this.cost = cost;
		this.path = path;
	}
	
	public Solution(Integer cost) {
		super();
		this.cost = cost;
	}

	public Solution(Solution sol) {
		super();
		this.cost = sol.cost;
		path = copyStack(sol.getPath());
	}
	
	//Attention for bugs
	private Stack<Integer> copyStack(Stack<Integer> st){
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> helperArray = new ArrayList<Integer>();
		int length = 0;
		Iterator<Integer> it = st.iterator();
		
		while (it.hasNext()) {
			helperArray.add((Integer)it.next());
			length++;
		}
		for (int i = length - 1; i >= 0; i--) {
			stack.push(helperArray.get(i));
		}
		return stack;
	}
	
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public Stack<Integer> getPath() {
		return path;
	}
	
	public Integer pathSize() {
		return (path.size());
	}
	
	public void pathAddVertex(Integer vertex) {
		path.push(vertex);
	}
	
	public Integer pathRemoveVertex() {
		return path.pop();
	}
	
	public void setPath(Stack<Integer> path) {
		this.path = path;
	}
	
	public void addVertex(Integer v) {
		path.add(v);
	}
}
