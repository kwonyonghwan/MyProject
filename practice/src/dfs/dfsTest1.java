package dfs;
import java.util.Scanner;

public class dfsTest1 {

	static int numberOfVertex;
	static int[][] graph;
	static boolean[] visitVertex;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int startVertex = 1;
		int v1, v2;
		
		numberOfVertex = 8;
		graph = new int[numberOfVertex+1][numberOfVertex+1];
		visitVertex = new boolean[numberOfVertex];

		while(true){
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			
			if(v1 == -1 || v2 == -1){
				break;
			}
			graph[v1][v2] = graph[v2][v1] = 1;
		}//while
		
		DFS(startVertex);
		
	}//main
	
	private static void DFS(int startVertex) {
		int tempvertax = startVertex;
		
		visitVertex[tempvertax] = true;
		for(int i=1; i<numberOfVertex; i++){
			if(graph[tempvertax][i] == 1 && !visitVertex[i]){
				System.out.println(tempvertax+" ---> " + i);
				DFS(i);
			}
		}//for
		
	}//DFS

}//class
