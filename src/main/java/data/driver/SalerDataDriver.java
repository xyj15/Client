package data.driver;

import data.service.SalerDataService;
import data.stub.SalerDataStub;
import po.SalerPO;

import java.rmi.RemoteException;

/**
 * Created by CROFF on 2016/12/9.
 */
public class SalerDataDriver {
	
	private SalerDataService salerDataService = new SalerDataStub();
	
	public void drive() throws RemoteException {
		System.out.println(salerDataService.addSaler(new SalerPO("", "", "", "")));
		System.out.println(salerDataService.deleteSaler(""));
		System.out.println(salerDataService.getAvailableSalerID());
		System.out.println(salerDataService.getSaler(""));
		System.out.println(salerDataService.updateSaler(new SalerPO("", "", "", "")));
	}
	
	public static void main(String[] args) throws RemoteException {
		SalerDataDriver salerDataDriver = new SalerDataDriver();
		salerDataDriver.drive();
	}
}
