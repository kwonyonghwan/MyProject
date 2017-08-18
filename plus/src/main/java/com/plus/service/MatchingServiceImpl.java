package com.plus.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.domain.MatchingDTO;
import com.plus.persistence.MatchingDAO;
import com.plus.util.PeopleNumberByCategory;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Inject
	MatchingDAO dao;

	@Override
	public void matchingLogic() {

		List<String> categoryList = dao.readCategoryList();

		for (String string : categoryList) {
			boolean makeMeeting = false;
			List<MatchingDTO> matchingDataList = dao.readMathcingData(string);
			System.out.println(matchingDataList.toString());

			// Logic
			PeopleNumberByCategory peopleNumber = new PeopleNumberByCategory();
			int categoryPeopleNumber = peopleNumber.PeopleNumberByCategory(string);

			ArrayList<String> dateList = new ArrayList<>();
			SimpleDateFormat transFormat = new SimpleDateFormat("MM-dd");
			
			for (MatchingDTO matchingDTO : matchingDataList) {
				dateList.add(transFormat.format(matchingDTO.getMatchingtime()));
			}

			SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
			SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
			
			for (int i = 0; i < dateList.size(); i++) {
				
				ArrayList<ArrayList<MatchingDTO>> timeList = new ArrayList<ArrayList<MatchingDTO>>();

				for (int j = 0; j < 48; j++) {
					timeList.add(new ArrayList<MatchingDTO>());
				}

				for (int j = 0; j < matchingDataList.size(); j++) {
					int hour = Integer.parseInt(hourFormat.format(matchingDataList.get(i).getMatchingtime()));
					int minute = Integer.parseInt(minuteFormat.format(matchingDataList.get(i).getMatchingtime()));
					int index = hour * 2 + ((minute >= 30) ? 1 : 0);

					for (int k = -2; k < 2; k++) {
						if (index + k > -1 && index + k < 48) {
							timeList.get(index + k).add(matchingDataList.get(i));
						}
					}
				} // forMakeTimeList

				int[][] matchingMap = new int[1200][800];
				
				ArrayList<String> memberidList = new ArrayList<>();
				memberidList.add(" ");
				int memberidListIndex = 1;

				for (int time = 0; time < 48; time++) {
					if (timeList.get(time).size() > categoryPeopleNumber) {

						int index = 0;

						for (int timeListSize = 0; timeListSize < timeList.get(time).size(); timeListSize++) {

							int positionI = calcLatitude(timeList.get(time).get(index).getMatchinglatitude());
							int positionJ = calcLongitude(timeList.get(time).get(index).getMatchinglongitude(),
									timeList.get(time).get(index).getMatchinglatitude());

							// 리스트에 추가
							memberidList.add(timeList.get(time).get(index).getMemberid());

							matchingMap[positionI][positionJ] = -memberidListIndex;
							memberidListIndex++;

							boolean matchingFlag = false;
							int resultI = 0;
							int resultJ = 0;

							// 주위 20개 더하기
							// 찍으면서 성공
							for (int k = -20; k <= 20; k++) {
								for (int j = 1; j <= 20 - Math.abs(k); j++) {
									matchingMap[positionI + k][positionJ - j] += 1;
									if (matchingMap[positionI + k][positionJ - j] > categoryPeopleNumber) {
										matchingFlag = true;
										resultI = positionI + k;
										resultJ = positionJ - j;
									}
								}
								matchingMap[positionI + k][positionJ] += 1;
								if (matchingMap[positionI + k][positionJ] > categoryPeopleNumber) {
									matchingFlag = true;
									resultI = positionI + k;
									resultJ = positionJ;
								}
								for (int j = 1; j <= 20 - Math.abs(k); j++) {
									matchingMap[positionI + k][positionJ + j] += 1;
									if (matchingMap[positionI + k][positionJ + j] > categoryPeopleNumber) {
										matchingFlag = true;
										resultI = positionI + k;
										resultJ = positionJ + j;
									}
								}

							} // forIncreaseCountMap

							if (matchingFlag) {
								System.out.println("asdfasdfjqwnerjkqnwerkjqnwerkjqnwrelkqnwerkqlnwrek");
								ArrayList<Integer> resultList = new ArrayList<Integer>();
								for (int k = -20; k <= 20; k++) {
									for (int j = 1; j <= 20 - Math.abs(k); j++) {
										matchingMap[resultI + k][resultJ - j] += 1;
										if (matchingMap[resultI + k][resultJ - j] < 0) {
											resultList.add(matchingMap[resultI + k][resultJ - j]);
										}
									}

									matchingMap[resultI + k][resultJ] += 1;
									if (matchingMap[resultI + k][resultJ] < 0) {
										resultList.add(matchingMap[resultI + k][resultJ]);
									}

									for (int j = 1; j <= 20 - Math.abs(k); j++) {
										matchingMap[resultI + k][resultJ + j] += 1;
										if (matchingMap[resultI + k][resultJ + j] < 0) {
											resultList.add(matchingMap[resultI + k][resultJ + j]);
										}
									}
								} // forSearchList

								ArrayList<String> resultMemberIdList = new ArrayList<String>();
								for (Integer integer : resultList) {
									resultMemberIdList.add(memberidList.get(-integer));
								}

								for (String string2 : resultMemberIdList) {
								
									for(int timeSize=0; timeSize<timeList.get(time).size(); timeSize++){
										if(timeList.get(time).get(timeSize).getMemberid().equals(string2)){
											timeList.get(time).remove(timeSize);
										}
									}
								}

								matchingMap = null;
								memberidList = null;
								memberidListIndex = 1;
								memberidList = new ArrayList<>();
								matchingMap = new int[1200][800];
								time--;
								// pushApp
								
								
								System.out.println("aㄴㅇㄹ머뉴라ㅓㅁ눌엄나룸너ㅏㅇ로ㅓㅂㅈ듀기ㅓㅏ뷰ㅜ러ㅏㅁ눙러ㅏ무러ㅏㅜㅂ자ㅓㅣㄷ규ㅜㅂ자ㅣㅓㄷ구");
								break;
							}

						}

					} // checkPeopleNumber

				} // forTimeList

			} // forDateList

		} // forEach(categoryList)

	}// matchingLogic()

	// 37
	public static int calcLatitude(double latitude) {
		double defaultValue = 38.618403;
		return (int) (((Math.abs(defaultValue - latitude) * 6400 * 2 * 3.141592 / 360)) * 1000) / 500;
	}// clalcLatitude

	public static int calcLongitude(double longitude, double latitude) {
		double defaultValue = 125.882991;
		return (int) ((Math.cos(Math.toRadians(latitude))
				* ((Math.abs(defaultValue - longitude) * 6400 * 2 * 3.141592 / 360)) * 1000)) / 500;
	}// clalcLongitude

}// class
