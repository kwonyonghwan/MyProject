package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class History2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/History.txt"));

		// Scanner sc = new Scanner(System.in);
		int countOfVertex = sc.nextInt() + 1;
		int countOfEdge = sc.nextInt();
		int[][] graph = new int[countOfVertex][countOfVertex];

		for (int i = 1; i < countOfVertex; i++) {
			for (int j = 1; j < countOfVertex; j++){
				graph[i][j] =99999;
			}
		}

		for (int i = 0; i < countOfEdge; i++) {
			int startVertex = sc.nextInt();
			int endVertex = sc.nextInt();
			graph[startVertex][endVertex] = 1;
		} // forSetting

		for (int k = 1; k < countOfVertex; k++) {
			for (int j = 1; j < countOfVertex; j++) {
				for (int i = 1; i < countOfVertex; i++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		} // forMakeFloyed

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int startVetex = sc.nextInt();
			int endVertex = sc.nextInt();

			if (graph[startVetex][endVertex] !=99999) {
				System.out.println(-1);
			} else if (graph[endVertex][startVetex] !=99999) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		} // forTestCase

	}// main
}// class
