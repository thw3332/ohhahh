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

@WebServlet("/FindId.do")
public class FindIdPro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);	
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DAO dao = new DAO();
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "IdCheck.jsp");
		
		String id = null;
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone");
		String reqExp = "^[0-9]+$";
		 
		if(!phone1.matches(reqExp)) {
	    		session.setAttribute("msg", "숫자만 입력해주세요.");
	  	       	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	  	       	dis.forward(request, response);	 	  	   		
	  	}else {		
			int phone = Integer.parseInt(request.getParameter("phone"));
			if(request.getParameter("id")!=null) {
				id = request.getParameter("id");
				String mypw = dao.findPw(id, name, phone);
				request.setAttribute("mypw", mypw);
			}else {
				String myid = dao.findId(name, phone);
				request.setAttribute("myid", myid);
			}
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);	
	  	}
		
	}

}
