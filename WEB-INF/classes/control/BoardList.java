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

@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bdao = new BoardDAO();
		
		// 한 화면에 보여지는 게시글의 개수를 지정하여 담는 변수
		int pageSize = 5; // 내가 정해놓을 row의 개수
		
		// 현재 화면에 보여지고 있는 페이지의 넘버 값을 담는 변수
		// [1] [2] ....
		String pageNum = request.getParameter("pageNum");
		// BoardListCon.do에서 실행하면 pageNum 값은 없다. 고로 null처리한다.
		if(pageNum == null) {
			pageNum = "1";
		}
		// 전체 게시글의 개수를 담는 변수
		int count = 0;
		int count2=0;
		
		// 게시글의 번호를 최신글 순으로 출력되도록 번호를 지정하여 담는 변수
		// [번호] 1 -> 2 누적
		int number = 0;

		// 현재 보여지고 있는 페이지의 넘버값을 숫자로 변환하여 담는변수
		int currentPage = Integer.parseInt(pageNum);
		
// ================== ▲ 여기까지는 변수 초기값 지정===================== //
		
		// getAllCount() 메서드를 BoardDAO에 작성
		count = bdao.getAllCount();
		count2 = bdao.getAllCount2();
		
		// jsp화면에 [번호]부분에 들어갈 number값을 계산하는 식
		// number = 9 - (2-1)*5              => 4
		// 최신글 순으로 번호가 부여되어야 한다
		number = count - (currentPage-1)*pageSize;
		
		// 현재보여질 페이지의 시작 행번호를 담는 변수
		int startRow  = (currentPage-1)*pageSize + 1;
		
		// 현재 보여질 페이지의 마지막 행번호를 담는 변수
		int endRow = currentPage*pageSize;
		
		// 최신글 5개를 기준으로 리턴받아주는 메서드 작성
		// 동시에 여러개의 레코드를 담아야 하기 때문에 ArrayList를 이용한다.
		ArrayList<BoardDTO> a = bdao.getAllboardlist(startRow, endRow);
		
		// =========페이징 처리하는 소스코드 변수초기화작업
		int pageCount = 0; // 전체 페이지 넘버수를 담는 변수
		int pageBlock = 3; // 한화면에 페이징하고 싶은 개수
		int startPage = 1; // 한 화면에 제일 첫번째 페이징 넘버를 담는 변수
		int result = 0;
		int endPage = 0; // 한 화면에 제일 마지막 페이징 넘버를 담는 변수
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "BoardList.jsp");
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
//		검색---------------------------------------------------------------------------------------------------------
		String search=request.getParameter("search");
		if(search!=null){  // id를 검색 했을때
			ArrayList<BoardDTO> bdto= bdao.Search(search);
			request.setAttribute("bdto", bdto);
		
		}else {
			ArrayList<BoardDTO> bdto= bdao.getAllboardlist(startRow, endRow);
			request.setAttribute("bdto", bdto);
			
		}
		
//		페이징---------------------------------------------------------------------------------------------------------			
				if(count > 0) {  //count는 레코드 전체 개수
					System.out.println("startPage"+startPage);
					pageCount = count / pageSize + (count % pageSize == 0? 0 : 1);
					result = currentPage / pageBlock;
					
					if(currentPage % pageBlock != 0) {
						startPage = result * pageBlock + 1;
					}else {
						startPage = (result-1) * pageBlock +1;
					}
					
					endPage = (startPage + pageBlock) -1;
					
					if(endPage > pageCount) {
						endPage = pageCount;
					}
				}
				
				String cc = "";
				
				if(count==0) {
					cc = "one";
				}
				
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("count", count);
				session.setAttribute("count2", count2);
				request.setAttribute("cc", cc);
				request.setAttribute("number", number);
				request.setAttribute("currentPage", currentPage);
				
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("pageBlock", pageBlock);
				request.setAttribute("startPage", startPage);
				request.setAttribute("result", result);
				request.setAttribute("endPage", endPage);
				
				request.setAttribute("search", search);
		
		
				System.out.println("count"+count);
			
				System.out.println("cc"+cc);
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
	}
}