package kr.co.hta.exception;

/**
 * 사용자정보를 찾을 수 없을 때 던지는 예외다.
 * @author lee_e
 *
 */
public class UserNotFoundException extends BookStoreException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
