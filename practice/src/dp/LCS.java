package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LCS {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/LCS.txt"));

		// Scanner sc = new Scanner(System.in);

		String stringA = " "+sc.nextLine();
		String stringB = " "+sc.nextLine();
		int maxLength = 0;
		int[][] bottomUpMap = new int[stringA.length()][stringB.length()];
		
		for(int i=1; i<stringA.length(); i++){
			for(int j=1; j<stringB.length(); j++){
				if(stringA.charAt(i)==stringB.charAt(j)){
					bottomUpMap[i][j] = bottomUpMap[i-1][j-1]+1;
				}
				bottomUpMap[i][j] = Math.max(bottomUpMap[i][j], bottomUpMap[i][j-1]);
				bottomUpMap[i][j] = Math.max(bottomUpMap[i][j], bottomUpMap[i-1][j]);
			}
		}//forMakeBottomUPMap
		
		System.out.println(bottomUpMap[stringA.length()-1][stringB.length()-1]);
		
	}// main

}// class
