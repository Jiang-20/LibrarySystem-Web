package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/logout.do")
public class LogoutController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie cookie = new Cookie("username", "aaa");//2.����Cookie����Чʱ��Ϊ0
		cookie.setMaxAge(0);//ɾ��cookie�Ĺؼ�//3.��cookie���͸�����������滻ͬ��Cookie
		cookie.setPath("/");
		response.addCookie(cookie);

		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");
		response.sendRedirect("login.html");
	}

}