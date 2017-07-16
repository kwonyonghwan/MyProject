package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PadovanSequence {
	static Long[] padovanSequenceList;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/PadovanSequence.txt"));

		// Scanner sc = new Scanner(System.in);

			padovanSequenceList = new Long[101];
			padovanSequenceList[1]=(long) 1;
			padovanSequenceList[2]=(long) 1;
			padovanSequenceList[3]=(long) 1;
			for(int i=4; i<101;i++){
				padovanSequenceList[i] = padovanSequenceList[i-2]+padovanSequenceList[i-3];
			}

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+padovanSequenceList[sc.nextInt()]);
		}//forTest
		
	}// main

}// class
