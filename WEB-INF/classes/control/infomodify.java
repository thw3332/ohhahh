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
import model.DTO;


@WebServlet("/infomodify.do")
public class infomodify extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		repro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       repro(request, response);
	}
	protected void repro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     HttpSession session = request.getSession();
		 String pw1 = request.getParameter("password1");
         String pw2 = request.getParameter("password2");
         String phone1 = request.getParameter("phone");
         String addr = request.getParameter("addr");
         String id = session.getAttribute("log").toString();
         String detailaddr = request.getParameter("detailaddr");
         String postcode = request.getParameter("postcode");
         String reqExp = "^[0-9]+$";
         
         DTO dto = new DTO();
         DAO dao = new DAO();
         
         if(pw1=="" || pw2=="") {
        	  session.setAttribute("msg", "비밀번호를 모두 입력해주세요.");
	          RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	          dis.forward(request, response);
         }else {
        	 if(!pw1.equals(pw2)) {
 	    		session.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
 	           	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
 	           	dis.forward(request, response);
        	 }else {
	 	    	 if(!pw1.equals(dao.pw(id))) {
	 	    		 if(!phone1.matches(reqExp)) {
	 	    			session.setAttribute("msg", "숫자만 입력해주세요.");
		   	  	       	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
		   	  	       	dis.forward(request, response);	 	  	 
	 	    		 }else {
	 	    			int phone =  Integer.parseInt(request.getParameter("phone"));
	 	 	  		   dao.modifyinfo(pw1, phone, addr, id  , detailaddr ,postcode);
	 	 	  		   session.setAttribute("msg", "회원정보가 수정되었습니다.");
	 	 	 			RequestDispatcher dis = request.getRequestDispatcher("SuccessMSG.jsp");
	 	 	        	dis.forward(request, response); 
	 	    		 }
	 	  	   	}else if(!phone1.matches(reqExp)) {
	   	    		session.setAttribute("msg", "숫자만 입력해주세요.");
	   	  	       	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	   	  	       	dis.forward(request, response);	 	  	   		
	 	  	   	}else {
	 	  			session.setAttribute("msg", "현재 비밀번호와 같습니다.");
	 	  	       	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	 	  	       	dis.forward(request, response);
	 	  	   		}
	 	       }
        	
        	
        	 
       } 	
         
	
	}
}
