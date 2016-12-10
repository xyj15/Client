package data.stub;

import data.service.ManagerDataService;
import po.ManagerPO;

/**
 * Created by CROFF on 2016/12/2.
 */
public class ManagerDataStub implements ManagerDataService {
	
	private ManagerPO managerPO;
	
	public ManagerDataStub() {
		String managerID = "00";
		String password = "12345678910";
		String name = "manager";
		String tel = "12345678910";
		managerPO = new ManagerPO(managerID, password, name, tel);
	}
	
	@Override
	public boolean updateManager(ManagerPO managerPO) {
		System.out.println("更新网站管理人员信息成功");
		this.managerPO = managerPO;
		return true;
	}
	
	@Override
	public ManagerPO getManager() {
		System.out.println("获取网站管理人员信息成功");
		return managerPO;
	}
}
