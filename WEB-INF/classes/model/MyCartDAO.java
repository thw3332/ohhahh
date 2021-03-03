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
	
	// DB ���� �޼ҵ� �ۼ�
	public void getCon() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, dbid, dbpw);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//------------------------
	
	//----------��ٱ��� �߰� 
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
	//----------��ٱ��� �߰� (�ϳ���)
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
	
	// ��ٱ��Ͽ� �߰��� ������ ����Ʈ ���� 
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
	
	//------��ٱ��� ������ �����ϱ� 
	
	
	
	
	
	//-------------------------------
	
	//------��ٱ��� ������ ���� �����ϱ� 
	
	
	//���� ������ �ִ��� �˾ƺ���
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
	
	
	//--�������� �������� ������ �����ϱ�
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
	//��ٱ��Ͽ��� ���� �����ϱ�
	
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
	//���ǻ���
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
	//��ٱ��� �������
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
	//���Ǹ�λ���
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
		//���� �ϳ���
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
		//���� �ϳ���
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
	//�����ѹ����ϳ���
		
		//���Ǳ��Ž�
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
		
		//������ ��ǰ���
		
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
