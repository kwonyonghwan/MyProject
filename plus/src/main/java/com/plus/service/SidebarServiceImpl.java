package com.plus.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.domain.BlacklistDTO;
import com.plus.domain.MeetingDTO;
import com.plus.persistence.BlacklistDAO;
import com.plus.persistence.MeetingDAO;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
public class SidebarServiceImpl implements SidebarService {

	@Inject
	private MeetingDAO meetingDao;
	
	@Inject 
	private BlacklistDAO blackListDao;
	
	@Override
	public JSONArray readSidebarData(String memberid) {

		JSONArray sideJSON = new JSONArray();
		//json객체만들기 

		JSONObject id1 = new JSONObject();
		id1.put("id", 1);
		id1.put("level", 0);
		id1.put("name", "주변모임찾기");
		id1.put("icon", "ion-ios-location");
		id1.put("state", "search");
		id1.put("items", null);
		sideJSON.add(id1);
		
		List<MeetingDTO> meetingList =  meetingDao.selectMeetingList(memberid);
		
		JSONArray beforeMeetingArray = new JSONArray();
		JSONArray afterMeetingArray = new JSONArray();

		int beforeID = 20;
		int afterID = 30;
		for (MeetingDTO meetingDTO : meetingList) {
			JSONObject meetingInfo = new JSONObject();
			meetingInfo.put("level", 1);
			meetingInfo.put("name", makeMeetingName(meetingDTO));
			meetingInfo.put("items", null);
			meetingInfo.put("state", "meeting({mno: "+meetingDTO.getMno()+"})");
			
			if(meetingDTO.getMeetingstate().equals("before")){
				meetingInfo.put("id", beforeID);
				beforeID++;
				beforeMeetingArray.add(meetingInfo);
			}else{
				meetingInfo.put("id", afterID);
				afterID++;
				afterMeetingArray.add(meetingInfo);
			}
		}//forList<meeting>
		
		JSONObject id2 = new JSONObject();
		id2.put("id", 2);
		id2.put("level", 0);
		id2.put("name", "예정된모임");
		id2.put("icon", "ion-ios-people");
		if(beforeMeetingArray.size()==0){
			id2.put("items",null);
		}else{
			id2.put("items", beforeMeetingArray);
		}
		sideJSON.add(id2);

		JSONObject id3 = new JSONObject();
		id3.put("id", 3);
		id3.put("level", 0);
		id3.put("name", "완료된모임");
		id3.put("icon", "ion-checkmark-round");
		id3.put("items", afterMeetingArray);
		sideJSON.add(id3);
     
		JSONObject id4 = new JSONObject();
		id4.put("id", 4);
		id4.put("level", 0);
		id4.put("name", "블랙리스트");
		id4.put("icon", "ion-trash-a");
		id4.put("items", null);
		sideJSON.add(id4);
     	System.out.println(sideJSON.toJSONString());
		return sideJSON;
	}//readSidebarData

	public static String makeMeetingName(MeetingDTO meetingDTO){
		
		String meetingName = "";
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd일");
		String meetingDay = 	dayFormat.format(meetingDTO.getMeetingtime());
		meetingName +=meetingDay;
		meetingName += " ";
		meetingName += meetingDTO.getMeetingcategory();
		
		return meetingName;
	}//makeMeetingName
	
}//class
