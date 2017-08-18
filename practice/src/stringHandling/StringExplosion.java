package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringExplosion {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/StringExplosion.txt"));

		// Scanner sc = new Scanner(System.in);

		StringBuffer inputString = new StringBuffer(" " + sc.nextLine());
		String explosion = " " + sc.nextLine();
		String result = "";

		int[] piArray = new int[explosion.length()];
		for (int i = 1; i < explosion.length(); i++) {
			int lengthOfSubsequence = 0;
			for (int j = 1; j <= (i / 2); j++) {
				if (explosion.substring(1, 1 + j).equals(explosion.substring(i + 1 - j, i + 1))) {
					lengthOfSubsequence = Math.max(j, lengthOfSubsequence);
				}
			}
			piArray[i] = lengthOfSubsequence;
		} // forMakePiArray

		// kmp알고리즘 돌리면서 서치

		for (int index = 1; index < (inputString.length() - (explosion.length() - 2)); index++) {
			for (int i = 1; i < explosion.length(); i++) {
				if (inputString.charAt(index + i - 1) != explosion.charAt(i)) {
					if(piArray[i-1]>0){
					index += (i - 2 - piArray[i - 1]);
					}
					break;
				}//noSearch

				if (i == explosion.length() - 1) {
					inputString.delete(index, index + i);
					if (index - (explosion.length() - 1) > -1) {
						index -= (explosion.length() - 1);
					} else {
						index = 0;
					}

				}//findExplotion

			}
		}

		if (inputString.length() > 1) {
			System.out.println(inputString.delete(0, 1).toString());
		} else {
			System.out.println("FRULA");
		}

	}// main

}// class
