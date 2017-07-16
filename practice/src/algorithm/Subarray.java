package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Subarray {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/algorithm/Subarray.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfArray = sc.nextInt();
			int sumOfSubarray = sc.nextInt();

			int[] array = new int[numberOfArray];

			int minSubArrayLength = numberOfArray + 1;
			int stepSubArrayLength = 0;
			int sumOfStepArray = 0;

			for (int i = 0; i < numberOfArray; i++) {
				array[i] = sc.nextInt();
			} // forI

			for (int i = 0; i < numberOfArray; i++) {
				sumOfStepArray = 0;
				stepSubArrayLength = 0;
				for (int j = i; j < numberOfArray; j++) {
					sumOfStepArray += array[j];
					stepSubArrayLength++;

					if (sumOfStepArray >= sumOfSubarray) {
						if (minSubArrayLength > stepSubArrayLength) {
							minSubArrayLength = stepSubArrayLength;
						}
						break;
					}

				} // forJ
			} // forI

			if (minSubArrayLength == numberOfArray + 1) {
				minSubArrayLength = 0;
			}

			System.out.println(minSubArrayLength);

		} // forT
	}// main

}// class