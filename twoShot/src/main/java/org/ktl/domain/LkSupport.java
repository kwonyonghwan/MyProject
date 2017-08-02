package org.ktl.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LkSupport {
	
	// 지지도맵, Lk
	Map<Set<Integer>, Double> itemSupportMap;
	List<Set<Integer>> Lk;
	
	// 생성자
	public LkSupport() {
	
		this.itemSupportMap = new HashMap<>();
		Lk = new ArrayList<>();
	}

	public Map<Set<Integer>, Double> getItemSupportMap() {
		return itemSupportMap;
	}

	public void setItemSupportMap(Map<Set<Integer>, Double> itemSupportMap) {
		this.itemSupportMap = itemSupportMap;
	}

	public List<Set<Integer>> getLk() {
		return Lk;
	}

	public void setLk(List<Set<Integer>> lk) {
		Lk = lk;
	}

	@Override
	public String toString() {
		return "LkSupport [itemSupportMap=" + itemSupportMap + ", Lk=" + Lk + "]";
	}
	
}// class
	
