package bl.dataservice;

import java.util.ArrayList;

import po.MemberPO;
import po.OrderPO;

/**
 * Member模块bl层与data层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface MemberDataService {

	public MemberPO getMemberInformation(String memberID);	//获得用户信息
	public boolean updateMemberInformation(MemberPO memberPO);	//更新用户信息
	public ArrayList<OrderPO> getOrderList(String memberID);	//获得用户订单列表
	public boolean updateOrder(String orderID, OrderPO orderPO);	//更新订单状态（撤销、评价等）
	public boolean createOrder(OrderPO orderPO);	//创建新订单
}
