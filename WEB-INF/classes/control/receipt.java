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

import com.sun.xml.internal.bind.v2.model.core.ID;

import model.DAO;
import model.DTO;
import model.MyCartDAO;
import model.MycartDTO;


@WebServlet("/receipt.do")
public class receipt extends HttpServlet {
	
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
		    			session.setAttribute("center", "receipt.jsp");
		    			String [] buycode = (String []) session.getAttribute("buycode");
		    			
		    			
		    		    

		    			MyCartDAO mcdao = new MyCartDAO();
		    			MycartDTO mcdto = new MycartDTO();
		    			
		    			for(int i = 0;i<buycode.length;i++) {
		    				mcdao.itembuy(Integer.parseInt(buycode[i]), id);
		    			}
		    			 
		    	ArrayList<MycartDTO> a = new ArrayList<MycartDTO>();
		    			
		    			for(int i = 0;i<buycode.length;i++) {
		    			    mcdto = mcdao.getItemList2(Integer.parseInt(buycode[i]));
		    				a.add(mcdto);
		    			}

		    		  
		    			
		    			request.setAttribute("a",a);

		    			
		    			
		    			RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
		    			dis.forward(request, response);
		    		}
		}else if(addckbox.equals("one")) {
			session.setAttribute("center", "receipt.jsp");
			if(myname==""   || postcode == ""   || roadAddress == ""      ||	
		    		detailAddress == ""  || email ==""  || 
		    		phone == ""   ) {
		   				session.setAttribute("msg", "회원 정보를 모두 입력해 주세요");
		   	        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
		   	        	dis.forward(request, response);
		    			
		    		}else {
		    			String [] buycode = (String []) session.getAttribute("buycode");
		    			
		    			
		    		    

		    			MyCartDAO mcdao = new MyCartDAO();
		    			MycartDTO mcdto = new MycartDTO();
		    			
		    			for(int i = 0;i<buycode.length;i++) {
		    				mcdao.itembuy(Integer.parseInt(buycode[i]), id);
		    			}
		    			 
		   

		    			
		    			
		    			RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
		    			dis.forward(request, response);
		    		}
		}
		
		

		

	
	}
}
