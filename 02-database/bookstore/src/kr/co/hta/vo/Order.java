package kr.co.hta.vo;

import java.util.Date;

public class Order {

	private long no;
	private String userId;
	private String status;
	private Date createDate;
	
	public Order() {}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Order [no=" + no + ", userId=" + userId + ", status=" + status + ", createDate=" + createDate + "]";
	}
	
}
