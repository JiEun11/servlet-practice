package com.poscoict.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.guestbook.dao.GuestbookDao;
import com.poscoict.guestbook.vo.GuestbookVo;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		
		if("add".equals(actionName)) {
			String name = request.getParameter("name");
			String message = request.getParameter("message");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestbookDao().insert(vo);
			response.sendRedirect(request.getContextPath() +"/gb");
			
		}else if("deleteform".equals(actionName)){ 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
	
		}else if("delete".equals(actionName)) {
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(Integer.parseInt(no));
			vo.setPassword(password);
			
			new GuestbookDao().delete(Integer.parseInt(no), password);
			response.sendRedirect(request.getContextPath()+"/gb");
			
		}else{
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.findAll();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
//		request.setCharacterEncoding("utf-8");
//		
//		String no = request.getParameter("no");
//		
//		if(no==null) {
//			String name = request.getParameter("name");
//			String password = request.getParameter("password");
//			String message = request.getParameter("message");
//			
//			GuestbookVo gbvo = new GuestbookVo();
//			gbvo.setName(name);
//			gbvo.setPassword(password);
//			gbvo.setMessage(message);
//			
//			new GuestbookDao().insert(gbvo);
//			
//			response.sendRedirect(request.getContextPath() +"/gb");
//		}else {
//			String password = request.getParameter("password");
//			
//			
//		}
		
	}

