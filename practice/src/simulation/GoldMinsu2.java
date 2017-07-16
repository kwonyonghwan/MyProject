package simulation;

import java.util.Scanner;

public class GoldMinsu2 {
	static int inputNumber ;
	static int maxValue;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		 inputNumber = 774;
		
		DFS(0);
		System.out.println(maxValue);
	}//main

	private static void DFS(int stepNumber) {

		if(((stepNumber*10+7)<=inputNumber )){
			maxValue = Math.max(maxValue, (stepNumber*10+7));
			DFS((stepNumber*10+7));
		}

		if(((stepNumber*10+4)<=inputNumber )){
			maxValue = Math.max(maxValue, (stepNumber*10+4));
			DFS((stepNumber*10+4));
		}
		
	}//DFS

}//class
