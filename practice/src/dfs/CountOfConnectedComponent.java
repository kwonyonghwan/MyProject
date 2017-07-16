package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountOfConnectedComponent {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/CountOfConnectedComponent.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfVertex = sc.nextInt() + 1;
			int numberOfEdge = sc.nextInt();
			int countOfConnectedComponent = 0;

			boolean[][] graph = new boolean[numberOfVertex][numberOfVertex];
			boolean[] vertexList = new boolean[numberOfVertex];

			for (int i = 0; i < numberOfEdge; i++) {
				int positionx = sc.nextInt();
				int positiony = sc.nextInt();
				graph[positionx][positiony] = graph[positiony][positionx] = true;
			} // forSetting

			for (int i = 1; i < graph.length; i++) {
				if (!vertexList[i]) {
					countOfConnectedComponent++;
					dfs(graph, vertexList, i);
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + countOfConnectedComponent);
		} // forTest

	}// main

	private static void dfs(boolean[][] graph, boolean[] vertexList, int start) {

		vertexList[start] = true;

		for (int i = 1; i < graph.length; i++) {
			if (graph[start][i] && !vertexList[i]) {
				dfs(graph, vertexList, i);
			}
		}

	}

}// class
