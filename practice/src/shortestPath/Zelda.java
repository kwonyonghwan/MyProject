package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

class Position implements Comparable<Position> {
	int positionI;
	int positionJ;
	int weight;

	public Position(int positionI, int positionJ, int weight) {
		this.positionI = positionI;
		this.positionJ = positionJ;
		this.weight = weight;
	}

	@Override
	public int compareTo(Position target) {
		if (this.weight > target.weight) {
			return 1;
		} else if (this.weight < target.weight) {
			return -1;
		}
		return 0;
	}
}

public class Zelda {
	static int[][] nextDirection = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/Zelda.txt"));

		int testCase = 1;
		while (true) {

			int sizeOfMap = sc.nextInt() + 1;
			if (sizeOfMap == 1) {
				break;
			}

			int[][] graph = new int[sizeOfMap][sizeOfMap];

			for (int i = 1; i < sizeOfMap; i++) {
				for (int j = 1; j < sizeOfMap; j++) {
					graph[i][j] = sc.nextInt();
				}
			} // forSetting

			Position startPosition = new Position(1, 1, 0);
			PriorityQueue<Position> priorityQueue = new PriorityQueue<Position>();
			priorityQueue.offer(startPosition);

			int[][] distanceMap = new int[sizeOfMap][sizeOfMap];
			boolean[][] visitedMap = new boolean[sizeOfMap][sizeOfMap];
			for (int i = 1; i < sizeOfMap; i++) {
				for (int j = 1; j < sizeOfMap; j++) {
					distanceMap[i][j] = Integer.MAX_VALUE / 2;
				}
			} // forSetting
			distanceMap[1][1] = graph[1][1];

			while (!priorityQueue.isEmpty()) {
				Position nowPosition = priorityQueue.poll();
				visitedMap[nowPosition.positionI][nowPosition.positionJ] = true;

				for (int i = 0; i < 4; i++) {
					if (nowPosition.positionI + nextDirection[i][0] > 0
							&& nowPosition.positionJ + nextDirection[i][1] > 0
							&& nowPosition.positionI + nextDirection[i][0] < sizeOfMap
							&& nowPosition.positionJ + nextDirection[i][1] < sizeOfMap
							&& !visitedMap[nowPosition.positionI + nextDirection[i][0]][nowPosition.positionJ
									+ nextDirection[i][1]]) {

						Position nextPosition = new Position(nowPosition.positionI + nextDirection[i][0],
								nowPosition.positionJ + nextDirection[i][1], 0);

						distanceMap[nextPosition.positionI][nextPosition.positionJ] = Math.min(
								distanceMap[nextPosition.positionI][nextPosition.positionJ],
								distanceMap[nowPosition.positionI][nowPosition.positionJ]
										+ graph[nextPosition.positionI][nextPosition.positionJ]);
						nextPosition.weight = distanceMap[nextPosition.positionI][nextPosition.positionJ];
						priorityQueue.offer(nextPosition);
					}

				}

			}//dijkstraWhile

			System.out.println("Problem " + testCase + ": " + distanceMap[sizeOfMap - 1][sizeOfMap - 1]);
			testCase++;
		} // testCaseWhile

	}// main

}// class
