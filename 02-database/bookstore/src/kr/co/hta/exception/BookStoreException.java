package kr.co.hta.exception;

/**
 * BookStore 프로젝트의 최상위 예외 클래스다.
 * @author lee_e
 *
 */
public class BookStoreException extends RuntimeException {

	public BookStoreException(String message) {
		super(message);
	}
}
