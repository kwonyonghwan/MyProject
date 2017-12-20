package swExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No1222 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/swExpertAcademy/No1222.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_Case;

		for (test_Case = 1; test_Case <= 10; test_Case++) {
			int lengthOfInput = sc.nextInt();
			sc.nextLine();
			int result = 0;
			String inputData = sc.nextLine();
			for (int i = 0; i < lengthOfInput; i += 2) {
				result += Character.getNumericValue(inputData.charAt(i));
			}

			System.out.println("#" + test_Case + " " + result);

		} // forTestCase

	}// main

}// class