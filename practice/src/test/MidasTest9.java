package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MidasTest9 {

	static int[][] directionMove = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };
	static int numberOfN;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest9.txt"));

		// Scanner sc = new Scanner(System.in);

		numberOfN = sc.nextInt() + 2;
		int result = 0;

		int[][] graph = new int[numberOfN][numberOfN];
		boolean[][] visitedGraph = new boolean[numberOfN][numberOfN];

		for (int i = 0; i < numberOfN; i++) {
			graph[0][i] = graph[i][0] = graph[numberOfN - 1][i] = graph[i][numberOfN - 1] = -1;
		} // forSetting
		for (int i = 1; i < numberOfN - 1; i++) {
			for (int j = 1; j < numberOfN - 1; j++) {
				graph[i][j] = sc.nextInt();
			}
		} // forSetting

		for (int i = 0; i < numberOfN - 1; i++) {
			for (int j = 0; j < numberOfN - 1; j++) {
				if (graph[i][j] == 1 && !visitedGraph[i][j]) {
					result++;
					bfs(graph, visitedGraph, i, j);
				}
			}
		}

		System.out.println(result);

	}// main

	private static void bfs(int[][] graph, boolean[][] visitedGraph, int positionI, int positionJ) {

		Positon tempPosition = new Positon(positionI, positionJ);
		Queue<Positon> queue = new LinkedList<Positon>();
		queue.offer(tempPosition);

		while (!queue.isEmpty()) {
			Positon nowPosition = queue.poll();
			visitedGraph[nowPosition.I][nowPosition.J] = true;

			for (int i = 0; i < 4; i++) {
				Positon nextPosition = new Positon(nowPosition.I + directionMove[i][0],
						nowPosition.J + directionMove[i][1]);
				if (graph[nextPosition.I][nextPosition.J] == 1 && !visitedGraph[nextPosition.I][nextPosition.J]) {
					queue.offer(nextPosition);
				}

			} // forNextPosition

		} // whileBFS

	}// main

}// class

class Positon {
	int I;
	int J;

	public Positon(int i, int j) {
		this.I = i;
		this.J = j;
	}
}
