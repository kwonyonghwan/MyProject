package org.ktl.domain;

import java.util.List;


import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	  private int totalCount;
	  private int startPage;
	  private int endPage;
	  private boolean prev;
	  private boolean next;
	  private Criteria cri;
	 
	
	  private int displayPageNum = 10;  // 화면에 보여지는 페이지 번호의 숫자


	  public Criteria getCri() {
		  return cri;
	  }
	  
	  public void setCri(Criteria cri) {
	    this.cri = cri;
	  }

	  public int getTotalCount() {
		  return totalCount;
	  }

	  public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;

	    calcData();
	  }

	  public int getStartPage() {
	    return startPage;
	  }
	  
	  public int setStartPage() {
		    return startPage;
	  }


	  public int getEndPage() {
	    return endPage;
	  }
	  
	  public int setEndPage() {
		    return endPage;
		  }

	  public boolean isPrev() {
	    return prev;
	  }

	public boolean isNext() {
	    return next;
	  }

	  public int getDisplayPageNum() {
	    return displayPageNum;
	  }
	  
	  public int setDisplayPageNum() {
		    return displayPageNum;
	  }


	  private void calcData() {

		    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		    startPage = (endPage - displayPageNum) + 1;

		    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		    if (endPage > tempEndPage) {
		      endPage = tempEndPage;
		    }

		    prev = startPage == 1 ? false : true;

		    next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

		  }
	
	  
	//게시판에서 페이지를 처리하기 위해서 관련 정보를 쿼리에 넣는 부분
	public String makeQuery(int page) {

	    UriComponents uriComponents = 
	    		UriComponentsBuilder.newInstance()
	    		.queryParam("page", page)
	    		.queryParam("perPageNum", cri.getPerPageNum())
	    		.build();

	    return uriComponents.toUriString();
	  }
	
	// URI컴포넌트를 이용해 페이징 처리에 필요한 데이터를 생성한다. 
	// 링크가 필요한 부분에 자동으로 만들어진다.
	public String makeSearch(int page) {
		
	    UriComponents uriComponents = 
	    		UriComponentsBuilder.newInstance()
	    		.queryParam("page", page)
	    		.queryParam("perPageNum", cri.getPerPageNum())
	    		.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	    		.queryParam("keyword", ((SearchCriteria)cri).getKeyword())
	    		.build();

	    return uriComponents.toUriString();
	}
	
	
	public String searchCondition(int page) {
		    UriComponents uriComponents = 
		    		UriComponentsBuilder.newInstance()
		    		/*.queryParam("perPageNum", cri.getPerPageNum())
		    		.queryParam("category", ((SearchCriteria)cri).getCategory())	    	
		    		.queryParam("color", ((SearchCriteria)cri).getColor())
		    		.queryParam("size", ((SearchCriteria)cri).getSize())
		    		.queryParam("price", ((SearchCriteria)cri).getPrice())*/
		    		.queryParam("page", page)
		    		.build();
		    return uriComponents.toUriString();
	}
	

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	/* 게시만 주소가 http://www.oneshot.com 이고 page가 "3" perPageNum이 20이라면 이 함수의 리턴값은
	 http://www.oneshot.com?page=3&perPageNum=20 으로. */
	
}
