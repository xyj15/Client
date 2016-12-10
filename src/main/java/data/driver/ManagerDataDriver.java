package data.driver;

import data.service.ManagerDataService;
import data.stub.ManagerDataStub;
import po.ManagerPO;

/**
 * Created by CROFF on 2016/12/10.
 */
public class ManagerDataDriver {
	
	private ManagerDataService managerDataService = new ManagerDataStub();
	
	public void drive() {
		System.out.println(managerDataService.getManager());
		System.out.println(managerDataService.updateManager(new ManagerPO()));
	}
	
	public static void main(String[] args) {
		ManagerDataDriver managerDataDriver = new ManagerDataDriver();
		managerDataDriver.drive();
	}
}
