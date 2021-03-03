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

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

import model.DAO;
import model.DTO;
import model.MyCartDAO;
import model.MycartDTO;

@WebServlet("/itembuy.do")
public class itembuy extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("center", "itembuy.jsp");
		String id = (String)session.getAttribute("log");
		
		String [] itemcode =   request.getParameterValues("itemcode");
		if(itemcode == null) {
				session.setAttribute("msg", "선택된 물건이 없습니다.");
	        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	        	dis.forward(request, response);
		}else {
			session.setAttribute("buycode", itemcode);

			MyCartDAO mcdao = new MyCartDAO();
			MycartDTO mcdto = new MycartDTO();
			   ArrayList<MycartDTO> a = new ArrayList<MycartDTO>();
			
			for(int i = 0;i<itemcode.length;i++) {
				mcdto = mcdao.getItemList(Integer.parseInt(itemcode[i]));
				System.out.println("itemcode는" + Integer.parseInt(itemcode[i]));
				a.add(mcdto);
			}
			
			request.setAttribute("a",a);
			session.setAttribute("a", a);
			DAO dao = new DAO();
			DTO dto = new DTO();
			
			System.out.println(id);
			
			dto = dao.joinMmemberlist(id);
			request.setAttribute("dto",dto);
			
			RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
			dis.forward(request, response);
		}
		
	}
}
