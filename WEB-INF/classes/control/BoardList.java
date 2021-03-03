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
		
		// �� ȭ�鿡 �������� �Խñ��� ������ �����Ͽ� ��� ����
		int pageSize = 5; // ���� ���س��� row�� ����
		
		// ���� ȭ�鿡 �������� �ִ� �������� �ѹ� ���� ��� ����
		// [1] [2] ....
		String pageNum = request.getParameter("pageNum");
		// BoardListCon.do���� �����ϸ� pageNum ���� ����. ��� nulló���Ѵ�.
		if(pageNum == null) {
			pageNum = "1";
		}
		// ��ü �Խñ��� ������ ��� ����
		int count = 0;
		int count2=0;
		
		// �Խñ��� ��ȣ�� �ֽű� ������ ��µǵ��� ��ȣ�� �����Ͽ� ��� ����
		// [��ȣ] 1 -> 2 ����
		int number = 0;

		// ���� �������� �ִ� �������� �ѹ����� ���ڷ� ��ȯ�Ͽ� ��º���
		int currentPage = Integer.parseInt(pageNum);
		
// ================== �� ��������� ���� �ʱⰪ ����===================== //
		
		// getAllCount() �޼��带 BoardDAO�� �ۼ�
		count = bdao.getAllCount();
		count2 = bdao.getAllCount2();
		
		// jspȭ�鿡 [��ȣ]�κп� �� number���� ����ϴ� ��
		// number = 9 - (2-1)*5              => 4
		// �ֽű� ������ ��ȣ�� �ο��Ǿ�� �Ѵ�
		number = count - (currentPage-1)*pageSize;
		
		// ���纸���� �������� ���� ���ȣ�� ��� ����
		int startRow  = (currentPage-1)*pageSize + 1;
		
		// ���� ������ �������� ������ ���ȣ�� ��� ����
		int endRow = currentPage*pageSize;
		
		// �ֽű� 5���� �������� ���Ϲ޾��ִ� �޼��� �ۼ�
		// ���ÿ� �������� ���ڵ带 ��ƾ� �ϱ� ������ ArrayList�� �̿��Ѵ�.
		ArrayList<BoardDTO> a = bdao.getAllboardlist(startRow, endRow);
		
		// =========����¡ ó���ϴ� �ҽ��ڵ� �����ʱ�ȭ�۾�
		int pageCount = 0; // ��ü ������ �ѹ����� ��� ����
		int pageBlock = 3; // ��ȭ�鿡 ����¡�ϰ� ���� ����
		int startPage = 1; // �� ȭ�鿡 ���� ù��° ����¡ �ѹ��� ��� ����
		int result = 0;
		int endPage = 0; // �� ȭ�鿡 ���� ������ ����¡ �ѹ��� ��� ����
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "BoardList.jsp");
		
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
//		�˻�---------------------------------------------------------------------------------------------------------
		String search=request.getParameter("search");
		if(search!=null){  // id�� �˻� ������
			ArrayList<BoardDTO> bdto= bdao.Search(search);
			request.setAttribute("bdto", bdto);
		
		}else {
			ArrayList<BoardDTO> bdto= bdao.getAllboardlist(startRow, endRow);
			request.setAttribute("bdto", bdto);
			
		}
		
//		����¡---------------------------------------------------------------------------------------------------------			
				if(count > 0) {  //count�� ���ڵ� ��ü ����
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