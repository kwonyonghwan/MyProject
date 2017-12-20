package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class NexonTest2 {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(new FileInputStream("src/test/NexonTest1.txt"));

		 Scanner sc = new Scanner(System.in);

		 String s = "jKliasamanthasamanthajulia";
		 char[] arr = s.toCharArray();

		 String target = "julia";
		 
		 int result = -1;
		 for(int i=0; i<=s.length()-target.length(); i++){
			 System.out.println(i);
			 if(target.charAt(0)=='*' || s.charAt(i)==target.charAt(0)){
				 boolean isFind = true;
				 
				 for(int j=1; j<target.length(); j++){
					 if(target.charAt(j)=='*' ){
						 continue;
					 }
					 
					 if(target.charAt(j) != s.charAt(i+j)){
						 isFind = false;
						 break;
					 }
				 }//forVarification
				 
				 if(isFind){
					 result = i;
					 break;
				 }
				 
			 }//equalsFirstChar
			 
		 }
		 
		 System.out.println(result);
		 
		 

	}// main

}// class
