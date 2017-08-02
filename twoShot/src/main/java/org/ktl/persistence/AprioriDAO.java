package org.ktl.persistence;

import java.util.List;

import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.LSupportData;
import org.ktl.domain.MemberVO;
import org.ktl.domain.PersonalShoppingHistoryVO;
import org.ktl.domain.RecommendVO;
import org.ktl.domain.RuleConfidence;
import org.ktl.domain.ShoppingHistoryVO;
import org.ktl.domain.SupportVO;

public interface AprioriDAO {

	// 고객마다의 구매 이력(트랜잭션) 모두 가져오기
	public List<ShoppingHistoryVO> listAll() throws Exception;

	// DB에 지지도값 넣기
	public void insertSupport(LSupportData resultLS) throws Exception;

	// DB의 지지도 값 모두 삭제
	public void deleteAllSuport() throws Exception;

	// DB에 규칙 및 신뢰도 값 넣기
	public void insertRuleConfidence(List<RuleConfidence> ruleConfidenceList) throws Exception;

	// DB의 규칙 및 신뢰도 값 모두 삭제
	public void deleteAllRuleConfidence() throws Exception;

	// 향상도 계산하여 규칙 및 신뢰도 테이블 갱신
	public void updateLift() throws Exception;

	// 추천 제품 값 모두 삭제
	public void deleteAllRecommend() throws Exception;

	// 고객이 선택 or 구매한 제품 기반 추천 제품 값 넣기
	public void insertRecommedList(ConfidenceVO cVO) throws Exception;

	// 추천 제품  모두 가져오기
	public List<RecommendVO> getAllRecommend() throws Exception;

	// d3 그래프로 그릴때 루트 노드  가져오기
	public RecommendVO getRootdata(RecommendVO rVO) throws Exception;

	// 개인구매이력 테이블 모든 행 삭제
	public void deleteAllPersonalShoppingHistory() throws Exception;
	
	// 개인 구매이력 리스트 가공하여 개인구매이력 테이블에 삽입
	public void insertPersonalShoppingHistory(MemberVO mVO) throws Exception;
	
	// 개인구매이력 테입블에서 값 가져옴
	public PersonalShoppingHistoryVO getPersonalShoppingHistory() throws Exception;
	
	/* lift 수행 JAVA 코드로 수행하기 위해 구현한 것들 시작 */
	public List<SupportVO> getSupportVO() throws Exception;
	public List<ConfidenceVO> getConfidenceVO() throws Exception;
	// 리프트 못 넘는 데이터 삭제
	public void deleteConfidenceVO(ConfidenceVO cVO) throws Exception;
	/* lift 수행 JAVA 코드로 수행하기 위해 구현한 것들 끝 */
	
}// interface()
