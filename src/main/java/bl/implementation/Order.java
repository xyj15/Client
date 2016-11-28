package bl.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.OrderVO;

public class Order {

	private String orderID; 				//订单编号
	private Date createTime; 				//订单创建时间
	private Date checkinTime; 				//	预计入住时间
	private Date actualCheckinTime;			// 实际入住时间
	private Date latestCheckinTime; 		//最晚入住时间
	private Date checkoutTime; 				//预计退房时间
	private Date actualCheckoutTime; 		//实际退房时间
	private ArrayList<Room> roomList; 		//订单中房间类型及数量
	private int numberOfClient; 			//预计入住人数
	private boolean children; 				//有无儿童
	private double score; 					//订单评分
	private String evaluation; 				//订单评价
	
	public ArrayList<OrderVO> orderList;
	public Order(){
		orderList = new ArrayList<OrderVO>();
	}
	
	public OrderVO getOrder(String orderID) {
		for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderID().equals(orderID)){
				return orderList.get(i);
			}
		}
		return null;
	}
	
    public boolean addOrder(OrderVO order) {
    	orderList.add(order);
		return true;
	}
    
    public boolean cancelOrder(String orderID) {
    	for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderID().equals(orderID)){
				orderList.get(i).setState(4);
				return true;
			}
    	}
    	return false;
	}
    
    public boolean abnormalOrder(String orderID) {
    	for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderID().equals(orderID)){
				orderList.get(i).setState(3);
				return true;
			}
    	}
    	return false;
	}
    
    public boolean cancelAbnormalOrder(String orderID) {
    	for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderID().equals(orderID)){
				orderList.get(i).setState(4);
				return true;
			}
    	}
    	return false;
	}
    
    public ArrayList<OrderVO> getOrderList() {
		return orderList;
    }
    
}
