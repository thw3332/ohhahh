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


@WebServlet("/addcart.do")
public class addcart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   reqpro(request, response);
	}
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		
		if(session.getAttribute("log") == null ) {
			session.setAttribute("log", "손님");
		}
		
		if(session.getAttribute("log").toString().equals("손님")) {
			session.setAttribute("msg", "로그인 후 이용해 주세요.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
			
		}else {
			int item_code = Integer.parseInt(request.getParameter("item_code"));
			String id = (String)session.getAttribute("log");
			int cart_cnt = Integer.parseInt(request.getParameter("pronum"));
			
			System.out.println(id);
		
			MyCartDAO mcdao = new MyCartDAO();
			MycartDTO mcdto = new MycartDTO();
			if(mcdao.profind(item_code, id)== true) {
				mcdao.CntAddItem(item_code, id, cart_cnt);
			}else {
				mcdao.insertItem(item_code, id, cart_cnt);
			}
			
			session.setAttribute("msg", "장바구니에 물건이 담겼습니다.");
	    	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	    	dis.forward(request, response);
			
			
		}
	}
}
