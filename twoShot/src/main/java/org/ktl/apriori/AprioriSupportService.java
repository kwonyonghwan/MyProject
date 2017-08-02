package org.ktl.apriori;

import java.util.List;
import java.util.Set;

import org.ktl.domain.LSupportData;
import org.ktl.domain.LkSupport;

public interface AprioriSupportService {

	// C1생성
	public List<Set<Integer>> createC1(List<Set<Integer>> dataSetList);
	
	// 항목 출현횟수 카운팅
	public LkSupport scanD(List<Set<Integer>> dataSetList, List<Set<Integer>> Ck, Double minSupport);
	
	// Lk-1로부터 Ck만드는 함수
	// 이미 만들어진 Lk로 Ck+1을 만드는 함수.
	public List<Set<Integer>> aprioriGen(List<Set<Integer>> Lk, Integer k);
	
	// Set타입 원소들 오름차순 정렬
	public Set<Integer> setSort(Set<Integer> key);
		
	// apriori 메소드
	public LSupportData apriori(List<Set<Integer>> dataSetList, Double minSupport);
}
