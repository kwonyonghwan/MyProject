package org.ktl.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.ManufacturerVO;
import org.ktl.domain.ProductAllVO;

import org.ktl.domain.ProductImageVO;

import org.ktl.domain.ProductStockVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.SearchCriteria;
import org.ktl.persistence.BoardDAO;
import org.ktl.persistence.ProductDAO;
import org.springframework.stereotype.Service;

@Service  //spring의 빈으로 인식되기 위해
public class ProductServiceImpl implements ProductService{

	
	@Inject
	private ProductDAO dao;
	
	
	/* ---상품목록---*/
	@Override
	public List<ProductVO> productList() throws Exception {
		
		return dao.productList();
	}
	

	/* ---상품상세보기---*/
	@Override
	public ProductVO productDetail(Integer pno) throws Exception {
		
		return dao.productDetail(pno);
	}
	
	
	/* ---상품재고보기---*/
	@Override
	public List<ProductStockVO> productStock(Integer pno) throws Exception {

		return dao.productStock(pno);
	}


	/* ---LISTCRITERIA---*/
	@Override
	public List<ProductVO> listCriteria(Criteria cri) throws Exception {
	
		return dao.listCriteria(cri);
	}
	
	
	/* ---LISTCOUNTCRITERIA---*/
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		
		return dao.countPaging(cri);
	}

	/* ---LISTSEARCHCRITERIA--- 단일검색 부분*/
	@Override
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}
	
	
	/* ---LISTSEARCHCRITERIA--- 다중검색 부분*/
	@Override
	public List<ProductVO> multiSearch(SearchCriteria cri) throws Exception {
		
		return dao.multiSearch(cri);
	}

	
	/* ---LISTSEARCHCOUNT---*/
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

	/* ---이미지 회전시키기---*/
	@Override
	public ProductImageVO productReelImage(Integer pno) throws Exception {
		// TODO Auto-generated method stub
		return dao.productReelImage(pno);
	}


	@Override
	public List<ProductVO> specificStoreproductList(ManufacturerVO mVO) throws Exception {

		return dao.specificStoreproductList(mVO);
	}


	@Override
	public int specificStoreproductListCount(SearchCriteria cri) throws Exception {
		
		return dao.specificStoreproductListCount(cri);
	}

}
