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

import model.DAO;
import model.DTO;
import model.MyCartDAO;
import model.MycartDTO;

/**
 * Servlet implementation class onereceipt
 */
@WebServlet("/onereceipt.do")
public class onereceipt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	reqpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    reqpro(request, response);
	}
    protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("log");
	
	

		String myname = request.getParameter("myname");
		String myname2 = request.getParameter("myname2");
		String postcode = request.getParameter("postcode");
		String postcode2 = request.getParameter("postcode2");
		String roadAddress = request.getParameter("roadAddress");
		String roadAddress2 = request.getParameter("roadAddress2");
		String detailAddress = request.getParameter("detailAddress");
		String detailAddress2 = request.getParameter("detailAddress2");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String phone = request.getParameter("phone");
		String phone2 = request.getParameter("phone2");
		String addckbox = request.getParameter("addckbox1");
		
		
		if(addckbox.equals("two")) {
			if(myname2 ==""  || postcode2 == ""   || 	roadAddress2 == ""   ||	
		    		 detailAddress2 == ""  ||  email2 ==""  || phone2 =="" ) {
		   				session.setAttribute("msg", "회원 정보를 모두 입력해 주세요");
		   	        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
		   	        	dis.forward(request, response);
		    			
		    		}else {
		    			String  buycode =  session.getAttribute("onecode").toString();
		    	    	int cnt = (int) session.getAttribute("onecnt");	
		    	    	session.setAttribute("center", "onereceipt.jsp");
		    	    	MyCartDAO mcdao = new MyCartDAO();
		    			MycartDTO mcdto = new MycartDTO();
		    		
		    				mcdao.oneinsertItem(Integer.parseInt(buycode), id, cnt);
		    			
		    				DAO dao2 = new DAO();
		    				DTO dto2 = new DTO();
		    				
		    				String buycode2 = session.getAttribute("onecode").toString();
		    				dto2 = dao2.infolist( buycode2);
		    	    		request.setAttribute("a",dto2);

		    	    		
		    	    		
		    	    		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
		    	    		dis.forward(request, response);	
		    		}
		}else if(addckbox.equals("one")) {
			if(myname==""   || postcode == ""   || roadAddress == ""      ||	
		    		detailAddress == ""  || email ==""  || 
		    		phone == ""   ) {
		   				session.setAttribute("msg", "회원 정보를 모두 입력해 주세요");
		   	        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
		   	        	dis.forward(request, response);
		    			
		    		}else {
		    			String  buycode =  session.getAttribute("onecode").toString();
		    	    	int cnt = (int) session.getAttribute("onecnt");	
		    	    	session.setAttribute("center", "onereceipt.jsp");
		    	    	MyCartDAO mcdao = new MyCartDAO();
		    			MycartDTO mcdto = new MycartDTO();
		    		
		    				mcdao.oneinsertItem(Integer.parseInt(buycode), id, cnt);
		    			
		    				DAO dao2 = new DAO();
		    				DTO dto2 = new DTO();
		    				
		    				String buycode2 = session.getAttribute("onecode").toString();
		    				dto2 = dao2.infolist( buycode2);
		    	    		request.setAttribute("a",dto2);

		    	    		
		    	    		
		    	    		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
		    	    		dis.forward(request, response);	
		    		}
		}
		


	
    	
    	
	}
}
