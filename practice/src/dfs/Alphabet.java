package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alphabet {
	static int result = 0;
	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/Alphabet.txt"));

		// Scanner sc = new Scanner(System.in);

		int numberOfI = sc.nextInt();
		int numberOfJ = sc.nextInt();
		sc.nextLine();

		char[][] graph = new char[numberOfI][numberOfJ];
		boolean[] visitedGraph = new boolean[26];

		for (int i = 0; i < numberOfI; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < numberOfJ; j++) {
				graph[i][j] = temp.charAt(j);
			}
		} // forSetting

		visitedGraph[graph[0][0] - 'A'] = true;
		DFS(0, 0, 1, graph, visitedGraph);

		System.out.println(result);

	}// main

	private static void DFS(int positionI, int positionJ, int countOfStep, char[][] graph, boolean[] visitedGraph) {
		System.out.println(graph[positionI][positionJ]);

		for (int i = 0; i < 4; i++) {

			if (positionI + directionList[i][0] > -1 && positionI + directionList[i][0] < graph.length
					&& positionJ + directionList[i][1] > -1 && positionJ + directionList[i][1] < graph[0].length
					&& !visitedGraph[graph[positionI + directionList[i][0]][positionJ + directionList[i][1]] - 'A']) {
				visitedGraph[graph[positionI + directionList[i][0]][positionJ + directionList[i][1]] - 'A'] = true;
				DFS(positionI + directionList[i][0], positionJ + directionList[i][1], countOfStep + 1, graph,
						visitedGraph);
			} // if
		} // forI
		result = Math.max(result, countOfStep);
		visitedGraph[graph[positionI][positionJ] - 'A'] = false;
	}

}// class