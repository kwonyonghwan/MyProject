package simulation;

import java.util.Scanner;

public class GoldMinsu {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String inputNumber = "774";
		String temp="";
		String temp2="4";
		String temp3 ="7";
		String temp4="";
		String temp5="4";
		String temp6 ="7";
		
		
		for(int i=1; i<inputNumber.length(); i++){
			temp+="7";
			temp2+="7";
			temp3+="7";
			temp4+="4";
			temp5+="4";
			temp6+="4";
		}
		
		if(Integer.parseInt(temp3)<=Integer.parseInt(inputNumber)){
			System.out.println(temp3);
		}else if(Integer.parseInt(temp6)<=Integer.parseInt(inputNumber)){
			System.out.println(temp6);
		}else if(Integer.parseInt(temp2)<=Integer.parseInt(inputNumber)){
			System.out.println(temp2);
		}else if(Integer.parseInt(temp5)<=Integer.parseInt(inputNumber)){
			System.out.println(temp5);
		}else if(Integer.parseInt(temp)<=Integer.parseInt(inputNumber)){
			System.out.println(temp);
		}else{
			System.out.println(temp4);
		}
			
		/*
			
		
		
		if(inputNumber.length()==1){
			if(Character.getNumericValue(inputNumber.charAt(0))>6){
				System.out.println(7);
			}else if(Character.getNumericValue(inputNumber.charAt(0))>3){
				System.out.println(4);
			}
			return;
		}
		
		
		
		
		
		
		
		
		
		
		
        for(int i=0; i<inputNumber.length(); i++){
        	if(i==0){
        		 if(Character.getNumericValue(inputNumber.charAt(i))<4 || Character.getNumericValue(inputNumber.charAt(i+1))<3){
        			 continue;
        		 }
        	}
        	
           if(Character.getNumericValue(inputNumber.charAt(i))>=7||Character.getNumericValue(inputNumber.charAt(i))==0){
        	   temp+=7;
           }else{
        	   temp+=4;
           }
        }//for
        
		*/
      //  System.out.print(temp);
	}

}
