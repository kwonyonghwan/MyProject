package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Coins {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/Coins.txt"));

		//	Scanner sc = new Scanner(System.in);
			
			int T;
			int test_case;

			T = sc.nextInt();

			for (test_case = 1; test_case <= T; test_case++) {

				int countCoinList = sc.nextInt();
				int sumOfMoney = sc.nextInt()+1; 
				int[] coinList = new int[countCoinList];
				int[] sumOfMoneyBottomUpList = new int[sumOfMoney];
				
				for(int i=0; i<countCoinList; i++){
					coinList[i] = sc.nextInt();
				}//forSetting
				 
				sumOfMoneyBottomUpList[0] = 1;
				for(int i=0; i<coinList.length; i++){
					for(int j=coinList[i]; j<sumOfMoneyBottomUpList.length; j++){
						sumOfMoneyBottomUpList[j] += sumOfMoneyBottomUpList[j-coinList[i]];
					}
				}

				// 이 부분에서 정답을 출력하십시오.
				System.out.println("Case #" + test_case + " "+ sumOfMoneyBottomUpList[sumOfMoney-1] );
			}//forTest
		
		
	}//main

}//class
