package libs;

import java.util.ArrayList;

public class GraphNode{
	public String data;
	public ArrayList<GraphNode> children = new ArrayList<GraphNode>();
	public boolean isVisited = false;
	public double id = Math.random()*100000;
	
	public GraphNode() {}
	public GraphNode(String data) {
		this.data = data;
	}
}
