package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DontDecrease {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/DontDecrease.txt"));
		//Scanner sc = new Scanner(System.in);

		long[][] bottomUpMap = new long[1001][10];
		
		for(int i=0; i<10; i++){
			bottomUpMap[1][i]=1;
		}
		
		for(int i=1; i<1000; i++){
			for(int j=0; j<10; j++){
				for(int k=j; k<10; k++){
					bottomUpMap[i+1][k] += bottomUpMap[i][j]; 
				}
			}
		}//forMakeBottomUP
		
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int inputNumber =sc.nextInt();
			long sum = 0;
			for(int i=0; i<10; i++){
				sum+=bottomUpMap[inputNumber][i];
			}
			// 이 부분에서 정답을 출력하십시오.
			System.out.println(sum);
		}//forTest
		
	}//main

}//class
