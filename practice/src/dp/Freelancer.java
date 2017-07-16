package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Freelancer {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/Freelancer.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
		
			int numberOfWeek = sc.nextInt()+1;
			int[] payOfP = new int[numberOfWeek];
			int[] payOfQ = new int[numberOfWeek];
			int[] totalPay = new int[numberOfWeek];
			
			for(int i=1;i<numberOfWeek;i++){
				payOfP[i] = sc.nextInt();
			}
			for(int i=1;i<numberOfWeek;i++){
				payOfQ[i] = sc.nextInt();
			}
			
			totalPay[1] = payOfP[1];
			
			for(int i=2; i<numberOfWeek; i++){
				
				totalPay[i] = Math.max(totalPay[i-2]+payOfQ[i], totalPay[i-1]+payOfP[i]);
				
			}//forI
			
			System.out.println("Case #" + test_case);
			System.out.println(totalPay[totalPay.length-1]);
			
		} // forTestCase

	}//main

}//class
