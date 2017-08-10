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

			// �ܺ� ���α׷� ��� �б�
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));

			String message = new String();

			// "ǥ�� ���"�� "ǥ�� ���� ���"�� ���
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

			// �ܺ� ���α׷� ��ȯ�� ��� (�� �κ��� �ʼ��� �ƴ�)
			System.out.println("Exit Code: " + oProcess.exitValue());
			System.exit(oProcess.exitValue()); // �ܺ� ���α׷��� ��ȯ����, �� �ڹ� ���α׷� ��ü��
												// ��ȯ������ ���

		} catch (IOException e) { // ���� ó��
			System.err.println("����! �ܺ� ��� ���࿡ �����߽��ϴ�.\n" + e.getMessage());
			System.exit(-1);
		}
		return resultDto;
	}// runChatbot()

}// class