package org.ktl.domain;
//현재 목록 페이지의 정보를 담는 곳
public class Criteria {

	private int page;
	private int perPageNum;
	
	
	public Criteria(){
		this.page = 1;
		this.perPageNum = 15;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
	
		if(page <= 0){
			this.page = 1;  //페이지번호 기본값 = 1
			return;
		}
		
		this.page = page;
	}
	
	public int getPerPageNum() {
	
		return this.perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 20;
			return;
		}
		
		this.perPageNum = 15;	
	}
	
	public int getPageStart(){
		
		return (this.page - 1)* perPageNum;  //20
	}
	
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}


}


