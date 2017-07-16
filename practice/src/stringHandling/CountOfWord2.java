package stringHandling;

import java.util.Scanner;

public class CountOfWord2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// String inputString = sc.nextLine();
		String inputString = "        \n   ";
		inputString = inputString.toUpperCase();

		char[] charArray = inputString.toCharArray();

		int count = 0;
		boolean flag = true;

		int startIndex = 0;
		int endIndex = inputString.length()-1;
		while (flag) {
			if (charArray[startIndex] > 64 && charArray[startIndex] < 91) {
				flag = false;
				break;
			}

			charArray[startIndex] = 'A';
			startIndex++;
			if(startIndex==endIndex){
				System.out.println(0);
				return;
			}
		}

		for (int i = 0; i < charArray.length-1; i++) {
			if ((charArray[i] < 64 || charArray[i] > 91) && (charArray[i+1] >64 && charArray[i+1]<91) ) {
				count++;
			}
		}

		System.out.println(count + 1);

	}// main

}// class
