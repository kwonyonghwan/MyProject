package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoundRobin {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/algorithm/RoundRobin.txt"));

		// Scanner sc = new Scanner(System.in);
		
		int countOfProcess = sc.nextInt();
		int[] processList = new int[countOfProcess];
		long[] resultList = new long[countOfProcess];
		long nowTime = 0;
		
		for(int i=0; i<countOfProcess; i++){
			processList[i] = sc.nextInt();
		}//forSetting


		boolean remain = true;
		
		while(remain){
			remain = false;
			
			for(int i=0; i<countOfProcess; i++){
				
				if(processList[i]>0){
					remain=true;
					nowTime++;
					processList[i]--;
					if(processList[i]==0){
						resultList[i] = nowTime;
					}
					
				}
				
			}//forAllProcess
			
		}//whileOneStep
		
		for(int i=0; i<countOfProcess; i++){
			System.out.println(resultList[i]);
		}
		
	
	}// main

}// class