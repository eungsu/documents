package kr.co.hta.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.dao.BookDao;
import kr.co.hta.exception.BookNotFoundException;
import kr.co.hta.vo.Book;

/**
 * 도서관련 서비스(신규도서 등록, 도서 검색, 도서 가격변경, 도서 수량 변경)를 제공하는 클래스다.
 * @author lee_e
 *
 */
public class BookService {

	// SAMPLE_BOOKS와 관련된 DB Access작업이 구현된 BookDao객체 획득하기
	private BookDao bookDao = BookDao.getInstance();
	
	private static BookService bookService = new BookService();
	private BookService() {}
	public static BookService getInstance() {
		return bookService;
	}
	
	/**
	 * 신규도서 등록 서비스를 제공한다.
	 * @param book 책정보가 저장된 Book객체를 전달받는다.
	 * @throws SQLException
	 */
	public void insertNewBook(Book book) throws SQLException {
		bookDao.insertBook(book);
	}
	
	/**
	 * 등록된 모든 책정보를 제공한다.
	 * @return 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> getAllBooks() throws SQLException {
		return bookDao.getAllBooks();
	}
	
	/**
	 * 제목을 포함하고 있는 모든 책정보를 제공한다.
	 * @param keyword 검색키워드
	 * @return 검색키워드가 제목에 포함된 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> searchBooksByTitle(String keyword) throws SQLException {
		return bookDao.getBooksByTitle(keyword);
	}
	
	/**
	 * 지정된 이름의 저자가 출판한 모든 책정보를 제공한다.
	 * @param writer 작가이름
	 * @return 해당 작가가 출판한 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> searchBooksByWriter(String writer) throws SQLException {
		return bookDao.getBooksByWriter(writer);
	}
	
	/**
	 * 지정된 가격범위에 속하는 가격대의 모든 책 정보를 제공한다.
	 * @param minPrice 최소가격
	 * @param maxPrice 최대가격
	 * @return 가격범위에 속하는 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> searchBooksByPrice(int minPrice, int maxPrice) throws SQLException {
		return bookDao.getBooksByPrice(minPrice, maxPrice);
	}
	
	/**
	 * 책번호에 해당하는 책의 가격을 변경한다.
	 * @param bookNo 책번호
	 * @param price 책의 새로운 가격
	 * @throws SQLException
	 */
	public void changeBookPrice(int bookNo, int price) throws SQLException {
		Book book = bookDao.getBookByNo(bookNo);
		if (book == null) {
			throw new BookNotFoundException("[" + bookNo + "] 번호의 책정보가 없습니다.");
		}
		book.setPrice(price);
		bookDao.updateBook(book);
	}
	
	/**
	 * 책번호에 해당하는 책의 재고를 증가시킨다.
	 * @param bookNo 책번호
	 * @param amount 증가량
	 * @throws SQLException
	 */
	public void increaseBookStock(int bookNo, int amount) throws SQLException {
		Book book = bookDao.getBookByNo(bookNo);
		if (book == null) {
			throw new BookNotFoundException("[" + bookNo + "] 번호의 책정보가 없습니다.");
		}
		book.setStock(book.getStock() + amount);
		bookDao.updateBook(book);
	}
	
	/**
	 * 책번호에 해당하는 책의 재고를 감소시킨다.
	 * @param bookNo 책번호
	 * @param amount 감소량
	 * @throws SQLException
	 */
	public void decreaseBookStock(int bookNo, int amount) throws SQLException {
		Book book = bookDao.getBookByNo(bookNo);
		if (book == null) {
			throw new BookNotFoundException("[" + bookNo + "] 번호의 책정보가 없습니다.");
		}
		book.setStock(book.getStock() - amount);
		if (book.getStock() == 0) {
			book.setStatus("재고없음");
		}
		bookDao.updateBook(book);
	}
}
