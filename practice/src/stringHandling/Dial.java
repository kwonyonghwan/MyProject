package stringHandling;

import java.util.Scanner;

public class Dial {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] countList = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		
		String temp = "UNUCIC";
		char[] dial = temp.toCharArray();
		//char[] dial = sc.nextLine().toCharArray();
		int result = 0;
		for(int i=0; i<dial.length; i++){
			result += countList[dial[i] - 'A'];
		}
		
		System.out.println(result);
	
	}// main

}// class
