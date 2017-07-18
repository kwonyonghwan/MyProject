package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestIncreasingSubsequence2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/LongestIncreasingSubsequence2.txt"));

		//Scanner sc = new Scanner(System.in);

		int lengthOfArray = sc.nextInt()+1;
		int maxSum=0;
		int[] array =  new int[lengthOfArray];
		int[][] bottomUpMap =  new int[lengthOfArray][2];
		
		for(int i=1; i<lengthOfArray; i++){
			array[i] = sc.nextInt();
		}//forSetting
		
		for(int i=1; i<lengthOfArray; i++){
			for(int j=0; j<i; j++){				
				if(array[i] > array[j]){
					bottomUpMap[i][0] = Math.max(bottomUpMap[i][0], bottomUpMap[j][0]+1);
					bottomUpMap[i][1] = Math.max(bottomUpMap[i][1], bottomUpMap[j][1]+array[i]);
					maxSum = Math.max(maxSum, bottomUpMap[i][1]);
				}
			}
		}//forMakeBottomUP
		
		for(int i=0; i<bottomUpMap.length; i++){
			System.out.print(bottomUpMap[i][1]+" ");
		}
		System.out.println();
		System.out.println(maxSum);
	}//main

}//class
