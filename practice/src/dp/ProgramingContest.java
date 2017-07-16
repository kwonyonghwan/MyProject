package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ProgramingContest {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/ProgramingContest.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
		
			int numberOfPeople = sc.nextInt()+1;
			int[] scoreOfPeople = new int[numberOfPeople];
			int[][] lastScoreOfPeople = new int[numberOfPeople][numberOfPeople];
			int[] pointer = new int[numberOfPeople];
			for(int i=1; i<numberOfPeople; i++){
				pointer[i]=i-1;
			}
			
			for (int i=1; i<numberOfPeople; i++	) {
				scoreOfPeople[i] = sc.nextInt();
			}
			
			for(int i=1; i<numberOfPeople; i++){
				for(int j=1; j<numberOfPeople; j++){
					lastScoreOfPeople[i][j] = scoreOfPeople[j]+i;
				}//forJ
			}//forI

			Stack<Integer> stack = new Stack<Integer>();
			boolean[] flagI = new boolean[numberOfPeople];
			boolean[] flagJ = new boolean[numberOfPeople];
			
			for(int i=0; i<numberOfPeople; i++){
				for(int j=0; j<numberOfPeople; j++){
					if(flagI[i] || flagJ[j]){
						continue;
					}
					//stack.push(item)
					
				}
			}
			System.out.println("Case #" + test_case);

		} // forTestSase
		
	}// main

}// class
