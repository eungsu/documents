package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.Order;
import kr.co.hta.vo.OrderItem;

public class OrderItemDao {
	private static final String INSERT_ORDER_ITEM_SQL = "INSERT INTO SAMPLE_ORDER_ITEMS (ORDER_NO, BOOK_NO, ORDER_PRICE, ORDER_AMOUNT) VALUES (?, ?, ?, ?)";
	private static final String GET_ORDER_ITEMS_BY_ORDER_NO_SQL ="SELECT * FROM SAMPLE_ORDER_ITEMS WHERE ORDER_NO = ?";

	private OrderItemDao() {}
	private static OrderItemDao orderItemDao = new OrderItemDao();
	public static OrderItemDao getInstance() {
		return orderItemDao;
	}
	
	/**
	 * 주문 상품정보를 저장한다.
	 * @param orderItem
	 * @throws SQLException
	 */
	public void insertOrderItem(OrderItem orderItem) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER_ITEM_SQL);
		pstmt.setLong(1, orderItem.getOrderNo());
		pstmt.setInt(2, orderItem.getBookNo());
		pstmt.setInt(3, orderItem.getPrice());
		pstmt.setInt(4, orderItem.getAmount());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public List<OrderItem> getOrderItemsByOrderNo(long orderNo) throws SQLException {
		List<OrderItem> orderList = new ArrayList<OrderItem>();

		return orderList;
	}
}
