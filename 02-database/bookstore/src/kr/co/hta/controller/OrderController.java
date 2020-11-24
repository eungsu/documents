package kr.co.hta.controller;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.exception.BookStoreException;
import kr.co.hta.service.OrderService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.Order;

public class OrderController {

	// 주문서비스를 제공하는 OrderService객체를 획득해서 orderService가 참조 중임
	private OrderService orderService = OrderService.getInstance();
	
	// 싱글턴 객체 제공을 위한 코드
	private static OrderController orderController = new OrderController();
	private OrderController() {
	}
	public static OrderController getInstance() {
		return orderController;
	}
	
	/**
	 * 주문정보 관리하기 메뉴 제공
	 */
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
				System.out.println("[예외발생 : 데이터베이스 예외] " + e.getMessage() + "\n\n\n");
			} catch (BookStoreException e) {
				System.out.println("[예외발생 : 업무로직 예외] " + e.getMessage() + "\n\n\n");
			} catch (Exception e) {
				System.out.println("[예외발생 : 알 수 없는 예외] " + e.getMessage() + "\n\n\n");
			}
		}
	}
	
	private void buyOneBook() throws SQLException {
		System.out.println("[바로 구매하기]");
		System.out.println("### 사용자아이디, 책번호, 구매수량을 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		System.out.print("책번호 입력 > ");
		int bookNo = Keyboard.nextInt();
		System.out.print("구매수량 입력 > ");
		int amount = Keyboard.nextInt();
		
		orderService.insertOneOrder(userId, bookNo, amount);
		System.out.println("### 구매가 완료되었습니다.");
	}
	
	private void viewMyOrders() throws SQLException {
		System.out.println("[주문내역 조회]");
		System.out.println("### 주문자 아이디를 입력하세요");
		
		System.out.print("아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		List<Order> orders = orderService.getMyOrders(userId);
		if (orders.isEmpty()) {
			System.out.println("### 주문내역이 존재하지 않습니다.");
			return;
		}
		
		System.out.println("["+userId+"] 님의 주문내역입니다.");
		System.out.println("------------------------------------------------------------------------------");
		for (Order order : orders) {
			System.out.println("주문번호: " + order.getNo());
			System.out.println("주문상태: " + order.getStatus());
			System.out.println("주문날짜: " + order.getCreateDate());
			System.out.println("------------------------------------------------------------------------------");
			System.out.println();
		}
	}
	
	private void viewOrderInfo() throws SQLException {
		
	}
	
	private void cancelOrder() throws SQLException {
		
	}
}
