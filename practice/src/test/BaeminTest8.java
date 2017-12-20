package test;

import java.io.FileNotFoundException;

public class BaeminTest8 {

	public static void main(String[] args) throws FileNotFoundException {

		int[] A = {1,1,2,5,7};
	
		
		int result = 0;
		int startIndex = 0;
		
		while(startIndex<A.length-2){
			
			int endIndex = startIndex+1;
			int gap=(A[endIndex]-A[startIndex]);
			int beforeNumber=A[endIndex];
			
			while(endIndex<A.length-1){
				
				endIndex++;
				if(gap!= A[endIndex]-beforeNumber){
					break;
				}
				result++;
				if(result>1000000000){
//					return -1;
				}
				beforeNumber = A[endIndex];
				
			}
			
		startIndex++;
		}
		
		System.out.println(result);
//		return result;
	}// main

}// class
