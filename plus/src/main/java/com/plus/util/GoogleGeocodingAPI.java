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
public class GoogleGeocodingAPI {

	public static MatchingDTO addressToCoord(MatchingDTO matchingDTO, String address) {

		String apiKey = "AIzaSyByqEfW-Me8-33lgE_zeMYMP1hgwhtURJY";

		String requestURI = "https://maps.googleapis.com/maps/api/geocode/json?key=" + apiKey + "&address=";

		try {

			address = URLEncoder.encode(address, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		BufferedReader bufferedReader = openJSONReader(requestURI + address);

		try {

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(bufferedReader);

			JSONArray itemObjectList = (JSONArray) jsonObject.get("results");
			JSONObject resulttempObject1 = (JSONObject) (itemObjectList).get(0);
			JSONObject resultempObject2 = (JSONObject) resulttempObject1.get("geometry");
			JSONObject resulObject = (JSONObject) resultempObject2.get("location");

			matchingDTO.setMatchinglongitude((double) resulObject.get("lng"));
			matchingDTO.setMatchinglatitude((double) resulObject.get("lat"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeJSONReader(bufferedReader);

		return matchingDTO;
	}// AddressToCoord

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
	}// openJSONReader

	public static boolean closeJSONReader(BufferedReader bufferedReader) {

		boolean closeJSONReaderResult = true;

		try {

			bufferedReader.close();

		} catch (IOException e) {

			e.printStackTrace();
			closeJSONReaderResult = false;
		}

		return closeJSONReaderResult;
	}// closeJSONReader

}// class
