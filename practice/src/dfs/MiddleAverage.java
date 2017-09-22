package dfs;

import java.util.Scanner;

public class MiddleAverage {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case;
		int T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int min=Integer.MAX_VALUE; 
			int max=Integer.MIN_VALUE;
			int sum = 0;
			
			for(int i=0; i<10; i++){
				int temp = sc.nextInt();
				sum+=temp;
				min = Math.min(min, temp);
				max = Math.max(max, temp);
			}
			
			System.out.println(((sum-min-max)%8)>3?(sum-min-max)/8+1:(sum-min-max)/8);

		} // forTest

	}// main
}// class