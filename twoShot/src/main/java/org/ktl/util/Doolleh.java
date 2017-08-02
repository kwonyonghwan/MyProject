package org.ktl.util;

import java.util.Iterator;
import java.util.Map;

public class Doolleh {
	
	
	public int calcDoolleh(int footHeight,int footWidth, String sex) {
		
		Maps maps = new Maps();
		int temp;
		int difference = 100;
		int least=0;
		
		
		for(int i = 0; i < 21 ; i++){
			int num = 200+ i*5;
			temp = Math.abs(footHeight-num);
			if(temp<difference){
				difference = temp;
					
			}
			if(difference != 100 && temp>difference){
				least = num;
				break;
			}
			
		}
		//System.out.println("길이 최소 : "+least);
		Map<Integer,Integer> tempMap;
		if(sex.equals("male")){
			System.err.println("CALLED MANFOOT");
			tempMap =  maps.getManFoot().get(least);
		}else{
			System.err.println("CALLED WOMANFOOT");
			tempMap =  maps.getWomanFoot().get(least);
		}
		
	
		Iterator itr = tempMap.keySet().iterator();
		int widthTemp;
		int widthDifference = 100;
		int widthLeast = 0;
		while(itr.hasNext()){
			
			Integer key = (Integer) itr.next();
			
			widthTemp = Math.abs(footWidth-key);
			if(widthTemp< widthDifference){
				widthDifference = widthTemp;
				widthLeast = key;
			}
			if(widthTemp== widthDifference){
				if(widthLeast < key){
					widthLeast = key;
				}
			}
			
		}
		//System.out.println("너비 최소 : "+widthLeast);
		
		
		//System.out.println("둘레 길이 : "+tempMap.get(widthLeast));
		
		return tempMap.get(widthLeast);
	}
}
