package bl.driver;

import bl.implementation.Search;
import bl.service.SearchBLService;
import bl.stub.SearchBLStub;

public class SearchBLDriver {

	SearchBLService searchbl = new SearchBLStub();
	
	public void drive(Search search) {
		search.setAddress("XianLinBigRoad");
		search.setDistrict("NanjingQixia");
		search.getHotelList();
		search.getRoomList("88888888");
	}
	
	public static void main(String[] args) {
		SearchBLDriver driver = new SearchBLDriver();
		driver.drive(new Search());
	}
	
}
