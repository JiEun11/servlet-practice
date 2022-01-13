package com.poscoict.guestbook.dao.test;

import java.util.List;

import com.poscoict.guestbook.dao.GuestbookDao;
import com.poscoict.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		
		testFindAll();
//		testInsert();
//		testDelete(5,"0807");
	}

	private static void testDelete(int no, String password ) {
		GuestbookVo gbvo = new GuestbookVo();
		gbvo.setNo(no);
		gbvo.setPassword(password);
		
		boolean result = new GuestbookDao().delete(gbvo.getNo(), gbvo.getPassword());
		System.out.println(result? "success" : "fail");
	}

	private static void testInsert() {
		GuestbookVo gbvo = new GuestbookVo();
		gbvo.setName("김형민");
		gbvo.setPassword("1111");
		gbvo.setMessage("안녕하세요"
				+  " 반갑습니다.");	
		boolean result = new GuestbookDao().insert(gbvo);
		System.out.println(result? "success" : "fail");
	}

	private static void testFindAll() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo dbvo :list) {
			System.out.println(dbvo);
		}
	}

}
