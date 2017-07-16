package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SaleTicket2 {

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
			}

			for (int i = 0; i < numberOfEdge; i++) {
				int aStation = sc.nextInt();
				int bStation = sc.nextInt();
				graph[aStation][bStation] = graph[bStation][aStation] = sc.nextInt();
			} // forI

			int step = sc.nextInt();

			for (int i = 0; i < step; i++) {

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

		int[] distance = new int[graph.length]; //시작점에서 각 정점까지의 거리
		boolean[] endSet = new boolean[graph.length];
		// 최솟값을 찾았으면  여기에 추가한다. -> 여기 들어간건 갱신할 일 없음 (여기에 속한 정점 index로  distance[]에서 꺼내면 정점에서 그 지점까지 최단거리

		for(int i=0; i<endSet.length; i++){
			endSet[i] = false;
		}//초기화
		for (int i = 0; i < graph[0].length; i++) {
			distance[i] = Integer.MAX_VALUE / 2;
		}// 최솟값 계산을 MIN 연산으로 하니까 원래는 무한대 값이 들어가야하는데 double 형에서 가능해서  INT형 MAX값으로 저장

		distance[startStation] = 0; //시작 점
		
		for (int i = 0; i < graph.length - 1; i++) {

			int min = Integer.MAX_VALUE / 2;
			int index = -1 ;

			for (int j = 0; j < distance.length; j++) {
				if (!endSet[j] && min > distance[j]) {
					min = distance[j];
					index = j;
				}
			} // forMinSearch   한 스텝마다  endset에서 방문하지 않은 정점들 속에서 distance값이 최소인것을 찾고

			endSet[index] = true; // 그 정점에서 파생되는 최단거리를 구할꺼니까 방문했다고 변경

			for (int j = 1; j < distance.length; j++) {
				if (distance[j] > distance[index] + graph[index][j] ) {
					distance[j] = distance[index] + graph[index][j];
				}
			} // forRelaxtion 최단 거리를 비교해서 업데이트 

		}//forSearchShortestPath  이거 끝나면 distance[]배열에는 시작 점 부터 각 정점들까지의 최단거리가 저장되어 있다.

		
		return distance[endStation]; 
	}// dijkstra

}// class
