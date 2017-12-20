package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dp.Sticker;

public class NexonTest1 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/NexonTest1.txt"));

//		 Scanner sc = new Scanner(System.in);

		String[] words = {"ab",
				"aab",
				"aaaa",
				"abab",
				"abaaaba"};
		
		int[]  ops = new int[words.length];
		for(int test_Case=0; test_Case<words.length; test_Case++ ){
			int resultCount=0;
			StringBuilder temp = new StringBuilder(words[test_Case]);
			for(int i=1; i<temp.length() ; i++){
				
				if(temp.charAt(i-1)==temp.charAt(i)){
					resultCount++;
					temp.setCharAt(i, 'A');
				}
			}//forOperation
			ops[test_Case] = resultCount;
		}
		
		for(int test_Case=0; test_Case<words.length; test_Case++ ){
			System.out.print(ops[test_Case]+"  ");
		}
		
		

	}// main

}// class
