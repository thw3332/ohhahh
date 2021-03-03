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

import model.ShopDAO;
import model.ShopDTO;


@WebServlet("/centerc.do")
public class centerc extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        centerc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    centerc(request, response);
	}
	
	protected void centerc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ShopDTO dto = new ShopDTO();
		ShopDAO dao = new ShopDAO();
		
		ArrayList<ShopDTO> a = dao.shopList(0, 9); // 모든 상품 가져오기
		request.setAttribute("a", a);
		
		String center = (String) session.getAttribute("center");
		String headerr = (String) session.getAttribute("headerr");
		System.out.println(center);
		System.out.println(headerr);
		
		if(center!=null) {
			System.out.println("ㄹㅇ센터" + center);
			center = request.getParameter("center");
			if(center!="Center.jsp" && center!="" && center!="null" && center!=null) {
				session.setAttribute("center", center);	
				System.out.println("center1"+session.getAttribute("center"));
			}else {
				session.setAttribute("center", "Center.jsp");	
				System.out.println("center0"+session.getAttribute("center"));
			}
		}else {
			session.setAttribute("center", "Center.jsp");
			System.out.println("center2"+session.getAttribute("center"));
		}
		
		if(headerr!=null) {
			headerr = request.getParameter("headerr");
			if(headerr!="zero" && headerr!="" && headerr!="null" && headerr!=null) {
				headerr = request.getParameter("headerr");
				session.setAttribute("headerr", headerr);
				request.setAttribute("headerr", headerr);
				System.out.println("headerr1"+headerr);
			}else {
				session.setAttribute("headerr", "zero");
				request.setAttribute("headerr", "zero");
				System.out.println("headerr0"+session.getAttribute("headerr"));
			}
		}else {
			session.setAttribute("headerr", "zero");
			request.setAttribute("headerr", "zero");
			System.out.println("headerr2"+session.getAttribute("headerr"));
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		
	}

}
