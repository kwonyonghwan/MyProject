/*package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ApartmentNamed {

	static int[][] directionMove = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/ApartmentNamed.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfGraph = sc.nextInt();
			boolean[][] graph = new boolean[sizeOfGraph][sizeOfGraph];
			sc.nextLine();

			for (int i = 0; i < sizeOfGraph; i++) {
				String temp = sc.nextLine();
				for (int j = 0; j < sizeOfGraph; j++) {
					if (Character.getNumericValue(temp.charAt(j)) == 1) {
						graph[i][j] = true;
					}
				}
			} // forSetting

			Queue<Position> queue = new LinkedList<Position>();
			PriorityQueue<Integer> resultQueue = new PriorityQueue<Integer>();

			for (int i = 0; i < sizeOfGraph; i++) {
				for (int j = 0; j < sizeOfGraph; j++) {

					
					if (graph[i][j]) {
						int count = 0;
						Position startPosition = new Position(i, j);
						queue.offer(startPosition);
						graph[startPosition.I][startPosition.J] = false;
						count++;

						while (!queue.isEmpty()) {
							Position nowPosition = queue.poll();

							for (int k = 0; k < 4; k++) {
								if (nowPosition.I + directionMove[k][0] > -1 && nowPosition.J + directionMove[k][1] > -1
										&& nowPosition.I + directionMove[k][0] < sizeOfGraph
										&& nowPosition.J + directionMove[k][1] < sizeOfGraph
										&& graph[nowPosition.I + directionMove[k][0]][nowPosition.J
												+ directionMove[k][1]]) {
									Position nextPotion = new Position(nowPosition.I + directionMove[k][0],
											nowPosition.J + directionMove[k][1]);

									graph[nextPotion.I][nextPotion.J] = false;
									count++;
									queue.offer(nextPotion);
								}
							} // forNextStep
						} // whileBfs

						resultQueue.offer(count);
					} // if

				}
			} // forbfs

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + resultQueue.size());
			while (!resultQueue.isEmpty()) {
				System.out.println(resultQueue.poll());
			}
		} // forTest

	}// main

}// class

class Position {
	int I;
	int J;

	public Position(int i, int j) {
		this.I = i;
		this.J = j;
	}

}
*/