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
}// ClassVertex

public class FireEngineSolveDijkstraUsingPriorityQueue {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/FireEngine.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfVillage = sc.nextInt() + 1;
			int numberOfRoad = sc.nextInt();

			int[] FireVillageList = new int[sc.nextInt()];
			int[] FireStationLsit = new int[sc.nextInt()];

			int[][] graph = new int[numberOfVillage][numberOfVillage];

			for (int i = 0; i < numberOfVillage; i++) {
				for (int j = 0; j < numberOfVillage; j++) {
					graph[i][j] = Integer.MAX_VALUE / 2;
				}
			}

			for (int i = 0; i < numberOfRoad; i++) {
				int aVillage = sc.nextInt();
				int bVillage = sc.nextInt();
				graph[aVillage][bVillage] = graph[bVillage][aVillage] = sc.nextInt();
			}

			for (int i = 0; i < FireVillageList.length; i++) {
				FireVillageList[i] = sc.nextInt();
			}

			for (int i = 0; i < FireStationLsit.length; i++) {
				FireStationLsit[i] = sc.nextInt();
			}

			int result = 0;

			for (int i = 0; i < FireVillageList.length; i++) {
				int min = Integer.MAX_VALUE / 2;

				for (int j = 0; j < FireStationLsit.length; j++) {
					int temp = dijkstra(FireVillageList[i], graph, FireStationLsit[j]);
					if (temp < min) {
						min = temp;
					}
				} // forJ
				result += min;
			} // forI

			System.out.println(result);

		} // forTest
	}// main

	public static int dijkstra(int FireVillage, int[][] graph, int FireStation) {

		boolean[] endSet = new boolean[graph.length];
		int[] distance = new int[graph.length];
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
		Vertex startVertex = new Vertex(FireVillage, 0);

		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		} // forI

		distance[FireVillage] = 0;
		priorityQueue.offer(startVertex);

		for (int i = 0; i < graph.length - 1; i++) {

			int min = Integer.MAX_VALUE;
			int index = -1;

			// 가장 작은 값 찾고
			Vertex temp = priorityQueue.poll();

			endSet[temp.vertexNumber] = true;

			// 그걸 시작으로 하는 최소값 갱신하고
			for (int j = 0; j < distance.length; j++) {
				if (distance[j] > distance[temp.vertexNumber] + graph[temp.vertexNumber][j]) {
					distance[j] = distance[temp.vertexNumber] + graph[temp.vertexNumber][j];
					Vertex tempForNext = new Vertex(j, distance[j]);
					priorityQueue.offer(tempForNext);
				}
			} // forDijkstra

		} // for(N-1)번

		return distance[FireStation];
	}

}// class
*/