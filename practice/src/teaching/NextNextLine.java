package teaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NextNextLine {

	public static void main(String[] args) throws FileNotFoundException {

		int[] arr = {7,5,3,6,8,3,1,2,3,};
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+"  ");
		}
		System.out.println(arr);
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+"  ");
		}
		
		
	
	}// main

}// class
