package kr.co.hta.app;

import kr.co.hta.controller.BookController;
import kr.co.hta.controller.OrderController;
import kr.co.hta.controller.UserController;
import kr.co.hta.util.Keyboard;

public class StoreApp {

	public static void main(String[] args) {
		
		BookController bookController = BookController.getInstance();
		UserController userController = UserController.getInstance();
		OrderController orderController = OrderController.getInstance();
		
		while (true) {
			System.out.println("[도서 매장 메뉴]");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("1.책정보관리  2.사용자관리 3.주문정보관리 0.종료");
			System.out.println("------------------------------------------------------------------------------");
			
			System.out.print("메뉴 선택 > ");
			int menuNo = Keyboard.nextInt();
			
			if (menuNo == 1) {
				bookController.displayMenu();
			} else if (menuNo == 2) {
				userController.displayMenu();
			} else if (menuNo == 3) {
				orderController.displayMenu();
			} else if (menuNo == 0) {
				System.out.println("[도서 매장 프로그램 종료]");
				break;
			}
		}
		
	}
}
