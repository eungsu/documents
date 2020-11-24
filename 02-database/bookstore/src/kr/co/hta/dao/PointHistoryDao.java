package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.PointHistory;

public class PointHistoryDao {
	private static final String INSERT_POINT_HISTORY_SQL = "INSERT INTO SAMPLE_USER_POINT_HISTORIES (HISTORY_NO, USER_ID, HISTORY_CONTENT, HISTORY_POINT) VALUES(SAMPLE_POINT_HISTORY_SEQ.NEXTVAL, ?, ?, ?)";
	private static final String GET_POINT_HISTORIES_BY_USER_ID_SQL = "SELECT * FROM SAMPLE_USER_POINT_HISTORIES WHERE USER_ID = ? ORDER BY HISTORY_NO DESC";

	private PointHistoryDao() {}
	private static PointHistoryDao pointHistoryDao = new PointHistoryDao();
	public static PointHistoryDao getInstance() {
		return pointHistoryDao;
	}
	
	/** 
	 * 포인트 변경이력을 저장한다.
	 * @param pointHistory
	 * @throws SQLException
	 */
	public void insertPointHistory(PointHistory pointHistory) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_POINT_HISTORY_SQL);
		pstmt.setString(1, pointHistory.getUserId());
		pstmt.setString(2, pointHistory.getContent());
		pstmt.setLong(3, pointHistory.getPoint());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public List<PointHistory> getPointHistoriesByUserId(String userId) throws SQLException {
		List<PointHistory> pointHistoryList = new ArrayList<PointHistory>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_POINT_HISTORIES_BY_USER_ID_SQL);
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PointHistory history = new PointHistory();
			history.setNo(rs.getLong("history_no"));
			history.setUserId(rs.getString("user_id"));
			history.setContent(rs.getString("history_content"));
			history.setPoint(rs.getLong("history_point"));
			history.setCreateDate(rs.getDate("history_create_date"));
			
			pointHistoryList.add(history);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return pointHistoryList;
	}
}	








