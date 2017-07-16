package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class templet2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/RobotScavenger.txt"));

		int inpuNumber = 5;
		for (int i = 0; i < inpuNumber; i++) {
			for (int j = 0; j < inpuNumber; j++) {
				if(j<i){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}// main고려대학교

}// class
