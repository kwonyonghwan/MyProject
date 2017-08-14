package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Position;

public class Escape {

	static int[][] directList = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/Escape.txt"));

		// Scanner sc = new Scanner(System.in);

		int numberOfI = sc.nextInt() + 2;
		int numberOfJ = sc.nextInt() + 2;

		Queue<Position> hedgehogQueue = new LinkedList<Position>();
		Queue<Position> waterQueue = new LinkedList<Position>();

		char[][] graph = new char[numberOfI][numberOfJ];
		boolean[][] visitiedgraph = new boolean[numberOfI][numberOfJ];
		sc.nextLine();
		Position endPosition = new Position(0, 0);
		
		for (int i = 1; i < numberOfI - 1; i++) {
			String temp = sc.nextLine();
			for (int j = 1; j < numberOfJ - 1; j++) {
				char charTemp = temp.charAt(j - 1);
				if (charTemp == 'S') {
					Position startPosition = new Position(i, j);
					visitiedgraph[i][j] = true;
					hedgehogQueue.offer(startPosition);
				} else if (charTemp == '*') {
					Position waterPosition = new Position(i, j);
					waterQueue.offer(waterPosition);
				}
				graph[i][j] = charTemp;
			}
		} // forSetting

		int step = -1;
		// bfs 1step
		boolean findFlag = false;

		while (!hedgehogQueue.isEmpty() || !waterQueue.isEmpty()) {
			step++;

			int hedgehogQueueSize = hedgehogQueue.size();
			int waterQueueSize = waterQueue.size();

			for (int i = 0; i < waterQueueSize; i++) {
				Position nowPosition = waterQueue.poll();
				for (int j = 0; j < 4; j++) {
					Position nextPosition = new Position(nowPosition.positionI + directList[j][0],
							nowPosition.positionJ + directList[j][1]);
					if (graph[nextPosition.positionI][nextPosition.positionJ] == '.') {
						graph[nextPosition.positionI][nextPosition.positionJ] = '*';
						waterQueue.offer(nextPosition);
					}
				} // forNext

			}//warterQueueBFS

			for (int i = 0; i < hedgehogQueueSize; i++) {
				Position nowPosition = hedgehogQueue.poll();
				for (int j = 0; j < 4; j++) {
					if (findFlag) {
						break;
					}
					Position nextPosition = new Position(nowPosition.positionI + directList[j][0], nowPosition.positionJ + directList[j][1]);
					if (graph[nextPosition.positionI][nextPosition.positionJ] == '.' && !visitiedgraph[nextPosition.positionI][nextPosition.positionJ]) {
						visitiedgraph[nextPosition.positionI][nextPosition.positionJ] = true;
						hedgehogQueue.offer(nextPosition);
					}//nextStep
					if (graph[nextPosition.positionI][nextPosition.positionJ] == 'D') {
						findFlag = true;
						System.out.println(step + 1);
						waterQueue.clear();
						hedgehogQueue.clear();
						break;
					}//findDestination
				}
			} // forhedgehogQueueBFS

		} // while
		if (!findFlag) {
			System.out.println("KAKTUS");
		}

	}// main

}// class