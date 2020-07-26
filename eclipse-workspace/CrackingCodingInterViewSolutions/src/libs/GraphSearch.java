package libs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {

	public static boolean BFSWithQueue(GraphNode parentNode, GraphNode start, GraphNode end) {
		Queue<GraphNode> bfs = new LinkedList<>();
		ArrayList<GraphNode> path = new ArrayList<GraphNode>();
		if(start != parentNode) {
			bfs.add(start);
		}else {
			bfs.add(parentNode);
		}
		while(!bfs.isEmpty()) {
			GraphNode node = bfs.remove();
			path.add(node);
			node.isVisited = true;
			bfs.addAll((node.children));
			if(node == end) {
				System.out.println("Path found : ");
				for (GraphNode graphNode : path) {
					System.out.print("-->"+graphNode.data.toString());
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean BFSWithQueue(GraphNode parentNode) {
		Queue<GraphNode> bfs = new LinkedList<>();
		ArrayList<GraphNode> path = new ArrayList<GraphNode>();
		bfs.add(parentNode);
		while(!bfs.isEmpty()) {
			GraphNode node = bfs.remove();
			path.add(node);
			node.isVisited = true;
			bfs.addAll((node.children));
		}
		for (GraphNode graphNode : path) {
			System.out.print("-->" + graphNode.data);
		}
		return false;
	}
	
	
	//this is temp code
	public static void BFSWithQueueWithRecursion(GraphNode node) {
		if(node == null)
			return;
		System.out.print("-->" + node.data);
		for (GraphNode child : node.children) {
			BFSWithQueueWithRecursion(child);
		}
	}
	
}
