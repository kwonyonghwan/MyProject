package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Templet1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/simulation/RobotScavenger.txt"));

		// Scanner sc = new Scanner(System.in);

		int a = 31;
		int quotient=31;
		int remainder;

		System.out.println(28|21);
		
		String temp= "";
		
		while(quotient>1){
			
			quotient = quotient/2;
			remainder = quotient%2;
			
			if(remainder>0){
				temp = "#"+temp;
			}else{
				temp = " "+temp;
			}
			
		}
		
		temp=quotient>0?"#"+temp:" "+temp;
		System.out.println(getBinaryNumber(29,5));
	}// main

	 public static String getBinaryNumber(int quotient, int n){

			int remainder;
			String temp= "";
			
			for(int i=1; i<n; i++){
				
				remainder = quotient%2;
				quotient = quotient/2;
				
				if(remainder>0){
					temp = "#"+temp;
				}else{
					temp = " "+temp;
				}
				
			}
			
			temp=quotient>0?"#"+temp:" "+temp;
	        return temp;
	    }
	
}// class
