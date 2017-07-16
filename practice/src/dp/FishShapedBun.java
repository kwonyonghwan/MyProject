package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FishShapedBun {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/FishShapedBun.txt"));
		
		int countOfFishbun = sc.nextInt()+1;
		int[] feeOfSetmenu = new int[countOfFishbun];
		int[] bottomUpMap = new int[countOfFishbun];
		
		for(int i=1; i<countOfFishbun; i++){
			feeOfSetmenu[i] = sc.nextInt();
		}
		
		bottomUpMap[1] = feeOfSetmenu[1];
		
		for(int i=2; i<countOfFishbun; i++){
			bottomUpMap[i]= Math.max(bottomUpMap[i], feeOfSetmenu[i]);
			for(int j=1; j<i; j++){
				bottomUpMap[i]= Math.max(bottomUpMap[i], bottomUpMap[i-j]+feeOfSetmenu[j]);
			}
		}
		
		System.out.println(bottomUpMap[countOfFishbun-1]);
		
	}//main

}//class
