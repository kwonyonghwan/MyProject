package org.ktl.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingHistoryVO {
	private String memberid;
	private String dataset;
	private Set<Integer> transaction;
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getDataset() {
		return dataset;
	}
	public void setDataset(String dataset) {
		this.dataset = dataset;
		//가져온 스트링을 콤마를 구분자로 끊어서 Set<Integer>형식으로 만들어 준다. 
		
		List<String> splitedStrDataSet = new ArrayList<>();
		List<Integer> splitedIntDataSet = new ArrayList<>();
		
		splitedStrDataSet = Arrays.asList(dataset.split(","));
	
		for (String data : splitedStrDataSet) {
			splitedIntDataSet.add(Integer.parseInt(data));
		}// for()
		
		// splitedIntDataSet로 HashSet을 만들면 null 값이 항상 하나씩 포함되어서 remove(null)하여 제거해줘야한다.
		this.transaction = new HashSet<>(splitedIntDataSet);
		this.transaction.remove(null);
		
	}// setDataSet()
	
	
	public Set<Integer> getTransaction() {
		return transaction;
	}
	
	@Override
	public String toString() {
		return "ShoppingHistoryVO [memberid=" + memberid + ", dataset=" + dataset + ", transaction=" + transaction
				+ "] \n";
	}
	
	
}
