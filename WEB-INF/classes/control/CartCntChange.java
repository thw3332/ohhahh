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


@WebServlet("/CartCntChange.do")
public class CartCntChange extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         reqpro(request, response);
	}
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cnt = Integer.parseInt(request.getParameter("cnt"));
        int code = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession();
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		String id = (String)session.getAttribute("log");
	
		MyCartDAO mcdao = new MyCartDAO();
		MycartDTO mcdto = new MycartDTO();
		mcdao.CntChangeCart(code, id, cnt);
  	
		RequestDispatcher dis = request.getRequestDispatcher("MyCart.do"); 
		dis.forward(request, response);
	}
}
