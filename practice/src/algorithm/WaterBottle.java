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
						// i+1�� ����
						// ���� �� �մٸ�
						if (tempValue[i + 1] == sizeOfBottle[i + 1]) {
							//�� �� ���ؼ� ����� �ʰ� �ϸ�
							int[] nextTemp = new int[3];
							if (tempValue[(i)%3] + tempValue[(i + 2)%3] > sizeOfBottle[(i + 2)%3]) {
								nextTemp[(i)%3] = (tempValue[(i)%3] + tempValue[(i + 2)%3]) % sizeOfBottle[(i + 2)%3];
								nextTemp[(i + 2)%3] = sizeOfBottle[(i + 2)%3];
								nextTemp[(i+1)%3] = sizeOfBottle[(i+1)%3];
								//ť�� �ְ� 
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
							//���� ���� �ʾ����ϱ� i+1�� �̵�
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
						
						//i+2�� ����
						// ���� �� �մٸ�
						if (tempValue[(i + 2)%3] == sizeOfBottle[(i + 2)%3]) {
							//�� �� ���ؼ� ����� �ʰ� �ϸ�
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
							//���� ���� �ʾ����ϱ� i+2�� �̵�
							int[] nextTemp = new int[3];
							//�� �߿��� i+1�� ���� ��ĥ�� 
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

						// �����ϰ� ť�� �ְ�
						// ���� �ߴ� ������ Ȯ���ϰ�
						// tempValue[3] ��� ����Ʈ�� �ְ�

					}

				} // forBFS

			}

			System.out.println(resultList.toString());

		} // forTest

	}// main
	
		
	

}// class
