package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PinaryNumber {
	static Long[][] memoizationList ;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/PinaryNumber.txt"));
		
		// Scanner sc = new Scanner(System.in);
 
		int T;
		int test_case;

		T = sc.nextInt();
		
		for (test_case = 1; test_case <= T; test_case++) {
			int inputNumber = sc.nextInt()+1;
			memoizationList = new Long[inputNumber][2];

			memoizationList[inputNumber-1][0]=(long) 0;
			memoizationList[inputNumber-1][1]=(long) 1;
			
			for(int i=inputNumber-2; i>0; i--){
				memoizationList[i][0] = memoizationList[i+1][0]+memoizationList[i+1][1];
				memoizationList[i][1] = memoizationList[i+1][0];
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+( memoizationList[1][0]+memoizationList[1][1]) );
		}//forTest
		
	}// main

}// class
