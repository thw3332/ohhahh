package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.DADD;

import model.DAO;
import model.DTO;


@WebServlet("/mypage.do")
public class mypage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		repro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		repro(request, response);
	}
    protected void repro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	HttpSession session = request.getSession();
    	
    	String headerr = request.getParameter("headerr");
		session.setAttribute("headerr", headerr);
		request.setAttribute("headerr", headerr);
    	
	   DAO dao = new DAO();
	   DTO dto = new DTO();
	   String id= session.getAttribute("log").toString();
	   dto = dao.Mypage(id);
	   request.setAttribute("a", dto);
		
		session.setAttribute("center", "Mypage.jsp");
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
	}
}
