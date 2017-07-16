package bfs;

import java.beans.Visibility;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hideAndSeek2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int startLocation = 0;
		int endLocation = 100000;
		//testCase (0, 100000), (100000, 0), (1,10)

		boolean[] visitedGraph = new boolean[100001];

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> nextQueue = new LinkedList<Integer>();

		queue.offer(startLocation);

		int count = 0;
		int shortestLength = 100001;
		int step = 0;
		boolean findEndLocation = false;

		while (!queue.isEmpty()) {
			
			step++;

			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {

				int nowLocation = queue.poll();
				visitedGraph[nowLocation] = true;

				if (nowLocation == endLocation) {
					findEndLocation = true;
					count++;
				}

				if (!findEndLocation) {
					if ((nowLocation - 1) > -1 && !visitedGraph[nowLocation - 1]) {
						queue.offer(nowLocation - 1);
					}

					if ((nowLocation + 1) < 100001 && !visitedGraph[nowLocation + 1]) {
						queue.offer(nowLocation + 1);
					}

					if ((nowLocation * 2) < 100001 && !visitedGraph[nowLocation * 2]) {
						queue.offer(nowLocation * 2);
					}
				}

			} // forStep
			
			if (findEndLocation) {
				break;
			}

		} // whileBFS

		System.out.println((step - 1));
		System.out.println(count);

	}// main

}// class
