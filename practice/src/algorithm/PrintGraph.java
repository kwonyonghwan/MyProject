package algorithm;

public class PrintGraph  {

	public static void printGraph(boolean[][] graph) {

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + "  ");
			}
			System.out.println();
		}

	}//printGraph

	public void printGraph(char[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void printGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + "     ");
			}
			System.out.println();
		}
	}

}//class
