package bl.dataservice;

import other.User;
import po.HotelPO;
import po.ManagerPO;
import po.MemberPO;
import po.SalerPO;

import java.util.ArrayList;

/**
 * Manager模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-12-1
 */
public interface ManagerDataService {
	
	public ManagerPO getManagerInformation();	//获得Manager信息
	public boolean updateManagerInformation(ManagerPO managerPO);	//更新Manager信息
	public ArrayList<User> getUserList();	//获得所有用户的列表
}
