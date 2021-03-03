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
import model.DTO;


@WebServlet("/infolist.do")
public class infolist extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		infolist(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       infolist(request, response);
	}
	protected void infolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
       String itemcode =  request.getParameter("itemcode");     
		DAO dao = new DAO();
        DTO dto = new DTO();
             
        dto = dao.infolist(itemcode);
        request.setAttribute("a",dto);
        HttpSession session = request.getSession();
        session.setAttribute("center", "Moreinfo.jsp");
   		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
   		dis.forward(request, response);
	}
}
