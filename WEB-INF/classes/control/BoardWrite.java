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

@WebServlet("/BoardWrite.do")
public class BoardWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO bdto = new BoardDTO();
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		if(request.getParameter("id")!="" && request.getParameter("title")!="" && request.getParameter("writepw")!=""  && request.getParameter("content")!="") {
			bdto.setId(request.getParameter("id"));
			bdto.setBoard_title(request.getParameter("title"));
			bdto.setBoard_pw(request.getParameter("writepw"));
			bdto.setBoard_img(request.getParameter("board_img"));
			bdto.setBoard_content(request.getParameter("content"));
			
			BoardDAO bdao = new BoardDAO();
			bdao.insertboard(bdto);
			
			RequestDispatcher dis = request.getRequestDispatcher("BoardList.do");
			dis.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "정보를 모두 입력해주세요.");
        	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
		}
		
		
	}
}
