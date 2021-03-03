package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.DTO;

@WebServlet("/prolist.do")
public class prolist extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  prolist(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 prolist(request, response);
	}
	protected void prolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cate = request.getParameter("cate");
		ArrayList<DTO> a = new ArrayList<DTO>();
		
		DAO dao = new DAO();
		a = dao.prolist(cate);
		request.setAttribute("cate", cate);
		request.setAttribute("a", a);
		HttpSession session = request.getSession();
		session.setAttribute("center", "prolist.jsp");
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		
	}

}
