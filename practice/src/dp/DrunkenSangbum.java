package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DrunkenSangbum {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/DrunkenSangbum.txt"));

		// Scanner sc = new Scanner(System.in);

		boolean bottomUpMap[] = new boolean[101];
		int[] countMap= new int[101];
		int count=0;
		
		for(int i=1; i<101; i++){
			for(int j=i; j<101; j+=i){
				bottomUpMap[j] = !bottomUpMap[j];
			}
			if(bottomUpMap[i]){
				count++;
			}
			countMap[i] = count;
		}//forMakeBottomUpMap
		
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+countMap[sc.nextInt()]);
		}//forTest
		
	}// main

}// class
