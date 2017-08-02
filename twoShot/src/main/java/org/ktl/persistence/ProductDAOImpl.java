package org.ktl.persistence;
import java.util.Iterator;
//상품 목록 , 페이징, 상세보기
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ktl.controller.BoardController;
import org.ktl.domain.Criteria;
import org.ktl.domain.ManufacturerVO;
import org.ktl.domain.ProductImageVO;
import org.ktl.domain.ProductStockVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.SearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private SqlSession session;  

	private static String namespace = "org.ktl.mapper.ProductMapper";

	
	@Override
	public List<ProductVO> productList() throws Exception {
		
		return session.selectList(namespace + ".productList");
	}


	
	/*----상품 목록 전체를 반환-----*/
	@Override
	public List<ProductVO> productListAll() throws Exception {
		
		return session.selectList(namespace + ".findAll");
	}
	
	
	/* ---- 상품상세 ----*/
	@Override
	public ProductVO productDetail(Integer pno) throws Exception {

		return session.selectOne(namespace + ".read", pno);
	}
	
	
	/* ---- 상품재고 ----*/
	@Override
	public List<ProductStockVO> productStock(Integer pno) throws Exception {
		
		
		return session.selectList(namespace + ".productStock", pno);
	}

	
	/* ---- 페이징한 상품목록 ----*/
	@Override
	public List<ProductVO> listPage(int page) throws Exception {
		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page -1)*10;
		
		return session.selectList(namespace + ".listPage", page);
	}

	
	/* ---- listCriteria ----*/
	@Override
	public List<ProductVO> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(namespace + ".listCriteria", cri);
	}

	/* ---- countPaging ----*/
	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(namespace + ".countPaging", cri);
	}

	/* ---- 단일검색(검색창) ----*/
	@Override
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".productSearch", cri);
	}
	
	
	/* ---- 다중검색(체크박스) ----*/
	@Override
	public List<ProductVO> multiSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".productMultiSearch", cri);
	}//

	
	/* ---- listSearchCount(페이징 처리) ----*/
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace + ".listSearchCount", cri);
	}


	@Override
	public ProductImageVO productReelImage(Integer pno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".readimageforder",pno);
	}



	@Override
	public List<ProductVO> specificStoreproductList(ManufacturerVO mVO) throws Exception {
		return session.selectList(namespace + ".specificStoreProductList", mVO);
	}



	@Override
	public int specificStoreproductListCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace + ".specificStoreProductListCount", cri);
	}

}
