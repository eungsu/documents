package kr.co.hta.exception;

/**
 * 유효한 비밀번호가 아닌 경우 던지는 예외
 * @author lee_e
 *
 */
public class InvalidPasswordException extends BookStoreException {

	public InvalidPasswordException(String message) {
		super(message);
	}
}
