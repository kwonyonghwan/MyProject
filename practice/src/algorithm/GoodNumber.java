package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoodNumber {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/algorithm/GoodNumber.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfArray = sc.nextInt();
			boolean[] oneNumber = new boolean[200007];
			boolean[] twoNumber = new boolean[400007];
			boolean[] threeNumber = new boolean[600001];

			int[] numberList = new int[numberOfArray];
			int resultCount = 0;

			for (int i = 0; i < numberOfArray; i++) {
				numberList[i] = sc.nextInt() + 100000;
			} // forI

			int oneNumberMax = numberList[0];
			int twoNumberMax = numberList[0] * 2;

			for (int i = 0; i < numberList.length; i++) {

				if (threeNumber[numberList[i]]) {
					resultCount++;
				}

				oneNumber[numberList[i]] = true;
				twoNumber[numberList[i] * 2] = true;
				threeNumber[numberList[i] * 3] = true;

				for (int j = 0; j < oneNumberMax - 100000; j++) {
					if (oneNumber[j]) {
						System.out.println("나 들어왓당");
						twoNumber[j + numberList[i]] = true;
						System.out.println("요기");
						oneNumberMax = j + numberList[i];
						System.out.println("조기");
					}
				}
			
				for (int j = 0; j < twoNumberMax - 200000; j++) {
					if (twoNumber[j]) {
						threeNumber[j + numberList[i]] = true;
						twoNumberMax = j + numberList[i];
					}
				}
				} // All

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultCount);

		} // forTest

	}// main

}// class
