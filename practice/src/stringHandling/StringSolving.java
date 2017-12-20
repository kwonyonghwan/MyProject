package stringHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringSolving {

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/StringSolving.txt"));

		StringBuilder inputStringA = new StringBuilder(sc.next());
		StringBuilder inputStringB = new StringBuilder(sc.next());
		int countOfDifference = Integer.MAX_VALUE;

		for (int i = 0; i <= inputStringB.length() - inputStringA.length(); i++) {

			int tempCountOfDifference = 0;
			for (int j = 0; j < inputStringA.length(); j++) {
				if (inputStringA.charAt(j) != inputStringB.charAt(i + j)) {
					tempCountOfDifference++;
				}
			}

			countOfDifference = Math.min(countOfDifference, tempCountOfDifference);
		}

		System.out.println(countOfDifference);
	}// main

}// class