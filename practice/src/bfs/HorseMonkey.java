package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HorseMonkey {

	static int[][] monkeyMovingList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -2 }, { -2, -1 }, { -2, 1 },
			{ -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/HorseMonkey.txt"));

		// Scanner sc = new Scanner(System.in);
		int countOfHorse = sc.nextInt();
		int numberOfW = sc.nextInt();
		int numberOfH = sc.nextInt();

		boolean[][] graph = new boolean[numberOfH][numberOfW];
		boolean[][][] visitedMap = new boolean[numberOfH][numberOfW][countOfHorse + 1];

		for (int i = 0; i < numberOfH; i++) {
			for (int j = 0; j < numberOfW; j++) {
				if (sc.nextInt() == 0) {
					graph[i][j] = true;
				} else {
					graph[i][j] = false;
				}
			}
		} // forSetting

		Queue<Position> queue = new LinkedList<Position>();
		Position startPosition = new Position(0, 0, 0);
		visitedMap[0][0][0] = true;
		queue.offer(startPosition);
		int countOfMoving = 0;

		while (!queue.isEmpty()) {

			countOfMoving++;
			int quSize = queue.size();
			for (int i = 0; i < quSize; i++) {

				Position nowPosition = queue.poll();

				for (int j = 0; j < 4; j++) {

					if (nowPosition.positionI + monkeyMovingList[j][0] > -1
							&& nowPosition.positionI + monkeyMovingList[j][0] < graph.length
							&& nowPosition.positionJ + monkeyMovingList[j][1] > -1
							&& nowPosition.positionJ + monkeyMovingList[j][1] < graph[0].length
							&& !visitedMap[nowPosition.positionI + monkeyMovingList[j][0]][nowPosition.positionJ
									+ monkeyMovingList[j][1]][nowPosition.countOfHorse]
							&& graph[nowPosition.positionI + monkeyMovingList[j][0]][nowPosition.positionJ
									+ monkeyMovingList[j][1]]) {

						Position nextPosition = new Position(nowPosition.positionI + monkeyMovingList[j][0],
								nowPosition.positionJ + monkeyMovingList[j][1], nowPosition.countOfHorse);

						visitedMap[nextPosition.positionI][nextPosition.positionJ][nextPosition.countOfHorse] = true;
						queue.offer(nextPosition);

						if (nextPosition.positionI == (numberOfH - 1) && nextPosition.positionJ == (numberOfW - 1)) {
							System.out.println(countOfMoving);
							return;
						}

					}
				} // °øÅë

				if (nowPosition.countOfHorse < countOfHorse) {

					for (int j = 4; j < 12; j++) {
						if (nowPosition.positionI + monkeyMovingList[j][0] > -1
								&& nowPosition.positionI + monkeyMovingList[j][0] < graph.length
								&& nowPosition.positionJ + monkeyMovingList[j][1] > -1
								&& nowPosition.positionJ + monkeyMovingList[j][1] < graph[0].length
								&& !visitedMap[nowPosition.positionI + monkeyMovingList[j][0]][nowPosition.positionJ
										+ monkeyMovingList[j][1]][nowPosition.countOfHorse + 1]
								&& graph[nowPosition.positionI + monkeyMovingList[j][0]][nowPosition.positionJ
										+ monkeyMovingList[j][1]]) {
							Position nextPosition = new Position(nowPosition.positionI + monkeyMovingList[j][0],
									nowPosition.positionJ + monkeyMovingList[j][1], nowPosition.countOfHorse + 1);

							visitedMap[nextPosition.positionI][nextPosition.positionJ][nextPosition.countOfHorse] = true;
							queue.offer(nextPosition);

							if (nextPosition.positionI == (numberOfH - 1)
									&& nextPosition.positionJ == (numberOfW - 1)) {
								System.out.println(countOfMoving);
								return;
							}
						}

					} // forHorseMoving

				}//ifHorseCount

			}//forQueueSize
		} // whileBFS

		System.out.println(-1);
	}// main

}// class

class Position {
	int positionI;
	int positionJ;
	int countOfHorse;

	public Position(int i, int j, int k) {
		this.positionI = i;
		this.positionJ = j;
		this.countOfHorse = k;
	}

}