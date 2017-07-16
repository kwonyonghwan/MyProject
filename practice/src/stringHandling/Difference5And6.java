package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Difference5And6 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		//String firstNumber = sc.next();
		//String SecondNumber = sc.next();
		
		String firstNumber = "1430";
		String SecondNumber = "4862";
	
		firstNumber = firstNumber.replaceAll("6", "5");
		SecondNumber = SecondNumber.replaceAll("6", "5");
		System.out.print(Integer.parseInt(firstNumber)+Integer.parseInt(SecondNumber)+" ");
	
		firstNumber = firstNumber.replaceAll("5", "6");
		SecondNumber = SecondNumber.replaceAll("5", "6");
		System.out.print(Integer.parseInt(firstNumber)+Integer.parseInt(SecondNumber));
		
	}// main
}// class
