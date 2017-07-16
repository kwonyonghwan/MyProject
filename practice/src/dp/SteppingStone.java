package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SteppingStone {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/SteppingStone.txt"));
		
		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
        
			int numberOfStone = sc.nextInt();
			int jumpRange = sc.nextInt();
			int mineCount = sc.nextInt();
			int result=0;
			boolean[] minePosition = new boolean[numberOfStone+1];
			int[][] countMemory = new int[numberOfStone+1][jumpRange];
			
			for(int i=0; i<numberOfStone; i++){
				for(int j=0; j<jumpRange; j++){
					countMemory[i][j] = -1;
				}
			}
		
			for(int  i=0; i<mineCount; i++){
				minePosition[sc.nextInt()] = true;
			}
			
			for(int i=1; i<jumpRange+1; i++){
			result = result+ jumpStone(numberOfStone-i, minePosition, countMemory, jumpRange, i, result);
			}
		
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}//forT
		
		
		
		
	}//main
	
	
	public static int jumpStone(int position,boolean[] minePosition, int[][] countMemory, int jumpRange, int beforeJumpRange, int result){
		
		if(position ==0){
			return 0;
		}
		
		if(position == 1){
			return 1;
		}
		
		
		if(position < jumpRange){
			for(int i=1; i<position; i++){
				if(i==beforeJumpRange){
					continue;
				}
				if(minePosition[position-i]){
					continue;
				}
				if(countMemory[position-i][i]>-1){
					return countMemory[position-i][i];
				}
				int temp=jumpStone(position-i, minePosition, countMemory, jumpRange, beforeJumpRange, result);
				result = result + temp;
				countMemory[position-i][i]=temp;
			}//forI
		}//if
		
		
		for(int i=1; i<jumpRange; i++){
			if(i==beforeJumpRange){
				continue;
			}
			
			if(minePosition[position-i]){
				continue;
			}
			
			if(countMemory[position-i][i]>-1){
				return countMemory[position-i][i];
			}
			
			int temp=jumpStone(position-i, minePosition, countMemory, jumpRange, beforeJumpRange, result);
			result = result + temp;
			countMemory[position-i][i]=temp;
		}//forI
		
		return result;
	}//jumpStone
	
	

}//class
