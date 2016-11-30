package bl.service;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Order模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface OrderBLService {
	
	public ArrayList<OrderVO> getOrderList();	//获得订单列表
	public ArrayList<OrderVO> getExcutedOrders();	//获得已执行订单列表
	public ArrayList<OrderVO> getUnexcutedOrders();	//获得未执行订单列表
	public ArrayList<OrderVO> getAbnormalOrders();	//获得异常订单列表
	public ArrayList<OrderVO> getCanceledOrders();	//获得已撤销订单列表
	
	public boolean cancelOrder(String orderID);	//撤销订单
	public boolean evaluateOrder(double score, String comment);	//评价订单
	public boolean cancelAbnormalOrder(String orderID, double recover);	//撤销异常订单，recover为恢复信用的比例，全部或一半
}
