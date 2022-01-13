package com.poscoict.emaillist02.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.emaillist02.dao.EmaillistDao;
import com.poscoict.emaillist02.vo.EmaillistVo;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");

		if ("form".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp"); // 내부에 있기 때문에 /WEB-INF부터
																								// 시작해주면 된다.
			rd.forward(request, response);

		} else if ("add".equals(actionName)) {

			String firstName = request.getParameter("fn"); // 무조건 String으로 나옴
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");

			EmaillistVo vo = new EmaillistVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);

			new EmaillistDao().insert(vo);
			
			response.sendRedirect(request.getContextPath() +"/el");
			
		} else { // default page를 보여주는게 좋음

			EmaillistDao dao = new EmaillistDao();
			List<EmaillistVo> list = dao.findAll();

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp"); // 내부에 있기 때문에 /WEB-INF부터
																								// 시작해주면 된다.
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
