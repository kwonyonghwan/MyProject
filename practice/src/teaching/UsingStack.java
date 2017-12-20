package teaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UsingStack {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(System.in);
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
					stackTemp.push(0);
				}else{
					if(stackTemp.isEmpty()){
						pairResult = false;
						break;
					}
					stackTemp.pop();
				}
				
			}//forCheck
			
			if(!stackTemp.isEmpty()){
				pairResult = false;
			}
			
			
			if(pairResult){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			// 이 부분에서 정답을 출력하십시오.
		
		}//forTest

	}//main

}//class
