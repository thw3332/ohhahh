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


@WebServlet("/join.do")
public class join extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		joinmember(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       joinmember(request, response);
	}
	protected void joinmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
        DAO dao = new DAO();
        DTO dto = new DTO();
        
        String id =request.getParameter("id");
        String pw = request.getParameter("pw");
        String pwck = request.getParameter("pwck");
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String phone1 = request.getParameter("phone");
        String detailAddress = request.getParameter("detailAddress");
        String postcode = request.getParameter("postcode");
        String memroadAddress = request.getParameter("memroadAddress");
        String reqExp = "^[0-9]+$";
        
        /*String dupleId = dao.findDupliId(id);
        System.out.println(dupleId);*/
        
        if(dao.findDupliId(id)!=null) { // 중복된 아이디 값이 있으면
        	session.setAttribute("msg", "중복된 아이디 입니다.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
        }else {
        	if(id==""||pw==""||name==""||birth==""|| phone1   ==""||detailAddress=="" || pwck==""|| postcode=="" || memroadAddress =="") {
            	session.setAttribute("msg", "회원가입 정보를 모두 입력해주세요.");
            	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
            	dis.forward(request, response);
            	
            }else if(!pw.equals(pwck)){
            	session.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
            	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
            	dis.forward(request, response);
            }else {
            	 if(phone1.matches(reqExp) && birth.matches(reqExp)) {
            		int phone = Integer.parseInt(request.getParameter("phone"));
                 	dto.setId(id);
         		    dto.setPw(pw);
         		    dto.setName(name);
         		    dto.setBirth(birth);
         		    dto.setPhone(phone);
         		    dto.setAddr(memroadAddress);
         		    dto.setDetailaddr(detailAddress);
         		    dto.setPostcode(postcode);
         		    dao.joinmember(dto);
         		  	session.setAttribute("msg", "가입이 완료 되었습니다.");
         		    RequestDispatcher dis = request.getRequestDispatcher("SuccessMSG.jsp");
         		    dis.forward(request, response);
                 }else {
                 	session.setAttribute("msg", "숫자만 입력해 주세요");
                 	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
                	dis.forward(request, response);
                 }

                }
            }
        }
        
       
	
	
	
}
