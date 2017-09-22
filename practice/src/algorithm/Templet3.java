package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Templet3 {

	public static void main(String[] args) throws FileNotFoundException {

		String temp =  "1S2D*3T";
		
		System.out.println(getResult(temp));
	}// main고려대학교

	public static int getResult(String inputstring){
		
		int[] scoreList = new int[3];
		int scoreIndex=-1;
		
		for(int i=0; i<inputstring.length(); i++){
			char temp = inputstring.charAt(i);
			if((int)temp>47&&(int)temp<58){
				 if((int)temp==49 && inputstring.charAt(i+1)==48){
					 scoreList[scoreIndex+1]=10;
					 i++;
					 scoreIndex++;
					 continue;
				 }
				scoreList[scoreIndex+1] = Character.getNumericValue(temp);
				scoreIndex++;
				continue;
			}//숫자일 경우
			
			if(temp=='S'){
			}else if(temp=='D'){
				scoreList[scoreIndex]*=scoreList[scoreIndex];
			}else if(temp=='T'){
				scoreList[scoreIndex]=scoreList[scoreIndex]*scoreList[scoreIndex]*scoreList[scoreIndex];
			}else if(temp=='#'){
				scoreList[scoreIndex]=scoreList[scoreIndex]*(-1); 
			}
			else if(temp=='*'){
				if(scoreIndex>0){
					scoreList[scoreIndex-1]*=2; 
					scoreList[scoreIndex]*=2;
				}else{
					scoreList[scoreIndex]*=2;
				}
			}
			
		}
		
		return scoreList[0]+scoreList[1]+scoreList[2];
	}
	
	
}// class
