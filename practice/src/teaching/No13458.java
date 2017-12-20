package teaching;

import java.io.FileInputStream;
import java.util.Scanner;

public class No13458 {

	public static void main(String[] args) throws Exception {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/teaching/No13458.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();

		int result = 0;
		// ---------------------입력
		for (int i = 0; i < N; i++) {

			arr[i] = arr[i] - B;
			result++;

			if(arr[i] >0){
				result = result + (arr[i] / C);
				if (arr[i] % C > 0) {
					result++;
				}//if문
			}

		}//for문
       
		System.out.println(result);
	}// main

}// class
