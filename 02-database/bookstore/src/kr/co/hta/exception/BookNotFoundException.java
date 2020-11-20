package kr.co.hta.exception;

/**
 * 책정보가 존재하지않는 경우 던지는 예외
 * @author lee_e
 *
 */
public class BookNotFoundException extends BookStoreException {

	public BookNotFoundException(String message) {
		super(message);
	}
}
