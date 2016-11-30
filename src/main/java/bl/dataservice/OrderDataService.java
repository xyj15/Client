package bl.dataservice;

import java.util.ArrayList;

import po.OrderPO;

/**
 * Order模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface OrderDataService {
	
	public ArrayList<OrderPO> getOrderList(String userID);	//获得客户或酒店的订单列表
	public boolean addOrder(OrderPO orderPO);	//添加新订单
	public boolean deleteOrder(String orderID);	//删除订单
	public boolean updateOrder(String orderID, OrderPO orderPO);	//更新订单信息
	public OrderPO getOrder(String orderID);	//获得订单信息
}
