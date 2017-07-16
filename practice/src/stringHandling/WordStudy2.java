package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordStudy2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/WordStudy.txt"));

		
		//Scanner sc = new Scanner(System.in);
		 String inputString = sc.nextLine();
		//String inputString = "MississipizZAa";
		inputString = inputString.toUpperCase();

		int[] wordCountList = new int[91];

		for (int i = 0; i < inputString.length(); i++) {
			wordCountList[(int)inputString.charAt(i)]++;
		}
		
		int maxValue = Integer.MIN_VALUE;
		int maxIndex = 0;
		boolean overTwoWord = false;

		for (int i = 65; i < 91; i++) {
			if (maxValue < wordCountList[i]) {
				maxValue = wordCountList[i];
				maxIndex = i;
				overTwoWord = false;
			} else if (maxValue == wordCountList[i]) {
				overTwoWord = true;
			}
		} // for

		if (overTwoWord) {
			System.out.println("?");
		} else {
			System.out.print((char)maxIndex);
		}

	}// main
}// class
