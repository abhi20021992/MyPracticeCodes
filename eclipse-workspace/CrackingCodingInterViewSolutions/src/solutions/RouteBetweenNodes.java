package solutions;

import libs.GraphNode;
import libs.GraphSearch;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		GraphNode graph = new GraphNode("A");
		GraphNode graphB = new GraphNode("B");
		GraphNode graphC = new GraphNode("C");
		GraphNode graphD = new GraphNode("D");
		GraphNode graphE = new GraphNode("E");
		GraphNode graphF = new GraphNode("F");
		GraphNode graphG = new GraphNode("G");
		graphB.children.add(graphD);
		graphE.children.add(graphB);
		graph.children.add(graphB);
		graphC.children.add(graphF);
		graphG.children.add(graphC);
		graph.children.add(graphC);
		
		System.out.println(GraphSearch.BFSWithQueue(graph, graph, graphD));
		System.out.println(GraphSearch.BFSWithQueue(graph, graph, graphE));
		System.out.println(GraphSearch.BFSWithQueue(graph));
		GraphSearch.BFSWithQueueWithRecursion(graph);
	}
}

