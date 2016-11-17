package bl.dataservice;

import java.util.ArrayList;

import po.OrderPO;

public interface OrderData {
	
	public boolean insert(OrderPO user);
	public boolean delete(OrderPO user);
	public boolean update(OrderPO user);
	public OrderPO getOrder(String orderID);
	public ArrayList<OrderPO> getOrderList(String userID);
	
}
