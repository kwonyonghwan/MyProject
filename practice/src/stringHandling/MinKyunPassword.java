package stringHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MinKyunPassword {

	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/MinKyunPassword.txt"));
		// Scanner sc = new Scanner(System.in);

		int countOfInputWord = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		sc.nextLine();
		
		for(int i=0; i<countOfInputWord; i++){
			String temp=sc.nextLine();
            if(temp.equals(new StringBuilder(temp).reverse().toString())){
				System.out.println(temp.length()+" "+ temp.charAt(temp.length()/2));
	    	}
			if(map.containsKey(temp) ||map.containsKey(new StringBuilder(temp).reverse())){
				System.out.println(temp.length()+" "+ temp.charAt(temp.length()/2));
			}else{
				map.put(temp, 1);
				map.put(new StringBuilder(temp).reverse().toString(), 1);
			}
			
		}//forInput
		
	}// main

}// class