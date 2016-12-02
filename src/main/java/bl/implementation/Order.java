package bl.implementation;

import data.service.OrderDataService;
import bl.service.OrderBLService;
import other.OrderStatus;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

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
		orderList = orderDataService.getOrderList(userID);
		
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		OrderPO orderPO;
		OrderVO orderVO;
		for(int i=0; i<orderList.size(); i++) {
			orderPO = orderList.get(i);
			String memberID = orderPO.getMemberID();
			String hotelID = orderPO.getHotelID();
			String orderID = orderPO.getOrderID();
			OrderStatus orderStatus = orderPO.getOrderStatus();
			Date createTime = orderPO.getCreateTime();
			Date checkinTime = orderPO.getCheckinTime();
			Date actualCheckinTime = orderPO.getActualCheckinTime();
			Date latestCheckinTime = orderPO.getLatestCheckinTime();
			Date checkoutTime = orderPO.getCheckoutTime();
			Date actualCheckoutTime = orderPO.getActualCheckoutTime();
			int numberOfRoom = orderPO.getNumberOfRoom();
			String roomName = orderPO.getRoomName();
			int numberOfClient = orderPO.getNumberOfClient();
			boolean hasKids = orderPO.getHaveKids();
			double score = orderPO.getScore();
			String evaluation = orderPO.getEvaluation();
			double recover = orderPO.getRecover();
			String promotionID = orderPO.getPromotionID();
			double price = orderPO.getPrice();
			orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
					checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime,
					actualCheckoutTime, numberOfRoom, roomName, numberOfClient, hasKids,
					score, evaluation, recover, promotionID, price);
			orderVOList.add(orderVO);
		}
		return orderVOList;
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
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

//	public OrderVO getOrder(String orderID) {
//		for(int i=0; i<orderList.size(); i++) {
//			if(orderList.get(i).getOrderID().equals(orderID)){
//				return orderList.get(i);
//			}
//		}
//		return null;
//	}
//
//    public boolean addOrder(OrderVO order) {
//    	orderList.add(order);
//		return true;
//	}
//
//    public boolean cancelOrder(String orderID) {
//    	for(int i=0; i<orderList.size(); i++) {
//			if(orderList.get(i).getOrderID().equals(orderID)){
//				orderList.get(i).setState(4);
//				return true;
//			}
//    	}
//    	return false;
//	}
    
//    public boolean abnormalOrder(String orderID) {
//    	for(int i=0; i<orderList.size(); i++) {
//			if(orderList.get(i).getOrderID().equals(orderID)){
//				orderList.get(i).setState(3);
//				return true;
//			}
//    	}
//    	return false;
//	}
//
//    public boolean cancelAbnormalOrder(String orderID) {
//    	for(int i=0; i<orderList.size(); i++) {
//			if(orderList.get(i).getOrderID().equals(orderID)){
//				orderList.get(i).setState(4);
//				return true;
//			}
//    	}
//    	return false;
//	}
//
//    public ArrayList<OrderVO> getOrderList() {
//		return orderList;
//    }
    
}
