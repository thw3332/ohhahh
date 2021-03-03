package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyCartDAO {
	
	String dbid = "test";
	String dbpw = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
   
   //-----------------------------------------
	
	// DB 연결 메소드 작성
	public void getCon() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, dbid, dbpw);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//------------------------
	
	//----------장바구니 추가 
	public void insertItem(int item_code,String id,int cart_cnt) {
		getCon();
		try{
			String sql = "insert into oh_cart values(oh_cart_seq.NEXTVAL,?,?,?,'Y')";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, item_code);
			pstm.setString(2, id);
			pstm.setInt(3, cart_cnt);
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
	}
	//----------장바구니 추가 (하나만)
		public void oneinsertItem(int item_code,String id,int cart_cnt) {
			getCon();
			try{
				String sql = "insert into oh_cart values(oh_cart_seq.NEXTVAL,?,?,?,'N')";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, item_code);
				pstm.setString(2, id);
				pstm.setInt(3, cart_cnt);
				pstm.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
		}
	//-------------------------
	
	// 장바구니에 추가한 아이템 리스트 보기 
	public ArrayList<MycartDTO> getAllItemList(String id){
		ArrayList<MycartDTO> a = new ArrayList<MycartDTO>();
		getCon();
		try {
			String sql = "select item_img,item_name,item_price,cart_cnt,oh_item.item_code from oh_item,oh_cart where oh_item.item_code = oh_cart.item_code and cart_see = 'Y' and id = ?  ";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				MycartDTO mcdto = new MycartDTO();
				mcdto.setItem_img(rs.getString(1));
				mcdto.setItem_name(rs.getString(2));
				mcdto.setItem_price(rs.getInt(3));
				mcdto.setCnt(rs.getInt(4));
				mcdto.setItem_code(rs.getInt(5));
				a.add(mcdto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
		return a;
	}
	
	//
	public ArrayList<MycartDTO> getAllItemList2(String id){
		ArrayList<MycartDTO> a = new ArrayList<MycartDTO>();
		getCon();
		try {
			String sql = "select item_img,item_name,item_price,cart_cnt,oh_item.item_code from oh_item,oh_cart where oh_item.item_code = oh_cart.item_code and cart_see = 'N' and id = ?  ";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				MycartDTO mcdto = new MycartDTO();
				mcdto.setItem_img(rs.getString(1));
				mcdto.setItem_name(rs.getString(2));
				mcdto.setItem_price(rs.getInt(3));
				mcdto.setCnt(rs.getInt(4));
				mcdto.setItem_code(rs.getInt(5));
				a.add(mcdto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
		return a;
	}
	
	//--------------------------------
	
	//------장바구니 아이템 삭제하기 
	
	
	
	
	
	//-------------------------------
	
	//------장바구니 아이템 수량 수정하기 
	
	
	//같은 물건이 있는지 알아보기
	public Boolean profind(int item_code,String id) {
		Boolean a = true;
		int num = -1;
		getCon();
		try{
			String sql = "Select item_code from oh_cart where item_code=? and cart_see = 'Y' and id=? ";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, item_code);
			pstm.setString(2, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			if(num == item_code) {
			 a = true;
			}else {
				a= false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
		return a;
		
	}
	
	
	//--같은물건 들어왓을떄 수량만 변경하기
	public void CntAddItem(int item_code,String id,int cart_cnt) {
		getCon();
		try{
			String sql = "update oh_cart set cart_cnt=(cart_cnt)+? where item_code=? and id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cart_cnt);
			pstm.setInt(2, item_code);
			pstm.setString(3, id);
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
	}
	//장바구니에서 수량 변경하기
	
	public void CntChangeCart(int item_code,String id,int cart_cnt) {
		getCon();
		try{
			String sql = "update oh_cart set cart_cnt=? where item_code=? and id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cart_cnt);
			pstm.setInt(2, item_code);
			pstm.setString(3, id);
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
	}
	//물건삭제
	public void deletecart(int item_code,String id) {
		getCon();
		try{
			String sql = "delete from oh_cart where item_code=? and id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, item_code);
			pstm.setString(2, id);
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
	}
	//장바구니 비엇는지
	public int cartfind(String id) {
		int b = 0;
		getCon();
		try{
			String sql = "Select count(id) from oh_cart where id=? and cart_see = 'Y'";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				b = rs.getInt(1);
				
			}
	
			
			System.out.println(b);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {rs.close();}
				catch(Exception e) {}}
			if(pstm!=null){
				try {pstm.close();}
				catch(Exception e){}}
			if(con!=null){
				try {con.close();}
				catch(Exception e){}}
		}
		
		return b;
		
	}
	//
	//물건모두삭제
		public void Alldeletecart(String id) {
			getCon();
			try{
				String sql = "delete from oh_cart where id=?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, id);
				pstm.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
		}
		//물건 하나만
		public MycartDTO getItemList(int item_code){
			MycartDTO mcdto = new MycartDTO();
			getCon();
			try {
				String sql = "select item_img,item_name,item_price,cart_cnt,oh_item.item_code from oh_item,oh_cart where oh_item.item_code = oh_cart.item_code and cart_see = 'Y' and oh_item.item_code = ?  ";
				
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, item_code);
				rs = pstm.executeQuery();
				
				if(rs.next()) {
					
					mcdto.setItem_img(rs.getString(1));
					mcdto.setItem_name(rs.getString(2));
					mcdto.setItem_price(rs.getInt(3));
					mcdto.setCnt(rs.getInt(4));
					mcdto.setItem_code(rs.getInt(5));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
			return mcdto;
		}
		//물건 하나만
		public MycartDTO getItemList2(int item_code){
			MycartDTO mcdto = new MycartDTO();
			getCon();
			try {
				String sql = "select item_img,item_name,item_price,cart_cnt,oh_item.item_code from oh_item,oh_cart where oh_item.item_code = oh_cart.item_code and cart_see = 'N' and oh_item.item_code = ?  ";
				
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, item_code);
				rs = pstm.executeQuery();
				
				if(rs.next()) {
					
					mcdto.setItem_img(rs.getString(1));
					mcdto.setItem_name(rs.getString(2));
					mcdto.setItem_price(rs.getInt(3));
					mcdto.setCnt(rs.getInt(4));
					mcdto.setItem_code(rs.getInt(5));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
			return mcdto;
		}
	//구매한물건하나만
		
		//물건구매시
		public void itembuy(int item_code,String id) {
			getCon();
			try{
				String sql = "update oh_cart set cart_see = 'N' where item_code = ? and id=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, item_code);
				pstm.setString(2, id);
				pstm.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
		}
		
		//구매한 물품출력
		
		public ArrayList<MycartDTO> getBuyItemList(String id){
			ArrayList<MycartDTO> a = new ArrayList<MycartDTO>();
			getCon();
			try {
				String sql = "select item_img,item_name,item_price,cart_cnt,oh_item.item_code from oh_item,oh_cart where oh_item.item_code = oh_cart.item_code and cart_see = 'N' and id = ?  ";
				
				pstm = con.prepareStatement(sql);
				pstm.setString(1, id);
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					MycartDTO mcdto = new MycartDTO();
					mcdto.setItem_img(rs.getString(1));
					mcdto.setItem_name(rs.getString(2));
					mcdto.setItem_price(rs.getInt(3));
					mcdto.setCnt(rs.getInt(4));
					mcdto.setItem_code(rs.getInt(5));
					a.add(mcdto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
			return a;
		}
		
		public int orderfind(String id) {
			int b = 0;
			getCon();
			try{
				String sql = "Select count(id) from oh_cart where id=? and cart_see = 'N'";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, id);
				rs = pstm.executeQuery();
				if(rs.next()) {
					b = rs.getInt(1);
					
				}
		
				
				System.out.println(b);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {rs.close();}
					catch(Exception e) {}}
				if(pstm!=null){
					try {pstm.close();}
					catch(Exception e){}}
				if(con!=null){
					try {con.close();}
					catch(Exception e){}}
			}
			
			return b;
			
		}
		
}
