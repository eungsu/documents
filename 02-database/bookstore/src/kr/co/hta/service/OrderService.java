package kr.co.hta.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.dao.BookDao;
import kr.co.hta.dao.OrderDao;
import kr.co.hta.dao.OrderItemDao;
import kr.co.hta.dao.PointHistoryDao;
import kr.co.hta.dao.UserDao;
import kr.co.hta.exception.BookNotFoundException;
import kr.co.hta.exception.NotEnoughBookStockException;
import kr.co.hta.exception.UserNotFoundException;
import kr.co.hta.vo.Book;
import kr.co.hta.vo.Order;
import kr.co.hta.vo.OrderItem;
import kr.co.hta.vo.PointHistory;
import kr.co.hta.vo.User;

/**
 * 주문관련 서비스(주문하기, 주문내역조회하기, 주문취소하기, 주문상태 조회하기)를 제공하는 클래스다.
 * @author lee_e
 *
 */
public class OrderService {
	
	private BookDao bookDao = BookDao.getInstance();
	private OrderDao orderDao = OrderDao.getInstance();
	private OrderItemDao orderItemDao = OrderItemDao.getInstance();
	private PointHistoryDao pointHistoryDao = PointHistoryDao.getInstance();
	private UserDao userDao = UserDao.getInstance();
	
	// 싱글턴 객체
	private OrderService() {}
	private static OrderService orderService = new OrderService();
	public static OrderService getInstance() {
		return orderService;
	}

	/**
	 * 바로 구매하기
	 * @param userId 주문자 아이디
	 * @param bookNo 책번호
	 * @param amount 주문수량
	 * @throws SQLException
	 */
	public void insertOneOrder(String userId, int bookNo, int amount) throws SQLException {
		// SAMPLE_USERS에서 고객의 정보를 조회 <--- 가입한 사용자가 맞는지, 탈퇴한 사용자는 아닌지 확인
		// SAMPLE_BOOKS에서 책의 정보를 조회 <--- 책번호에 해당하는 책이 존재하는지, 재고가 충분한지 확인
		// SAMPLE_ORDERS에 주문정보 저장(주문번호, 주문자, 주문상태, 주문날짜)
		// SAMPLE_ORDER_ITEMS에 주문상품정보 저장(주문번호, 책번호, 구매수량, 구매가격)
		// SAMPLE_BOOKS의 재고를 구매수량만큼 감소시킨다.
		// SAMPLE_USERS의 포인트를 결재금액의 1%만큼 증가시킨다.
		// SAMPLE_USER_POINT_HISTORIES에 포인트 변경이력 저장(이력번호, 사용자아이디, 내용, 포인트량, 등록일)
		User user = userDao.getUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("["+userId+"] 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		}
		
		if (UserService.DISABLED_USER_STATUS_YES.equals(user.getDisabled())) {
			throw new UserNotFoundException("["+userId+"] 아이디는 이미 탈퇴한 사용자 입니다.");
		}
		
		Book book = bookDao.getBookByNo(bookNo);
		if (book == null) {
			throw new BookNotFoundException("["+bookNo+"] 책번호에 해당하는 책정보를 찾을 수 없습니다.");
		}
		
		if (book.getStock() < amount) {
			throw new NotEnoughBookStockException("["+book.getTitle()+"]의 재고량이 부족합니다.");
		}
		
		long orderNo = orderDao.getNewOrderNo(); // 새 주문번호 획득
		
		Order order = new Order();
		order.setNo(orderNo);
		order.setUserId(userId);
		order.setStatus("결재완료");
		orderDao.insertOrder(order);	// 주문정보 저장
		
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderNo(orderNo);
		orderItem.setBookNo(bookNo);
		orderItem.setPrice(book.getPrice());
		orderItem.setAmount(amount);
		orderItemDao.insertOrderItem(orderItem);	// 주문상품 정보 저장
		
		book.setStock(book.getStock() - amount);
		if (book.getStock() == 0) {
			book.setStatus("재고없음");
		}
		bookDao.updateBook(book);	// 책의 재고 변경
		
		int point = (int) (book.getPrice()*amount*0.01); 
		user.setPoint(user.getPoint() + point);
		userDao.updateUser(user);	// 고객의 포인트 변경
		
		PointHistory pointHistory = new PointHistory();
		pointHistory.setUserId(userId);
		pointHistory.setContent("도서구매");
		pointHistory.setPoint(point);
		pointHistoryDao.insertPointHistory(pointHistory);	// 고객의 포인트 변경이력 저장
		
	}
	
	/**
	 * 내 주문내역 조회하기
	 * @param userId 사용자아이디
	 * @return 해당 사용자가 주문한 모든 주문정보 
	 * @throws SQLException
	 */
	public List<Order> getMyOrders(String userId) throws SQLException {
		User user = userDao.getUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("["+userId+"] 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		}
		
		if (UserService.DISABLED_USER_STATUS_YES.equals(user.getDisabled())) {
			throw new UserNotFoundException("["+userId+"] 아이디는 이미 탈퇴한 사용자 입니다.");
		}
		
		List<Order> orderList = orderDao.getOrdersByUserId(userId);
		
		return orderList;
	}
	
	/**
	 * 주문번호에 해당하는 주문을 취소처리 한다.
	 * @param orderNo 취소할 주문번호
	 * @throws SQLException
	 */
	public void cancelOrder(long orderNo) throws SQLException {
		
	}
	
	/**
	 * 주문번호에 해당하는 상세주문정보를 제공한다.
	 * @param orderNo 주문번호
	 * @return 주문정보
	 * @throws SQLException
	 */
	public Order getOrderDetail(long orderNo) throws SQLException {
		return null;
	}
}




