package org.ktl.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LSupportData {

		// 최종 지지도맵, L
		Map<Set<Integer>, Double> supportData;
		List<List<Set<Integer>>> L;
		
		// 생성자
		public LSupportData() {
			
			this.supportData = new HashMap<>();
			L = new ArrayList<>();
		}

		public Map<Set<Integer>, Double> getSupportData() {
			return supportData;
		}

		public void setSupportData(Map<Set<Integer>, Double> supportData) {
			this.supportData.putAll(supportData);
		}

		public List<List<Set<Integer>>> getL() {
			return L;
		}

		public void setL(List<Set<Integer>> l) {
			L.add(l) ;
		}

		@Override
		public String toString() {
			return "LSupportData [supportData=" + supportData + ", L=" + L + "]";
		}
	
}// class
