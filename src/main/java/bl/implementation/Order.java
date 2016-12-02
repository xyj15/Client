package bl.implementation;

import bl.service.OrderBLService;
import data.service.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;

public class Order implements OrderBLService {
	
	private ArrayList<OrderPO> orderList;
	private OrderDataService orderDataService;
	private String userID;
	
	public Order(String userID) {
		this.userID = userID;
		orderList = orderDataService.getOrderList(userID);
	}
	
	@Override
	public ArrayList<OrderVO> getOrderList() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getExcutedOrders() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getUnexcutedOrders() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getAbnormalOrders() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getCanceledOrders() {
		return null;
	}
	
	@Override
	public boolean cancelOrder(String orderID) {
		return false;
	}
	
	@Override
	public boolean evaluateOrder(double score, String comment) {
		return false;
	}
	
	@Override
	public boolean cancelAbnormalOrder(String orderID, double recover) {
		return false;
	}
}

//	@Override
//	public ArrayList<OrderVO> getOrderList() {
//		orderList = orderDataService.getOrderList(userID);
//
//		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
//		OrderPO orderPO;
//		OrderVO orderVO;
//		for (int i = 0; i < orderList.size(); i++) {
//			orderPO = orderList.get(i);
//			String memberID = orderPO.getMemberID();
//			String hotelID = orderPO.getHotelID();
//			String orderID = orderPO.getOrderID();
//			OrderStatus orderStatus = orderPO.getOrderStatus();
//			Date createTime = orderPO.getCreateTime();
//			Date checkinTime = orderPO.getCheckinTime();
//			Date actualCheckinTime = orderPO.getActualCheckinTime();
//			Date latestCheckinTime = orderPO.getLatestCheckinTime();
//			Date checkoutTime = orderPO.getCheckoutTime();
//			Date actualCheckoutTime = orderPO.getActualCheckoutTime();
//			int numberOfRoom = orderPO.getNumberOfRoom();
//			String roomName = orderPO.getRoomName();
//			int numberOfClient = orderPO.getNumberOfClient();
//			boolean haveKids = orderPO.getHaveKids();
//			double score = orderPO.getScore();
//			String evaluation = orderPO.getEvaluation();
//			double recover = orderPO.getRecover();
//			String promotionID = orderPO.getPromotionID();
//			double price = orderPO.getPrice();
//			orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
//					checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime,
//					actualCheckoutTime, numberOfRoom, roomName, numberOfClient, haveKids,
//					score, evaluation, recover, promotionID, price);
//			orderVOList.add(orderVO);
//		}
//		return orderVOList;
//	}