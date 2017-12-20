package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidasTest7 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest7.txt"));

		// Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int totalValue = N+M;
		int result =0;
		
		while(N>1&&M>0&& (totalValue-K)>=3){
			
			N-=2;
			M--;
			result++;
			totalValue = N+M;
			
		}
		
		
		System.out.println(result);
		
	}// main

}// class
