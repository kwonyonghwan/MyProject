package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SanggeunTravel {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/SanggeunTravel.txt"));

		// Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int test_Case;

		for (test_Case = 1; test_Case <= T; test_Case++) {

			int countOfNation = sc.nextInt() + 1;
			int countOfAirplane = sc.nextInt();

			int[][] graph = new int[countOfNation][countOfNation];
			boolean[] visitiedMap = new boolean[countOfNation];
			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < countOfAirplane; i++) {
				int tempI = sc.nextInt();
				int tempJ = sc.nextInt();
				graph[tempI][tempJ] = graph[tempJ][tempI] = 1;
			} // forSetting

			int result = 0;
			for (int i = 1; i < countOfNation; i++) {

				if (!visitiedMap[i]) {
					result++;
					visitiedMap[i] = true;
					queue.offer(i);

					while (!queue.isEmpty()) {

						int nowPosition = queue.poll();

						for (int j = 1; j < countOfNation; j++) {

							if (graph[nowPosition][j] > 0 && !visitiedMap[j]) {

								visitiedMap[j] = true;
								queue.offer(j);

							}

						}

					} // while

				}

			} // bFSAll

			System.out.println(result);
		} // forTestCase

	}// main

}// class
