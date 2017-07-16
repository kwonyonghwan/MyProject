package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoomInMaze {

	static int[][] maze;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/algorithm/RoomInMaze.txt"));

		int T;
		int test_case;
		
		
		for(int i = 0; i<4;i++){
			for(int j=4; j>-1; j--){
				maze = new int[i][j];
			}
		}
		 
		int i = 0;
		int j = 0;
		int num = 0;
		
		while(i<4){
			int temp=0;
			
			if((i+j)%2==0){
				while(j<temp){
					maze[i][j] = num++;
					i--; 
					j++;
				}
				j++;
			} else if((i+j)%2==1){
				while(i<temp){
					maze[i][j] = num++;
					j--; 
					i++;
				}
				i++;
			}//¦ 
			
			
		}
		for(int k=0; k<100; k++){
			System.out.println(maze[0][k]);
		}
		System.out.println();
		

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {


			
		}//forTest

	}// main

}
