package org.ktl.persistence;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ktl.controller.BoardController;
import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.LSupportData;
import org.ktl.domain.MemberVO;
import org.ktl.domain.PersonalShoppingHistoryVO;
import org.ktl.domain.RecommendVO;
import org.ktl.domain.RuleConfidence;
import org.ktl.domain.ShoppingHistoryVO;
import org.ktl.domain.SupportVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AprioriDAOImpl implements AprioriDAO {


	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private SqlSession session;  

	private static String namespace = "org.ktl.mapper.AprioriMapper";
									
	// 고객마다의 구매 이력(트랜잭션) 모두 가져오기
	@Override
	public List<ShoppingHistoryVO> listAll() throws Exception {
		return session.selectList(namespace+".getTransaction");
	}// listAll()
	
	// DB에 지지도값 넣기
	@Override
	public void insertSupport(LSupportData resultLS) throws Exception {
	
		// tbl_support에 deleteAll이 먼저 되고 수행되어야 한다. 그렇지 않으면 insertSupport가 불릴때 마다
		// tbl_support에 값이 들어가게 되는데 기존에 있는 키 값과 중복이 되기 때문에 오류가 난다. 즉, 업데이트시
		// 일단 테이블에 있는 값을 다 버리고 난다음에 넣어야한다.
		
		// 
		Iterator keys = resultLS.getSupportData().keySet().iterator();
		
		while(keys.hasNext()){
			
			SupportVO supportVO = new SupportVO();
			
			Set<Integer> key = (Set<Integer>) keys.next();
			String supportKey = key.toString().substring(1, key.toString().length()-1).replaceAll("\\s", "");
			Double value = resultLS.getSupportData().get(key);
			
			supportVO.setFreqdata(supportKey);
			supportVO.setSupport(value);
			
			session.insert(namespace+".insertSupport", supportVO);
			
		}// while()	
		
	}// insertSupport()

	
	// DB의 지지도 값 모두 삭제
	@Override
	public void deleteAllSuport() throws Exception {
		session.delete(namespace+".deleteAllSupport");

	}// deleteAllSuport()

	
	// DB에 규칙 및 신뢰도 값 넣기
	@Override
	public void insertRuleConfidence(List<RuleConfidence> ruleConfidenceList) throws Exception {
		for (RuleConfidence ruleConfidence : ruleConfidenceList) {
			ConfidenceVO confidenceVO = new ConfidenceVO();
			
			confidenceVO.setStartdata(ruleConfidence.getStart().toString().substring(1, ruleConfidence.getStart().toString().length()-1).replaceAll("\\s", ""));
			confidenceVO.setEnddata(ruleConfidence.getEnd().toString().substring(1, ruleConfidence.getEnd().toString().length()-1).replaceAll("\\s", ""));
			confidenceVO.setConfidence(ruleConfidence.getConfidence());

			session.insert(namespace+".insertConfidence", confidenceVO );
		}// for()
	}// insertConfidence()

	// DB의 규칙 및 신뢰도 값 모두 삭제
	@Override
	public void deleteAllRuleConfidence() throws Exception {
		session.delete(namespace+".deleteAllConfidence");
		
	}// deleteAllRuleConfidence()

	// 향상도 계산
	@Override
	public void updateLift() throws Exception {		
		session.selectList(namespace+".updateLift");
		
	}// updateLift()


	// 추천 제품 관련
	@Override
	public void insertRecommedList(ConfidenceVO cVO) throws Exception {
		
		session.selectList(namespace+".insertRecommedList", cVO);
	}

	@Override
	public void deleteAllRecommend() throws Exception {
		session.delete(namespace+".deleteAllRecommend");
	}

	@Override
	public List<RecommendVO> getAllRecommend() throws Exception {
		
		return session.selectList(namespace+".getRecommedList");
	}

	@Override
	public RecommendVO getRootdata(RecommendVO rVO) throws Exception {
		return session.selectOne(namespace+".getRootdata", rVO);

	}

	@Override
	public void insertPersonalShoppingHistory(MemberVO mVO) throws Exception {
		session.selectOne(namespace+".insertPersonalShoppingHistory", mVO);
				
	}

	@Override
	public void deleteAllPersonalShoppingHistory() throws Exception {
		session.delete(namespace+".deleteAllPersonalShoppingHistory");
	}

	@Override
	public PersonalShoppingHistoryVO getPersonalShoppingHistory() throws Exception {
		return session.selectOne(namespace+".getPersonalShoppingHistory");
		
	}
	
	/* lift 수행 JAVA 코드로 수행하기 위해 구현한 것들 시작 */
	@Override
	public List<SupportVO> getSupportVO() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getSupportList");
	}

	@Override
	public List<ConfidenceVO> getConfidenceVO() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getConfidenceList");
	}

	@Override
	public void deleteConfidenceVO(ConfidenceVO cVO) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteConfidenceVO",cVO);
		
	}
	/* lift 수행 JAVA 코드로 수행하기 위해 구현한 것들 끝 */
	
}// class
