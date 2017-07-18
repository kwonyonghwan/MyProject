package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class TileCode {

	public static void main(String[] args) throws FileNotFoundException {

		//Scanner sc = new Scanner(new FileInputStream("src/dp/Tiling.txt"));

		// Scanner sc = new Scanner(System.in);

		int inputNumber = 5;
		int[] bottomUpMap = new int[31];
		bottomUpMap[1] = 1;
		bottomUpMap[2] = 3;
		
		for (int i = 3; i <=inputNumber; i++) {
			bottomUpMap[i] = bottomUpMap[i-1]+(2*bottomUpMap[i-2]);
		}

		// �� �κп��� ������ ����Ͻʽÿ�.
        if((inputNumber%2)!=0){
            System.out.println(bottomUpMap[inputNumber]- ((bottomUpMap[inputNumber]-bottomUpMap[inputNumber/2])/2));
        }else{
             System.out.println(bottomUpMap[inputNumber]- ((bottomUpMap[inputNumber]-bottomUpMap[inputNumber/2+1])/2));
        }
	
	}// main

}// class
