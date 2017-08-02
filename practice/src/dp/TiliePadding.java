package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class TiliePadding {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		
		int sizeOfWall = 8;
//		int sizeOfWall = sc.nextInt();

		int[] bottomUpMap = new int[31];
		
		bottomUpMap[0] = 1;
		bottomUpMap[2] = 3;
		bottomUpMap[4] = 11;
		boolean flag = false;
		for(int i=6; i<sizeOfWall+1; i+=2){
				bottomUpMap[i] = (bottomUpMap[i-2]*3);
				for(int j=4; j<=i; j+=2){
					bottomUpMap[i] += bottomUpMap[i-j]*2;
				}
		}
		
		System.out.println(bottomUpMap[sizeOfWall]);
	}// main

}// class
