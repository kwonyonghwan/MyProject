package org.ktl.persistence;

import java.util.List;

import org.ktl.domain.ProductVO;

public interface ManufacturerDAO {

	public List<ProductVO> productList() throws Exception;
}
