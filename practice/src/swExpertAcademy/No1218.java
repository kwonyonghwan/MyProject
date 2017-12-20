package swExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class No1218 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/swExpertAcademy/No1218.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_Case;
		
		for(test_Case=1; test_Case<=10; test_Case++){
			int result=1;
			int sizeOfInputData = sc.nextInt();
			sc.nextLine();
			
			String inputString = sc.nextLine();
			Stack<Character> stack = new  Stack<Character>();
			
			for(int i=0; i<sizeOfInputData; i++){
				char tempChar = inputString.charAt(i);
				if(tempChar=='('||tempChar=='{'||tempChar=='['||tempChar=='<'){
					stack.push(tempChar);	
				}else{
					char stackTop = stack.pop();
					if((int)stackTop==40 && (int)tempChar!=41){
						result=0;
						break;
					}else if((int)stackTop>40&&(int)stackTop+2 != (int)tempChar){
						result=0;
						break;
					}
					
				}
				
			}//forStack
			
			System.out.println("#"+test_Case+" "+result);
			
		}//forTestCase
	
	}// main

}// class
