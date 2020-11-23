package kr.co.hta.controller;

import java.sql.SQLException;

import kr.co.hta.exception.BookStoreException;
import kr.co.hta.service.OrderService;
import kr.co.hta.util.Keyboard;

public class OrderController {

	private OrderService orderService = OrderService.getInstance();
	
	private static OrderController orderController = new OrderController();
	private OrderController() {
	}
	public static OrderController getInstance() {
		return orderController;
	}
	
	public void displayMenu() {
		while (true) {
			try {
				System.out.println("[주문 정보 관리하기]");
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("1.바로구매  2.주문내역 조회 3.주문상세조회  4.주문취소  0.종료");
				System.out.println("------------------------------------------------------------------------------");
				
				System.out.print("메뉴 선택 > ");
				int menuNo = Keyboard.nextInt();
				
				if (menuNo == 1) {
					buyOneBook();
				} else if (menuNo == 2) {
					viewMyOrders();
				} else if (menuNo == 3) {
					viewOrderInfo();
				} else if (menuNo == 4) {
					cancelOrder();
				} else if (menuNo == 0) {
					System.out.println("### 주문정보 관리하기 종료\n\n\n");
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
	
	private void buyOneBook() throws SQLException {
		
	}
	
	private void viewMyOrders() throws SQLException {
		
	}
	
	private void viewOrderInfo() throws SQLException {
		
	}
	
	private void cancelOrder() throws SQLException {
		
	}
}
