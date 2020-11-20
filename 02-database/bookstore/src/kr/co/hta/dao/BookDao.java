package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.Book;

public class BookDao {
	private static final String INSERT_BOOK_SQL = "INSERT INTO SAMPLE_BOOKS(BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_GENRE, BOOK_PRICE) VALUES (SAMPLE_BOOK_SEQ.NEXTVAL, ?, ?, ?, ?)";
	private static final String GET_ALL_BOOKS_SQL = "SELECT * FROM SAMPLE_BOOKS ORDER BY BOOK_NO DESC";
	private static final String GET_BOOK_BY_NO_SQL = "SELECT * FROM SAMPLE_BOOKS WHERE BOOK_NO = ?";
	private static final String UPDATE_BOOK_SQL = "UPDATE SAMPLE_BOOKS SET BOOK_TITLE = ?, BOOK_WRITER = ?, BOOK_GENRE = ?, BOOK_PRICE = ?, BOOK_STOCK = ?, BOOK_STATUS = ? WHERE BOOK_NO = ?";

	// 싱글턴 객체로 만들기(생성자 은닉화, 정적변수에 객체 담기, 객체를 제공하는 정적메소드 정의하기)
	private BookDao() {}
	private static BookDao bookDao = new BookDao();
	public static BookDao getInstance() {
		return bookDao;
	}
	
	public void insertBook(Book book) throws SQLException {

	}

	public List<Book> getAllBooks() throws SQLException {
		List<Book> bookList = new ArrayList<Book>();

		return bookList;
	}

	/**
	 * 책번호에 해당하는 책정보를 조회한다.
	 * @param bookNo 책번호
	 * @return 책정보, null이 반환될 수 도 있음
	 * @throws SQLException
	 */
	public Book getBookByNo(int bookNo) throws SQLException {
		Book book = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_BOOK_BY_NO_SQL);
		pstmt.setInt(1, bookNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setGenre(rs.getString("book_genre"));
			book.setPrice(rs.getInt("book_price"));
			book.setStock(rs.getInt("book_stock"));
			book.setStatus(rs.getString("book_status"));
			book.setCreateDate(rs.getDate("book_create_date"));
		}

		rs.close();
		pstmt.close();
		con.close();
		
		return book;
	}

	/**
	 * 책 정보를 변경한다.
	 * @param book 변경할 책정보
	 * @throws SQLException
	 */
	public void updateBook(Book book) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UPDATE_BOOK_SQL);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setInt(4, book.getPrice());
		pstmt.setInt(5, book.getStock());
		pstmt.setString(6, book.getStatus());
		pstmt.setInt(7, book.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}















