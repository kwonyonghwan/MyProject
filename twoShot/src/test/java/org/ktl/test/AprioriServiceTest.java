package org.ktl.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.LSupportData;
import org.ktl.domain.MemberVO;
import org.ktl.domain.RecommendVO;
import org.ktl.domain.RuleConfidence;
import org.ktl.service.AprioriService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class AprioriServiceTest {
	
	@Inject
	private AprioriService service;
	
	
	
	@Test
	public void test() throws Exception {
		
		LSupportData resultLS = service.aprioriSupport();
		
		System.out.println("-빈발항목집합\n" + resultLS.getL());
		System.out.println("-지지도\n" +resultLS.getSupportData());
		
		List<RuleConfidence> ruleConfidenceList 
				= service.aprioriConfidence(resultLS);
		
		System.out.println("<생성된 규칙>");
		for (RuleConfidence ruleConfidence : ruleConfidenceList) {
			System.out.println(ruleConfidence.getStart()+"-->" + ruleConfidence.getEnd() +"\t"+ ruleConfidence.getConfidence());
		}
		
	}// test()

	@Test
	public void insertSupportTest() throws Exception {
		service.aprioriSupport();
		
	}// test()
	
	@Test
	public void insertConfidenceTest() throws Exception {
		service.aprioriConfidence(service.aprioriSupport());
		
	}// test()
	
	@Test
	public void aprioriTest() throws Exception {
		long start = System.currentTimeMillis();
		System.out.println(service);
		service.apriori();
		
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "s" );
		
	}// test()
	
	@Test
	public void executeD3Test() throws Exception {
	
		ConfidenceVO cVO = new ConfidenceVO();
		cVO.setStartdata("38");
		
		List<RecommendVO> rList = service.executeD3(cVO);
		
		for (RecommendVO recommendVO : rList) {
			System.out.println(recommendVO);
		}
		
	}// test()
	
	@Test
	public void getPersonalShoppingHistoryTest() throws Exception {
	
		MemberVO mVO = new MemberVO();
		mVO.setMemberid("pcid");
		
		System.out.println(service.getPersonalShoppingHistory(mVO));
	}// test()
	
	
	/* lift개념 JAVA코드로 작성한 것 테스트 부분 (procedure와 성능 비교위함) */
	@Test
	public void liftInJAVAtest() throws Exception {
		service.liftInJAVAtest();
		
	}// test()
	
	
}// class
