package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KevinBaconSixStepRule {
	static int resultDistance;
	static int resultPeopleNumber;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/KevinBaconSixStepRule.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			resultDistance = Integer.MAX_VALUE;
			int numberOfUser = sc.nextInt() + 1;
			int numberOfNetwork = sc.nextInt();
			boolean[][] networkMap = new boolean[numberOfUser][numberOfUser];

			for (int i = 0; i < numberOfNetwork; i++) {
				int peopleOfA = sc.nextInt();
				int peopleOfB = sc.nextInt();
				networkMap[peopleOfA][peopleOfB] = networkMap[peopleOfB][peopleOfA] = true;
			} // forSetting

			for (int i = 1; i < numberOfUser; i++) {
				int[] distanceList = new int[numberOfUser];
				int KevinBaconSum = 0;
				Queue<Integer> queue = new LinkedList<Integer>();
				
				for (int j = 1; j < numberOfUser; j++) {
					distanceList[j] = -1;
				}
				distanceList[i] = 0;

				queue.offer(i);
				while (!queue.isEmpty()) {
					int startPeople = queue.poll();
					for (int j = 1; j < networkMap.length; j++) {
						if (distanceList[j] < 0 && networkMap[startPeople][j]) {
							distanceList[j] = distanceList[startPeople] + 1;
							queue.offer(j);
						}//if
					}//forJ
				}//whileBFS

				for (int j = 1; j < numberOfUser; j++) {
					KevinBaconSum += distanceList[j];
				}

				if (resultDistance > KevinBaconSum) {
					resultDistance = KevinBaconSum;
					resultPeopleNumber = i;
				}

				distanceList = null;
			} // bAll()

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + resultPeopleNumber);

		} // forTest

	}// main

}// class
