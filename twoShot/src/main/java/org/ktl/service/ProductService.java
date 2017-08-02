package org.ktl.service;

import java.util.List;

import org.ktl.domain.Criteria;
import org.ktl.domain.ManufacturerVO;
import org.ktl.domain.ProductAllVO;

import org.ktl.domain.ProductImageVO;

import org.ktl.domain.ProductStockVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.SearchCriteria;

public interface ProductService {
	
	public List<ProductVO> productList() throws Exception;  // listALL	
	
	public ProductVO productDetail(Integer pno) throws Exception;  //게시물 상세 보기
	
	public ProductImageVO productReelImage(Integer pno) throws Exception;
	
	public List<ProductStockVO> productStock(Integer pno) throws Exception;  //상품재고

	public List<ProductVO> listCriteria(Criteria cri) throws Exception;  //페이징 처리
	
	public int listCountCriteria(Criteria cri) throws Exception;

	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;  //단일 검색부분
	
	public List<ProductVO> multiSearch(SearchCriteria cri) throws Exception;  //다중 검색부분
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<ProductVO> specificStoreproductList(ManufacturerVO mVO) throws Exception; 
	
	public int specificStoreproductListCount(SearchCriteria cri) throws Exception; //매장 페이징
}
