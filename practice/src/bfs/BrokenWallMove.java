/*package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.PortableServer.POA;

public class BrokenWallMove {

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

		for (int i = 0; i < sizeOfI; i++) {
			for (int j = 0; j < sizeOfJ; j++) {
				if((i == 0 && j == 0)){
					BFS(graph);
				}
				
				if (graph[i][j] == 1) {
					graph[i][j] = 0;
					BFS(graph);
				
					graph[i][j] = 1;
				}
			}
		}
		if (minResult > Integer.MAX_VALUE / 2) {
			System.out.println(-1);
		} else {
			System.out.println(minResult);
		}

	}// main

	private static void BFS(int[][] graph) {

		Position startPosition = new Position(0, 0);
		boolean[][] visitiedMap = new boolean[graph.length][graph[0].length];
		Queue<Position> queue = new LinkedList<Position>();
		int length = 0;

		queue.offer(startPosition);
		visitiedMap[startPosition.positionI][startPosition.positionJ] = true;

		while (!queue.isEmpty()) {

			int queueSize = queue.size();
			length++;

			for (int i = 0; i < queueSize; i++) {

				Position nowPosition = queue.poll();
			

				for (int j = 0; j < 4; j++) {

					if (nowPosition.positionI + directionList[j][0] > -1
							&& nowPosition.positionJ + directionList[j][1] > -1
							&& nowPosition.positionI + directionList[j][0] < graph.length
							&& nowPosition.positionJ + directionList[j][1] < graph[0].length
							&& graph[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
									+ directionList[j][1]] < 1
							&& !visitiedMap[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ
									+ directionList[j][1]]) {

						Position nextPosition = new Position(nowPosition.positionI + directionList[j][0],
								nowPosition.positionJ + directionList[j][1]);
						visitiedMap[nextPosition.positionI][nextPosition.positionJ] = true;
						
						if (nextPosition.positionI == graph.length - 1
								&& nextPosition.positionJ == graph[0].length - 1) {
							minResult = Math.min(minResult, length)+1;
							return;
						}
						
						queue.offer(nextPosition);
					}

				}

			}

		} // whileBFS
		System.out.println(length);
	}

}// class
*/