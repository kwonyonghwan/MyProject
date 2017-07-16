package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MakeNumberUsingOne {
	static int[] bottomUpMap = new int[1000001];
	static boolean makeFlag= true;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/MakeNumberUsingOne.txt"));

		// Scanner sc = new Scanner(System.in);
		if(makeFlag){
			for (int i = 4; i < bottomUpMap.length; i++) {
				bottomUpMap[i]= -1;
			}
			makeFlag=false;
			bottomUpMap[1]=0;
			bottomUpMap[2]=1;
			bottomUpMap[3]=1;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			queue.offer(2);
			queue.offer(3);
			
			while(!queue.isEmpty()){
				int temp = queue.poll();
				
				if(temp+1<1000001 &&  bottomUpMap[temp+1] <0){
					bottomUpMap[temp+1] = bottomUpMap[temp]+1;
					queue.offer(temp+1);
				}
				if(2*temp<1000001 &&bottomUpMap[2*temp] <0){
					bottomUpMap[2*temp] = bottomUpMap[temp]+1;
					queue.offer(2*temp);
				}
				if(3*temp<1000001 &&bottomUpMap[3*temp] <0){
					bottomUpMap[3*temp] = bottomUpMap[temp]+1;
					queue.offer(3*temp);
				}
				
			}//whileBFS
			
		}//if

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+bottomUpMap[sc.nextInt()]);
		}//forTest
		
	}// main

}// class
