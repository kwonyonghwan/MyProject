package test;

import java.util.Scanner;

public class PreTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		 int inputNumber = sc.nextInt();
//		int inputNumber = 99999;
		int judgeNumber = 9;
		StringBuilder result = new StringBuilder(inputNumber);
		char[] broadArray = { ' ', 'ÀÏ', 'ÀÌ', '»ï', '»ç', '¿À', 'À°', 'Ä¥', 'ÆÈ', '±¸' };
		char[] pointArray = { ' ', '½Ê', '¹é', 'Ãµ', '¸¸' };
		int pointIndex = 0;

		while (inputNumber > (judgeNumber / 10)) {

			int stepNumber = inputNumber % (judgeNumber + 1) / ((judgeNumber + 1) / 10);

			if (stepNumber > 0) {
				result.append(pointArray[pointIndex]);
				if (pointIndex < 1 || stepNumber > 1) {
					result.append(broadArray[stepNumber]);
				}
			} // ifNotZero

			judgeNumber = judgeNumber * 10 + 9;
			pointIndex++;
		} // whileStep

		System.out.println(result.reverse());
	}// main

}// class
