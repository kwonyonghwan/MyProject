package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchAlphabet {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/algorithm/SearchAlphabet.txt"));

		// Scanner sc = new Scanner(System.in);
		String wordS = sc.nextLine();

		int[] locationArray = new int[123];
		for(int i =0; i<locationArray.length; i++){
			locationArray[i]=-1;
		}
	
		for(int i=0; i<wordS.length(); i++){
			if(locationArray[(int)wordS.charAt(i)]>-1){
				continue;
			}else{
				locationArray[(int)wordS.charAt(i)] = i;
			}
		}
	
		// 이 부분에서 정답을 출력하십시오.
		for(int i=97; i<123; i++){
			System.out.print(locationArray[i]+ " ");
		}
			
			
	}// main

}// class
