package bl.dataservice;

import java.util.ArrayList;

import po.MemberPO;
import po.OrderPO;

/**
 * Member模块bl层与data层之间的接口
 * @author CROFF
 * @version 2016-12-1
 */
public interface MemberDataService {
	
	public boolean addMember(MemberPO memberPO);	//添加客户
	public boolean deleteMember(String memberID);	//删除客户
	public ArrayList<MemberPO> getMemberList();	//获得客户列表
	public void updateMemberInformation(String memberID, MemberPO memberPO);	//更新客户信息
	public MemberPO getMemberInfomation(String memberID);	//获得客户信息
}
