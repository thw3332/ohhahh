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

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_EXCLUSIONPeer;

import model.MyCartDAO;
import model.MycartDTO;


@WebServlet("/MyCart.do")
public class mycart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		if(session.getAttribute("log") == null || session.getAttribute("log").toString().equals("손님")) {
			session.setAttribute("msg", "로그인 후 이용 가능합니다.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
		}else {
			
			MyCartDAO mcdao = new MyCartDAO();
			MycartDTO mcdto = new MycartDTO();
			if(mcdao.cartfind(session.getAttribute("log").toString())!=0) {
				session.setAttribute("center", "Mycart.jsp");
				ArrayList<MycartDTO> mcto = mcdao.getAllItemList(session.getAttribute("log").toString());
				request.setAttribute("mcto",mcto);
				RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
				dis.forward(request, response);
			}else {
				session.setAttribute("center", "Emptycart.jsp");
				RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
				dis.forward(request, response);
				
			}
			
		}
		
	}
		
}
