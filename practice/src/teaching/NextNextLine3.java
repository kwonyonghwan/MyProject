package teaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class NextNextLine3 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/teaching/UsingStack.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		sc.nextLine();

		for (test_case = 1; test_case <= T; test_case++) {

			String temp = sc.nextLine();
			boolean pairResult = true;
			
			Stack<Integer> stackTemp = new Stack<>(); 
			
			for(int i=0; i<temp.length(); i++){
				if(temp.charAt(i)=='('){
					System.out.print("0"+ " ");
				}else{

					System.out.print("1"+ " ");			}
				
			}//forCheck
			
			if(!stackTemp.isEmpty()){
				pairResult = false;
			}
			
			
		System.out.println();
		}//forTest
		
		
		
	}//main

}//class
