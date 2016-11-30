package bl.implementation;

import bl.dataservice.OrderDataService;
import bl.service.OrderBLService;
import other.User;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;

public class Order implements OrderBLService {

	private ArrayList<OrderVO> orderVOList;
	private ArrayList<OrderPO> orderPOList;
	private OrderDataService orderDataService;
	private User user;
	
	public Order(User user) {
		this.user = user;
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
