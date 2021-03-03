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

@WebServlet("/Boarddelete.do")
public class Boarddelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bdao = new BoardDAO();
		
		HttpSession session1 = request.getSession();
		int board_code = (int)session1.getAttribute("board_code");
		
		bdao.deleteboard(board_code);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("BoardList.do");
		dis.forward(request, response);
		
		
	}
}
