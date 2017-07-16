package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Constant {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/Constant.txt"));

		// Scanner sc = new Scanner(System.in);
	        String number1 = sc.next();
	        String number2 = sc.next();
	        
	        number1 = new StringBuffer(number1).reverse().toString();
	        number2 = new StringBuffer(number2).reverse().toString();
	        
	        System.out.println(Math.max(Integer.parseInt(number1),Integer.parseInt(number1)));


	}// main
}// class
