package kr.co.hta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC 드라이버를 메모리에 로딩하고, 데이터베이스와 연결된 Connection 객체를 제공하는 클래스다.
 * @author lee_e
 *
 */
public class ConnectionUtil {

	private static final String DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "hta";
	private static final String PASSWORD = "zxcv1234";
	
	static {
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private ConnectionUtil() {}
	
	/**
	 * 데이터베이스와 연결된 Connection을 반환한다.
	 * @return 데이터베이스와 연결된 Connection 객체
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
