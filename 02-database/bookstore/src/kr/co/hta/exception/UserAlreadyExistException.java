package kr.co.hta.exception;

/**
 * 사용자가 정보가 이미 존재하는 경우 던지는 예외다.
 * @author lee_e
 *
 */
public class UserAlreadyExistException extends BookStoreException {

	public UserAlreadyExistException(String message) {
		super(message);
	}
}
