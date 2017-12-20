package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidasTest8 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest8.txt"));

		// Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] inputArray = new int[N];
		
		for(int i=0; i<N; i++){
			inputArray[i] = sc.nextInt();
		}
		
		System.out.println( ((N-1)/(M-1)) * (inputArray[1]-inputArray[0]) );
	}// main

}// class
