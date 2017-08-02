package org.ktl.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.MemberVO;
import org.ktl.domain.RecommendVO;
import org.ktl.domain.ShoppingHistoryVO;
import org.ktl.domain.SupportVO;
import org.ktl.persistence.AprioriDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class AprioriDAOTest {

	@Inject
	private AprioriDAO dao;

	@Test
	public void test() throws Exception {
		
		List<ShoppingHistoryVO> ShoppingHistoryList; 
		ShoppingHistoryList = dao.listAll();
		
		for (ShoppingHistoryVO shoppingHistoryVO : ShoppingHistoryList) {
			System.out.println(shoppingHistoryVO.getMemberid() +"\t "+  shoppingHistoryVO.getTransaction());
		}
		
	}// test()

	
	@Test
	public void liftTest() throws Exception {
		long start = System.currentTimeMillis();
		dao.updateLift();
	
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "s" );
		
	}// liftTest()

	
	
	@Test
	public void getRecommedListTest() throws Exception {
	
		ConfidenceVO cVO = new ConfidenceVO();
		cVO.setStartdata("38");
	
		dao.deleteAllRecommend();
		dao.insertRecommedList(cVO);
		
		List<RecommendVO> rList = dao.getAllRecommend();
		
		for (RecommendVO recommendVO : rList) {
			System.out.println(recommendVO);
		}

	}// getRecommedListTest()
	
	@Test
	public void getRootdata() throws Exception {
		RecommendVO rVO = new RecommendVO();
		rVO.setPno(38);
		System.out.println(dao.getRootdata(rVO));
	
	}// liftTest()
	
	
	@Test
	public void fileTest() throws Exception {
		
		String fileName = "C:\\zzz\\test11.json" ;
	    String txt = "t";
		
	    try{
	                     
	        // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
	        
	    	// 이어쓰기
	    	//BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	    	// 덮어쓰기
	    	BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
	        
	        // 파일안에 문자열 쓰기
	        fw.write(txt);
	        fw.flush();

	        // 객체 닫기
	        fw.close(); 
	         
	         
	    }catch(Exception e){
	        e.printStackTrace();
	    }
		
	}// liftTest()	
	
	
	@Test
	public void insertShoppingHistory() throws Exception {
		MemberVO mVO = new MemberVO();
		mVO.setMemberid("pcid");
		dao.insertPersonalShoppingHistory(mVO);
	
	}// insertShoppingHistory()
	
	@Test
	public void deleteShoppingHistory() throws Exception {

		dao.deleteAllPersonalShoppingHistory();
	}// deleteShoppingHistory()
	
	
	@Test
	public void getShoppingHistory() throws Exception {
		
		System.out.println(dao.getPersonalShoppingHistory());
	}// getShoppingHistory()
	
	@Test
	public void AllpersonalShoppingHistory() throws Exception {
		
		dao.deleteAllPersonalShoppingHistory();
		
		MemberVO mVO = new MemberVO();
		mVO.setMemberid("pcid");
		dao.insertPersonalShoppingHistory(mVO);
		
		System.out.println(dao.getPersonalShoppingHistory());
		
		
	}// getShoppingHistory()
	
	
	
	/* lift개념 JAVA코드로 작성한 것 테스트 부분 (procedure와 성능 비교위함)시작 */
	@Test
	public void getConfidenceVOTest() throws Exception {
		
		List<ConfidenceVO> cList = dao.getConfidenceVO();
		
		for (ConfidenceVO ConfidenceVO : cList) {
			System.out.println(ConfidenceVO);
		}

	}// getRecommedListTest()
	
	
	@Test
	public void getSupportVOTest() throws Exception {
		
		List<SupportVO> sList = dao.getSupportVO();
		
		for (SupportVO SupportVO : sList) {
			System.out.println(SupportVO);
		}

	}// getRecommedListTest()
	/* lift개념 JAVA코드로 작성한 것 테스트 부분 (procedure와 성능 비교위함)끝 */
	
	
	
	
	
	

}// class
