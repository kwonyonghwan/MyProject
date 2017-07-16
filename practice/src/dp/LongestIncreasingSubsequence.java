package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/LongestIncreasingSubsequence.txt"));

		//Scanner sc = new Scanner(System.in);

		int lengthOfArray = sc.nextInt()+1;
		int longestLength=0;
		int[] array =  new int[lengthOfArray];
		int[] bottomUpMap =  new int[lengthOfArray];
		
		for(int i=1; i<lengthOfArray; i++){
			array[i] = sc.nextInt();
		}//forSetting
		
		for(int i=1; i<lengthOfArray; i++){
			for(int j=0; j<i; j++){				
				if(array[i] > array[j]){
					bottomUpMap[i] = Math.max(bottomUpMap[i], bottomUpMap[j]+1);
					longestLength = Math.max(longestLength, bottomUpMap[i]);
				}
			}
		}//forMakeBottomUP
		
		System.out.println(longestLength);
	}//main

}//class
