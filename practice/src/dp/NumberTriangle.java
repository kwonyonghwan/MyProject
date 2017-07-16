package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberTriangle {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/NumberTriangle.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfN = sc.nextInt()+1;
			int[][] numberOfTriangle = new int[numberOfN][]; 
			

			for(int i=1; i<numberOfN; i++){
				numberOfTriangle[i] = new int[i+1]; 
			}
			
	
			for(int i=1; i<numberOfN; i++){
				for(int j=1; j<=i; j++){
					numberOfTriangle[i][j] =sc.nextInt();
				}
			}//forSetting
			
			for(int i=numberOfTriangle.length-2; i>0; i--){
				for(int j=1; j<=i; j++){
					numberOfTriangle[i][j] = Math.max(numberOfTriangle[i+1][j]+numberOfTriangle[i][j], numberOfTriangle[i+1][j+1]+numberOfTriangle[i][j]);
				}
			}//forBottomUp
	
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + numberOfTriangle[1][1]);
		}//forTest
		
	}// main

}// class