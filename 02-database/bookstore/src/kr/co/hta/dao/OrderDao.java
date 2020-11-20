package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.Order;

public class OrderDao {
	private static final String GET_NEW_ORDER_NO_SQL = "SELECT SAMPLE_ORDER_SEQ.NEXTVAL AS ORDERNO FROM DUAL";
	private static final String INSERT_ORDER_SQL = "INSERT INTO SAMPLE_ORDERS (ORDER_NO, USER_ID, ORDER_STATUS) VALUES (?, ?, ?)";
	private static final String GET_ORDERS_BY_USER_ID_SQL = "SELECT * FROM SAMPLE_ORDERS WHERE USER_ID = ?";
	private static final String GET_ORDER_BY_NO_SQL = "SELECT * FROM SAMPLE_ORDERS WHERE ORDER_NO = ?";
	private static final String UPDATE_ORDER_SQL = "UPDATE SAMPLE_ORDERS SET ORDER_STATUS = ? WHERE ORDER_NO = ?";

	private OrderDao() {}
	private static OrderDao orderDao = new OrderDao();
	public static OrderDao getInstance() {
		return orderDao;
	}
	
	/**
	 * 새로운 주문번호를 조회한다.
	 * @return 새 주문번호
	 * @throws SQLException
	 */
	public long getNewOrderNo() throws SQLException {
		long orderNo = 0;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_NEW_ORDER_NO_SQL);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			orderNo = rs.getLong("orderno");
		}
		
		rs.close();
		pstmt.close();
		con.close();

		return orderNo;
	}

	/**
	 * 주문정보를 저장한다.
	 * @param order 새 주문정보
	 * @throws SQLException
	 */
	public void insertOrder(Order order) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER_SQL);
		pstmt.setLong(1, order.getNo());
		pstmt.setString(2, order.getUserId());
		pstmt.setString(3, order.getStatus());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public List<Order> getOrdersByUserId(String userId) throws SQLException {
		List<Order> orderList = new ArrayList<Order>();

		return orderList;
	}

	public Order getOrderByNo(long orderNo) throws SQLException {
		Order order = null;

		return order;
	}

	public void updateOrder(Order  order) throws SQLException {

	}
}