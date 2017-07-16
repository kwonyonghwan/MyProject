package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*class Position {
int I;
int J;

public Position(int i, int j) {
	this.I = i;
	this.J = j;
}
}*/

import algorithm.Position;

public class TreasureIsland {

	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int maxLength = Integer.MIN_VALUE;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/TreasureIsland.txt"));

		// Scanner sc = new Scanner(System.in);

		int sizeOfI = sc.nextInt();
		int sizeOfJ = sc.nextInt();
		sc.nextLine();

		char[][] graph = new char[sizeOfI][sizeOfJ];

		for (int i = 0; i < sizeOfI; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < sizeOfJ; j++) {
				graph[i][j] = temp.charAt(j);
			}
		}//forSetting

		for (int i = 0; i < sizeOfI; i++) {
			for (int j = 0; j < sizeOfJ; j++) {
				if (graph[i][j] == 'L') {
					Position startPosition = new Position(i, j);
					BFS(startPosition, graph);
				}
			}
		}//forBFSAll
		
		maxLength -= 1;
		System.out.println(maxLength);

	}// main

	private static void BFS(Position startPosition, char[][] graph) {

		Queue<Position> queue = new LinkedList<Position>();
		queue.offer(startPosition);
		boolean[][] visitedMap = new boolean[graph.length][graph[0].length];
		visitedMap[startPosition.positionI][startPosition.positionJ] = true;
		int length = 0;

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			length++;
			for (int i = 0; i < queueSize; i++) {
				Position nowPosition = queue.poll();

				for (int j = 0; j < 4; j++) {

					if (nowPosition.positionI + directionList[j][0] > -1
							&& nowPosition.positionI + directionList[j][0] < graph.length
							&& nowPosition.positionJ + directionList[j][1] > -1
							&& nowPosition.positionJ + directionList[j][1] < graph[0].length
							&& graph[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
									+ directionList[j][1]] == 'L'
							&& !visitedMap[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
									+ directionList[j][1]]) {
						Position nextPosition = new Position(nowPosition.positionI + directionList[j][0],
								nowPosition.positionJ + directionList[j][1]);
						visitedMap[nextPosition.positionI][nextPosition.positionJ] = true;
						queue.offer(nextPosition);
					}

				} // forDirection
			} // forOneStep
		}//whileBFS
		maxLength = Math.max(maxLength, length);
	}//methodBFS()

}// class