package kr.co.hta.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.dao.UserDao;
import kr.co.hta.exception.InvalidPasswordException;
import kr.co.hta.exception.PasswordMismatchException;
import kr.co.hta.exception.UserAlreadyExistException;
import kr.co.hta.exception.UserNotFoundException;
import kr.co.hta.vo.PointHistory;
import kr.co.hta.vo.User;

/**
 * 사용자 관련 서비스(신규가입, 비밀번호 변경, 내정보 조회, 탈퇴, 포인트변경이력 조회)를 제공한다.
 * @author lee_e
 *
 */
public class UserService {
	
	private UserDao userDao = UserDao.getInstance();
	
	/**
	 * 탈퇴한 사용자
	 */
	public static final String DISABLED_USER_STATUS_YES = "Y";
	/**
	 * 사용중인 사용자
	 */
	public static final String DISABLED_USER_STATUS_NO = "N";

	// 싱글턴 객체로 만들기
	private UserService() {}
	private static UserService userService = new UserService();
	public static UserService getInstance() {
		return userService;
	}
	/**
	 * 신규 가입서비스를 제공한다.
	 * @param user 새 사용자 정보
	 * @throws SQLException
	 */
	public void registerUser(User user) throws SQLException {
		// 동일한 아이디로 가입한 사용자 있는지 확인 --> select * from sample_users where user_id = ?
		// 동일한 이메일 정보로 이미 가입한 사용자가 있는지 확인? --> select * from sample_user where user_email = ?
		// 동일한 아이디, 이메일로 가입한 사용자가 없다 --> 위의 쿼리를 실행했을 때 아무런 정보가 획득되지 않는다.
		// 사용자가 존재하지 않으면 회원정보 저장 --> insert into sample_users () values (?,?,?,?)
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			throw new UserAlreadyExistException("["+user.getId()+"]는 이미 사용중인 아이디입니다.");
		}
		
		savedUser = userDao.getUserByEmail(user.getEmail());
		if (savedUser != null) {
			throw new UserAlreadyExistException("["+user.getEmail()+"]은 다른 사용자가 사용중인 이메일 입니다.");
		}
		
		userDao.insertUser(user);
	}
	
	/**
	 * 지정된 아이디에 대한 사용자정보를 조회한다.
	 * @param userId 사용자 아이디
	 * @return 사용자 정보
	 * @throws SQLException
	 */
	public User getUserInfo(String userId) throws SQLException {
		// 아이디로 사용자 정보 조회하기 --> select * from sample_users where user_id = ?
		User savedUser = userDao.getUserById(userId);
		if (savedUser == null) {
			throw new UserNotFoundException("["+userId+"] 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		}
		
		return savedUser;
	}
	
	/**
	 * 비밀번호를 변경한다.
	 * @param userId 사용자아이디
	 * @param oldPassword 이전 비밀번호
	 * @param newPassword 새 비밀번호
	 * @throws SQLException
	 */
	public void changePassword(String userId, String oldPassword, String newPassword) throws SQLException {
		// 이전 비밀번호와 새 비밀번호가 동일한 경우 예외발생 - InvalidPasswordException
		// 아이디로 사용자 정보 조회 --> select * from sample_users where user_id = ? UserDao에 구현되어 있음
		// 조회된 사용자정보의 비밀번호와 사용자가 입력한 이전 비밀번호가 일치하는지 확인, 일치하지 않으면 예외발생 PasswordMismatchException
		// 위의 모든 과정을 통과했으면  사용자정보의 비빌번호를 변경하기 - update set ......
		if (oldPassword.equals(newPassword)) {
			throw new InvalidPasswordException("이전 비밀번호와 동일한 비밀번호로 변경할 수 없습니다.");
		}
		
		User user = userDao.getUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("["+userId+"] 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		}
		
		if (!user.getPassword().equals(oldPassword)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		
		user.setPassword(newPassword);
		userDao.updateUser(user);
	}
	
	/**
	 * 사용자를 탈퇴처리한다.
	 * @param userId 사용자아이디
	 * @throws SQLException
	 */
	public void disabledUser(String userId, String password) throws SQLException {
		// 아이디로 사용자 정보 조회 -> 사용자정보가 없으면 예외발생
		// 사용자가 이미 탈퇴처리된 사용자라면 예외발생
		// 비밀번호가 일치하지 않으면 예외발생
		// 사용자를 탈퇴처리하기
		User user = userDao.getUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("["+userId+"] 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		}
		
		if (DISABLED_USER_STATUS_YES.equals(user.getDisabled())) {
			throw new UserNotFoundException("["+userId+"] 사용중인 사용자 중에는 아이디에 해당하는 사용자를 찾을 수 없습니다. 이미 탈퇴처리된 사용자입니다.");
		}
		
		if (!user.getPassword().equals(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		
		user.setDisabled(DISABLED_USER_STATUS_YES);
		userDao.updateUser(user);
	}
	
	/**
	 * 포인트 변경이력을 조회한다.
	 * @param userId 사용자아이디
	 * @return 지정된 사용자의 포인트 변경이력 정보
	 * @throws SQLException
	 */
	public List<PointHistory> getMyPointHistories(String userId) throws SQLException {
		return null;
	}
	
}











