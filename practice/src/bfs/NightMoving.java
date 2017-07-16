package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.PortableServer.POA;

import algorithm.Position;

public class NightMoving {

	static int[][] nextPositionList = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 },
			{ 1, -2 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/NightMoving.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfMap = sc.nextInt();
			int[][] distanceMap = new int[sizeOfMap][sizeOfMap];
			boolean[][] visitedMap = new boolean[sizeOfMap][sizeOfMap];

			Queue<Position> queue = new LinkedList<Position>();
			Position startPosition = new Position(sc.nextInt(), sc.nextInt());
			Position endPosition = new Position(sc.nextInt(), sc.nextInt());
			queue.offer(startPosition);

			while (!queue.isEmpty()) {
				Position tempPosition = queue.poll();
				if (tempPosition.positionI == endPosition.positionI && tempPosition.positionJ == endPosition.positionJ) {
					queue = null;
					break;
				}
				
				for (int i=0; i < 8; i++) {
					if (tempPosition.positionI + nextPositionList[i][0] > -1
							&& tempPosition.positionI + nextPositionList[i][0] < sizeOfMap
							&& tempPosition.positionJ + nextPositionList[i][1] > -1
							&& tempPosition.positionJ + nextPositionList[i][1] < sizeOfMap
							&& !visitedMap[tempPosition.positionI + nextPositionList[i][0]][tempPosition.positionJ + nextPositionList[i][1]]) {

						Position nextPosition = new Position(tempPosition.positionI + nextPositionList[i][0], tempPosition.positionJ + nextPositionList[i][1]);
						visitedMap[nextPosition.positionI][nextPosition.positionJ] = true;
						distanceMap[nextPosition.positionI][nextPosition.positionJ] = distanceMap[tempPosition.positionI][tempPosition.positionJ] + 1;
						queue.offer(nextPosition);
					}
				}

			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + distanceMap[endPosition.positionI][endPosition.positionJ]);
		} // forTest

	}// main

}// class

