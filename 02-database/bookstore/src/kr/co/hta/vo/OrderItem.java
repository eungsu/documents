package kr.co.hta.vo;

public class OrderItem {

	private long orderNo;
	private int bookNo;
	private int price;
	private int amount;
	
	public OrderItem() {}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderItem [orderNo=" + orderNo + ", bookNo=" + bookNo + ", price=" + price + ", amount=" + amount + "]";
	}
	
}
