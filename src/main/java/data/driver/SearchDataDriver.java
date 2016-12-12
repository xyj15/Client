package data.driver;

import data.service.SearchDataService;
import data.stub.SearchDataStub;

/**
 * Created by CROFF on 2016/12/12.
 */
public class SearchDataDriver {
	
	private SearchDataService searchDataService = new SearchDataStub();
	
	public void drive() {
		System.out.println(searchDataService.getHotelListByCityDistrict("南京市", "南京大学商圈"));
	}
	
	public static void main(String[] args) {
		SearchDataDriver searchDataDriver = new SearchDataDriver();
		searchDataDriver.drive();
	}
}
