package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DegreeOfKinshipCalculation {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/DegreeOfKinshipCalculation.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int countOfPeople = sc.nextInt() + 1;
			int startPeople = sc.nextInt();
			int endPeople = sc.nextInt();
			boolean[][] kindShipMap = new boolean[countOfPeople][countOfPeople];
			boolean[][] visitedMap = new boolean[countOfPeople][countOfPeople];
			int[] degreeMap = new int[countOfPeople];

			int countOfKindship = sc.nextInt();

			for (int i = 0; i < countOfKindship; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				kindShipMap[start][end] = kindShipMap[end][start] = true;
			}

			Queue<Integer> queue = new LinkedList<Integer>();

			queue.offer(startPeople);
			int degreeOfKindship = 0;

			while (!queue.isEmpty()) {
				int nowPeople = queue.poll();

				if (nowPeople == endPeople) {
					System.out.println(degreeMap[nowPeople]);
					return;
				}

				for (int i = 1; i < countOfPeople; i++) {
					if (kindShipMap[nowPeople][i] && !visitedMap[nowPeople][i]) {
						visitedMap[nowPeople][i] = true;
						degreeMap[i] = degreeMap[nowPeople] + 1;
						queue.offer(i);
					}
				}//forNext

			}//whileBFS

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("-1");
		} // forTest

	}// main

}// class
