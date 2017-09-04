package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/DSLR.txt"));
		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberA = sc.nextInt();
			int numberB = sc.nextInt();

			boolean[] visitiedMap = new boolean[10000];
			char[] parentConnection = new char[10000];
			int[] parentNumber = new int[10000];
			
			Queue<Integer> queue = new LinkedList<>();

			queue.offer(numberA);

			char[] parent = {'D','S','L','R'};
			while (!queue.isEmpty()) {
				
				int tempNumber = queue.poll();
				int[] nextList = new int[4];
				nextList[0] =  (tempNumber*2)%10000;
				//nextList[1] =  tempNumber-1<0?9999:tempNumber-1;
				nextList[1] =  (tempNumber+9999)%10000;
				
				nextList[2] =  ((tempNumber%1000)*10 )+(tempNumber/1000);
				nextList[3] =  ((tempNumber%10)*1000 )+(tempNumber/10);
				
			/*	nextList[2] =  rotate(tempNumber, 'L');
				nextList[3] =  rotate(tempNumber, 'R');
*/
				for(int i=0; i<4; i++	){
					
					if(!visitiedMap[nextList[i]]){
						visitiedMap[nextList[i]]= true;
						parentConnection[nextList[i]] = parent[i];
						parentNumber[nextList[i]]= tempNumber;
						queue.offer(nextList[i]);
					}
				}//forNextStep
			
				if(visitiedMap[numberB]){
					break;
				}
			
			}//while
			
			int temp = numberB;
			StringBuilder sb = new StringBuilder();
			while(temp!=numberA){
				sb.append(parentConnection[temp]);
				temp = parentNumber[temp];
			}
			
			System.out.println(sb.reverse().toString());

		}//forTestCase
	}//main
/*	
	public static Integer rotate(int tempNumber, char command) {
		
		String temp = String.valueOf(tempNumber);
		String tempA = "";
		for(int i=0; i<(4-temp.length()); i++){
			tempA +="0";
		}
		temp = tempA+temp;
		StringBuilder sb = new StringBuilder();
		
		if(command=='L'){
			for(int i=1; i<5; i++){
				sb.append(temp.charAt(i%4));
			}
			
		}else{
			for(int i=0; i<4; i++){
				sb.append(temp.charAt((i+3)%4));
			}
			
		}
		
		return Integer.parseInt(sb.toString());
	}
	*/
}//class