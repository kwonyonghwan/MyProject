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
		String s;
		try {
			
			
			System.out.println("-------------------runChatbot------------------------");

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

			System.out.println(message);
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

			resultDto.setMatchingpeoplenumber(Integer.parseInt(temp[4]));
			resultDto.setMatchingagegroup(temp[5]);
			resultDto.setMatchingoptional(temp[6]);

			// 외부 프로그램 반환값 출력 (이 부분은 필수가 아님)
			System.out.println("Exit Code: " + oProcess.exitValue());
			System.exit(oProcess.exitValue()); // 외부 프로그램의 반환값을, 이 자바 프로그램 자체의
												// 반환값으로 삼기

		} catch (IOException e) { // 에러 처리
			System.err.println("에러! 외부 명령 실행에 실패했습니다.\n" + e.getMessage());
			System.exit(-1);
		}
		return resultDto;
	}// runChatbot()

}// class