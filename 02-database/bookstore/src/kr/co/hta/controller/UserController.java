package kr.co.hta.controller;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.exception.BookStoreException;
import kr.co.hta.service.UserService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.PointHistory;
import kr.co.hta.vo.User;

public class UserController {

	private UserService userService = UserService.getInstance();
	
	private static UserController userController = new UserController();
	private UserController() {
	}
	public static UserController getInstance() {
		return userController;
	}
	
	public void displayMenu() {
		while (true) {
			try {
				System.out.println("[사용자 정보 관리하기]");
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("1.신규가입  2.내정보보기  3.비밀번호변경  4.포인트내역보기  0.종료");
				System.out.println("------------------------------------------------------------------------------");
				
				System.out.print("메뉴 선택 > ");
				int menuNo = Keyboard.nextInt();
				
				if (menuNo == 1) {
					addNewUser();
				} else if (menuNo == 2) {
					viewMyInfo();
				} else if (menuNo == 3) {
					changeMyPassword();
				} else if (menuNo == 4) {
					viewMyPointHistory();
				} else if (menuNo == 0) {
					System.out.println("## 사용자 정보 관리 종료\n\n\n");
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
	
	private void addNewUser() throws SQLException {
		System.out.println("[신규 가입]");
		
		System.out.println("아이디, 이름, 비밀번호, 이메일을 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		System.out.print("이름 입력 > ");
		String name = Keyboard.nextString();
		System.out.print("비밀번호 입력 > ");
		String password = Keyboard.nextString();
		System.out.print("이메일 입력 > ");
		String email = Keyboard.nextString();
		
		User user = new User();
		user.setId(userId);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		
		userService.registerUser(user);
		System.out.println("### 사용자 등록이 완료되었습니다.");
	}
	
	private void viewMyInfo() throws SQLException {
		System.out.println("[내정보 보기]");
		
		System.out.println("### 아이디를 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		User user = userService.getUserInfo(userId);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("아 이 디: " + user.getId());
		System.out.println("이     름: " + user.getName());
		System.out.println("비밀번호: " + user.getPassword());
		System.out.println("이 메 일: " + user.getEmail());
		System.out.println("포 인 트: " + user.getPoint());
		System.out.println("탈퇴여부: " + user.getDisabled());
		System.out.println("가 입 일: " + user.getCreateDate());
		System.out.println("------------------------------------------------------------------------------");
	}
	
	private void changeMyPassword() throws SQLException {
		System.out.println("[비밀번호 변경하기]");
		
		System.out.println("### 아이디, 이전 비밀번호, 새 비밀번호를 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		System.out.print("이전 비밀번호 입력 > ");
		String oldPassword = Keyboard.nextString();
		System.out.print("새 비밀번호 입력 > ");
		String newPassword = Keyboard.nextString();
		
		userService.changePassword(userId, oldPassword, newPassword);
		System.out.println("### 비밀번호 변경이 완료되었습니다.");
	}
	
	private void viewMyPointHistory() throws SQLException {
		System.out.println("[포인트 변경이력 조회]");
		
		System.out.println("### 아이디를 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		List<PointHistory> pointHistories = userService.getMyPointHistories(userId);
		if (pointHistories.isEmpty()) {
			System.out.println("### 포인트 변경이력이 존재하지 않습니다.");
			return;
		}
		
		System.out.println("------------------------------------------------------------------------------");
		for (PointHistory history : pointHistories) {
			System.out.println(history.getCreateDate() + "\t" + history.getPoint() + "\t" + history.getContent());
		}
		System.out.println("------------------------------------------------------------------------------");
	}
}
