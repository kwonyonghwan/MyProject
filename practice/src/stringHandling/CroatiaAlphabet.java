package stringHandling;

import java.util.Scanner;

public class CroatiaAlphabet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] croatiaList = { "dz=", "z=", "d-", "lj", "nj", "s=", "c-" };
		String inputString = "-";
		String result = "";
		inputString= inputString+"  ";
		
		for(int i=0; i<inputString.length()-2; i++){
			boolean searchCroatia = false;
			
			if(inputString.substring(i, i+3).equals(croatiaList[0])){
				searchCroatia = true;
				result+="1";
				i+=2;
				continue;
			}
		
			for(int j=1; j<7; j++){
				if(inputString.substring(i, i+2).equals(croatiaList[j])){
					searchCroatia = true;
					result+="1";
					i+=1;
					break;
				}
			}//forCroatiaList
			
			if(!searchCroatia){
				if( inputString.charAt(i)=='-'||inputString.charAt(i)=='='){
					continue;
				}
				result+= inputString.charAt(i);
			}
			
		}//forInputString
		
	System.out.println(result.length());
	
//	System.out.println(inputString.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=","1").length());

	
	}// main

}// class
