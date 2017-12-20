package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidasTest10 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest10.txt"));

		// Scanner sc = new Scanner(System.in);

		String inputValue1 = sc.next();
		String inputValue2 = sc.next();
		int result = Integer.MAX_VALUE;

		for (int i = 0; i <= inputValue2.length() - inputValue1.length(); i++) {

			int tempCount = 0;
			for (int j = 0; j < inputValue1.length(); j++) {
				if (inputValue2.charAt(i + j) != inputValue1.charAt(j)) {
					tempCount++;
				}
			}
			result = Math.min(tempCount, result);
		}

		System.out.println(result);

	}// main

}// class
