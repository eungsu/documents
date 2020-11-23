package kr.co.hta.controller;

import java.sql.SQLException;

import kr.co.hta.exception.BookStoreException;
import kr.co.hta.service.UserService;
import kr.co.hta.util.Keyboard;

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
				System.out.println("[예외발생 : 데이터베이스 예외] " + e.getMessage());
			} catch (BookStoreException e) {
				System.out.println("[예외발생 : 업무로직 예외] " + e.getMessage());
			} catch (Exception e) {
				System.out.println("[예외발생 : 알 수 없는 예외] " + e.getMessage());
			}
		}
	}
	
	private void addNewUser() throws SQLException {
		
	}
	
	private void viewMyInfo() throws SQLException {
		
	}
	
	private void changeMyPassword() throws SQLException {
		
	}
	
	private void viewMyPointHistory() throws SQLException {
		
	}
}
