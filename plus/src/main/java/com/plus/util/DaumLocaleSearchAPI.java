package com.plus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.plus.domain.MatchingDTO;

@Service
public class DaumLocaleSearchAPI {
	
	public static MatchingDTO addressToCoord(MatchingDTO matchingDTO, String address){
		System.out.println(address);
		
		String apiKey = "0fa7d35d2108fc7254a10689d92330c2";

		String requestURI = "http://apis.daum.net/local/geo/addr2coord?apikey=" + apiKey
				+ "&output=json&page_size=1&q=";
		//address = "¾ßÅ¾";
		
		try {

			address = URLEncoder.encode(address, "UTF-8");
 
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		BufferedReader bufferedReader = openJSONReader(requestURI + address);
		
		try {

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(bufferedReader);

			JSONObject channelObject = (JSONObject) jsonObject.get("channel");

			JSONArray itemObjectList = (JSONArray) channelObject.get("item");

			int i = 1;
			for (Object tempObject : itemObjectList) {

				tempObject = (JSONObject) tempObject;

				System.out.println("\ttitle : " + ((JSONObject) tempObject).get("title"));
				matchingDTO.setMatchinglongitude((double) ((JSONObject) tempObject).get("point_x"));
				matchingDTO.setMatchinglatitude((double) ((JSONObject) tempObject).get("point_y"));

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeJSONReader(bufferedReader);
		
		return matchingDTO;
	}//AddressToCoord

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
	}//openJSONReader

	public static boolean closeJSONReader(BufferedReader bufferedReader) {

		boolean closeJSONReaderResult = true;

		try {

			bufferedReader.close();

		} catch (IOException e) {

			e.printStackTrace();
			closeJSONReaderResult = false;
		}

		return closeJSONReaderResult;
	}//closeJSONReader

}//class
