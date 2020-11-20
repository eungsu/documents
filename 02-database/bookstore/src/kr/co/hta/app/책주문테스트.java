package kr.co.hta.app;

import kr.co.hta.service.OrderService;
import kr.co.hta.util.Keyboard;

public class 책주문테스트 {

	public static void main(String[] args) throws Exception {
		System.out.println("### 책 주문 테스트");
		
		System.out.println("# 사용자아이디, 책번호, 구매수량을 입력하세요");
		
		System.out.print("사용자 아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		System.out.print("책번호 입력 > ");
		int bookNo = Keyboard.nextInt();
		
		System.out.print("구매수량 입력 > ");
		int amount = Keyboard.nextInt();
		
		OrderService orderService = OrderService.getInstance();
		orderService.insertOneOrder(userId, bookNo, amount);
		
		System.out.println("## 책 주문이 완료되었습니다.");
	}
}
