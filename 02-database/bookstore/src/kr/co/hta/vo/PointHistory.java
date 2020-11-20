package kr.co.hta.vo;

import java.util.Date;

public class PointHistory {

	private long no;
	private String userId;
	private String content;
	private long point;
	private Date createDate;
	
	public PointHistory() {}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "PointHistory [no=" + no + ", userId=" + userId + ", content=" + content + ", point=" + point
				+ ", createDate=" + createDate + "]";
	}
	
	
}
