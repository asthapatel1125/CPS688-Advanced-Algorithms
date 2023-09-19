package lab1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph graph = new Graph();
		
		//add vertices
		graph.addNode(new Node(0));
		graph.addNode(new Node(1));
		graph.addNode(new Node(2));
		graph.addNode(new Node(3));
		graph.addNode(new Node(4));
		graph.addNode(new Node(5));
		
		
		//add edges
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		//Print degree of given vertex
		System.out.println("Degree of given Vertex: " + graph.degreeVertext(4) + "\n");
		
		//Print adjacent vertices of given vertex
		System.out.println("Adjacent Vertices");
		graph.printAdjVertices(5);
		
		
		System.out.println("\n\n");
		graph.printMat();	
		
		//Perform Breadth First Search(BFS) from given source vertex
		System.out.println("\nBreadth First Search (BFS)"); 
		graph.bfs(0);
		
		//Perform Depth First Search (DFS) from given source vertex
		System.out.println("\n\nDepth First Search (DFS)"); 
		graph.dfs(0);
	}

}
