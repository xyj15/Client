package data.stub;

import data.service.OrderDataService;
import other.OrderStatus;
import po.OrderPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class OrderDataStub implements OrderDataService {
	
	private ArrayList<OrderPO> orderList;
	
	public OrderDataStub() {
		orderList = new ArrayList<>();
		
		OrderPO orderPO1 = new OrderPO("00000000", "000000", "000", OrderStatus.Executed, new Date(),
				new Date(), new Date(), new Date(), new Date(), new Date(), 1, "大床房", 2, false, 5,
				"敲棒～～～", 0, "00000", 500, null);
		orderList.add(orderPO1);
		
		OrderPO orderPO2 = new OrderPO("00000000", "000001", "001", OrderStatus.Abnormal, new Date(),
				new Date(), new Date(), new Date(), new Date(), new Date(), 1, "大床房", 2, false, 0,
				null, 0, "00000", 500, null);
		orderList.add(orderPO2);
	}
	
	@Override
	public boolean addOrder(OrderPO order) {
		System.out.println("添加订单成功");
		return orderList.add(order);
	}
	
	@Override
	public boolean updateOrder(OrderPO order) {
		System.out.println("更新订单信息成功");
		String orderID = order.getOrderID();
		for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderID().equals(orderID)) {
				orderList.set(i, order);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean cancelOrder(String orderID) {
		System.out.println("撤销订单成功");
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderPO.getOrderID().equals(orderID)) {
				orderPO.setOrderStatus(OrderStatus.Canceled);
				orderPO.setCancelTime(new Date());
				orderList.set(i, orderPO);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean makeOrderAbnormal(String orderID) {
		System.out.println("异常订单成功");
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderPO.getOrderID().equals(orderID)) {
				if(orderPO.getOrderStatus()!=OrderStatus.Unexecuted) {
					return false;
				}
				
				orderPO.setOrderStatus(OrderStatus.Abnormal);
				orderList.set(i, orderPO);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean recoverOrder(String orderID, double recover) {
		System.out.println("恢复异常订单成功");
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderPO.getOrderID().equals(orderID)) {
				if(orderPO.getOrderStatus()!=OrderStatus.Abnormal) {
					return false;
				}
				
				orderPO.setOrderStatus(OrderStatus.Executed);
				orderPO.setActualCheckinTime(new Date());
				orderPO.setRecover(recover);
				orderList.set(i, orderPO);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public OrderPO getOrder(String orderID) {
		System.out.println("获取订单信息成功");
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderPO.getOrderID().equals(orderID)) {
				return orderPO;
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getOrderList(String userID) {
		System.out.println("获取订单列表成功");
		return orderList;
	}
	
	@Override
	public ArrayList<OrderPO> getFinishedOrders(String userID) {
		System.out.println("获取已执行订单列表成功");
		ArrayList<OrderPO> list = new ArrayList<>();
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderList.get(i).getOrderStatus()==OrderStatus.Executed) {
				list.add(orderPO);
			}
		}
		return list;
	}
	
	@Override
	public ArrayList<OrderPO> getUnfinishedOrders(String userID) {
		System.out.println("获取未执行订单列表成功");
		ArrayList<OrderPO> list = new ArrayList<>();
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderList.get(i).getOrderStatus()==OrderStatus.Unexecuted) {
				list.add(orderPO);
			}
		}
		return list;
	}
	
	@Override
	public ArrayList<OrderPO> getAbnormalOrders(String userID) {
		System.out.println("获取异常订单列表成功");
		ArrayList<OrderPO> list = new ArrayList<>();
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderList.get(i).getOrderStatus()==OrderStatus.Abnormal) {
				list.add(orderPO);
			}
		}
		return list;
	}
	
	@Override
	public ArrayList<OrderPO> getCancledOrders(String userID) {
		System.out.println("获取已撤销订单列表成功");
		ArrayList<OrderPO> list = new ArrayList<>();
		for(int i=0; i<orderList.size(); i++) {
			OrderPO orderPO = orderList.get(i);
			if(orderList.get(i).getOrderStatus()==OrderStatus.Canceled) {
				list.add(orderPO);
			}
		}
		return list;
	}
}
