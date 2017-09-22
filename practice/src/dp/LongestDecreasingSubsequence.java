package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestDecreasingSubsequence {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/LongestDecreasingSubsequence.txt"));

		//Scanner sc = new Scanner(System.in);
		int sizeOfArray = sc.nextInt()+1;
		int[] numberList = new int[sizeOfArray];
		int[] bottomUpMap = new int[sizeOfArray];
		int longestLength=0;
		numberList[0]=Integer.MAX_VALUE;
		
		for(int i=1; i<sizeOfArray; i++){
			numberList[i] = sc.nextInt();
		}//forSetting
	
		for(int i=1; i<sizeOfArray; i++){
			for(int j=0; j<i; j++){
				if(numberList[i]<numberList[j]){
					bottomUpMap[i] = Math.max(bottomUpMap[j]+1, bottomUpMap[i]);
					longestLength=Math.max(longestLength, bottomUpMap[i]);
				}
			}
		}//forMakeBottomUp
	
		System.out.println(longestLength);
	}//main

}//class
