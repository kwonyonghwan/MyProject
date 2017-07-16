package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Position;

public class MakeBridge {
	static int shortestDistance;
	static int[][] directionList = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };//

	public static void main(String[] args) throws FileNotFoundException {

		shortestDistance = Integer.MAX_VALUE;
		Scanner sc = new Scanner(new FileInputStream("src/bfs/MakeBridge2.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfN = sc.nextInt();
			int[][] graph = new int[numberOfN][numberOfN];
			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfN; j++) {
					graph[i][j] = sc.nextInt();
				}
			} // forSetting

			int ClassificationNumber = 2;

			boolean[][] visitedClassificationGraph = new boolean[graph.length][graph[0].length];
			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfN; j++) {
					if (graph[i][j] == 1 && !visitedClassificationGraph[i][j]) {
						classificationBfs(graph, visitedClassificationGraph, i, j, ClassificationNumber);
						ClassificationNumber++;
					}
				}
			} // forClassification

			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfN; j++) {
					if (graph[i][j] > 1) {
						findShortestBfs(graph, i, j, graph[i][j]);
					}
				}
			} // forFindShortestRoot

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + shortestDistance);
		} // forTest

	}// main

	private static void findShortestBfs(int[][] graph, int positionI, int positionJ, int classificationNumber) {

		int[][] distanceGraph = new int[graph.length][graph[0].length];
		boolean[][] visitedGraph = new boolean[graph.length][graph[0].length];
		Queue<Position> queue = new LinkedList<Position>();
		Position temp = new Position(positionI, positionJ);
		queue.offer(temp);

		while (!queue.isEmpty()) {
			Position tempPosition = queue.poll();
			visitedGraph[tempPosition.positionI][tempPosition.positionJ] = true;

			if (distanceGraph[tempPosition.positionI][tempPosition.positionJ] > shortestDistance) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				Position nextPosition = new Position(tempPosition.positionI + directionList[i][0],
						tempPosition.positionJ + directionList[i][1]);
				if (nextPosition.positionI > -1 && nextPosition.positionI < graph.length && nextPosition.positionJ > -1
						&& nextPosition.positionJ < graph[0].length
						&& graph[nextPosition.positionI][nextPosition.positionJ] != classificationNumber
						&& !visitedGraph[nextPosition.positionI][nextPosition.positionJ]) {

					if (graph[nextPosition.positionI][nextPosition.positionJ] != 0) {
						shortestDistance = Math.min(shortestDistance,
								distanceGraph[tempPosition.positionI][tempPosition.positionJ]);
						break;
					}
					distanceGraph[nextPosition.positionI][nextPosition.positionJ] = distanceGraph[tempPosition.positionI][tempPosition.positionJ]
							+ 1;
					queue.offer(nextPosition);
				}
			} // forDirection

		} // bfswhile

	}// findShortestBfs()

	private static void classificationBfs(int[][] graph, boolean[][] visitedGraph, int positionI, int positionJ,
			int classificationNumber) {
		Queue<Position> queue = new LinkedList<Position>();

		Position temp = new Position(positionI, positionJ);
		queue.offer(temp);

		while (!queue.isEmpty()) {
			Position tempPosition = queue.poll();

			visitedGraph[tempPosition.positionI][tempPosition.positionJ] = true;

			graph[tempPosition.positionI][tempPosition.positionJ] = classificationNumber;
			for (int i = 0; i < 4; i++) {
				Position nextPosition = new Position(tempPosition.positionI + directionList[i][0],
						tempPosition.positionJ + directionList[i][1]);
				if (nextPosition.positionI > -1 && nextPosition.positionI < graph.length && nextPosition.positionJ > -1
						&& nextPosition.positionJ < graph[0].length
						&& graph[nextPosition.positionI][nextPosition.positionJ] == 1
						&& !visitedGraph[nextPosition.positionI][nextPosition.positionJ]) {
					graph[nextPosition.positionI][nextPosition.positionJ] = classificationNumber;
					queue.offer(nextPosition);
				}
			} // forDirection
		} // bfsWhile

	}// classificationBfs()

}// class