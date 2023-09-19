package lab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	ArrayList<LinkedList<Node>> alist; //adjacent list (alist)
	
	//
	ArrayList<Node> nodes; //bfs and dfs
	int row = 10,column = 10;
	int[][] mat = new int[row][column];
	
	Graph()
	{
		alist = new ArrayList<>(); 
	}
	
	public void addNode(Node node)
	{
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(node);//set this node as the head of the linked list
		alist.add(currentList); //add this list to the array
	}
	
	//source(a), destination(b)
	public void addEdge(int a, int b)
	{
		/*retrieve and store the linked list from alist with source as the head of the linked list:
		LinkedList<Node> currentList = alist.get(a);*/
		
		Node dstNode = alist.get(b).get(0); //find linked list with b as head and retrieve the head (b)
		alist.get(a).add(dstNode);//add b to the tail of a's linked list
		
		Node dstNode1 = alist.get(a).get(0);
		alist.get(b).add(dstNode1);//add b to a's linkded list as well since it's an undirected graph
		
		//since it's an undirected graph
		mat[a][b] = 1;
		mat[b][a] = 1;
		
	}
	
	public int degreeVertext(int v)
	{
		int degree = 0;
		
		for(int i=0; i < row ; i++)
		{
			if(mat[v][i] == 1)
				degree++;
		}
		 
		return degree;
	} 
	
	public void printAdjVertices(int a)
	{
		LinkedList<Node> currentList = alist.get(a);
		for(Node node : currentList)
		{
			System.out.print(node.data + " -> "); 
		}
	}
	
	public void printMat()
	{
		for(int i=0; i < row ; i++ )
		{
			for(int j=0; j< column ; j++)
			{
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	
	//BREADTH FIRST SEARCH
	public void bfs(int src)
	{
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[alist.size()]; //size of visited nodes = no. of vertices
		
		queue.add(src);
		visited[src] = true;
		
		while(queue.size() != 0)
		{
			src = queue.poll(); //dequeue
			System.out.print(alist.get(src).get(0).data + " , ");
			for(int  i= 0; i<row ;i++)
			{
				if(mat[src][i] == 1 && !visited[i])
				{
					queue.add(i); //add each neighbor to the queue
					visited[i] = true; 
				}
			}
		}
		
	}
	
	//DEPTH FIRST SEARCH
	public void dfs(int src)
	{
		boolean[] visited = new boolean[alist.size()]; //size of visited nodes = no. of vertices
		
		//using recursion to find the depth of the selected node
		dfsHelper(src,visited); //pass the visited queue
	}
	
	public void dfsHelper(int src, boolean[] visited)
	{
		if(visited[src])
			return;
		else 
		{
			visited[src] = true;
			System.out.print(alist.get(src).get(0).data + " , ");
		}
		
		//recursion
		for(int i =0 ; i<mat.length; i++)
		{
			//find the neighbors of node src. 
			//use the dfsHelper method to find the child of that node
			if(mat[src][i] == 1)
				dfsHelper(i, visited); //call for i = neighbor, and send the visited array
		}
	}
}
