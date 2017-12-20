package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/test/Test1.txt"));

		// Scanner sc = new Scanner(System.in);

		int[] temp = new int[3];
		Queue<Integer> bag = new LinkedList<>();
		bag.offer(0);
		bag.offer(0);
		bag.offer(0);
		
		String inputItemList = sc.nextLine();
		String[] inputArray = inputItemList.split(" ");
		
		for(int k=0; k<inputArray.length; k++){	
			int inputItem=Integer.parseInt(inputArray[k]);
			boolean isItem = false;
			int itemIndex=-1;
			for(int i=0; i<3; i++){
			
				temp[i] = bag.poll();
				if(temp[i]==inputItem){
					isItem=true;
					itemIndex=i;
				}
				
			}//for3
			
			for(int i=0; i<3; i++){
				
				if(i==itemIndex){
					continue;
				}
				bag.offer(temp[i]);
			}//forInput
			if(isItem){
				bag.offer(temp[itemIndex]);
			}else{
				int result=bag.poll();
				if(result>0){
					System.out.println(result);
				}
				bag.offer(inputItem);
			}
			
		}//forInput
			
		
		
		
		

	}// main

}// class
