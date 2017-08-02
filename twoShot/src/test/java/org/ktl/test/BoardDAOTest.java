package org.ktl.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.SearchCriteria;
import org.ktl.persistence.BoardDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sun.media.jfxmedia.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;

	/* -----CREATE------ */
	@Test
	public void createTest() throws Exception {
		
		BoardVO bVo = new BoardVO();
		
		bVo.setTitle("고구마과자!!!");
		bVo.setContent("맛이따!!!");
		bVo.setWriter("jiwonlove");
		dao.create(bVo);
	}
	
	
	/* -----READ------ */
	@Test
	public void readTest() throws Exception {
		
		System.out.println(dao.read(1));  //dao.read에 bno가 2인 값을  문자로 출력한다. 
	}  //null..............
	

	/* -----UPDATE------ */
	@Test
	public void updateTest() throws Exception {
		
		BoardVO bVo = new BoardVO();
		bVo.setBno(1);
		bVo.setTitle("잘지내요");
		bVo.setContent("안녕");
		dao.update(bVo);
		
		System.out.println(dao.read(2));
	}
	
	
	/* -----DELETE------ */
	@Test
	public void deleteTest() throws Exception {
		
		dao.delete(5);  //dao에서 bno가 3인 항목 제거 
	}
	
	
	/* -----LISTALL------ */
	@Test
	public void listAllTest() throws Exception {
		
		dao.listAll();
		System.out.println("전체목록:" + dao.listAll());
	}
	
	
	/* -----LISTPAGE------ */
	@Test
	public void listPageTest() throws Exception {
		
		int page = 2;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO bVo : list) {
			
			System.out.println(bVo.getBno() + ":" + bVo.getContent());
		}//for
	}
	
	
	/* -----LISTCRITERIA------ */
	@Test
	public void ListCriteriaTest() throws Exception {
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO bVo : list) {
			System.out.println(bVo.getBno() + ":" + bVo.getContent());
			
		}//for
		
	}
	
	/* -----UriComponentsBuilder 사용 테스트------ */
	  @Test
	  public void testURI() throws Exception {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/board/read").queryParam("bno", 12)
	        .queryParam("perPageNum", 20).build();

	    System.out.println("/board/read?bno=12&perPageNum=20");
	    System.out.println(uriComponents.toString());

	  } // uriComponents = URI를 작성할 때 도움이 되는 클래스로, Path나 query에 해당하는 문자열을 추가해서 원하는 URI를 생성할 때 사용한다.
	  
	  
	  @Test
	  public void testURI2() throws Exception {

		//{module}->board, {page}->read
	    UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("bno", 12)
	        .queryParam("perPageNum", 20).build().expand("board", "read").encode();

	    System.out.println("/board/read?bno=12&perPageNum=20");
	    System.out.println(uriComponents.toString());
	  }
	  
	  
	  /* -----testDynamic1------오류!!!나중에 다시보기*/
	  @Test
	  public void testDynamic1() throws Exception {

	    SearchCriteria cri = new SearchCriteria();
	    cri.setPage(1);
	    cri.setKeyword("글");
	    cri.setSearchType("t");

	    System.out.println("=====================================");

	    List<BoardVO> list = dao.listSearch(cri);

	    for (BoardVO bVo : list) {
	      System.out.println(bVo.getBno() + ": " + bVo.getTitle());
	    }

	    System.out.println("=====================================");

	    System.out.println("COUNT: " + dao.listSearchCount(cri));
	    
	  }
		
}

