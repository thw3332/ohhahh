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

/**
 * Servlet implementation class Boardselectafter
 */
@WebServlet("/Boardselectafter.do")
public class Boardselectafter extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   reqpro(request, response);
	}
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bdao = new BoardDAO();
		int a = Integer.parseInt(request.getParameter("board_code"));
		int after_code = bdao.getOneaftercode(a);
		System.out.println("after_code" + after_code);
		BoardDTO bdto= bdao.getOne(after_code);
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		String input = request.getParameter("input");
		
		HttpSession session1 = request.getSession();
		int maxcode = bdao.maxcode();
		session1.setAttribute("maxcode", maxcode);
		int mincode = bdao.mincode();
		session1.setAttribute("mincode", mincode);
		session1.setAttribute("board_code", bdto.getBoard_code());
		session1.setAttribute("id", bdto.getId());
		session1.setAttribute("board_title", bdto.getBoard_title());
		session1.setAttribute("board_pw", bdto.getBoard_pw());
		session1.setAttribute("board_img", bdto.getBoard_img());
		session1.setAttribute("board_content", bdto.getBoard_content());
		session1.setAttribute("board_date", bdto.getBoard_date());
		session1.setAttribute("cnt", bdto.getCnt());
		session1.setAttribute("ref", bdto.getRef());
		session1.setAttribute("re_step", bdto.getRe_step());
		session1.setAttribute("re_level", bdto.getRe_level());
		
		int board_code=(int)session1.getAttribute("board_code");
		String id=(String)session1.getAttribute("id");
		String board_title = (String)session1.getAttribute("board_title");
		String board_pw = input;
		String board_img = (String)session1.getAttribute("board_img");
		String board_content = (String)session1.getAttribute("board_content");
		String board_date = (String)session1.getAttribute("board_date");
		int cnt = (int)session1.getAttribute("cnt");
		int ref = (int)session1.getAttribute("ref");
		int re_step = (int)session1.getAttribute("re_step");
		int re_level = (int)session1.getAttribute("re_level");
		
		ArrayList<BoardDTO> aa = bdao.getAllboardComment(ref);
		request.setAttribute("a", aa);
		
		System.out.println(input);
		System.out.println(bdao.chkBoardPw(id, input));
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "Boarddetail.jsp");
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
	}

}
