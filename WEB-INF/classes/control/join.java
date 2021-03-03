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
        
        if(dao.findDupliId(id)!=null) { // �ߺ��� ���̵� ���� ������
        	session.setAttribute("msg", "�ߺ��� ���̵� �Դϴ�.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
        }else {
        	if(id==""||pw==""||name==""||birth==""|| phone1   ==""||detailAddress=="" || pwck==""|| postcode=="" || memroadAddress =="") {
            	session.setAttribute("msg", "ȸ������ ������ ��� �Է����ּ���.");
            	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
            	dis.forward(request, response);
            	
            }else if(!pw.equals(pwck)){
            	session.setAttribute("msg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
         		  	session.setAttribute("msg", "������ �Ϸ� �Ǿ����ϴ�.");
         		    RequestDispatcher dis = request.getRequestDispatcher("SuccessMSG.jsp");
         		    dis.forward(request, response);
                 }else {
                 	session.setAttribute("msg", "���ڸ� �Է��� �ּ���");
                 	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
                	dis.forward(request, response);
                 }

                }
            }
        }
        
       
	
	
	
}
