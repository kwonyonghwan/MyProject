package teaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UsingQueue {

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/teaching/UsingQueue.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		sc.nextLine();

		for (test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			Queue<Integer> queue1 = new LinkedList<>();
			Queue<Integer> queue2 = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				queue1.add(sc.nextInt());
				queue2.add(i);
			}

			int maxNumber = -1;
			int count = 0;
			// -------------insertData
			// 비교 --> 최댓값 찾기
			int queueSize = queue1.size();

			for (int step = 0; step < queueSize; step++) {
				maxNumber = -1;
				
				for (int i = 0; i < queue1.size(); i++) {
					int temp = queue1.poll();
					int temp2 = queue2.poll();

					if (maxNumber < temp) {
						maxNumber = temp;
					}
					queue1.add(temp);
					queue2.add(temp2);
				} // forMax찾기

				// for돌면서 최댓값이면 출력 아니면 뒤로 넣기

				for (int i = 0; i < queue1.size(); i++) {

					int temp1 = queue1.poll();
					int temp2 = queue2.poll();

					if (maxNumber == temp1) {
						count++;
						if(temp2 == M){
							System.out.println(count);
						}
						
						break;
					}

					queue1.add(temp1);
					queue2.add(temp2);

				} // for꺼내기

			} // forStep

			// logic

		
		} // forTest

	}// main

}// class
