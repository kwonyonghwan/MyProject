package algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		 
	//	Scanner sc = new Scanner(new FileInputStream("src/algorithm/Test.txt"));

			for (int i = 1; i <= 10; i++) {
	        	int testCase= 1;
	            int result=2;
	            int countOfNumber = 8;
	            
	            for(int j=1; j<countOfNumber; j++){
	                result *=result;
	            }
	        	System.out.println("#"+testCase+" "+result);
	        }	

	}

}
