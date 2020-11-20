package kr.co.hta.exception;

/**
 * 비밀번호가 일치하지 않는 경우 던지는 예외
 * @author lee_e
 *
 */
public class PasswordMismatchException extends BookStoreException {

	public PasswordMismatchException(String message) {
		super(message);
	}
}
