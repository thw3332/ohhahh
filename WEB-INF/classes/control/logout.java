package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout.do")
public class logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logout(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logout(request, response);
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession();
	    session.setAttribute("msg", "로그아웃 되었습니다.");
		session.setAttribute("log", "손님");
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		RequestDispatcher dis = request.getRequestDispatcher("SuccessMSG.jsp");
	    dis.forward(request, response);
	}

}
