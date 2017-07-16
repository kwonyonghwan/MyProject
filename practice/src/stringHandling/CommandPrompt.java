package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandPrompt {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/CommandPrompt.txt"));

		// Scanner sc = new Scanner(System.in);
		
		int countOfFile = sc.nextInt();
		sc.nextLine();
		
		char[] resultArray = sc.nextLine().toCharArray();
		
		for(int i=1; i<countOfFile; i++){
		 
			char[] tempArray = sc.nextLine().toCharArray();
			
			for(int j=0; j<tempArray.length; j++){
				if(resultArray[j] != tempArray[j]){
					resultArray[j] = '?';
				}else{
					resultArray[j] = resultArray[j];
				}
					
			}//forJ
			
		}
		
		for(int i=0; i<resultArray.length; i++){
			System.out.print(resultArray[i]);
		}
		
		
		
	}// main
}// class
