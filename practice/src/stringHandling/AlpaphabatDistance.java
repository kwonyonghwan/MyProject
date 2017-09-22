package stringHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class AlpaphabatDistance {

	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/AlpaphabatDistance.txt"));
		// Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int test_case;
		sc.nextLine();
		
		for(test_case=1; test_case<=T; test_case++){
			String inputString1 = sc.next();
			String inputString2 = sc.next();
				System.out.print("Distances:");
			for(int i=0; i<inputString1.length(); i++){
				if((int)inputString1.charAt(i)> (int)inputString2.charAt(i)){
					System.out.print(" "+(((int)inputString2.charAt(i)+26)-(int)inputString1.charAt(i)));
				}else{
					System.out.print(" "+((int)inputString2.charAt(i)-(int)inputString1.charAt(i)));
				}
			}
			System.out.println();
			
		}//forTestCase
		
	}// main

}// class
