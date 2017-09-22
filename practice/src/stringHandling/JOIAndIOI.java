package stringHandling;

import java.util.Scanner;

public class JOIAndIOI {

	public static void main(String[] args)   {

		Scanner sc = new Scanner(System.in);

		// String inputString = sc.next();
		String inputString = "JOIOIOIOI";
		
		int countOfJOI=0;
		int countOfIOI =0;
		
		for(int i=0; i<inputString.length()-2; i++){
			if(inputString.charAt(i)=='J'){
				if(inputString.charAt(i+1)=='O'&&inputString.charAt(i+2)=='I'){
					countOfJOI++;
					i++;
				}
			}
			if(inputString.charAt(i)=='I'){
				if(inputString.charAt(i+1)=='O'&&inputString.charAt(i+2)=='I'){
					countOfIOI++;
					i++;
				}
			}
		}
		System.out.println(countOfJOI+"\n"+countOfIOI);
		
	}// main

}// class
