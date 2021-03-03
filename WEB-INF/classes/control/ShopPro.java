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

import model.ShopDAO;
import model.ShopDTO;

@WebServlet("/Shop.do")
public class ShopPro extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "Shop.jsp");
		
		String headerr = request.getParameter("headerr");
		session.setAttribute("headerr", headerr);
		
		ShopDTO dto = new ShopDTO();
		ShopDAO dao = new ShopDAO();
		
		String id = (String) session.getAttribute("log"); // ���̵� 
		
		int searchCnt = 0;
		if(request.getParameter("searchCnt")!=null){
			searchCnt = Integer.parseInt(request.getParameter("searchCnt")); // �ֽż�, �α�� ��ӹڽ� ���ִ� üũŰ
		}
		String shopsName = request.getParameter("shopName"); // �׺���̼� ī�װ� �̸�
		System.out.println(shopsName);
		int itemCount = dao.AllItemCount(); // �� ��ǰ ���� ��������
		int list = 0;
		String itemName = request.getParameter("itemName");
		System.out.println(itemName);
		
		int ClickCnt = 1; // ���� ����¡ ����
		int offset = 0;
		int noOfRecords = 13;
	
		if(request.getParameter("ClickCnt") != null) {
			ClickCnt = Integer.parseInt(request.getParameter("ClickCnt")); // 2 3
			offset = 12*(ClickCnt-1); // 12 24
			noOfRecords = (ClickCnt*12)+1; // 25 37
		}
		if(itemCount<noOfRecords) { 
			noOfRecords = itemCount+1;
		}
		
		if(request.getParameter("list") != null) {
			list = Integer.parseInt(request.getParameter("list")); // 1:�α�� 2:�ֽż� 3:�������� 4:��������
		}
		
		if(itemName != null) {
			shopsName = itemName;
			ArrayList<ShopDTO> a = dao.ItemSearch(itemName, offset, noOfRecords); // �˻��Ұ��
			System.out.println("itemCount" + itemCount);
			System.out.println("offset" + offset);
			System.out.println("noOfRecords" + noOfRecords);
			request.setAttribute("a", a);
			itemCount = dao.ItemSearchCount(itemName); // �˻��� ��ǰ ����
		}else if(shopsName == null || shopsName.equals("EVERY") || shopsName.equals("SHOP")) {
			shopsName = "SHOP";
			if(list==1) {
				ArrayList<ShopDTO> a = dao.shopList(offset, noOfRecords); // ��� ��ǰ ��������
				request.setAttribute("a", a);
			}else if(list==2 || list==0) {
				ArrayList<ShopDTO> a = dao.shopList(offset, noOfRecords); // �ֽż� ��� ��ǰ ��������
				request.setAttribute("a", a);
			}else if(list==3) {
				ArrayList<ShopDTO> a = dao.shopLowList(offset, noOfRecords); // �������� ��� ��ǰ ��������
				request.setAttribute("a", a);
			}else if(list==4) {
				ArrayList<ShopDTO> a = dao.shopHighList(offset, noOfRecords); // �������� ��� ��ǰ ��������
				request.setAttribute("a", a);
			}
		}else{
			int ItemCnt = dao.ItemCnt(shopsName);
			if(ItemCnt<noOfRecords) { 
				noOfRecords = ItemCnt+1;
			}
			if(list==1) {
				ArrayList<ShopDTO> a = dao.shopItemList(shopsName, offset, noOfRecords); // ���� ��ǰ ��������
				request.setAttribute("a", a);
			}else if(list==2 || list==0) {
				ArrayList<ShopDTO> a = dao.shopItemList(shopsName, offset, noOfRecords); // �ֽż� ���� ��ǰ ��������
				request.setAttribute("a", a);
			}else if(list==3) {
				ArrayList<ShopDTO> a = dao.shopItemLowList(shopsName, offset, noOfRecords); // �������� ���� ��ǰ ��������
				request.setAttribute("a", a);
			}else if(list==4) {
				ArrayList<ShopDTO> a = dao.shopItemHighList(shopsName, offset, noOfRecords); // �������� ���� ��ǰ ��������
				request.setAttribute("a", a);
			}
			itemCount = dao.ItemCount(shopsName); // ���� ��ǰ ���� ��������
		}
		
		int recentCnt = 0; // �ֱ� �� ��ǰ �� ����
		int cartCnt = 0;
		dao.RecentdeleteItem(); // �Ϸ� ������ �ֱ� �� ��ǰ�� �ִ°� �����!
		if(id!="�մ�") {
			recentCnt = dao.RecentCnt(id);
			cartCnt = dao.cartCnt(id);
			ArrayList<ShopDTO> recentItem = dao.recentSeeItem(id);
			ArrayList<ShopDTO> cartItem = dao.cartSeeItem(id);
			request.setAttribute("recentItem", recentItem);
			request.setAttribute("cartItem", cartItem);
		}
		
		request.setAttribute("shopName", shopsName);
		request.setAttribute("itemCount", itemCount);
		request.setAttribute("list", list);
		request.setAttribute("searchCnt", searchCnt);
		request.setAttribute("recentCnt", recentCnt);
		request.setAttribute("cartCnt", cartCnt);
		request.setAttribute("ClickCnt", ClickCnt);
		request.setAttribute("offset", offset);
		request.setAttribute("noOfRecords", noOfRecords);
		System.out.println("searchCnt"+searchCnt);
		System.out.println("cartCnt"+cartCnt);
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);	
		
	}

}
