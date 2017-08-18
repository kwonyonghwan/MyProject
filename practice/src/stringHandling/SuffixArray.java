package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SuffixArray {

	public static void main(String[] args) throws FileNotFoundException {

		//Scanner sc = new Scanner(new FileInputStream("src/stringHandling/StringExplosion.txt"));

		 Scanner sc = new Scanner(System.in);

//		String inputString = sc.nextLine();
		String inputString = "baekjoon";

		String[] suffixArray = new String[inputString.length()];
		
		for(int i=0; i<inputString.length(); i++){
			suffixArray[i] = inputString.substring(i);
		}
		Arrays.sort(suffixArray);
		for(int i=0; i<inputString.length(); i++){
			System.out.println(suffixArray[i]);
		}
		
	}// main

}// class
