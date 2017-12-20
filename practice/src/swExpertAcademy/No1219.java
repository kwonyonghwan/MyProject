package swExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class No1219 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/swExpertAcademy/No1219.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_Case;

		for (test_Case = 1; test_Case <= 10; test_Case++) {
			int temp = sc.nextInt();
			int result = 0;
			int sizeOfInputData = sc.nextInt();

			int[] graph1 = new int[100];
			int[] graph2 = new int[100];
			boolean[] visitiedMap = new boolean[100];

			for (int i = 0; i < sizeOfInputData; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if (graph1[start] < 1) {
					graph1[start] = end;
				} else {
					graph2[start] = end;
				}
			} // forSetting

			Queue<Integer> queue = new LinkedList<>();

			queue.offer(0);

			while (!queue.isEmpty()) {
				int now = queue.poll();

				if (graph1[now] > 0 && !visitiedMap[graph1[now]]) {
					visitiedMap[graph1[now]] = true;
					queue.offer(graph1[now]);
				}

				if (graph2[now] > 0 && !visitiedMap[graph2[now]]) {
					visitiedMap[graph2[now]] = true;
					queue.offer(graph2[now]);
				}

				if (visitiedMap[99]) {
					result = 1;
					break;
				}
			} // while

			System.out.println("#" + test_Case + " " + result);

		} // forTestCase

	}// main

}// class