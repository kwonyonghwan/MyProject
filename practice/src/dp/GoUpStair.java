package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoUpStair {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/GoUpStair.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			int countOfStair = sc.nextInt()+1;
			int[] stair = new int[countOfStair];
			int[][] bottomUpMap = new int[countOfStair][3];
			
			for(int i=1; i<countOfStair; i++){
				stair[i]	= sc.nextInt();
			}
			
			bottomUpMap[1][0] = 0;
			bottomUpMap[1][1] = stair[1];
			bottomUpMap[1][2] = stair[1];
			
			for(int i=2; i<countOfStair; i++){
				bottomUpMap[i][0]= Math.max(bottomUpMap[i-1][1], bottomUpMap[i-1][2]);
				bottomUpMap[i][1]=bottomUpMap[i-1][0]+stair[i];
				bottomUpMap[i][2]=bottomUpMap[i-1][1]+stair[i];		
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+ Math.max(bottomUpMap[countOfStair-1][2], bottomUpMap[countOfStair-1][1]));
		}//forTest
		
	}// main

}// class
 