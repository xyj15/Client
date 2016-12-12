package data.stub;

import data.service.OrderDataService;
import po.OrderPO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/2.
 */
public class OrderDataStub implements OrderDataService {
	
	@Override
	public boolean addOrder(OrderPO order) {
		return false;
	}
	
	@Override
	public boolean updateOrder(OrderPO order) {
		return false;
	}
	
	@Override
	public boolean cancelOrder(String orderID) {
		return false;
	}
	
	@Override
	public boolean makeOrderAbnormal(String orderID) {
		return false;
	}
	
	@Override
	public boolean recoverOrder(String orderID, double recover) {
		return false;
	}
	
	@Override
	public OrderPO getOrder(String orderID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getOrderList(String userID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getFinishedOrders(String userID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getUnfinishedOrders(String userID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getAbnormalOrders(String userID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getCancledOrders(String userID) {
		return null;
	}
}
