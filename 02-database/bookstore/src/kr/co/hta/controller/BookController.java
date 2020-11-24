package kr.co.hta.controller;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.exception.BookStoreException;
import kr.co.hta.service.BookService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.Book;

public class BookController {

	// 책관련 업무로직이 구현된 BookService객체를 획득해서 bookService 변수에 저장함
	private BookService bookService = BookService.getInstance();
	
	// 싱글턴 객체 제공을 위한 코드
	private static BookController bookController = new BookController();
	private BookController() {
	}
	public static BookController getInstance() {
		return bookController;
	}
	
	/**
	 * 책정보 관리 메뉴를 제공한다.
	 */
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
				} else if (menuNo == 5) {
					updateBookStock();
				} else if (menuNo == 0) {
					System.out.println("### 책 정보 관리하기 종료\n\n\n");
					break;
				}
				System.out.println();
				System.out.println();
				
			} catch (SQLException e) {
				System.out.println("[예외발생 : 데이터베이스 예외] " + e.getMessage() + "\n\n\n");
			} catch (BookStoreException e) {
				System.out.println("[예외발생 : 업무로직 예외] " + e.getMessage() + "\n\n\n");
			} catch (Exception e) {
				System.out.println("[예외발생 : 알 수 없는 예외] " + e.getMessage() + "\n\n\n");
			}
		}
	}
	
	private void displayAllBooks() throws SQLException {
		System.out.println("[모든 책 정보 조회]");
		
		List<Book> books = bookService.getAllBooks();
		viewBooks(books);
	}
	
	private void searchBooks() throws SQLException {
		System.out.println("[책 정보 검색하기]");
		
		System.out.println("### 검색옵션과 값을 입력하세요");
		System.out.print("검색옵션 입력(t, w, p) 입력 > ");
		
		String opt = Keyboard.nextString();
		if ("t".equals(opt)) {
			System.out.print("제목 입력 > ");
			String keyword = Keyboard.nextString();
			viewBooks(bookService.searchBooksByTitle(keyword));
			
		} else if ("w".equals(opt)) {
			System.out.print("저자명 입력 > ");
			String name = Keyboard.nextString();
			viewBooks(bookService.searchBooksByWriter(name));
			
		} else if ("p".equals(opt)) {
			System.out.print("최소가격 입력 > ");
			int minPrice = Keyboard.nextInt();
			System.out.print("최대가격 입력 > ");
			int maxPrice = Keyboard.nextInt();
			viewBooks(bookService.searchBooksByPrice(minPrice, maxPrice));
			
		} else {
			System.out.println("### 유효한 검색옵션이 아닙니다.");
		}
	}
	
	private void insertBook() throws SQLException {
		System.out.println("[신규 책 정보 등록하기]");
		
		System.out.println("### 제목, 저자, 쟝르, 가격을 입력하세요");
		System.out.print("제목 입력 > ");
		String title = Keyboard.nextString();
		System.out.print("저자 입력 > ");
		String writer = Keyboard.nextString();
		System.out.print("쟝르 입력 > ");
		String genre = Keyboard.nextString();
		System.out.print("가격 입력 > ");
		int price = Keyboard.nextInt();
		
		Book book = new Book();
		book.setTitle(title);
		book.setWriter(writer);
		book.setGenre(genre);
		book.setPrice(price);
		
		bookService.insertNewBook(book);
		System.out.println("### 책 등록이 완료되었습니다.");
		
	}
	
	private void updateBookPrice() throws SQLException {
		System.out.println("[가격 변경하기]");
		
		System.out.println("### 책번호, 가격을 입력하세요.");
		
		System.out.print("책번호 입력 > ");
		int bookNo = Keyboard.nextInt();
		System.out.print("가격 입력 > ");
		int price = Keyboard.nextInt();
		
		bookService.changeBookPrice(bookNo, price);
		System.out.println("### 가격 변경이 완료되었습니다.");
	}
	
	private void updateBookStock() throws SQLException {
		System.out.println("[재고 변경하기]");
		
		System.out.println("### 책번호, 입고량을 입력하세요");
		
		System.out.print("책번호 입력 > ");
		int bookNo = Keyboard.nextInt();
		System.out.print("입고량 입력 > ");
		int amount = Keyboard.nextInt();
		
		bookService.increaseBookStock(bookNo, amount);
		System.out.println("### 재고량 변경이 완료되었습니다.");
		
	}
	
	private void viewBooks(List<Book> books) {
		if (books.isEmpty()) {
			System.out.println("### 조회된 책정보가 없습니다.");
			return;
		}

		System.out.println("------------------------------------------------------------------------------");
		for (Book book : books) {
			System.out.println("번호: " + book.getNo());
			System.out.println("제목: " + book.getTitle());
			System.out.println("저자: " + book.getWriter());
			System.out.println("쟝르: " + book.getGenre());
			System.out.println("가격: " + book.getPrice());
			System.out.println("재고: " + book.getStock());
			System.out.println("상태: " + book.getStatus());
			System.out.println("------------------------------------------------------------------------------");
		}
		System.out.println();
	}
}
