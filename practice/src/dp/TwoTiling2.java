package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoTiling2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/TwoTiling.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
	
		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfTile = sc.nextInt();
			int[] bottomUpMap = new int[1001];
			bottomUpMap[1]=1;
			bottomUpMap[2]=2;
			
			for(int i=3; i<sizeOfTile+1; i++){
				bottomUpMap[i] = bottomUpMap[i-1]+2*bottomUpMap[i-2];
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+bottomUpMap[sizeOfTile]);
		}//forTest
		
	}// main

}// class
