package org.ktl.apriori;

import java.util.List;
import java.util.Set;

import org.ktl.domain.LSupportData;
import org.ktl.domain.RuleConfidence;

public interface AprioriConfidenceService {

	// 규칙 생성.
	public List<RuleConfidence> generateRules(LSupportData resultLS, Double minConfidence);

	// 규칙의 신뢰도 계산 ( 매개변수 : freqSet, H1, 지지도값, 저장될 규칙리스트, 최소신뢰도)
	public List<Set<Integer>> calConf(Set<Integer> freqSet, List<Set<Integer>> H1, LSupportData resultLS,
			List<RuleConfidence> ruleConfidenceList, Double minConf);

	// H1 생성
	public List<Set<Integer>> createH1(Set<Integer> set);
	
	// L[i]의 한 집합의 길이가 3개 이상인 경우 부터 처리해주는 함수
	public void rulesFromConseq(Set<Integer> freqSet, List<Set<Integer>> H, LSupportData resultLS, 
			   	List<RuleConfidence> ruleConfidenceList, Double minConfidence);
	

}// interface
