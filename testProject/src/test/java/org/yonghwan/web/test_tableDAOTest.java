package org.yonghwan.web;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yonghwan.domain.test_tableDTO;
import org.yonghwan.persistence.test_tableDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class test_tableDAOTest {

	@Inject
	private test_tableDAO dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertTest_table() throws Exception{
		test_tableDTO dto = new test_tableDTO();
		dto.setName("user01");
		dto.setAge(29);
		
		dao.insertTest_table(dto);
	}
	
	@Test
	public void testReadTest_table() throws Exception{
		String name = "±Ë√∂ªÁ";
		
		System.out.println(dao.read(name).toString());

	}
	
}//class
