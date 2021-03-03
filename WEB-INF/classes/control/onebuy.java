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
import model.MyCartDAO;
import model.MycartDTO;


@WebServlet("/onebuy.do")
public class onebuy extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  reqpro(request, response);
	}
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("log") == null ) {
			session.setAttribute("log", "손님");
		}
		
		if(session.getAttribute("log").toString().equals("손님")) {
			session.setAttribute("msg", "로그인 후 이용해 주세요.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
			
		}else {
			session.setAttribute("center", "onebuy.jsp");
			String id = (String)session.getAttribute("log");
			String  itemcode =   request.getParameter("item_code");
		    int pronum = Integer.parseInt(request.getParameter("pronum"));
		    session.setAttribute("onecode", itemcode);
		    session.setAttribute("onecnt", pronum);
		    request.setAttribute("cnt", pronum);
		    DAO dao = new DAO();
			DTO dto = new DTO();
			dto = dao.joinMmemberlist(id);
			request.setAttribute("dto",dto);
		    
				DAO dao2 = new DAO();
				DTO dto2 = new DTO();
				
				dto2 = dao2.infolist(itemcode);
				
				

				request.setAttribute("a",dto2);
				
				
				RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
				dis.forward(request, response);
		}
		
	}
}
