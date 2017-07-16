package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IncreaseNumber {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		//int inputNumber = sc.nextInt()+1;
		int inputNumber = 3;
		
		int[][] bottomUpMap = new int[inputNumber][10];
		
		for(int i=1; i<inputNumber; i++){
			for(int j=0; j<10; j++){
				if(i==1||j==0){
					bottomUpMap[i][j] = 1;
					continue;
				}
				bottomUpMap[i][j] = (bottomUpMap[i][j-1]+bottomUpMap[i-1][j])%10007;
			}
		}//forMakeBottomUP

		int resultValue = 0;
		for(int i=0; i<10; i++){
			resultValue += bottomUpMap[inputNumber-1][i];
			resultValue = resultValue%10007;
		}
	System.out.println(resultValue);
	}//main
}//class