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


@WebServlet("/login.do")
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request, response);
	} 
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
      String id= request.getParameter("id");
	  String pw = request.getParameter("pw");
	  DAO dao = new DAO();
	  System.out.println("id="+id);
	  System.out.println(dao.findid(id));
	  System.out.println("pw="+pw);
	  System.out.println(dao.findpw(id));
	  
	  if(id!="" && pw!="") {
		  if(!id.equals(dao.findid(id))) {
			    HttpSession session = request.getSession();
				session.setAttribute("msg", "���̵� ��ġ���� �ʽ��ϴ�...");
	        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	        	dis.forward(request, response);
		  }else {
			  if(pw.equals(dao.findpw(id))) {
				  HttpSession session = request.getSession();
					session.setAttribute("msg", "�α��� �Ǿ����ϴ�.");
					session.setAttribute("log", id);
					String headerr = request.getParameter("headerr");
					request.setAttribute("headerr", headerr);
					RequestDispatcher dis = request.getRequestDispatcher("SuccessMSG.jsp");
		        	dis.forward(request, response);
			  }else {
				    HttpSession session = request.getSession();
					session.setAttribute("msg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
		        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
		        	dis.forward(request, response);
			  }
			  
		  }
	  }else {
		    HttpSession session = request.getSession();
			session.setAttribute("msg", "������ ��� �Է����ּ���.");
			RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
			dis.forward(request, response);
	  }
	  
		
	}

}
