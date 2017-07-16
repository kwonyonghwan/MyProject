package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

class CountryVertex implements Comparable<CountryVertex> {
	int vertexNumber;
	int vertexFee;

	public CountryVertex(int vertexNumber, int vertexFee) {
		super();
		this.vertexNumber = vertexNumber;
		this.vertexFee = vertexFee;
	}// Generator

	@Override
	public int compareTo(CountryVertex target) {
		if (this.vertexFee > target.vertexFee) {
			return 1;
		} else if (this.vertexFee < target.vertexFee) {
			return -1;
		}
		return 0;
	}
}// ClassCountryVertex

public class SaleTicketUsingPriorityQueue {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/SaleTicket.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfStation = sc.nextInt() + 1;
			int numberOfEdge = sc.nextInt();
			int feeOfSaleTicket = sc.nextInt();
			int countOfSaleTicket = 0;
			int feeOfStep = 0;

			int[][] graph = new int[numberOfStation][numberOfStation];

			for (int i = 0; i < numberOfStation; i++) {
				for (int j = 0; j < numberOfStation; j++) {
					graph[i][j] = Integer.MAX_VALUE / 2;
				}
			}//forComparableMinCalculate

			for (int i = 0; i < numberOfEdge; i++) {
				int aStation = sc.nextInt();
				int bStation = sc.nextInt();
				graph[aStation][bStation] = graph[bStation][aStation] = sc.nextInt();
			} //forSetting

			int countOfPlan = sc.nextInt();

			for (int i = 0; i < countOfPlan; i++) {
				if (feeOfSaleTicket < dijkstra(graph, sc.nextInt(), sc.nextInt())) {
					countOfSaleTicket++;
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(countOfSaleTicket);

		} // forTest

	}// main

	public static int dijkstra(int[][] graph, int startStation, int endStation) {

		int[] distance = new int[graph.length];
		boolean[] endSet = new boolean[graph.length];
		PriorityQueue<CountryVertex> priorityQueue = new PriorityQueue<CountryVertex>();
		CountryVertex startVertex = new CountryVertex(startStation, 0);
		
		priorityQueue.offer(startVertex);
		
		for(int i=0; i<distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
		}//forSettingMinCalculation

		distance[startStation] = 0;
		
		for (int i = 0; i < graph.length-1; i++) {

			CountryVertex vertexForBefore = priorityQueue.poll();
			endSet[vertexForBefore.vertexNumber] = true;

			for(int j=0; j<graph.length; j++){
				if(!endSet[j]){
					if(distance[j] > distance[vertexForBefore.vertexNumber] + graph[vertexForBefore.vertexNumber][j]){
						distance[j] = distance[vertexForBefore.vertexNumber] + graph[vertexForBefore.vertexNumber][j];
						CountryVertex vertexAfter = new CountryVertex(j, distance[j]);
						priorityQueue.offer(vertexAfter);
					}//ActionRelaxtion
				}//CheckVisited
			}//forDijkstra
			
		}//for(N-1)

		return distance[endStation];
	}// dijkstra

}// class
