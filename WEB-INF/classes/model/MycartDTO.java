package model;

public class MycartDTO {
	
	private int item_code; // 상품코드
	private String item_img; // 상품 이미지 
	private String item_name; // 상품이름
	private int item_price; // 상품가격
	private int cnt; // 상품수량
	private int item_total; // 상품 총금액
	
	
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getItem_total() {
		return item_total;
	}
	public void setItem_total(int item_total) {
		this.item_total = item_total;
	}
	
	
}

