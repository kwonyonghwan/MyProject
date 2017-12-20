package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dp.Sticker;

public class BaeminTest3 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new FileInputStream("src/test/BaeminTest3.txt"));

		int x1 = s.nextInt();
		int y1 = s.nextInt();
		int x2 = s.nextInt();
		int y2 = s.nextInt();
		int x3 = s.nextInt();
		int y3 = s.nextInt();
		int x4 = s.nextInt();
		int y4 = s.nextInt();
		int x5 = s.nextInt();
		int y5 = s.nextInt();
		int x6 = s.nextInt();
		int y6 = s.nextInt();
		
		boolean[][] area = new boolean[10001][10001];
		
		changeArea(x1, x2, y1, y2, area, 't'); 
		changeArea(x3, x4, y3, y4, area, 'f'); 
		changeArea(x5, x6, y5, y6, area, 'f'); 
		
		int result =0;
		
		for(int i=0; i<10001; i++){
			for(int j=0; j<10001; j++){
				if(area[i][j]){
					result++;
				}
			}
		}
		
		System.out.println(result);
	}// main
	
	public static void changeArea(int x1, int x2, int y1, int y2, boolean[][] area, char c) {
		
		for(int i=y1; i<y2; i++){
			for(int j=x1; j<x2; j++){
				if(c=='t'){
					area[i][j] = true;
				}else{
					area[i][j] = false;
				}
			}
		}
	}

}// class
