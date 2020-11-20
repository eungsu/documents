package kr.co.hta.app;

import kr.co.hta.service.UserService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.User;

public class 신규회원가입테스트 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("### 신규회원가입 테스트 ");
		
		System.out.println("# 신규 회원정보를 입력하세요.");
		System.out.print("아이디 입력 > ");
		String id = Keyboard.nextString();
		
		System.out.print("이름 입력 > ");
		String name = Keyboard.nextString();
		
		System.out.print("비밀번호 입력 > ");
		String password = Keyboard.nextString();
		
		System.out.print("이메일 입력 > ");
		String email = Keyboard.nextString();
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		
		UserService userService = UserService.getInstance();
		userService.registerUser(user);
		
		System.out.println("### 신규회원 가입이 완료되었습니다.");
		
	}
}
