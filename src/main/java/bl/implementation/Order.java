package bl.implementation;

import bl.dataservice.OrderDataService;
import bl.service.OrderBLService;
import other.User;
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
		orderList = orderDataService.getOrderList(userID);
		
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		OrderPO orderPO;
		OrderVO orderVO;
		for(int i=0; i<orderList.size(); i++) {
			orderPO = orderList.get(i);
			
		}
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
