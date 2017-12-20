package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaeminTest4 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new FileInputStream("src/test/BaeminTest2.txt"));

//		 Scanner sc = new Scanner(System.in);
		int n = s.nextInt();

		short[] areaArray = new short[700000001];
		int minPosition =1000000000;
		int maxPosition = 0;
		
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();

			// 여기부터 작성해 주세요
			minPosition = Math.min(minPosition, a);
			maxPosition = Math.max(maxPosition, b);
			
			for(int j=a; j<b; j++){
				areaArray[j]++;
			}
			
			//요사이
		}//forStep

		System.out.println("(-, "+minPosition+")");
		int startPosition = 0;
		boolean startEven = false;
		boolean lastPosition = false;
		String result="";
		for(int i=minPosition; i<=maxPosition; i++){
			if(!startEven&&areaArray[i]%2==0){
				startEven=true;
				if(areaArray[i]==0){
					result=result+"("+ i +", ";
				}else{
					result=result+"["+ i +", ";
				}
			}//if(FindEven)

			if(startEven && i==maxPosition){
				lastPosition = true;
				result=result+"+)";
				System.out.println(result);
				break;
			}
			
			
			if(startEven && areaArray[i]%2>0){
				if(areaArray[i-1]==0){
					result=result+i+")";
				}else{
					result=result+i+"]";
				}
				System.out.println(result);
				result="";
				startEven = false;
			}
		}//forFindEvenArea
		
		if(!lastPosition){
			System.out.println("("+maxPosition+", +)");
		}
		
	

	}// main

}// class
