package org.ktl.service;

import java.util.List;

import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.LSupportData;
import org.ktl.domain.MemberVO;
import org.ktl.domain.PersonalShoppingHistoryVO;
import org.ktl.domain.RecommendVO;
import org.ktl.domain.RuleConfidence;

public interface AprioriService {

	// 지지도 값 계산
	public LSupportData aprioriSupport() throws Exception;

	// 신뢰도 값 계산
	public List<RuleConfidence> aprioriConfidence(LSupportData resultLS) throws Exception;

	// 향상도 계산하여 규칙 및 신뢰도 테이블 갱신
	public void updateLift() throws Exception;

	// Apriori 알고리즘 전체 수행
	public void apriori() throws Exception;

	// 추천 제품 값 모두 삭제
	public void deleteAllRecommend() throws Exception;

	// 고객이 선택 or 구매한 제품 기반 추천 제품 값 넣기
	public void insertRecommedList(ConfidenceVO cVO) throws Exception;

	// 추천 제품 모두 가져오기
	public List<RecommendVO> getAllRecommend() throws Exception;
	
	// d3 전체수행 
	public List<RecommendVO> executeD3(ConfidenceVO cVO) throws Exception;

	// d3 그래프 그릴 때 루트 노드 정보 가져오기.
	public RecommendVO getRootdata(RecommendVO rVO) throws Exception;
	
	// 개인 구매이력 리스트 가져오기 전체 수행(삭제-삽입-인출)
	public PersonalShoppingHistoryVO getPersonalShoppingHistory(MemberVO mVO) throws Exception;
	
	// lift 개념 Java로 테스트한 코드.(procedure와 성능 비교 위함)
	public void liftInJAVAtest() throws Exception;
	
}// interface
