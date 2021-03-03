package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO {
	String id = "test";
	String pw= "1234";
	String url ="jdbc:oracle:thin:@localhost:1521:XE";
	
	Connection con =null;
   PreparedStatement pstm =null;
   ResultSet rs = null;
   
   //-----------------------------------------
   //DB�뜝�룞�삕�뜝�룞�삕 �뜝�뙣�냼�벝�삕 �뜝�뙗�눦�삕
   public void getCon() {
	   try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   con = DriverManager.getConnection(url, id, pw);
		   
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
   
	   
   }
   // 占쎄맒占쎈�밭뵳�딅뮞占쎈뱜
   public ArrayList<DTO> prolist(String cate_name){
	   ArrayList<DTO> a = new ArrayList<DTO>();

		try {
			getCon();
String sql = "select * from oh_category, oh_item where  oh_category.cate_code = oh_item.cate_code and oh_category.cate_name =?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cate_name);
			rs = pstm.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setCate_code(rs.getInt(1));
				dto.setCate_name(rs.getString(2));
				dto.setItem_code(rs.getInt(3));
			    dto.setCate_code(rs.getInt(4));
			    dto.setItem_name(rs.getString(5));
			    dto.setItem_price(rs.getInt(6));
			    dto.setItem_img(rs.getString(7));
			    dto.setItem_detailimg(rs.getString(8));
			    a.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { con.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
			if(pstm != null) {
				try { pstm.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
		}
	   
	   
	   return a;
	   
   }
   //占쎌돳占쎌뜚揶쏉옙占쎌뿯
   
   public void joinmember(DTO dto){
	 

		try {
			getCon();
String sql = "insert into oh_member values(?,?,?,?,?,?,?,?) ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getPw());
			pstm.setString(3, dto.getName());
			pstm.setString(4, dto.getBirth());
			pstm.setInt(5, dto.getPhone());
			pstm.setString(6, dto.getAddr());
			pstm.setString(7, dto.getDetailaddr());
			pstm.setString(8, dto.getPostcode());
			pstm.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { con.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
			if(pstm != null) {
				try { pstm.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
		}
	   
   }
   //嚥≪뮄�젃占쎌뵥 占쎈툡占쎌뵠占쎈탵筌랃옙 �빊遺욱뀱
   public String findid(String id){
		 String findid ="";

			try {
				getCon();
	String sql = "select id from oh_member where id=? ";
				pstm = con.prepareStatement(sql);
		        pstm.setString(1, id);
				
			rs = pstm.executeQuery();
		  if(rs.next()) {
			  
			  findid = rs.getString(1);
		  }
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) {
					try { con.close(); }
					catch(Exception e) { e.printStackTrace(); }
				}
				if(pstm != null) {
					try { pstm.close(); } 
					catch(Exception e) { e.printStackTrace(); }
				}
				if(con != null) {
					try { con.close(); } 
					catch(Exception e) { e.printStackTrace(); }
				}
			}
			return findid;
	   }
   //嚥≪뮄�젃占쎌뵥 �뜮袁⑨옙甕곕뜇�깈筌랃옙 �빊遺욱뀱
   public String findpw(String id){
		 String findpw ="";

			try {
				getCon();
	String sql = "select pw from oh_member where id=? ";
				pstm = con.prepareStatement(sql);
		        pstm.setString(1, id);
				
			rs = pstm.executeQuery();
		  if(rs.next()) {
			  
			  findpw = rs.getString(1);
		  }
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) {
					try { con.close(); }
					catch(Exception e) { e.printStackTrace(); }
				}
				if(pstm != null) {
					try { pstm.close(); } 
					catch(Exception e) { e.printStackTrace(); }
				}
				if(con != null) {
					try { con.close(); } 
					catch(Exception e) { e.printStackTrace(); }
				}
			}
			return findpw;
	   }
   //占쎄맒占쎈�� 占쎄맒占쎄쉭 占쎌젟癰귨옙
   public DTO infolist(String itemcode){
	   DTO dto = new DTO();

		try {
			getCon();
			String sql = "select * from oh_item where item_code=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, itemcode);
			rs = pstm.executeQuery();
			while(rs.next()) {
				
				dto.setItem_code(rs.getInt(1));
				dto.setCate_code(rs.getInt(2));
			    dto.setItem_name(rs.getString(3));
			    dto.setItem_price(rs.getInt(4));
			    dto.setItem_img(rs.getString(5));
			    dto.setItem_detailimg(rs.getString(6));
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { con.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
			if(pstm != null) {
				try { pstm.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
		}
	   return dto;
   }
   
   // �븘�씠�뵒 李얘린
   public String findId(String name, int phone) {
	   String id = null;
	   getCon();
		
		try{
			String sql = "select id from oh_member where name=? and phone=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, phone);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);
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
	   
	   return id;
   }
   
   // 鍮꾨�踰덊샇 李얘린
   public String findPw(String id, String name, int phone) {
	   String pw = null;
	   getCon();
		
		try{
			String sql = "select pw from oh_member where id=? and name=? and phone=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, phone);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				pw = rs.getString(1);
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
	   
	   return pw;
   }
   
// 以묐났 �븘�씠�뵒 李얘린
   public String findDupliId(String id) {
	   String idd = null;
	   getCon();
		
		try{
			String sql = "select id from oh_member where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				idd = rs.getString(1);
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
	   
	   return idd;
   }
   
   //留덉씠�럹�씠吏� �쉶�썝�젙蹂대뱾
   public DTO Mypage(String id){
	   DTO dto = new DTO();

		try {
			getCon();
			String sql = "select * from oh_member where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				
				dto.setId(rs.getString(1));
				dto.setPw(rs.getString(2));
			    dto.setName(rs.getString(3));
			    dto.setBirth(rs.getString(4));
			    dto.setPhone(rs.getInt(5));
			    dto.setAddr(rs.getString(6));
			    dto.setDetailaddr(rs.getString(7));
			    dto.setPostcode(rs.getString(8));
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { con.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
			if(pstm != null) {
				try { pstm.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
		}
	   
	   
	   return dto;
	   
   }
   
   //�쉶�썝�젙蹂� �닔�젙
   public void modifyinfo(String pw,int phone,String addr,String id,String detailaddr,String postcode){
		try {
			getCon();
			String sql = "update oh_member set pw=?,phone=?,addr=?,detailaddr=?,postcode=? where id = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pw);
			pstm.setInt(2, phone);
			pstm.setString(3, addr);
			pstm.setString(4, detailaddr);
			pstm.setString(5, postcode);
			pstm.setString(6, id);
			pstm.executeUpdate();
	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { con.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
			if(pstm != null) {
				try { pstm.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
		}
   }
   
   //�썝�옒 鍮꾨�踰덊샇 李얘린
   public String pw(String id){
	   String pw2 ="" ;
	       DTO dto = new DTO();

		try {
			getCon();
			String sql = "select pw from oh_member where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				
			pw2 = rs.getString(1);
			
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { con.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
			if(pstm != null) {
				try { pstm.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } 
				catch(Exception e) { e.printStackTrace(); }
			}
		}
	   return pw2;
   }
   
   public DTO joinMmemberlist(String id){
	  DTO dto = new DTO();
	  getCon();

	  try {
		  String sql ="select * from oh_member where id=?";
		  pstm = con.prepareStatement(sql);
		  pstm.setString(1, id);
		  rs = pstm.executeQuery();		

		  if(rs.next()) {
			  dto.setId(rs.getString(1));
			  dto.setPw(rs.getString(2));
			  dto.setName(rs.getString(3));  
			  dto.setBirth(rs.getString(4));
			  dto.setPhone(rs.getInt(5));
			  dto.setAddr(rs.getString(6));	
			  dto.setDetailaddr(rs.getString(7));
			  dto.setPostcode(rs.getString(8));
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
	  return dto;
   }
      
   public void deleteMember1(String id) {
	   getCon();

	  try {
		  String sql ="delete from oh_recent_item where id=?";
		  pstm = con.prepareStatement(sql);
		  pstm.setString(1, id);
		  pstm.executeUpdate();

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
   }
   
   public void deleteMember2(String id) {
	   getCon();

	  try {
		  String sql1 ="delete from oh_board where id=?";
		  pstm = con.prepareStatement(sql1);
		  pstm.setString(1, id);
		  pstm.executeUpdate();

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
   }
   
   public void deleteMember3(String id) {
	   getCon();

	  try {
		  String sql2 ="delete from oh_cart where id=?";
		  pstm = con.prepareStatement(sql2);
		  pstm.setString(1, id);
		  pstm.executeUpdate();

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
   }
   
   public void deleteMember4(String id) {
	   getCon();

	  try {
		  String sql3 ="delete from oh_member where id=?";
		  pstm = con.prepareStatement(sql3);
		  pstm.setString(1, id);
		  pstm.executeUpdate();

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
   }
      
   

}



























