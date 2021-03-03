package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShopDAO;
import model.ShopDTO;

@WebServlet("/ShopDetails.do")
public class ShopDetailPro extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("center", "ShopDetail.jsp");
		String headerr = request.getParameter("headerr");
		request.setAttribute("headerr", headerr);
		
		int itemNum = Integer.parseInt(request.getParameter("itemNum"));
		
		ShopDAO sdao = new ShopDAO();
		ShopDTO sdto = sdao.shopDetail(itemNum);
		
		request.setAttribute("item_code", sdto.getItem_code());
		request.setAttribute("cart_code", sdto.getCart_code());
		request.setAttribute("cate_name", sdto.getCate_name());
		request.setAttribute("item_name", sdto.getItem_name());
		request.setAttribute("item_price", sdto.getItem_price());
		request.setAttribute("item_img", sdto.getItem_img());
		request.setAttribute("item_detailimg", sdto.getItem_detailimg());
		
		int item_code = sdto.getItem_code();
		String id = (String) session.getAttribute("log"); // 아이디 ***나중에 추가요망!***
		
		SimpleDateFormat sim = new SimpleDateFormat ("yyyy-MM-dd");
		Date time = new Date();
		String sys = sim.format(time);
		
		if(id!="손님") {
			sdao.RecentDupleDeleteItem(item_code, id); // 이전에 클릭한 상품이면 이전에 클릭했던거 지움
			sdao.recentInsertItem(item_code, id, sys); // 최근 본 상품 추가
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp"); 
		dis.forward(request, response);
		
	}

}
