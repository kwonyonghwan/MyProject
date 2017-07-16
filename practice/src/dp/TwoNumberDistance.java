package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoNumberDistance {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/TwoNumberDistance.txt"));

		int[][] dpMap = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				dpMap[i][j] = Math.abs(i - j);
			}
		}

		 String numberOfA = sc.next(); 
		 String numberOfB = sc.next();
		 

		String temp = "";
		for (int i = 0; i < Math.abs(numberOfA.length() - numberOfB.length()); i++) {
			temp = temp + "0";
		}

		int result = 0;

		for (int i = Integer.parseInt(numberOfA); i < Integer.parseInt(numberOfB); i++) {
			for (int j = i + 1; j <= Integer.parseInt(numberOfB); j++) {
				String tempA =temp + Integer.toString(i);
				String tempB = Integer.toString(j);
				
				System.out.println(tempA+"    "+tempB);
				
				for (int k = 0; k < tempB.length(); k++) {
					System.out.println(Character.getNumericValue(tempA.charAt(k))+"           "+Character.getNumericValue(tempB.charAt(k)));
					result = (result + dpMap[Character.getNumericValue(tempA.charAt(k))][Character
							.getNumericValue(tempB.charAt(k))]) % 1000000007;
				}
			}
		}

		System.out.println(result * 2);

	}// main

}// class
