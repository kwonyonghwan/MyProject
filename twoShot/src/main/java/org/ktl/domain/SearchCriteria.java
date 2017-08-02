package org.ktl.domain;
//page, perPageNum, serchType, keyword 네 개의 데이터를 유지하고 있다. 

import java.util.List;

public class SearchCriteria extends Criteria {

	private String searchType; // 검색 타입( 이름, 모델명, 이름 또는 모델명)
	private String keyword; // 사용자가 검색창에 입력한 키워드
	
	private List<String> category;  // 체크박스에서 사용자가 선택한 카테고리
	private List<String> color; 	// 체크박스에서 사용자가 선택한 색상
	private List<String> size;  //체크박스에서 사용자가 선택한 사이즈
	private String price;		// productSearch.jsp에서 price를 선택할때의 select태그의 name이 price이다. 즉, 이 form데이터를 컨트롤러로 날리면 이 name과 같은 VO의 필드와 매핑시키기 때문에 일단 price멤버 필드로 받고나서, 
	private String beginPrice; // 체크박스에서 사용자가 선택한 가격대
	private String endPrice; // 체크박스에서 사용자가 선택한 가격대
	
	private String manufacturerid;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public List<String> getSize() {
		return size;
	}

	public void setSize(List<String> size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(String beginPrice) {
		this.beginPrice = beginPrice;
	}

	public String getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}

	public String getManufacturerid() {
		return manufacturerid;
	}

	public void setManufacturerid(String manufacturerid) {
		this.manufacturerid = manufacturerid;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", category=" + category
				+ ", color=" + color + ", size=" + size + ", price=" + price + ", beginPrice=" + beginPrice
				+ ", endPrice=" + endPrice + ", manufacturerid=" + manufacturerid + "]";
	}
	
	
}// class
