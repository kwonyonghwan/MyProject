package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.PortableServer.POA;

class Position {
	int positionI;
	int positionJ;
	int borkenWallCount;

	public Position(int i, int j, int k) {
		this.positionI = i;
		this.positionJ = j;
		this.borkenWallCount = k;
	}
}

public class BrokenWallMove2 {

	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int minResult;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/BrokenWallMove.txt"));

		// Scanner sc = new Scanner(System.in);

		int sizeOfI = sc.nextInt();
		int sizeOfJ = sc.nextInt();
		minResult = Integer.MAX_VALUE;
		sc.nextLine();

		int[][] graph = new int[sizeOfI][sizeOfJ];

		for (int i = 0; i < sizeOfI; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < sizeOfJ; j++) {
				graph[i][j] = Character.getNumericValue(temp.charAt(j));
			}
		} // forSetting

		Position startPosition = new Position(0, 0, 0);

		boolean[][][] visitiedMap = new boolean[graph.length][graph[0].length][2];

		Queue<Position> queue = new LinkedList<Position>();
		int length = 0;

		visitiedMap[0][0][0] = true;
		queue.offer(startPosition);

		while (!queue.isEmpty()) {

			int queueSize = queue.size();
			length++;

			for (int i = 0; i < queueSize; i++) {

				Position nowPosition = queue.poll();
				if (nowPosition.positionI == graph.length - 1 && nowPosition.positionJ == graph[0].length - 1) {
					minResult = Math.min(minResult, length);
				}

				if (nowPosition.borkenWallCount > 0) {

					for (int j = 0; j < 4; j++) {

						if (nowPosition.positionI + directionList[j][0] > -1
								&& nowPosition.positionJ + directionList[j][1] > -1
								&& nowPosition.positionI + directionList[j][0] < graph.length
								&& nowPosition.positionJ + directionList[j][1] < graph[0].length
								&& graph[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
										+ directionList[j][1]] < 1
								&& !visitiedMap[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
										+ directionList[j][1]][nowPosition.borkenWallCount]) {
							Position nextPosition = new Position(nowPosition.positionI + directionList[j][0],
									nowPosition.positionJ + directionList[j][1], 1);
							visitiedMap[nextPosition.positionI][nextPosition.positionJ][1] = true;

							queue.offer(nextPosition);
						} // if
					} // forNextDirection(1Broken)

				} else {

					for (int j = 0; j < 4; j++) {

						if (nowPosition.positionI + directionList[j][0] > -1
								&& nowPosition.positionJ + directionList[j][1] > -1
								&& nowPosition.positionI + directionList[j][0] < graph.length
								&& nowPosition.positionJ + directionList[j][1] < graph[0].length
								&& graph[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
										+ directionList[j][1]] < 1
								&& !visitiedMap[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
										+ directionList[j][1]][nowPosition.borkenWallCount]) {

							Position nextPosition = new Position(nowPosition.positionI + directionList[j][0],
									nowPosition.positionJ + directionList[j][1], 0);
							visitiedMap[nextPosition.positionI][nextPosition.positionJ][0] = true;

							queue.offer(nextPosition);

						} // if
					} // forNextDirection(0Broken->0)

					for (int j = 0; j < 4; j++) {

						if (nowPosition.positionI + directionList[j][0] > -1
								&& nowPosition.positionJ + directionList[j][1] > -1
								&& nowPosition.positionI + directionList[j][0] < graph.length
								&& nowPosition.positionJ + directionList[j][1] < graph[0].length
								&& graph[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
										+ directionList[j][1]] > 0
								&& !visitiedMap[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
										+ directionList[j][1]][nowPosition.borkenWallCount + 1]) {

							Position nextPosition = new Position(nowPosition.positionI + directionList[j][0],
									nowPosition.positionJ + directionList[j][1], 1);
							visitiedMap[nextPosition.positionI][nextPosition.positionJ][1] = true;

							queue.offer(nextPosition);

						} // if
					} // forNextDirection(0Broken->1)
				} // if0Broken

			} // forOneStep
		} // whileBFS

		if (minResult > Integer.MAX_VALUE / 2) {
			System.out.println(-1);
		} else {
			System.out.println(minResult);
		}

	}// main
}// class
