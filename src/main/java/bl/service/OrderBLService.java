package bl.service;
import vo.OrderVO;

import java.util.ArrayList;

public interface OrderBLService {
	
	public ArrayList<OrderVO> getOrderList();
	public ArrayList<OrderVO> getAllOrder();
	public ArrayList<OrderVO> getExcutedOrders();
	public ArrayList<OrderVO> getAbnormalOrders();
	public ArrayList<OrderVO> getCanceledOrders();
	public void cancelOrder(String orderID);
	public void evaluateOrder(double score, String comment);
}
