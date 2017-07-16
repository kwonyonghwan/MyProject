package algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class UnSolve {

	public static void main(String[] args) {
		
		File directory = new File("C:/Users/yonghwan/Desktop/권용환/공부 자료/전공 스터디/unsolve");
		
		File[] files = directory.listFiles();
		ArrayList<String> fileNameList =new ArrayList<String>();
		
		for (File file : files) {
			if(file.isFile()){
				if(file.getName().substring(file.getName().length()-3, file.getName().length()).equals("txt")){
					continue;
				}
				fileNameList.add(file.getName());
			}
		}//forSetting
	
		System.out.println(fileNameList.get((int)(Math.random()*fileNameList.size())));
	
	}//main

}//class



