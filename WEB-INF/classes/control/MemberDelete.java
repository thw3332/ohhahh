package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;

@WebServlet("/MemberDelete.do")
public class MemberDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("log"); // ¾ÆÀÌµð 
		System.out.println(id);
		
		DAO dao = new DAO();
		
		dao.deleteMember1(id);
		dao.deleteMember2(id);
		dao.deleteMember3(id);
		dao.deleteMember4(id);
		
		session.setAttribute("msg", "Å»Åð°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
		session.setAttribute("log", "¼Õ´Ô");
		
		RequestDispatcher dis = request.getRequestDispatcher("SuccessMSG.jsp");
		dis.forward(request, response);
		
		
	}

}
