package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhiteSpace {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/WhiteSpace.txt"));
		// Scanner sc = new Scanner(System.in);
		int count = 0;

		for (int i = 0; i < 8; i++) {
			String inputString = sc.nextLine();
			
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j%2==0 && inputString.charAt(j) == 'F') {
						count++;
					}
				} /* ¦ */else {
					if (j%2==1 && inputString.charAt(j) == 'F') {
						count++;
					}
				}//Ȧ
			}
		}
		

		System.out.println(count);
	}// main
}// class
