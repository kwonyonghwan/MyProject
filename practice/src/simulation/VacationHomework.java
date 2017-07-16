package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.sound.sampled.Port;

public class VacationHomework {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/VacationHomework.txt"));

		 // Scanner sc = new Scanner(System.in);
	        
	        int lengthOfVacation = sc.nextInt();
	        int totalMathPage = sc.nextInt();
	        int totalLanguagePage = sc.nextInt();
	        int stepOfMathPage = sc.nextInt();
	        int stepOfLanguagePage = sc.nextInt();
	        
	        
	        while(totalMathPage>0 || totalLanguagePage>0){
	            totalMathPage -= stepOfMathPage;
	            totalLanguagePage -= stepOfLanguagePage;
	            lengthOfVacation--;
	           if(lengthOfVacation==0){
	               break;
	           }
	        }
	        
	        System.out.println(lengthOfVacation);
		
	}// main

}// class