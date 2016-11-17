package bl.implementation;

import java.util.ArrayList;
import java.util.List;

import vo.OrderVO;

public class Order {
	
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
    
    public List<OrderVO> getOrderList() {
		return orderList;
    }
    
}
