package kr.co.hta.controller;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.exception.BookStoreException;
import kr.co.hta.service.BookService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.Book;

public class BookController {

	private BookService bookService = BookService.getInstance();
	
	private static BookController bookController = new BookController();
	private BookController() {
	}
	public static BookController getInstance() {
		return bookController;
	}
	
	public void displayMenu()  {
		while (true) {
			try {
				System.out.println("[책 정보 관리하기]");
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("1.전체조회  2.검색  3.등록  4.가격변경  5.재고변경  0.종료");
				System.out.println("------------------------------------------------------------------------------");
				
				System.out.print("메뉴 선택 > ");
				int menuNo = Keyboard.nextInt();
				
				if (menuNo == 1) {
					displayAllBooks();
				} else if (menuNo == 2) {
					searchBooks();
				} else if (menuNo == 3) {
					insertBook();
				} else if (menuNo == 4) {
					updateBookPrice();
				} else if (menuNo == 4) {
					updateBookStock();
				} else if (menuNo == 0) {
					System.out.println("### 책 정보 관리하기 종료\n\n\n");
					break;
				}
				System.out.println();
				System.out.println();
				
			} catch (SQLException e) {
				System.out.println("[예외발생 : 데이터베이스 예외] " + e.getMessage());
			} catch (BookStoreException e) {
				System.out.println("[예외발생 : 업무로직 예외] " + e.getMessage());
			} catch (Exception e) {
				System.out.println("[예외발생 : 알 수 없는 예외] " + e.getMessage());
			}
		}
	}
	
	private void displayAllBooks() throws SQLException {
		System.out.println("[모든 책 정보 조회");
		
	}
	
	private void searchBooks() throws SQLException {
		System.out.println("[책 정보 검색하기]");
	}
	
	private void insertBook() throws SQLException {
		System.out.println("[신규 책 정보 등록하기]");
	}
	
	private void updateBookPrice() throws SQLException {
		System.out.println("[가격 변경하기]");
	}
	
	private void updateBookStock() throws SQLException {
		System.out.println("[재고 변경하기]");
	}
}
