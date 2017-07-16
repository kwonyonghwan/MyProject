/*package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {
	int vertexNumber;
	int vertexWeight;

	public Vertex(int vertexNumber, int vertexWeight) {
		super();
		this.vertexNumber = vertexNumber;
		this.vertexWeight = vertexWeight;
	}

	@Override
	public int compareTo(Vertex target) {

		if (this.vertexWeight > target.vertexWeight) {
			return 1;
		} else if (this.vertexWeight < target.vertexWeight) {
			return -1;
		}
		return 0;
	}

}//ClassVertex

public class ShortestPath {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/ShortestPath.txt"));

		// Scanner sc = new Scanner(System.in);

		int countOfVertex = sc.nextInt()+1;
		int countOfEdge = sc.nextInt() ;
		int startIndex = sc.nextInt();

		int[][] graph = new int[countOfVertex][countOfVertex];
		for (int i = 0; i < countOfVertex; i++) {
			for (int j = 0; j < countOfVertex; j++) {
				graph[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		for(int i =0; i<countOfEdge; i++){
			graph[sc.nextInt()][sc.nextInt()]=sc.nextInt();
		}

		dijkstra(graph, startIndex);

	}// main

	private static void dijkstra(int[][] graph, int startIndex) {
		
		boolean[] endSet = new boolean[graph.length];
		int[] distanceGraph = new int[graph.length];
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
		Vertex startVertex = new Vertex(startIndex, 0);
		
		for (int i = 1; i < graph.length; i++) {
			distanceGraph[i] = Integer.MAX_VALUE;
		} // forSetting
		
		distanceGraph[startIndex] = 0;
		priorityQueue.offer(startVertex);
		
		for(int i=0; i<graph.length-1; i++){
			Vertex nowVertex = priorityQueue.poll();
			
			endSet[nowVertex.vertexNumber] = true;
			
			for(int j=1; j<graph.length; j++){
				if(!endSet[j] ){
					if(distanceGraph[j] > distanceGraph[nowVertex.vertexNumber]+graph[nowVertex.vertexNumber][j]){
						distanceGraph[j] = distanceGraph[nowVertex.vertexNumber]+ graph[nowVertex.vertexNumber][j];
						Vertex nextVertex = new Vertex(j, distanceGraph[j]);
						priorityQueue.offer(nextVertex);
					}
					
				}
			}
			
		}
		
		for (int i = 1; i < graph.length; i++) {
			if(distanceGraph[i]>1073700000){
				System.out.println("INF");
				continue;
			}
			System.out.println(distanceGraph[i]);
		}
	}//dijkstra()

}// clas
*/