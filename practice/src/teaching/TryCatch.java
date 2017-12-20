package teaching;

import java.util.ArrayList;

public class TryCatch {

	public static void main(String[] args) {
		
		name();
		
	}//main

	public static void name() {
	
	
		char[] ad = new char[2];
		System.out.println(ad[0]);
//		System.out.println(ad);
	try {
		int a = 1;
		
		System.out.println("-----------------------------------");
		
		
		
		
		int[] b = new int[3];
		
		b[3] = 3;
		
		System.out.println(1);	
		return;

	} catch (Exception e) {
		
		e.printStackTrace();
		System.out.println(2);
		return;
		
	}
	finally {
		System.out.println(3);
	}	
	

	}
}//class
