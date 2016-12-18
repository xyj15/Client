package data.driver;

import data.service.SearchDataService;
import data.stub.SearchDataStub;

import java.rmi.RemoteException;

/**
 * Created by CROFF on 2016/12/12.
 */
public class SearchDataDriver {
	
	private SearchDataService searchDataService = new SearchDataStub();
	
	public void drive() throws RemoteException {
		System.out.println(searchDataService.getHotelListByCityDistrict("南京市", "南京大学商圈"));
	}
	
	public static void main(String[] args) throws RemoteException {
		SearchDataDriver searchDataDriver = new SearchDataDriver();
		searchDataDriver.drive();
	}
}
