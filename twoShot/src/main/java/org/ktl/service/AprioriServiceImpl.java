package org.ktl.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.ktl.apriori.AprioriConfidenceServiceImpl;
import org.ktl.apriori.AprioriSupportServiceImpl;
import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.LSupportData;
import org.ktl.domain.MemberVO;
import org.ktl.domain.PersonalShoppingHistoryVO;
import org.ktl.domain.RecommendVO;
import org.ktl.domain.RuleConfidence;
import org.ktl.domain.ShoppingHistoryVO;
import org.ktl.domain.SupportVO;
import org.ktl.persistence.AprioriDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AprioriServiceImpl implements AprioriService {

	@Inject
	private AprioriDAO dao;

	@Inject
	private AprioriSupportServiceImpl supportService;
	
	@Inject
	private AprioriConfidenceServiceImpl confidenceService;
	
	// 최소 지지도
	private static final Double MIN_SUPPORT = 0.015;
	// 최소 신뢰도
	private static final Double MIN_CONFIDENCE = 0.15;

	// 지지도 계산
	@Override
	public LSupportData aprioriSupport() throws Exception {

		LSupportData resultLS = new LSupportData();	// 빈발항목집합리스트 L, 지지도데이터 SupportData 
		List<RuleConfidence> ruleConfidenceList = new ArrayList<>(); // 규칙, 신뢰도
		
		AprioriSupportServiceImpl supportService = new AprioriSupportServiceImpl();
		
		// 데이터셋 로드
		List<ShoppingHistoryVO> ShoppingHistoryVOList = dao.listAll();
		List<Set<Integer>> dataSetList =
				new ArrayList<>(new HashSet<>());;
				
		for (ShoppingHistoryVO vo : ShoppingHistoryVOList) {
			dataSetList.add(vo.getTransaction());
		}// for()
		
		// 지지도 계산
		resultLS = supportService.apriori(dataSetList, MIN_SUPPORT);
		
		// 지지도 데이터 DB에 삽입.( 삽입전에 테이블의 모든 행을 삭제하여야 한다. 아니면 pk 충돌 남.)
		dao.deleteAllSuport();

		dao.insertSupport(resultLS);

		return resultLS;
	}// aprioriSupport()

	// 신뢰도 계산 및 규칙 생성
	@Override
	public List<RuleConfidence> aprioriConfidence(LSupportData resultLS) throws Exception {
	
		List<RuleConfidence> ruleConfidenceList 
			= confidenceService.generateRules(resultLS , MIN_CONFIDENCE);
		
		// 규칙 및 신뢰도 DB에 삽입. ( 삽입전에 테이블의 모든 행을 삭제하여야 한다. 아니면 pk 충돌 남.)
		dao.deleteAllRuleConfidence();		
		dao.insertRuleConfidence(ruleConfidenceList);

		return ruleConfidenceList;
	}// aprioriConfidence()

	// 생성된 규칙 및 신뢰도 값에서 lift를 만족하는 것만 남기도록 한다.
	@Override
	public void updateLift() throws Exception {
		
		dao.updateLift();
	}// updateLift()

	
	// Apriori 알고리즘 전체
	// 스케줄은 메서드에 @Scheduled 어노테이션을 부여해서 설정한다.
	// cron = "초 분 시 월 년 요일"
	// fixed-rate="5000" 5초마다 태스크 호출
	// fixed-delay="5000" 태스크 실행 후에 지정한 5초 동안 대기하고, 다시 태스크를 호출한다.
	//@Scheduled(fixedDelay = 3)
	//@Scheduled(cron = "1 * * * * ?")
	@Override
	public void apriori() throws Exception {
		long start = System.currentTimeMillis();
		
		// 지지도 계산
		LSupportData ls = aprioriSupport();
		// 신뢰도 계산 및 규칙 생성
		List<RuleConfidence> rc = aprioriConfidence(ls);
		// 향상도 계산
	   	updateLift(); 
	   	
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));
		
		System.out.println("- 빈발집합리스트\n" + ls.getL());
		System.out.println("- 지지도 \n" + ls.getSupportData());
			
		System.out.println("- 규칙 및 신뢰도");
		for (RuleConfidence r : rc) {
			System.out.println(r.getStart()+"=>"+r.getEnd()+"\t\t"+r.getConfidence());
		}// for()
				
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "s" );
		System.out.println(str);// 현재 시각
		
	}// apriori()

	
	
	// 추천 테이블 모든 행 삭제
	@Override
	public void deleteAllRecommend() throws Exception {
		dao.deleteAllRecommend();
		
	}// deleteAllRecommend()
	
	// 매개변수로 넘어온 startdata에 대한 추천제품들 추천 테이블에 삽입

	@Override
	public void insertRecommedList(ConfidenceVO cVO) throws Exception {
		dao.insertRecommedList(cVO);
		
	}// insertRecommedList()
	
	// 추천 테이블에서 값(추천 제품 리스트) 읽어옴

	@Override
	public List<RecommendVO> getAllRecommend() throws Exception {
		return dao.getAllRecommend();
		
	}// getAllRecommend()

	@Override
	public List<RecommendVO> executeD3(ConfidenceVO cVO) throws Exception {
	
		// 기존의 추천테이블 내용 삭제하고,
		dao.deleteAllRecommend();
		// cVO에 담긴 startdata에 해당하는 추천제품리스트를 추천테이블에 삽입하고,
		dao.insertRecommedList(cVO);
		// 갱신된 추천테이블의 내용을 받아와서 반환한다.
		List<RecommendVO> rList = dao.getAllRecommend();
		
		return rList;
		
	}// executeD3()

	@Override
	public RecommendVO getRootdata(RecommendVO rVO) throws Exception {

		return dao.getRootdata(rVO);
	}// getRootdata()

	@Override
	public PersonalShoppingHistoryVO getPersonalShoppingHistory(MemberVO mVO) throws Exception {
		
		dao.deleteAllPersonalShoppingHistory();
		dao.insertPersonalShoppingHistory(mVO);
		
		return dao.getPersonalShoppingHistory();
	}// getPersonalShoppingHistory()

	
	// lift 개념 Java로 테스트한 코드.(procedure와 성능 비교 위함)
	@Override
	public void liftInJAVAtest() throws Exception {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();

		// DB로 부터 지지도 값 가져옴.
		List<SupportVO> sList = dao.getSupportVO();
		// DB로 부터 신뢰도 값 가져옴.
		List<ConfidenceVO> cList = dao.getConfidenceVO();


		for (ConfidenceVO cVO : cList) {
			for (SupportVO sVO : sList) {
				if (cVO.getEnddata().equals(sVO.getFreqdata())) {
					// lift 값이 1이 넘으면 삭제
					if( (cVO.getConfidence() / sVO.getSupport()) > 1 )
					{
						dao.deleteConfidenceVO(cVO);
					}// if
				}// if
			}// for
		}// for
		
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "s" );
		
	}// liftInJAVAtest()
	
}// class
