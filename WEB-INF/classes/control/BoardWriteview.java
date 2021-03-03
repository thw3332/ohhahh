package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BoardWriteview.do")
public class BoardWriteview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("log");
		System.out.println("id: "+id);
		
		if(id!="손님" && id!="" && id!=null && id!="null") {
			session.setAttribute("center", "BoardWrite.jsp");
			
			String headerr = request.getParameter("headerr");
			request.setAttribute("headerr", headerr);
		
			RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
			dis.forward(request, response);
		}else {
			session.setAttribute("msg", "로그인 후 이용해주세요.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
		}
		
	}
}
