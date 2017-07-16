package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WineEating {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/WineEating.txt"));
		
		int countOfWine = sc.nextInt()+1;
		int[] wineList = new int[countOfWine];
		int[] bottomUpMap = new int[countOfWine];
		if(countOfWine==2){
			System.out.println(sc.nextInt());
			return;
		}
		
		for(int i=1; i<countOfWine; i++){
			wineList[i] = sc.nextInt();
		}
		
		bottomUpMap[1] = wineList[1];
		bottomUpMap[2] = wineList[1]+wineList[2];
		
		for(int i=3; i<countOfWine; i++){
			bottomUpMap[i] = Math.max(wineList[i-1]+wineList[i]+bottomUpMap[i-3], wineList[i]+bottomUpMap[i-2]);
			bottomUpMap[i] = Math.max(bottomUpMap[i], bottomUpMap[i-1]);
		}
		
		System.out.println(bottomUpMap[countOfWine-1]);

	}
}