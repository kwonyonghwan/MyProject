package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandPrompt {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		String inputWord = sc.nextLine();
		
		for(int i=0; i<inputWord.length(); i++){
			System.out.print((char)((((int)inputWord.charAt(i)-65)+23)%26+65));
		}
		
	}// main
}// class
