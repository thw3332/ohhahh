package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShopDAO {
	
    String id = "test";
	String pw = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
   
   //-----------------------------------------
	
	// DB ���� �޼ҵ� �ۼ�
	public void getCon() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��� ��ǰ ��� ��������(�ֽż�)
	public ArrayList<ShopDTO> shopList(int offset, int noOfRecords){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select * from oh_item order by item_date desc) tmp)"
					+ "where ? < rm and rm < ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, offset);
			pstm.setInt(2, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
	
	// ��ü ����Ʈ ���� ���ݼ� ����
	public ArrayList<ShopDTO> shopLowList(int offset, int noOfRecords){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select * from oh_item order by item_price asc) tmp) "
					+ "where ? < rm and rm < ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, offset);
			pstm.setInt(2, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
	
	// ��ü ����Ʈ ���� ���ݼ� ����
	public ArrayList<ShopDTO> shopHighList(int offset, int noOfRecords){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select * from oh_item order by item_price desc) tmp) "
					+ "where ? < rm and rm < ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, offset);
			pstm.setInt(2, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
	
	// �� ��ǰ�� ����
	public int ItemCnt(String name) {
		int cnt = 0;
		getCon();
		try{
			String sql = "select count(*) from oh_item i, oh_category c "
					+ "where i.cate_code = c.cate_code and c.cate_name = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}
	
	// �� ī�װ��� ��ǰ ����Ʈ ��� ����
	public ArrayList<ShopDTO> shopItemList(String name, int offset, int noOfRecords){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select i.item_code, c.cate_code, i.item_name, "
					+ "i.item_price, i.item_img, i.item_detailimg, i.item_date "
					+ "from oh_item i, oh_category c "
					+ "where i.cate_code = c.cate_code and c.cate_name = ? "
					+ "order by item_date desc) tmp) "
					+ "where ? < rm and rm < ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, offset);
			pstm.setInt(3, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
	
	// �� ī�װ��� ��ǰ ����Ʈ ���(���� ���ݼ�)
	public ArrayList<ShopDTO> shopItemLowList(String name, int offset, int noOfRecords){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select i.item_code, c.cate_code, i.item_name, "
					+ "i.item_price, i.item_img, i.item_detailimg, i.item_date "
					+ "from oh_item i, oh_category c "
					+ "where i.cate_code = c.cate_code and c.cate_name = ? "
					+ "order by item_price asc) tmp) "
					+ "where ? < rm and rm < ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, offset);
			pstm.setInt(3, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
	
	// �� ī�װ��� ��ǰ ����Ʈ ���(���� ���ݼ�)
	public ArrayList<ShopDTO> shopItemHighList(String name, int offset, int noOfRecords){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select i.item_code, c.cate_code, i.item_name, "
					+ "i.item_price, i.item_img, i.item_detailimg, i.item_date "
					+ "from oh_item i, oh_category c "
					+ "where i.cate_code = c.cate_code and c.cate_name = ? "
					+ "order by item_price desc) tmp) "
					+ "where ? < rm and rm < ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, offset);
			pstm.setInt(3, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
		
	// ��ü ��ǰ ����
	public int AllItemCount() {
		int cnt = 0;
		getCon();
		
		try{
			String sql = "select count(*) from oh_item";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}
	
	// Ư�� ��ǰ ����
	public int ItemCount(String name) {
		int cnt = 0;
		getCon();
		
		try{
			String sql = "select count(*) from oh_item i, oh_category c "
					+ "where i.cate_code = c.cate_code and c.cate_name = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}
	
	// ��ǰ �̸����� �˻��ϱ�
	public ArrayList<ShopDTO> ItemSearch(String name, int offset, int noOfRecords) {
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from (select rownum rm, tmp.* "
					+ "from (select * from oh_item "
					+ "where upper(item_name) like upper(?) "
					+ "order by item_date desc) tmp) where ? < rm and rm < ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%"+ name + "%");
			pstm.setInt(2, offset);
			pstm.setInt(3, noOfRecords);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setRm(rs.getInt(1));
				dto.setItem_code(rs.getInt(2));
				dto.setCart_code(rs.getInt(3));
				dto.setItem_name(rs.getString(4));
				dto.setItem_price(rs.getInt(5));
				dto.setItem_img(rs.getString(6));
				dto.setItem_detailimg(rs.getString(7));
				dto.setItem_date(rs.getString(8));
				a.add(dto);
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
	
	// ��ǰ �̸����� �˻��ϱ�(��������)
	public ArrayList<ShopDTO> ItemSearchLow(String name) {
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from oh_item where upper(item_name) like upper(?) order by item_price asc;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%"+ name + "%");
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setItem_code(rs.getInt(1));
				dto.setCart_code(rs.getInt(2));
				dto.setItem_name(rs.getString(3));
				dto.setItem_price(rs.getInt(4));
				dto.setItem_img(rs.getString(5));
				dto.setItem_detailimg(rs.getString(6));
				dto.setItem_date(rs.getString(7));
				a.add(dto);
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
	
	// ��ǰ �̸����� �˻��ϱ�(��������)
	public ArrayList<ShopDTO> ItemSearchHigh(String name) {
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		
		try{
			String sql = "select * from oh_item where upper(item_name) like upper(?) order by item_price desc";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%"+ name + "%");
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setItem_code(rs.getInt(1));
				dto.setCart_code(rs.getInt(2));
				dto.setItem_name(rs.getString(3));
				dto.setItem_price(rs.getInt(4));
				dto.setItem_img(rs.getString(5));
				dto.setItem_detailimg(rs.getString(6));
				dto.setItem_date(rs.getString(7));
				a.add(dto);
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
	
	// �˻��� ��ǰ ����
	public int ItemSearchCount(String name) {
		int cnt = 0;
		getCon();
		
		try{
			String sql = "select count(*) from oh_item where upper(item_name) like upper(?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%"+ name + "%");
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}
	
	// �ֱ� �� ��ǰ �߰�
	public void recentInsertItem(int num, String id, String sys) {
		getCon();
		try{
			String sql = "insert into oh_recent_item values(oh_recent_item_seq.NEXTVAL,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.setString(2, id);
			pstm.setString(3, sys);
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
	
	// �ֱ� �߰��� ��ǰ�� ��ü ����
	public ArrayList<ShopDTO> recentSeeItem(String id){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		try{
			String sql = "select * from ("
					+ "select i.item_name, i.item_price, i.item_img, i.item_code "
					+ "from oh_recent_item r, oh_item i "
					+ "where r.item_code = i.item_code and r.id = ? "
					+ "order by r.recent_item_code desc)"
					+ "where rownum < 5";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setItem_name(rs.getString(1));
				dto.setItem_price(rs.getInt(2));
				dto.setItem_img(rs.getString(3));
				dto.setItem_code(rs.getInt(4));
				a.add(dto);
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
	
	// �ֱ� �� ��ǰ �� ����
	public int RecentCnt(String id) {
		int cnt = 0;
		getCon();
		try{
			String sql = "select count(*) from oh_recent_item where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}
	
	// �ֱ� �� ��ǰ�� �ߺ����� �ִ� ���
	public void RecentDupleDeleteItem(int num, String id) {
		getCon();
		try{
			String sql = "delete from oh_recent_item "
					+ "where item_code in (select item_code "
					+ "from oh_recent_item where item_code = ?) and id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.setString(2, id);
			pstm.executeUpdate();
			con.commit();
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
	
	// ������ ������ �ֱ� �߰��� ��ǰ�� �ڵ����� ����
	public void RecentdeleteItem() {
		getCon();
		try{
			String sql = "delete from oh_recent_item "
					+ "where to_char(recent_date, 'MMDD') < to_char(sysdate, 'MMDD')";
			pstm = con.prepareStatement(sql);
			pstm.executeUpdate();
			con.commit();
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
	
	/*############################ ��ǰ ������ #############################*/
	
	// ��ǰ ��ȭ�� ����
	public ShopDTO shopDetail(int num) {
		ShopDTO sdto = new ShopDTO();
		getCon();
		
		try{
			String sql = "select i.item_code, i.cate_code, c.cate_name, i.item_name, "
					+ "i.item_price, i.item_img, i.item_detailimg "
					+ "from oh_item i, oh_category c "
					+ "where i.cate_code = c.cate_code and item_code = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				sdto.setItem_code(rs.getInt(1));
				sdto.setCart_code(rs.getInt(2));
				sdto.setCate_name(rs.getString(3));
				sdto.setItem_name(rs.getString(4));
				sdto.setItem_price(rs.getInt(5));
				sdto.setItem_img(rs.getString(6));
				sdto.setItem_detailimg(rs.getString(7));
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
		return sdto;
	}	
	

	// �ֱ� �� ��ǰ �� ����
	public ArrayList<ShopDTO> cartSeeItem(String id){
		ArrayList<ShopDTO> a = new ArrayList<ShopDTO>();
		getCon();
		try{
			String sql = "select * from ("
					+ "select i.item_name, i.item_price, i.item_img, i.item_code "
					+ "from oh_cart r, oh_item i "
					+ "where r.item_code = i.item_code and r.id = ? and cart_see='Y'"
					+ "order by r.item_code desc)"
					+ "where rownum < 5";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setItem_name(rs.getString(1));
				dto.setItem_price(rs.getInt(2));
				dto.setItem_img(rs.getString(3));
				dto.setItem_code(rs.getInt(4));
				a.add(dto);
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
	
	public int cartCnt(String id) {
		int cnt = 0;
		getCon();
		try{
			String sql = "select count(*) from oh_cart where id=? and cart_see = 'Y'";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}
	
	
	
	
	
   
}

