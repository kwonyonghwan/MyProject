package com.plus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import org.springframework.stereotype.Service;

import com.plus.domain.MatchingTempDTO;

import net.minidev.json.parser.JSONParser;

@Service
public class CallAiAPi {

	public MatchingTempDTO runChatbot(String sentence) throws Exception {
		
		MatchingTempDTO resultDto = new MatchingTempDTO();
		try {
			String s;

			ProcessBuilder pb = new ProcessBuilder("C:\\zzz\\client8.exe", sentence);
			Process oProcess = pb.start();

			// 외부 프로그램 출력 읽기
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));

			String message = new String();

			// "표준 출력"과 "표준 에러 출력"을 출력
			while ((s = stdOut.readLine()) != null)
				message += s;
			while ((s = stdError.readLine()) !=  null)
				System.err.println(s);

			// String => JSON
			String[] temp = message.split(" ");

			SimpleDateFormat transFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat transFormat2 = new SimpleDateFormat("HH:mm:ss");
			resultDto.setMatchingcategory(temp[0]);
			resultDto.setMatchinglocation(temp[1]);
			Date to1 = transFormat1.parse(temp[2] + " " + temp[3]);
			Date to2 = transFormat2.parse(temp[3]);
			resultDto.setDate(to1);
			resultDto.setTime(to2);
			
			resultDto.setMatchingpeoplenumber(extractPeopleNumber(temp[4]));
			resultDto.setMatchingagegroup(temp[5]);
			resultDto.setMatchingoptional(temp[6]);

		} catch (IOException e) { // 에러 처리
			System.err.println("에러! 외부 명령 실행에 실패했습니다.\n" + e.getMessage());
			System.exit(-1);
		}
		return resultDto;
	}// runChatbot()
	
	public static int extractPeopleNumber(String temp){

		String result = "";
		char[] changeArray = temp.toCharArray();
		
		for (char c : changeArray) {
			if((int)c >47&& (int)c<58 ){
				result+=c;
			}
		}
		
		return Integer.parseInt(result);
	}//extractPeopleNumber
	
}// class