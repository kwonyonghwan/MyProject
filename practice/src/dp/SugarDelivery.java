package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SugarDelivery {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		int targetWeight = 7;
		int count = 0;
		
		while(targetWeight>0){
			if(targetWeight%5==0){
				count += targetWeight/5;
				break;
			}
			else{
				targetWeight -= 3;
				count++;
			}
		}
		
		if(count<0){
			System.out.println(-1);
		}else{
			System.out.println(count);
		}
		
	}// main

}// class
