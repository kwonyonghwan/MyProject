package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WaterBottle {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/algorithm/WarterBottle.txt"));

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			int[] sizeOfBottle = new int[3];

			for (int i = 0; i < 3; i++) {
				sizeOfBottle[i] = sc.nextInt();
			}

			ArrayList<Integer> resultList = new ArrayList<Integer>();
			Queue<int[]> queue = new LinkedList<int[]>();

			boolean[][][] bottleMap = new boolean[sizeOfBottle[0]+1][sizeOfBottle[1]+1][sizeOfBottle[2]+1];

			int[] startValue = new int[3];

			startValue[0] = startValue[1] = 0;
			startValue[2] = sizeOfBottle[2];

			queue.offer(startValue);

			while (!queue.isEmpty()) {

				int[] tempValue = queue.poll();
				bottleMap[tempValue[0]][tempValue[1]][tempValue[2]] = true;

				for (int i = 0; i < 3; i++) {
					if (tempValue[(i)%3] > 0) {
						// i+1로 갈때
						// 가득 차 잇다면
						if (tempValue[i + 1] == sizeOfBottle[i + 1]) {
							//두 개 더해서 사이즈를 초과 하면
							int[] nextTemp = new int[3];
							if (tempValue[(i)%3] + tempValue[(i + 2)%3] > sizeOfBottle[(i + 2)%3]) {
								nextTemp[(i)%3] = (tempValue[(i)%3] + tempValue[(i + 2)%3]) % sizeOfBottle[(i + 2)%3];
								nextTemp[(i + 2)%3] = sizeOfBottle[(i + 2)%3];
								nextTemp[(i+1)%3] = sizeOfBottle[(i+1)%3];
								//큐에 넣고 
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
								
							}else{
								nextTemp[(i)%3] = 0;
								nextTemp[(i+1)%3] = sizeOfBottle[(i+1)%3];
								nextTemp[(i+2)%3] = tempValue[(i)%3]+ tempValue[(i+2)%3];
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
							}
						}else{
							int[] nextTemp = new int[3];
							//가득 차지 않앗으니까 i+1로 이동
							if (tempValue[(i)%3] + tempValue[(i + 1)%3] > sizeOfBottle[(i+1)%3]) {
								nextTemp[(i)%3] = (tempValue[(i)%3] + tempValue[(i + 1)%3]) % sizeOfBottle[(i + 1)%3];
								nextTemp[(i + 1)%3] = sizeOfBottle[(i + 1)%3];
								nextTemp[(i+2)%3] = tempValue[(i+2)%3];
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
							}else{
								tempValue[(i+1)%3] += tempValue[(i)%3];
								
								nextTemp[(i)%3] = 0;
								nextTemp[(i+1)%3] = tempValue[(i)%3] + tempValue[(i+1)%3];
								nextTemp[(i+2)%3] = tempValue[(i+2)%3];
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
							}
						}
						
						//i+2로 갈때
						// 가득 차 잇다면
						if (tempValue[(i + 2)%3] == sizeOfBottle[(i + 2)%3]) {
							//두 개 더해서 사이즈를 초과 하면
							int[] nextTemp = new int[3];
							if (tempValue[(i)%3] + tempValue[(i + 1)%3] > sizeOfBottle[(i+1)%3]) {
								nextTemp[(i)%3] = (tempValue[(i)%3] + tempValue[(i + 1)%3]) % sizeOfBottle[(i + 1)%3];
								nextTemp[(i + 1)%3] = sizeOfBottle[(i + 1)%3];
								nextTemp[(i+2)%3] = sizeOfBottle[(i+2)%3];
							
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
							
							
							}
							
		
							
							else{
								nextTemp[(i)%3]=0;
								nextTemp[(i+1)%3] = tempValue[(i)%3] + tempValue[(i+1)%3];
								nextTemp[(i+2)%3] = tempValue[(i+2)%3];
								
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
							}
							
							
							
							
							
							
						}else{
							//가득 차지 않앗으니까 i+2로 이동
							int[] nextTemp = new int[3];
							//그 중에서 i+1로 가면 넘칠때 
							if (tempValue[(i)%3] + tempValue[(i + 2)%3] > sizeOfBottle[(i+2)%3]) {
								nextTemp[(i)%3] = (tempValue[(i)%3] + tempValue[(i + 2)%3]) % sizeOfBottle[(i + 2)%3];
								nextTemp[(i+1)%3] = tempValue[(i+1)%3];
								nextTemp[(i+2)%3] = sizeOfBottle[(i + 2)%3];
								
								
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
								
								
								
								
								
							}else{
								tempValue[(i+2)%3] += tempValue[(i)%3];
								
								nextTemp[(i)%3] = 0;
								nextTemp[(i+1)%3] = tempValue[(i+1)%3];
								nextTemp[(i+2)%3] = tempValue[(i + 2)%3]+ tempValue[(i)%3];
								
								if(!bottleMap[nextTemp[(i)%3]][nextTemp[(i+1)%3]][nextTemp[(i+2)%3]]){
									queue.offer(nextTemp);
									resultList.add(nextTemp[(i+2)%3]);
								}
								
							}

						}

						// 연산하고 큐에 넣고
						// 연산 했던 놈인지 확인하고
						// tempValue[3] 결과 리스트에 넣고

					}

				} // forBFS

			}

			System.out.println(resultList.toString());

		} // forTest

	}// main
	
		
	

}// class
