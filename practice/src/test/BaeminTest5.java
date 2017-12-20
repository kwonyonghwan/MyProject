package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class PhotoObject implements Comparable<PhotoObject> {
	String fileType;
	String cityName;
	String day;
	String time;
	int index;

	public PhotoObject(String fileType, String cityName, String day, String time, int index) {
		this.fileType = fileType;
		this.cityName = cityName;
		this.day = day;
		this.time = time;
		this.index = index;
	}

	@Override
	public int compareTo(PhotoObject target) {
		if (this.day.compareTo(target.day) > 0) {
			return 1;
		} else if (this.day.compareTo(target.day) == 0) {
			if (this.time.compareTo(target.time) > 0) {
				return 1;
			} else if (this.time.compareTo(target.time) == 0) {
				return 0;
			} else {
				return -1;
			}
		} else if (this.day.compareTo(target.day) < 0) {
			return -1;
		}
		return 0;
	}

}

public class BaeminTest5 {

	public static void main(String[] args) throws FileNotFoundException {

		String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";
		S+=S;
		S+=S;
		S+=S;
		S+=S;
		String[] photoList = S.split("\n");
		String[] resultList = new String[photoList.length];

		String[][] dataList = new String[photoList.length][4];
		PhotoObject[] inputPhotoList = new PhotoObject[photoList.length];

		for (int i = 0; i < photoList.length; i++) {
			dataList[i] = photoList[i].split(" ");
			dataList[i][0] = dataList[i][0].substring(dataList[i][0].indexOf('.'), dataList[i][0].length() - 1);
			dataList[i][1] = dataList[i][1].substring(0, dataList[i][1].length() - 1);

			PhotoObject temp = new PhotoObject(dataList[i][0], dataList[i][1], dataList[i][2], dataList[i][3], i);
			inputPhotoList[i] = temp;
		}

		HashMap<String, Boolean> keyMap = new HashMap<>();

		for (int i = 0; i < photoList.length; i++) {

			if (!keyMap.containsKey(inputPhotoList[i].cityName)) {
				String targetCity = inputPhotoList[i].cityName;
				ArrayList<PhotoObject> tempList = new ArrayList<>();

				keyMap.put(targetCity, true);

				for (int j = 0; j < photoList.length; j++) {
					if (targetCity.equals(inputPhotoList[j].cityName)) {
						tempList.add(inputPhotoList[j]);
					}

				}

				Collections.sort(tempList);

				for(int j = 0; j<tempList.size(); j++){
					if(tempList.size()>99){
						if(j>98){
							resultList[tempList.get(j).index] = ""+tempList.get(j).cityName+(j+1)+tempList.get(j).fileType;
						} else if(j<9){
								resultList[tempList.get(j).index] = ""+tempList.get(j).cityName+"00"+(j+1)+tempList.get(j).fileType;
							}else{
								resultList[tempList.get(j).index] = ""+tempList.get(j).cityName+"0"+(j+1)+tempList.get(j).fileType;
							}
					}else if(tempList.size()>9){
						if(j<9){
							resultList[tempList.get(j).index] = ""+tempList.get(j).cityName+"0"+(j+1)+tempList.get(j).fileType;
						}else{
							resultList[tempList.get(j).index] = ""+tempList.get(j).cityName+(j+1)+tempList.get(j).fileType;
							
						}
							
					}else{
						
						resultList[tempList.get(j).index] = ""+tempList.get(j).cityName+(j+1)+tempList.get(j).fileType;
					}
					
				}
				
				
				

			} // ifNotFind

		}

		String result = "";
		
		for(int i=0; i<resultList.length; i++){
			System.out.println(resultList[i]);
			result=result+resultList[i]+"\n";
		}
		
		System.out.println(result);
	}// main

}// class
