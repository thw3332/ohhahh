package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardDTO;

@WebServlet("/BoardChk.do")
public class BoardChk extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO bdto = new BoardDTO();
		BoardDAO bdao = new BoardDAO();
		
		HttpSession session = request.getSession();
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		String id = (String) session.getAttribute("log");
		String input = request.getParameter("input");
		String board_pw = input;
		System.out.println("input: "+input);
		System.out.println("패스워드: "+bdao.chkBoardPw(id, input));
		
		if(bdao.chkBoardPw(id, input)=="") { // 비밀번호가 일치하지 않음
			session.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
	    	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
	    	dis.forward(request, response);
		}else {
			session.setAttribute("center", "Boardupdate.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
	    	dis.forward(request, response);
		}
		
	}

}



















