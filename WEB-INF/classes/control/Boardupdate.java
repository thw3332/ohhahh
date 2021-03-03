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


@WebServlet("/Boardupdate.do")
public class Boardupdate extends HttpServlet {
	
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
		
		HttpSession session1 = request.getSession();
		
		int board_code = (int)session1.getAttribute("board_code"); 
		String board_title = (String)request.getParameter("board_title");
		String board_content = (String)request.getParameter("board_content");
		String board_img = (String)request.getParameter("board_img");
		String board_img2 = request.getParameter("board_img2");
		
		if(board_img!="") {
			bdao.updateboard(board_code, board_title, board_content, board_img);
			
			RequestDispatcher dis = request.getRequestDispatcher("BoardList.do");
			dis.forward(request, response);
		}else {
			bdao.updateboard(board_code, board_title, board_content, board_img2);
			
			RequestDispatcher dis = request.getRequestDispatcher("BoardList.do");
			dis.forward(request, response);
		}
		
		
		
		
		
		
		
		
		
	}
}
