package algorithm;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Templet4 {

	public static void main(String[] args) throws FileNotFoundException {

		int cacheSize =5;
		String[] cities ={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
	
		
		for(int i=0; i<cities.length; i++){
			cities[i] = cities[i].toLowerCase();
		}
		
		
		Stack<String> LRUStack = new Stack<>();
		int ResultTime = 0;
		for(int i=0; i<cities.length; i++){
			
			if(LRUStack.size()<cacheSize){
				LRUStack.push(cities[i]);
				ResultTime+=5;
				continue;
			}
			
		String[] tempList = new String[cacheSize];
		for(int j=0; j<cacheSize; j++){
			tempList[j] = "==";
		}
		
		boolean hitFlag = false;
		for(int j=cacheSize-1; j>-1; j--){
			String tempCity = LRUStack.pop();
			if(cities[i].equals(tempCity)){
				hitFlag=true;
				continue;
			}
			tempList[j] = tempCity;
		}
		
		if(hitFlag){
			ResultTime+=1;
		}else{
			ResultTime+=5;
		}

		for(int j=0; j<cacheSize; j++){
			
			if(j==0 || !hitFlag){
				continue;
			}
			if(tempList[j].equals("==")){
				continue;
			}
			LRUStack.push(tempList[j]);
		}
		
			LRUStack.push(cities[i]);
		
		}
		
		System.out.println(	ResultTime);
	}// main고려대학교

}// class