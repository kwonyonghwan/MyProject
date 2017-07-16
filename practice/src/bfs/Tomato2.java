package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Position;

public class Tomato2 {

	static int[][] directionList = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/Tomato2.txt"));

		// Scanner sc = new Scanner(System.in);

		int numberOfJ = sc.nextInt();
		int numberOfI = sc.nextInt();
		int numberOfK = sc.nextInt();
		int resultDay = -1;
		int[][][] graph = new int[numberOfI][numberOfJ][numberOfK];

		for (int k = 0; k < numberOfK; k++) {
			for (int i = 0; i < numberOfI; i++) {
				for (int j = 0; j < numberOfJ; j++) {
					graph[i][j][k] = sc.nextInt();
				}
			}
		} // forSetting

		Queue<Location> queue = new LinkedList<Location>();

		for (int k = 0; k < numberOfK; k++) {
			for (int i = 0; i < numberOfI; i++) {
				for (int j = 0; j < numberOfJ; j++) {
					if (graph[i][j][k] == 1) {
						queue.offer(new Location(i, j, k));
					}
				}
			}
		} // searchFistStep

		while (!queue.isEmpty()) {

			int queueSize = queue.size();

			resultDay++;
			for (int i = 0; i < queueSize; i++) {

				Location nowLocation = queue.poll();
				for (int j = 0; j < 6; j++) {
					if (nowLocation.positionI + directionList[j][0] > -1
							&& nowLocation.positionI + directionList[j][0] < graph.length
							&& nowLocation.positionJ + directionList[j][1] > -1
							&& nowLocation.positionJ + directionList[j][1] < graph[0].length
							&& nowLocation.positionK + directionList[j][2] > -1
							&& nowLocation.positionK + directionList[j][2] < graph[0][0].length
							&& graph[nowLocation.positionI + directionList[j][0]][nowLocation.positionJ
									+ directionList[j][1]][nowLocation.positionK + directionList[j][2]] == 0) {
						Location nextLocation = new Location(nowLocation.positionI + directionList[j][0],
								nowLocation.positionJ + directionList[j][1],
								nowLocation.positionK + directionList[j][2]);
						graph[nextLocation.positionI][nextLocation.positionJ][nextLocation.positionK] = 1;
						queue.offer(nextLocation);
					}

				} // fordirection

			} // forOneDay

		} // whileBFS
		for (int k = 0; k < numberOfK; k++) {
			for (int i = 0; i < numberOfI; i++) {
				for (int j = 0; j < numberOfJ; j++) {
					if (graph[i][j][k] == 0) {
						resultDay = -1;
					}
				}
			} // searchFistStep
		}

		System.out.println(resultDay);
	}// main

}// class

class Location {
	public int positionI;
	public int positionJ;
	public int positionK;

	public Location(int i, int j, int k) {
		this.positionI = i;
		this.positionJ = j;
		this.positionK = k;
	}

}