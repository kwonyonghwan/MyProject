package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MidasTest3 {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest3.txt"));

		 Scanner sc = new Scanner(System.in);

		int N = sc.nextInt()+1;
		int[] toyList = new int[N];
		
		for(int i=1; i<N; i++){
			toyList[i] = sc.nextInt(); 
		}

		int result = 0;
		
		Arrays.sort(toyList);
		boolean[] toyWeight = new boolean[toyList[N-1]+1];
		boolean[] tempList = new boolean[toyList[N-1]+1];

		for(int i=1; i<N; i++){
			toyWeight[toyList[i]] = true;
		}

		
		int index = toyList[1];
		
		for( ; index<toyWeight.length; index++	){
			if(toyWeight[index]){
				result++;
				index+=4;
			}
		}
		
		System.out.println(result);
		
	}

}// class
