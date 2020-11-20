package kr.co.hta.app;

import kr.co.hta.service.UserService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.User;

public class 사용자정보조회테스트 {

	public static void main(String[] args) throws Exception {
		System.out.println("### 사용자정보 조회 테스트");
		
		System.out.println("# 아이디를 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		UserService userService = UserService.getInstance();
		
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
