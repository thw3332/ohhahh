package model;

public class DTO {
     
	
	private String id;
	private String pw;
	private String name;
	private String birth;
	private int phone;
	private String addr;
	private String detailaddr;
	private String postcode;
	//멤버테이블
	private int cate_code;
	private String cate_name;
	//카테고리 테이블
	private int item_code;
	private String item_name;
	private int item_price;
	private String item_img;
	private String item_detailimg;
	//상품 테이블
	
	private int cart_code;
	private String cart_option;
	private int cart_cnt;
	private String cart_see;
	//장바구니&구매테이블
	
	private int board_code;
	private String board_title;
	private String board_pw;
	private String board_img;
	private String board_content;
	private String board_date;
	private int cnt;
	//게시판 테이블
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getCate_code() {
		return cate_code;
	}
	public void setCate_code(int cate_code) {
		this.cate_code = cate_code;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public String getItem_detailimg() {
		return item_detailimg;
	}
	public void setItem_detailimg(String item_detailimg) {
		this.item_detailimg = item_detailimg;
	}
	public int getCart_code() {
		return cart_code;
	}
	public void setCart_code(int cart_code) {
		this.cart_code = cart_code;
	}
	public String getCart_option() {
		return cart_option;
	}
	public void setCart_option(String cart_option) {
		this.cart_option = cart_option;
	}
	public int getCart_cnt() {
		return cart_cnt;
	}
	public void setCart_cnt(int cart_cnt) {
		this.cart_cnt = cart_cnt;
	}
	public String getCart_see() {
		return cart_see;
	}
	public void setCart_see(String cart_see) {
		this.cart_see = cart_see;
	}
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_pw() {
		return board_pw;
	}
	public void setBoard_pw(String board_pw) {
		this.board_pw = board_pw;
	}
	public String getBoard_img() {
		return board_img;
	}
	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getDetailaddr() {
		return detailaddr;
	}
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}
	
	
	
	 
}
