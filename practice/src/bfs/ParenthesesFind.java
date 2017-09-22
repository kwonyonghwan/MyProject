package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesesFind {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/ParenthesesFind.txt"));

		// Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int lengthOfString = sc.nextInt();
			sc.nextLine();
			String inputString = sc.nextLine();		
			
			Stack<Character> stack = new Stack<Character>();
			System.out.print("#"+i+" ");
			boolean isPair = true;
			
			for (int j = 0; j < lengthOfString; j++) {
				if (inputString.charAt(j) == '(' || inputString.charAt(j) == '[' || inputString.charAt(j) == '{'
						|| inputString.charAt(j) == '<') {
					stack.push(inputString.charAt(j));
				} else {
					Character temp = stack.pop();
					if(temp=='(') {
						if(inputString.charAt(j)!=')'){
							System.out.println(0);
							isPair=false;
							break;
						}
					}else if(((int)temp+2) != (int)inputString.charAt(j)  ) {
						System.out.println(0);
						isPair=false;
						break;
					}
				}
			}//forLogic
			if(isPair){
				System.out.println(1);
			}
		}

	}// main

}// class