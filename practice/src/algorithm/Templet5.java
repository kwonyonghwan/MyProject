package algorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Templet5 {

	public static void main(String[] args) throws FileNotFoundException {
	//	2, 10, 2, ["09:10", "09:09", "08:00"]
		int n = 1;// 횟수
		int t = 1;// 시간 간격
		int m = 5; // 명수
		String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		int[] convertTime = new int[timetable.length];

		
		int[] busTable = new int[n];

		for (int i = 0; i < timetable.length; i++) {
			convertTime[i] = Integer.parseInt(timetable[i].substring(0, 2)) * 60
					+ Integer.parseInt(timetable[i].substring(3, 5));
		}
		Arrays.sort(convertTime);
		int temp=convertTime[0];
		System.out.println(temp);

		int busPeopleCount = 0;
		// int[][] busTable = new int[n][3]; 0:busIndex 1:busPeopleCount

		for (int i = 0; i < convertTime.length; i++) {
			boolean isboarding = false;
			for (int busIndex = 0; busIndex < n; busIndex++) {
				if ((540 + busIndex * t) >= convertTime[i] && busTable[busIndex]< m) {
					busTable[busIndex]++;
					break;
				}
			} // searchBus
		}

		String answer = "";
		boolean isFull=true;

		for(int i=n-1; i>-1;i--){
			
			if (busTable[i] < m) {
				isFull=false;
				if (((540 + i * t) / 60) < 12) {
					answer+="0";
					answer+=((540 + i * t) / 60);
				}else{
					answer+=((540 + i * t) / 60);
				}
				answer+=":";
				if(i==n-1){
					answer+="00";
					break;
				}
				
				if (((540 + i * t) % 60)+t-1< 10) {
					answer+="0";
					answer+=(     ((540 + i * t) % 60)+t-1  );
				}else{
					answer+=(((540 + i * t) % 60)+t-1);
				}
			break;
			}//제일 뒤에 있을때 
			
		}
		
		if(isFull){
			temp-=1;	
			if ((temp / 60) < 12) {
						answer+="0";
						answer+=(temp / 60);
					}else{
						answer+=(temp / 60);
					}
					answer+=":";
				
					if ((temp % 60)< 10) {
						answer+="0";
						answer+=((temp % 60)+t-1  );
					}else{
						answer+=((temp % 60)+t-1);
					}
			System.out.println(answer);
		}else{
			System.out.println(answer);
		}
		
	}// main고려대학교

}// class