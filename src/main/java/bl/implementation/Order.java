package bl.implementation;

import bl.dataservice.OrderDataService;
import bl.service.OrderBLService;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;

public class Order implements OrderBLService {

	private ArrayList<OrderVO> orderVOList;
	private ArrayList<OrderPO> orderPOList;
	private OrderDataService orderDataService;
	
	public Order() {
		
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
