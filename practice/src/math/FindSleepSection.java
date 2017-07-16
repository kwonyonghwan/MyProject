package math;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindSleepSection {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/math/FindSleepSection.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfMap = sc.nextInt();
			boolean[][] Map = new boolean[sizeOfMap][sizeOfMap];
			sc.nextLine();

			for (int i = 0; i < sizeOfMap; i++) {
				String temp = sc.nextLine();
				for (int j = 0; j < temp.length(); j++) {
					if (temp.charAt(j) == 'X') {
						Map[i][j] = true;
					}
				}
			} // forSetting

			int countOfHorizental = 0;
			int countOfVertical = 0;

			for (int i = 0; i < sizeOfMap; i++) {
				int count = 0;
				boolean flag = false;
				for (int j = 0; j < sizeOfMap; j++) {
					if (!Map[i][j]) {
						count++;
						if (count > 1 && !flag) {
							countOfHorizental++;
							flag = true;
						}
					} else {
						flag = false;
						count = 0;
					}
				}
			}

			for (int j = 0; j < sizeOfMap; j++) {
				int count = 0;
				boolean flag = false;
				for (int i = 0; i < sizeOfMap; i++) {
					if (!Map[i][j]) {
						count++;
						if (count > 1 && !flag) {
							countOfVertical++;
							flag = true;
						}
					} else {
						flag = false;
						count = 0;
					}
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + countOfHorizental + " " + countOfVertical);
		} // forTest

	}// main

}// class
