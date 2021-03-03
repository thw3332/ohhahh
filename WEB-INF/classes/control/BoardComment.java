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

import model.BoardDAO;
import model.BoardDTO;
import model.ShopDTO;

@WebServlet("/BoardComment.do")
public class BoardComment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = new BoardDTO();
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "Boarddetail.jsp");
		String headerr = request.getParameter("headerr");
		session.setAttribute("headerr", headerr);
		
		bdto.setId(request.getParameter("id"));
		bdto.setBoard_content(request.getParameter("content"));
		bdto.setRef(Integer.parseInt(request.getParameter("ref")));
		bdto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		bdto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		bdao.reInsertBoard(bdto);
		
		String board_title = request.getParameter("board_title");
		String id = request.getParameter("myid"); //게시글쓴사람
		String log = request.getParameter("id"); //댓글쓴사람
		String board_date = request.getParameter("board_date");
		String board_cnt = request.getParameter("board_cnt");
		String board_content = request.getParameter("board_content");
		String board_img = request.getParameter("board_img");
		
		request.setAttribute("board_title", board_title);
		request.setAttribute("id", id);
		request.setAttribute("log", log);
		request.setAttribute("board_date", board_date);
		request.setAttribute("board_cnt", board_cnt);
		request.setAttribute("board_content", board_content);
		request.setAttribute("board_img", board_img);
		
		int ref = Integer.parseInt(request.getParameter("ref"));
		ArrayList<BoardDTO> aa = bdao.getAllboardComment(ref);
		request.setAttribute("a", aa);
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		
		
		
	}

}




























