package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FibonacciFunction {
	static int[][] fibonacciList = new int[41][2];

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/FibonacciFunction.txt"));

		// Scanner sc = new Scanner(System.in);

		fibonacciList[0][0] = 1;
		fibonacciList[0][1] = 0;
		fibonacciList[1][0] = 0;
		fibonacciList[1][1] = 1;
		fibonacciList[2][0] = 1;
		fibonacciList[2][1] = 1;
		
		for(int i=3; i<fibonacciList.length; i++){
			fibonacciList[i][0] = fibonacciList[i-1][0]+fibonacciList[i-2][0];
			fibonacciList[i][1] = fibonacciList[i-1][1]+fibonacciList[i-2][1];
		}
				
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int intputNumber = sc.nextInt();
				
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+fibonacciList[intputNumber][0]+ " "+fibonacciList[intputNumber][1]);
		}//forTest
		
	}// main

}// class
