package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.User;

/**
 * SAMPLE_USERS 테이블에 대한 CRUD(Create, Read, Update, Delete) 작업을 지원하는 클래스다.
 * @author lee_e
 *
 */
public class UserDao {
	private static final String INSERT_USER_SQL = "INSERT INTO SAMPLE_USERS (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES(?, ?, ?, ?)";
	private static final String GET_USER_BY_ID_SQL = "SELECT * FROM SAMPLE_USERS WHERE USER_ID = ?";
	private static final String GET_USER_BY_EMAIL_SQL = "SELECT * FROM SAMPLE_USERS WHERE USER_EMAIL = ?";
	private static final String UPDATE_USER_SQL = "UPDATE SAMPLE_USERS SET USER_NAME = ?, USER_PASSWORD = ?, USER_EMAIL = ?, USER_POINT = ?, USER_DISABLED = ? WHERE USER_ID = ?";

	private UserDao() {}
	private static UserDao userDao = new UserDao();
	public static UserDao getInstance() {
		return userDao;
	}
	
	/**
	 * 전달받은 사용자 정보를 데이터베이스에 저장한다.
	 * @param user 신규 사용자 정보
	 * @throws SQLException
	 */
	public void insertUser(User user) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_USER_SQL);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	/**
	 * 지정된 아이디에 대한 사용자정보를 데이터베이스에서 조회한다.
	 * @param userId 사용자 아이디
	 * @return 사용자 정보, 아이디에 대한 사용자정보가 존재하지 않는 경우 null이 반환됨
	 * @throws SQLException
	 */
	public User getUserById(String userId) throws SQLException {
		User user = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_USER_BY_ID_SQL);
		pstmt.setString(1, userId);
			
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			user = new User();
			
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getLong("user_point"));
			user.setDisabled(rs.getString("user_disabled"));
			user.setCreateDate(rs.getDate("user_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}
	
	/**
	 * 지정된 이메일에 대한 사용자정보를 데이터베이스에서 조회한다.
	 * @param email 사용자 이메일
	 * @return 이메일로 조회한 사용자 정보, 
	 * @throws SQLException
	 */
	public User getUserByEmail(String email) throws SQLException {
		User user = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_USER_BY_EMAIL_SQL);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			user = new User();
			
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getLong("user_point"));
			user.setDisabled(rs.getString("user_disabled"));
			user.setCreateDate(rs.getDate("user_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();		
		
		return user;
	}

	/**
	 * 전달받은 사용자정보로 데이터베이스의 사용자정보를 갱신한다.
	 * @param user 변경할 사용자 정보를 포함하고 있는 User객체
	 * @throws SQLException
	 */
	public void updateUser(User user) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UPDATE_USER_SQL);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setLong(4, user.getPoint());
		pstmt.setString(5, user.getDisabled());
		pstmt.setString(6, user.getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}








