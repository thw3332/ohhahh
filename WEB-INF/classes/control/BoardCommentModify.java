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

@WebServlet("/BoardCommentModify.do")
public class BoardCommentModify extends HttpServlet {
	
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
		
		String content = request.getParameter("content");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		
		String board_title = request.getParameter("board_title");
		String id = request.getParameter("myid"); //게시글쓴사람
		String log = request.getParameter("id"); //댓글쓴사람
		String loglog = request.getParameter("log"); 
		String board_date = request.getParameter("board_date");
		String board_cnt = request.getParameter("board_cnt");
		String board_content = request.getParameter("board_content");
		String board_img = request.getParameter("board_img");
		System.out.println("log"+log);
		System.out.println("loglog"+loglog);
		
		if(!loglog.equals(log)) {
			session.setAttribute("msg", "작성자만 댓글을 수정할 수 있습니다.");
         	RequestDispatcher dis = request.getRequestDispatcher("FailMSG.jsp");
        	dis.forward(request, response);
		}else {
			bdao.updateComent(content, ref, re_step, re_level, log);
			
			request.setAttribute("board_title", board_title);
			request.setAttribute("id", id);
			request.setAttribute("log", log);
			request.setAttribute("board_date", board_date);
			request.setAttribute("board_cnt", board_cnt);
			request.setAttribute("board_content", board_content);
			request.setAttribute("board_img", board_img);
			
			ArrayList<BoardDTO> aa = bdao.getAllboardComment(ref);
			request.setAttribute("a", aa);
			
			RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
			dis.forward(request, response);	
		}
		
	}

}



























