package com.plus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * <pre>
 * DESC :
 * Daum 로컬 API 주소 -> 좌표변환
 * JSON Data를 제공받아 좌표정보를 파싱함
 * </pre>
 * 
 * @Company
 * @author hanjoong.cho
 * @Date 2014. 1. 29
 */

//Apriori 알고리즘 전체
	// 스케줄은 메서드에 @Scheduled 어노테이션을 부여해서 설정한다.
	// cron = "초 분 시 월 년 요일"
	// fixed-rate="5000" 5초마다 태스크 호출
	// fixed-delay="5000" 태스크 실행 후에 지정한 5초 동안 대기하고, 다시 태스크를 호출한다.
	//@Scheduled(fixedDelay = 3)
	//@Scheduled(cron = "1 * * * * ?")
public class DaumLocaleSearchAPITest {

	public static void main(String[] args) {

		System.out.println("배치 테스트");
	/*	 http://dna.daum.net/myapi/dataapi/new 에서 발급받은 키를 입력 
		String apiKey = "AIzaSyByqEfW-Me8-33lgE_zeMYMP1hgwhtURJY";

		String requestURI = "https://maps.googleapis.com/maps/api/geocode/json?key="+apiKey+ "&address=";
		
		 //printAddressToCoord(requestURI, "역삼");
		parseAddressToCoord(requestURI, "야탑");
*/
	}

	public static void printAddressToCoord(String requestURI, String address) {

		try {

			address = URLEncoder.encode(address, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		BufferedReader bufferedReader = openJSONReader(requestURI + address);
		printJSONData(bufferedReader);
		closeJSONReader(bufferedReader);
	}

	public static void parseAddressToCoord(String requestURI, String address) {

		try {

			address = URLEncoder.encode(address, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		BufferedReader bufferedReader = openJSONReader(requestURI + address);
		parseJSONData(bufferedReader);
		closeJSONReader(bufferedReader);
	}

	public static void printJSONData(BufferedReader bufferedReader) {

		String inputLine;
		try {

			while ((inputLine = bufferedReader.readLine()) != null) {
				System.out.println(inputLine);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void parseJSONData(BufferedReader bufferedReader) {

		try {

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(bufferedReader);

			JSONArray itemObjectList = (JSONArray) jsonObject.get("results");
			JSONObject resulttempObject1 = (JSONObject)(itemObjectList).get(0);
			JSONObject resultempObject2 = (JSONObject)resulttempObject1.get("geometry");
			JSONObject resulObject = (JSONObject)resultempObject2.get("location");

			double temp1 = (double)resulObject.get("lng");
			double temp2 = (double)resulObject.get("lat");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static BufferedReader openJSONReader(String requestURI) {

		URL requestURL = null;
		try {

			requestURL = new URL(requestURI);

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		URLConnection urlConnection = null;
		try {

			urlConnection = requestURL.openConnection();

		} catch (IOException e) {

			e.printStackTrace();
		}

		BufferedReader bufferedReader = null;
		try {

			bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		} catch (IOException e) {

			e.printStackTrace();
		}

		return bufferedReader;
	}

	public static boolean closeJSONReader(BufferedReader bufferedReader) {

		boolean closeJSONReaderResult = true;

		try {

			bufferedReader.close();

		} catch (IOException e) {

			e.printStackTrace();
			closeJSONReaderResult = false;
		}

		return closeJSONReaderResult;
	}

}
