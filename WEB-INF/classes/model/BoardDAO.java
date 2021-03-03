package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
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
	
	// ��� �Խù� �������� �޼��� �ۼ�
		public ArrayList<BoardDTO> getAllboardlist(int startRow, int endRow){
			ArrayList <BoardDTO> a = new ArrayList<BoardDTO>();
			getCon();
			
			try {
				// �����غ�
				// Rownum�� ����Ŭ�ý��ۿ��� �ڵ����� ��ȣ�� ������ִ� �Լ���.
				
				String sql = "select * from (select A.*, Rownum Rnum from (select * from oh_board  where re_step=1 and board_title !='null' order by ref desc, re_level asc) A) where Rnum >= ? and Rnum <= ?";//��������
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, startRow);
				pstm.setInt(2, endRow);
				
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					BoardDTO bdto = new BoardDTO();
					bdto.setBoard_code(rs.getInt(1));
					bdto.setId(rs.getString(2));
					bdto.setBoard_title(rs.getString(3));
					bdto.setBoard_pw(rs.getString(4));
					bdto.setBoard_img(rs.getString(5));
					bdto.setBoard_content(rs.getString(6));
					bdto.setBoard_date(rs.getString(7));
					bdto.setCnt(rs.getInt(8));
					bdto.setRef(rs.getInt(9));
					bdto.setRe_step(rs.getInt(10));
					bdto.setRe_level(rs.getInt(11));
											
					a.add(bdto);				
				}
						
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
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
	
		// �ϳ��� �Խñ��� �о���̴� �޼��� �ۼ�
				// ��, �Խñ��� Ŭ���ϴ� ���� ��ȸ���� �����ǵ��� �ۼ�
			public BoardDTO getOne(int board_code) {
				
				getCon();
				
				BoardDTO bdto = new BoardDTO();
				
				try {
					// �ϳ��� �Խñ��� Ŭ���� �� ��ȸ�� �����ϴ� ���� �ۼ�
					String countsql = "update oh_board set board_cnt = board_cnt+1 where board_code =?";
					pstm = con.prepareStatement(countsql);
					pstm.setInt(1, board_code);
					pstm.executeUpdate();
					
					//�Խñ� �ϳ��� ������ ��ȸ�ϴ� �����ۼ�
					String sql = "select * from oh_board where board_code=?";
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, board_code);
					rs = pstm.executeQuery();
					
					if(rs.next()){
						bdto.setBoard_code(rs.getInt(1));
						bdto.setId(rs.getString(2));
						bdto.setBoard_title(rs.getString(3));
						bdto.setBoard_pw(rs.getString(4));
						bdto.setBoard_img(rs.getString(5));
						bdto.setBoard_content(rs.getString(6));
						bdto.setBoard_date(rs.getString(7));
						bdto.setCnt(rs.getInt(8));
						bdto.setRef(rs.getInt(9));
						bdto.setRe_step(rs.getInt(10));
						bdto.setRe_level(rs.getInt(11));
						
					}
					
				}catch(Exception e) {
					
					e.printStackTrace();
					
				}finally {
					if(rs!=null) {
						try {rs.close();}catch(Exception e) {}
					}
					if(pstm!=null) {
						try {pstm.close();}catch(Exception e) {}
					}
					if(con!=null) {
						try {con.close();}catch(Exception e) {}
					}
				}
				
				return bdto;
			}
	
	// �Խñ� insert
	public void insertboard(BoardDTO bdto) {
		getCon();
		int ref = 0; // �� �׷��� �ǹ� => ����������Ѽ� ���� ū ref���� ������ �� +1
		int re_step = 1;
		int re_level = 1;
		
		try{
			String refsql = "select max(ref) from oh_board";
			pstm = con.prepareStatement(refsql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				ref = rs.getInt(1)+1; // �ִ밪�� ã�� 1�� ������Ŵ.
			}
			
			String sql="insert into oh_board values(oh_board_seq.NEXTVAL,?,?,?,?,?,SYSDATE,0,?,?,?)";
			pstm= con.prepareStatement(sql);
			
			pstm.setString(1, bdto.getId());
			pstm.setString(2, bdto.getBoard_title());
			pstm.setString(3, bdto.getBoard_pw());
			pstm.setString(4, bdto.getBoard_img());
			pstm.setString(5, bdto.getBoard_content());
			pstm.setInt(6, ref);
			pstm.setInt(7, re_step);
			pstm.setInt(8, re_level);
			
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
	
	public void updateboard(int board_code,String board_title, String board_content, String board_img) {
		getCon();
		try {
			String sql="update oh_board set board_title=?, board_content=?, board_img=? where board_code=?";
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, board_title);
			pstm.setString(2, board_content);
			pstm.setString(3, board_img);
			pstm.setInt(4, board_code);
			
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
	
	public void deleteboard(int board_code) {
		getCon();
		try {
			String sql="delete from oh_board where board_code=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, board_code);
			
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
	
	/*public void updatecnt(int board_code) {
		getCon();
		try {
			String sql="update oh_board set board_cnt=board_cnt+1 where board_code=?";
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, board_code);
			
			pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
		
	}*/
	
	public ArrayList<BoardDTO> Search(String name){
		ArrayList<BoardDTO> a = new ArrayList<BoardDTO>();
		getCon();
		try{
			String sql = "select * from oh_board where id like ? order by board_code desc";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%"+ name + "%");
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				BoardDTO bdto = new BoardDTO();
				bdto.setBoard_code(rs.getInt(1));
				bdto.setId(rs.getString(2));
				bdto.setBoard_title(rs.getString(3));
				bdto.setBoard_pw(rs.getString(4));
				bdto.setBoard_img(rs.getString(5));
				bdto.setBoard_content(rs.getString(6));
				bdto.setBoard_date(rs.getString(7));
				bdto.setCnt(rs.getInt(8));
				a.add(bdto);
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
	
	// ��й�ȣ Ȯ��
	public String chkBoardPw(String id, String pw){
		String pww = "";
		getCon();
		try{
			String sql = "select board_pw from oh_board where id=? and board_pw=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				pww = rs.getString(1);
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
		return pww;
	}
	
	// �亯���� �����ϴ� �޼ҵ带 �ۼ��Ѵ�.
	public void reInsertBoard(BoardDTO bdto) {
		getCon();
		
		// ���� �ۼ��� ���� �ƴ϶� �亯���� �ۼ��ϱ� ������ ������ ���� ������ �ִ� ref, re_step, re_level���� �Ѱܹ޾ƾ���
		int ref = bdto.getRef();
		int re_step = bdto.getRe_step();
		int re_level = bdto.getRe_level();
		System.out.println(ref);
		System.out.println(re_step);
		System.out.println(re_level);
		
		try{
			
			// �ٽ��ڵ�, re_level�� 1�� �����Ͽ��� ��
			// ��, ���� re_level���� ũ�鼭 ref�� ���� �����͸� 1�� ������Ű�� ���� �ۼ�.
			// ������ �׷��� ����� �ֽż����� ȭ�鿡 ���� ��� �� �� ����.
			// ref�� �����鼭 re_level���� ū ��� re_level+1�� �����ϴ� update���� �ۼ�
			String levelsql = "update oh_board set re_level = re_level+1 where ref = ? and re_level > ?";
			pstm = con.prepareStatement(levelsql);
			pstm.setInt(1, ref);
			pstm.setInt(2, re_level);
			// ���� ����
			pstm.executeUpdate();
			
			// insert �ϴ� ���� �ۼ�
			String sql = "insert into oh_board values(oh_board_seq.NEXTVAL,?,null,null,null,?,SYSDATE,0,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, bdto.getId());
			pstm.setString(2, bdto.getBoard_content());
			pstm.setInt(3, ref);
			pstm.setInt(4, re_step+1); // ���� �θ�ۿ� ���Ǻ��� 1�� �������Ѿ� ��.
			pstm.setInt(5, re_level+1); 
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
	
	public void reInsertBoard2(BoardDTO bdto) {
		getCon();
		
		// ���� �ۼ��� ���� �ƴ϶� �亯���� �ۼ��ϱ� ������ ������ ���� ������ �ִ� ref, re_step, re_level���� �Ѱܹ޾ƾ���
		int ref = bdto.getRef();
		int re_step = bdto.getRe_step();
		int re_level = bdto.getRe_level();
		
		
		try{
			String osql = "select min(re_level) from oh_board where ref = ? and re_step = 3";
			pstm = con.prepareStatement(osql);
			pstm.setInt(1, ref);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				re_level = rs.getInt(1);
			}
			
			if(re_level==0) {
				re_level = bdto.getRe_level();
			}
			System.out.println("ref"+ref);
			System.out.println("re_step"+re_step);
			System.out.println("re_level"+re_level);
			
			// �ٽ��ڵ�, re_level�� 1�� �����Ͽ��� ��
			// ��, ���� re_level���� ũ�鼭 ref�� ���� �����͸� 1�� ������Ű�� ���� �ۼ�.
			// ������ �׷��� ����� �ֽż����� ȭ�鿡 ���� ��� �� �� ����.
			// ref�� �����鼭 re_level���� ū ��� re_level+1�� �����ϴ� update���� �ۼ�
			String levelsql = "update oh_board set re_level = re_level+1 where ref = ? and re_level >= ?";
			pstm = con.prepareStatement(levelsql);
			pstm.setInt(1, ref);
			pstm.setInt(2, re_level);
			// ���� ����
			pstm.executeUpdate();
			
			// insert �ϴ� ���� �ۼ�
			String sql = "insert into oh_board values(oh_board_seq.NEXTVAL,?,null,null,null,?,SYSDATE,0,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, bdto.getId());
			pstm.setString(2, bdto.getBoard_content());
			pstm.setInt(3, ref);
			pstm.setInt(4, re_step+1); // ���� �θ�ۿ� ���Ǻ��� 1�� �������Ѿ� ��.
			pstm.setInt(5, re_level); 
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
	
	//  �� �Խù��� �ִ� ��� ��۵�
	public ArrayList<BoardDTO> getAllboardComment(int ref){
		ArrayList <BoardDTO> a = new ArrayList<BoardDTO>();
		getCon();
		try {
			String sql = "select * from oh_board where board_title is null "
					+ "and ref = ? order by ref desc, re_level asc";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, ref);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				BoardDTO bdto = new BoardDTO();
				bdto.setBoard_code(rs.getInt(1));
				bdto.setId(rs.getString(2));
				bdto.setBoard_title(rs.getString(3));
				bdto.setBoard_pw(rs.getString(4));
				bdto.setBoard_img(rs.getString(5));
				bdto.setBoard_content(rs.getString(6));
				bdto.setBoard_date(rs.getString(7));
				bdto.setCnt(rs.getInt(8));
				bdto.setRef(rs.getInt(9));
				bdto.setRe_step(rs.getInt(10));
				bdto.setRe_level(rs.getInt(11));
				a.add(bdto);
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
	
	// ��ü �Խñ��� ������ �����ϴ� �޼��� �ۼ�
	public int getAllCount() {
		
		getCon();
		
		int count =0;
		
		try {
			String sql = "select count(*) from oh_board where re_step=1";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {count = rs.getInt(1);}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
		return count;
	}
	// ��ü �Խñ��� ������ �����ϴ� �޼��� �ۼ�2
	public int getAllCount2() {
		
		getCon();
		
		int count =0;
		
		try {
			String sql = "select count(*) from oh_board";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {count = rs.getInt(1);}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
		return count;
	}
	
	// ��� �� ����� ��� ��������
	public void updateComent(String board_content, int ref, int re_step, int re_level, String id) {
		getCon();
		
		try {
			String sql = "update oh_board set board_content = ? where ref = ? and re_step=? and re_level=? and id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, board_content);
			pstm.setInt(2, ref);
			pstm.setInt(3, re_step);
			pstm.setInt(4, re_level);
			pstm.setString(5, id);
			pstm.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
	
	// ��� ����
	public void deleteComent(int ref, int re_step, int re_level, String id) {
		getCon();
		
		try {
			String sql = "update oh_board set board_content='������ ���Դϴ١�' where ref=? and re_step=? and re_level=? and id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, ref);
			pstm.setInt(2, re_step);
			pstm.setInt(3, re_level);
			pstm.setString(4, id);
			pstm.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
	
	//�����ڵ� ã�¹�
	public int getOnebeforecode(int board_code) {
					
					getCon();
					
					int code = 0;
					
					try {
						
						String sql = "select max(board_code) from oh_board where board_code <  ? and re_step = 1";
						pstm = con.prepareStatement(sql);
						pstm.setInt(1, board_code);
						rs = pstm.executeQuery();
						
						if(rs.next()){
							code = rs.getInt(1);
							
						}
						
					}catch(Exception e) {
						
						e.printStackTrace();
						
					}finally {
						if(rs!=null) {
							try {rs.close();}catch(Exception e) {}
						}
						if(pstm!=null) {
							try {pstm.close();}catch(Exception e) {}
						}
						if(con!=null) {
							try {con.close();}catch(Exception e) {}
						}
					}
					
					return code;
				}
	//�����ڵ� ã�¹�
	public int getOneaftercode(int board_code) {
		
		getCon();
		
		int code = 0;
		
		try {
			
			String sql = "select min(board_code) from oh_board where board_code > ? and re_step = 1";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, board_code);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				code = rs.getInt(1);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			if(rs!=null) {
				try {rs.close();}catch(Exception e) {}
			}
			if(pstm!=null) {
				try {pstm.close();}catch(Exception e) {}
			}
			if(con!=null) {
				try {con.close();}catch(Exception e) {}
			}
		}
		
		return code;
	}
	//�ְ�ū �Խù�
	public int maxcode() {
		
		getCon();
		
		int maxcode = 0;
		
		try {
			
			String sql = "select max(board_code) from oh_board where re_step = 1";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				maxcode = rs.getInt(1);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			if(rs!=null) {
				try {rs.close();}catch(Exception e) {}
			}
			if(pstm!=null) {
				try {pstm.close();}catch(Exception e) {}
			}
			if(con!=null) {
				try {con.close();}catch(Exception e) {}
			}
		}
		
		return maxcode;
	}
	//�ְ����� �Խù�
	public int mincode() {
		
		getCon();
		
		int mincode = 0;
		
		try {
			
			String sql = "select min(board_code) from oh_board where re_step = 1";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				mincode = rs.getInt(1);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			if(rs!=null) {
				try {rs.close();}catch(Exception e) {}
			}
			if(pstm!=null) {
				try {pstm.close();}catch(Exception e) {}
			}
			if(con!=null) {
				try {con.close();}catch(Exception e) {}
			}
		}
		
		return mincode;
	}
	
	
	
}




















