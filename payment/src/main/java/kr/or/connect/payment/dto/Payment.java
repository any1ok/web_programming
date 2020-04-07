package kr.or.connect.payment.dto;

public class Payment {
	int id;
	int price;
	String imp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImp() {
		return imp;
	}
	public void setImp(String imp) {
		this.imp = imp;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", price=" + price + ", imp=" + imp + "]";
	}
	
	
}
