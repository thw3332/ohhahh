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

import model.MyCartDAO;
import model.MycartDTO;

/**
 * Servlet implementation class orderinfo
 */
@WebServlet("/orderinfo.do")
public class orderinfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       reqpro(request, response);
	}
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		String id = session.getAttribute("log").toString();
			MyCartDAO mcdao = new MyCartDAO();
			MycartDTO mcdto = new MycartDTO();
			
			if(mcdao.orderfind(session.getAttribute("log").toString())!=0) {
				session.setAttribute("center", "orderpage.jsp");
				ArrayList<MycartDTO> mcto = mcdao.getBuyItemList(id);
				request.setAttribute("mcto",mcto);
				RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
				dis.forward(request, response);
			}else {
				session.setAttribute("center", "emptyorder.jsp");
				RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
				dis.forward(request, response);
				
			}
			
			
			
			
			
				
			
		
	}

}
