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

public class MirrorSearch {

	static int[][] nextDirection = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/MirrorSearch.txt"));

		// Scanner sc = new Scanner(System.in);

		int sizeOfN = sc.nextInt() + 1;
		int sizeOfM = sc.nextInt() + 1;

		int[][] graph = new int[sizeOfN][sizeOfM];
		int[][] distanceGraph = new int[sizeOfN][sizeOfM];
		sc.nextLine();
		
		for (int i = 1; i < sizeOfN; i++) {
			char[] tempArray = sc.nextLine().toCharArray();
			for (int j = 1; j < sizeOfM; j++) {
				graph[i][j] = Character.getNumericValue(tempArray[j - 1]);
			}
		} // forSetting

		for (int i = 1; i < sizeOfN; i++) {
			for (int j = 1; j < sizeOfM; j++) {
				distanceGraph[i][j] = -1;
			}
		}

		Position startPosition = new Position(1, 1);
		Queue<Position> queue = new LinkedList<Position>();
		distanceGraph[startPosition.positionI][startPosition.positionJ] = 1;
		queue.offer(startPosition);

		while (!queue.isEmpty()) {
			Position nowPosition = queue.poll();

			if (nowPosition.positionI == sizeOfN && nowPosition.positionJ == sizeOfM) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				if (nowPosition.positionI + nextDirection[i][0] < sizeOfN && nowPosition.positionI + nextDirection[i][0] > 0
						&& nowPosition.positionJ + nextDirection[i][1] < sizeOfM && nowPosition.positionJ + nextDirection[i][1] > 0
						&& distanceGraph[nowPosition.positionI + nextDirection[i][0]][nowPosition.positionJ + nextDirection[i][1]] < 0
						&& graph[nowPosition.positionI + nextDirection[i][0]][nowPosition.positionJ + nextDirection[i][1]] == 1) {

					Position nextPosition = new Position(nowPosition.positionI + nextDirection[i][0],
							nowPosition.positionJ + nextDirection[i][1]);

					distanceGraph[nextPosition.positionI][nextPosition.positionJ] = distanceGraph[nowPosition.positionI][nowPosition.positionJ] + 1;
					queue.offer(nextPosition);
				}

			}

		} // whileBFS

		// 이 부분에서 정답을 출력하십시오.
		System.out.println(distanceGraph[sizeOfN - 1][sizeOfM - 1]);

	}// main

}// class