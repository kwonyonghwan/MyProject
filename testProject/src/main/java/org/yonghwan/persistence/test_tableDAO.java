package org.yonghwan.persistence;

import org.yonghwan.domain.test_tableDTO;

public interface test_tableDAO {
	
	public String getTime();
	
	public void insertTest_table(test_tableDTO dto);

	public test_tableDTO read(String name);
}
