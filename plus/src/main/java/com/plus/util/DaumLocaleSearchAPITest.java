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
public class DaumLocaleSearchAPITest {

	public static void main(String[] args) {

		/* http://dna.daum.net/myapi/dataapi/new 에서 발급받은 키를 입력 */
		String apiKey = "AIzaSyByqEfW-Me8-33lgE_zeMYMP1hgwhtURJY";

		String requestURI = "https://maps.googleapis.com/maps/api/geocode/json?key="+apiKey+ "&address=";
		
		 //printAddressToCoord(requestURI, "역삼");
		parseAddressToCoord(requestURI, "야탑");

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
