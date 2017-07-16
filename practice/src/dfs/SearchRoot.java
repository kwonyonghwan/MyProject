package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchRoot {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/searchRoot.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfVertex = sc.nextInt() + 1;
			int[][] graph = new int[numberOfVertex][numberOfVertex];
			int[][] resultGraph = new int[numberOfVertex][numberOfVertex];

			for (int i = 1; i < numberOfVertex; i++) {
				for (int j = 1; j < numberOfVertex; j++) {
					graph[i][j] = sc.nextInt();
				}
			}//forSetting

			for (int i = 1; i < numberOfVertex; i++) {
				for (int j = 1; j < numberOfVertex; j++) {
					if (graph[i][j] == 1 && resultGraph[i][j] == 0) {
						dfs(graph, resultGraph[i], j);
					}
				}
			} //dfsAll

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			for (int i = 1; i < numberOfVertex; i++) {
				for (int j = 1; j < numberOfVertex; j++) {
					System.out.print(resultGraph[i][j] + " ");
				}
				System.out.println();
			}

		} // forTest

	}// main

	private static void dfs(int[][] graph, int[] resultGraph, int startPositon) {
		
		resultGraph[startPositon] = 1;
		for (int i = 1; i < graph[0].length; i++) {
			if (graph[startPositon][i] == 1 && resultGraph[i] == 0) {
				dfs(graph, resultGraph, i);
			}
		}

	}//dfs()

}// class
