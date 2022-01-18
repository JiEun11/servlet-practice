package helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String COOKIE_NAME = "visitcount";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키 읽기
		int visitCount = 0;
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(COOKIE_NAME.equals(cookie.getName())) {
					visitCount = Integer.parseInt(cookie.getValue());  // 그 쿠키의 value값을 visitcount에 세팅 
					break; 	// 다른 쿠키에는 관심 없으므로 
				}
			}
		}
		visitCount++;
		
		
		// 쿠키 쓰기 
		Cookie cookie = new Cookie(COOKIE_NAME, String.valueOf(visitCount));
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(24 * 60 * 60);	// 1 day
		
		response.addCookie(cookie);	//응답으로 Set cookie 해서 나감 .
		
		// 화면 출력 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>방문 횟수:"+ visitCount + "</h1>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
