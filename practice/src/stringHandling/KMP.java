package stringHandling;

import java.util.Scanner;

public class KMP {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String inputString = "Kadsfasdf-Mefwfw-paewf";
        char[] inputCharArray = inputString.toCharArray();
        
        String resultString = ""+inputCharArray[0];
       
        for(int i=0; i<inputCharArray.length; i++){
            if((int)inputCharArray[i] == 45){
                 resultString= resultString + inputCharArray[i+1];
             }   
        }//for
        
            System.out.println(resultString.toUpperCase());
        
		
		
	}//main

}//class
