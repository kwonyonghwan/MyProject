package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Diamond.txt"));
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
		
			int countOfDiamond = sc.nextInt()+1;
			
			//0무게 1선명도
			double[][] diamondList = new double[countOfDiamond][2];
			int[] bottomUpMap = new int[countOfDiamond];
			int maxValue=Integer.MIN_VALUE;
			diamondList[0][0] = Integer.MIN_VALUE;
			diamondList[0][1] = Integer.MAX_VALUE;
			
			for(int i=1; i<countOfDiamond; i++){
				diamondList[i][0] = sc.nextDouble();
				diamondList[i][1] = sc.nextDouble();
			}//forSetting
			
			for(int i=1; i<countOfDiamond; i++){
				for(int j=0; j<i; j++){
	
					if((diamondList[i][1] < diamondList[j][1] && diamondList[i][0] > diamondList[j][0])){
						bottomUpMap[i] = Math.max(bottomUpMap[i], bottomUpMap[j]+1);
					}
				}
			}//forMakeBottomUPMap
			
			for(int i =0; i<countOfDiamond; i++){
				maxValue = Math.max(maxValue, bottomUpMap[i]);
			}
			System.out.println(maxValue);
		}//forTestcase
	}//main

}//class
