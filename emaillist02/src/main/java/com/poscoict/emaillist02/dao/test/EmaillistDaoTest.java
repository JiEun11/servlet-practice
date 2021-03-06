package com.poscoict.emaillist02.dao.test;

import java.util.List;

import com.poscoict.emaillist02.dao.EmaillistDao;
import com.poscoict.emaillist02.vo.EmaillistVo;

public class EmaillistDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
	}

	private static void testInsert() {
		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName("김");
		vo.setLastName("지은");
		vo.setEmail("32161108@dankook.ac.kr");
		
		boolean result = new EmaillistDao().insert(vo);
		System.out.println(result? "success" : "fail");
		
	}
	
	private static void testFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for(EmaillistVo vo : list) {
			System.out.println(vo);
		}
		
//		assertEqual(2, list.size()); 
	}
}
