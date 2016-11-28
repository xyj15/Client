package bl.dataservice;

import java.util.ArrayList;

import po.MemberPO;
import po.OrderPO;

public interface MemberDataService {

	public MemberPO getMemberInformation(String username);
	public boolean saveMemberInformation(MemberPO memberPO);
	public ArrayList<OrderPO> getOrderList(String username);
	public boolean updateOrderList(ArrayList<OrderPO> orderList);
}
