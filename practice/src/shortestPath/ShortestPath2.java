package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
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

}// ClassVertex

public class ShortestPath2 {
	static int countOfVertex;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/ShortestPath.txt"));

		// Scanner sc = new Scanner(System.in);

		 countOfVertex = sc.nextInt()+1;
			int countOfEdge = sc.nextInt() ;
			int startIndex = sc.nextInt();
			
			ArrayList<ArrayList> graph = new ArrayList<ArrayList>(countOfVertex);
			for(int i=0; i<countOfVertex; i++){
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i =0; i<countOfEdge; i++){
				int startVertex = sc.nextInt();
				int endVertex = sc.nextInt();
				int weight = sc.nextInt();
				
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(endVertex);
				temp.add(weight);
				
				graph.get(startVertex).add(temp);
				
			}

			dijkstra(graph, startIndex);

		}// main

		private static void dijkstra(ArrayList<ArrayList> graph, int startIndex) {
			
			boolean[] endSet = new boolean[countOfVertex];
			int[] distanceGraph = new int[countOfVertex];
			PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
			Vertex startVertex = new Vertex(startIndex, 0);
			
			for (int i = 1; i < countOfVertex; i++) {
				distanceGraph[i] = Integer.MAX_VALUE;
			} // forSetting
			
			distanceGraph[startIndex] = 0;
			priorityQueue.offer(startVertex);
			
			while(!priorityQueue.isEmpty()){
				Vertex nowVertex = priorityQueue.poll();
				
				endSet[nowVertex.vertexNumber] = true;
				for(int j=0; j<graph.get(nowVertex.vertexNumber).size(); j++){
					ArrayList<Integer> temp = (ArrayList<Integer>) graph.get(nowVertex.vertexNumber).get(j);
					if(!endSet[temp.get(0)] ){
						if(distanceGraph[temp.get(0)] > distanceGraph[nowVertex.vertexNumber]+temp.get(1)){
							distanceGraph[temp.get(0)] = distanceGraph[nowVertex.vertexNumber]+ temp.get(1);
							Vertex nextVertex = new Vertex(temp.get(0), distanceGraph[temp.get(0)]);
							priorityQueue.offer(nextVertex);
						}
						
					}
				}
				
			}
			
			for (int i = 1; i < countOfVertex; i++) {
				if(distanceGraph[i]>Integer.MAX_VALUE/4){
					System.out.println("INF");
					continue;
				}
				System.out.println(distanceGraph[i]);
			}
		}//dijkstra()

	}// class
