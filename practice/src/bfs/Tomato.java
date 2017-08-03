package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Position;

public class Tomato {

	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/Tomato.txt"));

		// Scanner sc = new Scanner(System.in);

		int numberOfJ = sc.nextInt();
		int numberOfI = sc.nextInt();
		int resultDay = -1;
		int[][] graph = new int[numberOfI][numberOfJ];
		Queue<Position> queue = new LinkedList<Position>();

		for (int i = 0; i < numberOfI; i++) {
			for (int j = 0; j < numberOfJ; j++) {
				graph[i][j] = sc.nextInt();
				if (graph[i][j] == 1) {
					queue.offer(new Position(i, j));
				}
			}
		} // forSetting

		while (!queue.isEmpty()) {

			int queueSize = queue.size();

			resultDay++;
			for (int i = 0; i < queueSize; i++) {

				Position nowPosition = queue.poll();
				
				System.out.println("----------------------------------------------s");
				for(int k =0; k<graph.length; k++){
					for (int j = 0; j < graph[0].length; j++) {
						System.out.print(graph[k][j]+" ");
					}	
					System.out.println();
				}
				
				
				
				for (int j = 0; j < 4; j++) {
					if (nowPosition.positionI + directionList[j][0] > -1
							&& nowPosition.positionI + directionList[j][0] < graph.length
							&& nowPosition.positionJ + directionList[j][1] > -1
							&& nowPosition.positionJ + directionList[j][1] < graph[0].length
							&& graph[nowPosition.positionI + directionList[j][0]][nowPosition.positionJ + directionList[j][1]] == 0) {
						Position nextPosition = new Position(nowPosition.positionI + directionList[j][0], nowPosition.positionJ + directionList[j][1]);
						graph[nextPosition.positionI][nextPosition.positionJ] = 1;
						queue.offer(nextPosition);
					}

				} // fordirection

			} // forOneDay

		} // whileBFS

		for (int i = 0; i < numberOfI; i++) {
			for (int j = 0; j < numberOfJ; j++) {
				if (graph[i][j] == 0) {
					resultDay = -1;
				}
			}
		} // searchFistStep

		System.out.println(resultDay);
	}// main

}// class
