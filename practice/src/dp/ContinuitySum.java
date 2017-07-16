package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContinuitySum {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/ContinuitySum.txt"));
 
		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();


		for (test_case = 1; test_case <= T; test_case++) {
			int result=Integer.MIN_VALUE;
			//57% 결과값이 음수 일 경우 0이 출력되었다. 
			int countOfNumber = sc.nextInt();

			int[] numberList = new int[100001];
			int[] bottomUpMap = new int[100001];
		
			
			for(int i=0; i<countOfNumber; i++){
				numberList[i] = sc.nextInt();
			}
			bottomUpMap[countOfNumber-1] = numberList[countOfNumber-1];
			
			for(int i =countOfNumber-2; i>-1; i--){
				bottomUpMap[i] = Math.max(numberList[i], bottomUpMap[i+1]+numberList[i]);
			}
			
			
			for(int i=0; i<countOfNumber; i++){
				result = Math.max(bottomUpMap[i],result);
			}
				
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+result);
		}//forTest
		
	}// main

}// class
