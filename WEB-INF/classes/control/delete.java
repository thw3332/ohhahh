package control;

import java.io.IOException;

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
 * Servlet implementation class delete
 */
@WebServlet("/delete.do")
public class delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   reqpro(request, response);
	}
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		String [] itemcode =   request.getParameterValues("itemcode");
		MyCartDAO mcdao = new MyCartDAO();
		MycartDTO mcdto = new MycartDTO();
		HttpSession session = request.getSession();
		String id = session.getAttribute("log").toString();
		if(itemcode == null) {
			
			 
				session.setAttribute("msg", "선택된 물건이 없습니다.");
	      	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	      	dis.forward(request, response);
		}else {
			for(int i = 0;i<itemcode.length;i++) {
				mcdao.deletecart(Integer.parseInt(itemcode[i]), id);
				
			}
			RequestDispatcher dis = request.getRequestDispatcher("MyCart.do"); 
			dis.forward(request, response);
		}
	
	
	
	
	
	}
}
