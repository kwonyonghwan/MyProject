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

public class StoneBriedge {

	static int[] nextDirection = { 1, -1, 1, -1, 1, -1, 1, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/StoneBriedge.txt"));

		// Scanner sc = new Scanner(System.in);

		int powerA = sc.nextInt();
		int powerB = sc.nextInt();
		int startPosition = sc.nextInt();
		int endPosition = sc.nextInt();

		for (int i = 2; i < 4; i++) {
			nextDirection[i] *= powerA;
			nextDirection[i + 2] *= powerB;
		}
		nextDirection[6] *= powerA;
		nextDirection[7] *= powerB;

		int[] graph = new int[100001];
		boolean[] visitiedMap = new boolean[100001];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(startPosition);
		visitiedMap[startPosition] = true;
		int step = -1;

		while (!queue.isEmpty()) {

			int queueSize = queue.size();
			step++;

			for (int i = 0; i < queueSize; i++) {

				int nowPosition = queue.poll();

				if (nowPosition == endPosition) {
					System.out.println(step);
					return;
				}
				
				
				for (int j = 0; j < 6; j++) {

					if (nowPosition + nextDirection[j] > -1 && nowPosition + nextDirection[j] < 100001
							&& !visitiedMap[nowPosition + nextDirection[j]]) {
						int nextPosition = nowPosition + nextDirection[j];
						visitiedMap[nextPosition] = true;
						queue.offer(nextPosition);
					}
				} // forJ0~5

				for (int j = 6; j < 8; j++) {

					if (nowPosition * nextDirection[j] > -1 && nowPosition * nextDirection[j] < 100001
							&& !visitiedMap[nowPosition * nextDirection[j]]) {

						int nextPosition = nowPosition * nextDirection[j];

						visitiedMap[nextPosition] = true;
						queue.offer(nextPosition);
					}
				} // forJ6~7

			}

		} // whileBfs

		System.out.println(step);
	}// main

}// class