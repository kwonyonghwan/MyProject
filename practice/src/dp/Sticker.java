package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sticker {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/Sticker.txt"));
		
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int lengthOfArray = sc.nextInt();
			int[][] array = new int[2][lengthOfArray];
			int[][] bottomUpMap = new int[2][lengthOfArray];
			
			for(int i=0; i<2; i++){
				for(int j=0; j<lengthOfArray; j++){
					array[i][j] = sc.nextInt();
				}
			}//forSetting
			
			bottomUpMap[0][0] = array[0][0];
			bottomUpMap[1][0] = array[1][0];
			bottomUpMap[0][1] = array[1][0]+array[0][1];
			bottomUpMap[1][1] = array[0][0]+array[1][1];
			
			for(int j=2; j<lengthOfArray; j++){
				for(int i=0; i<2; i++){
					bottomUpMap[i][j] = Math.max(bottomUpMap[i][j], bottomUpMap[0][j-2]);
					bottomUpMap[i][j] = Math.max(bottomUpMap[i][j], bottomUpMap[1][j-2]);
					if(i==0){
						bottomUpMap[i][j] = Math.max(bottomUpMap[i][j], bottomUpMap[1][j-1]);
					}else{
						bottomUpMap[i][j] = Math.max(bottomUpMap[i][j], bottomUpMap[0][j-1]);
					}
					bottomUpMap[i][j] += array[i][j];
				}
			}//forSetting
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println(Math.max(bottomUpMap[0][lengthOfArray-1], bottomUpMap[1][lengthOfArray-1]));
		}//forTest

	}
}