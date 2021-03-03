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
		
		String id = (String) session.getAttribute("log"); // 아이디 
		
		int searchCnt = 0;
		if(request.getParameter("searchCnt")!=null){
			searchCnt = Integer.parseInt(request.getParameter("searchCnt")); // 최신순, 인기순 드롭박스 없애는 체크키
		}
		String shopsName = request.getParameter("shopName"); // 네비게이션 카테고리 이름
		System.out.println(shopsName);
		int itemCount = dao.AllItemCount(); // 총 상품 갯수 가져오기
		int list = 0;
		String itemName = request.getParameter("itemName");
		System.out.println(itemName);
		
		int ClickCnt = 1; // 누른 페이징 숫자
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
			list = Integer.parseInt(request.getParameter("list")); // 1:인기순 2:최신순 3:낮은가격 4:높은가격
		}
		
		if(itemName != null) {
			shopsName = itemName;
			ArrayList<ShopDTO> a = dao.ItemSearch(itemName, offset, noOfRecords); // 검색할경우
			System.out.println("itemCount" + itemCount);
			System.out.println("offset" + offset);
			System.out.println("noOfRecords" + noOfRecords);
			request.setAttribute("a", a);
			itemCount = dao.ItemSearchCount(itemName); // 검색한 상품 갯수
		}else if(shopsName == null || shopsName.equals("EVERY") || shopsName.equals("SHOP")) {
			shopsName = "SHOP";
			if(list==1) {
				ArrayList<ShopDTO> a = dao.shopList(offset, noOfRecords); // 모든 상품 가져오기
				request.setAttribute("a", a);
			}else if(list==2 || list==0) {
				ArrayList<ShopDTO> a = dao.shopList(offset, noOfRecords); // 최신순 모든 상품 가져오기
				request.setAttribute("a", a);
			}else if(list==3) {
				ArrayList<ShopDTO> a = dao.shopLowList(offset, noOfRecords); // 낮은가격 모든 상품 가져오기
				request.setAttribute("a", a);
			}else if(list==4) {
				ArrayList<ShopDTO> a = dao.shopHighList(offset, noOfRecords); // 높은가격 모든 상품 가져오기
				request.setAttribute("a", a);
			}
		}else{
			int ItemCnt = dao.ItemCnt(shopsName);
			if(ItemCnt<noOfRecords) { 
				noOfRecords = ItemCnt+1;
			}
			if(list==1) {
				ArrayList<ShopDTO> a = dao.shopItemList(shopsName, offset, noOfRecords); // 각각 상품 가져오기
				request.setAttribute("a", a);
			}else if(list==2 || list==0) {
				ArrayList<ShopDTO> a = dao.shopItemList(shopsName, offset, noOfRecords); // 최신순 각각 상품 가져오기
				request.setAttribute("a", a);
			}else if(list==3) {
				ArrayList<ShopDTO> a = dao.shopItemLowList(shopsName, offset, noOfRecords); // 낮은가격 각각 상품 가져오기
				request.setAttribute("a", a);
			}else if(list==4) {
				ArrayList<ShopDTO> a = dao.shopItemHighList(shopsName, offset, noOfRecords); // 높은가격 각각 상품 가져오기
				request.setAttribute("a", a);
			}
			itemCount = dao.ItemCount(shopsName); // 각각 상품 갯수 가져오기
		}
		
		int recentCnt = 0; // 최근 본 상품 총 갯수
		int cartCnt = 0;
		dao.RecentdeleteItem(); // 하루 지나면 최근 본 상품에 있는거 사라짐!
		if(id!="손님") {
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
