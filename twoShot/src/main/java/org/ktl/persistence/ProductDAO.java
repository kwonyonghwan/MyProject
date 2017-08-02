package org.ktl.persistence;
//상품
import java.util.List;

import org.ktl.domain.Criteria;
import org.ktl.domain.ManufacturerVO;
import org.ktl.domain.ProductImageVO;
import org.ktl.domain.ProductStockVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.SearchCriteria;

public interface ProductDAO {
	
	public List<ProductVO> productList() throws Exception;  //상품목록

	public ProductVO productDetail(Integer pno) throws Exception;  //상품상세
	
	public List<ProductStockVO> productStock(Integer pno) throws Exception;  //상품재고
	
	public List<ProductVO> productListAll() throws Exception;
	
	public List<ProductVO> listPage(int page) throws Exception;
	
	public List<ProductVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;
	
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;  //단일 검색부분
	
	public List<ProductVO> multiSearch(SearchCriteria cri) throws Exception;  //다중 검색
	
	public int listSearchCount(SearchCriteria cri) throws Exception;  //검색
	
	public ProductImageVO productReelImage(Integer pno) throws Exception; // 이미지 회전
	
	public List<ProductVO> specificStoreproductList(ManufacturerVO mVO) throws Exception;  //상품목록
	
	public int specificStoreproductListCount(SearchCriteria cri) throws Exception; //매장 페이징


}
