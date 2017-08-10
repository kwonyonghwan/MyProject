package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lotto2 {

	static ArrayList<Integer> numberList;
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/Lotto.txt"));

		int countOfNumber = sc.nextInt();
		while(countOfNumber !=0){
			
			numberList = new ArrayList<Integer>();
			for(int i=0; i<countOfNumber; i++){
				numberList.add(sc.nextInt());
			}//forSetting
			
			for(int i = 0; i<countOfNumber; i++){
				ArrayList<Integer> resultList = new ArrayList<Integer>();
				DFS(i, resultList);
			}
			
			
			
		}//while
		
	}//main

	private static void DFS(int i, ArrayList<Integer> resultList) {
		
		//���̰� 6���� üũ
		resultList.add(i);
		if(resultList.size()>5){
			System.out.println("�ϳ� �ϼ�");
			System.out.println(resultList.toString());
			return;
		}
		
		//ȣ��
		for(i=resultList.size(); i<numberList.size(); i++){
			DFS(numberList.get(i),resultList);
		} 
		
		
	}
}//class