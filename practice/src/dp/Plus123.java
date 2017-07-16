package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Plus123 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Plus123.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int inputNumber = sc.nextInt();
			int[] memoization = new int[11];

			memoization[1] = 1;
			memoization[2] = 2;
			memoization[inputNumber] = DPRecursionMethod(inputNumber, memoization);

			// 이 부분에서 정답을 출력하십시오.

			System.out.println("Case #" + test_case + " " + memoization[inputNumber]);
		} // forTest

	}// main

	private static int DPRecursionMethod(int inputNumber, int[] memoization) {

		if (inputNumber == 0 || inputNumber == 1) {
			return 1;
		}

		if (memoization[inputNumber] > 0) {
			return memoization[inputNumber];
		}
		memoization[inputNumber] = DPRecursionMethod(inputNumber - 1, memoization)
				+ DPRecursionMethod(inputNumber - 2, memoization) + DPRecursionMethod(inputNumber - 3, memoization);

		return memoization[inputNumber];
	}

}// class
