package kr.co.hta.app;

import kr.co.hta.service.UserService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.User;

public class 탈퇴처리테스트 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("### 사용자 탈퇴처리");
		
		System.out.println("# 아이디와 비밀번호를 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		System.out.print("비밀번호 입력 > ");
		String password = Keyboard.nextString();
		
		UserService userService = UserService.getInstance();
		userService.disabledUser(userId, password);
		
		User user = userService.getUserInfo(userId);
		System.out.println("### 사용자 정보 ###");
		System.out.println("아 이 디: " + user.getId());
		System.out.println("이     름: " + user.getName());
		System.out.println("비밀번호: " + user.getPassword());
		System.out.println("이 메 일: " + user.getEmail());
		System.out.println("포 인 트: " + user.getPoint());
		System.out.println("탈퇴여부: " + user.getDisabled());
		System.out.println("가 입 일: " + user.getCreateDate());
	}
}
