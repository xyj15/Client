package bl.driver;

import bl.service.SearchBLService;
import bl.stub.SearchBLStub;
import other.RoomType;

import java.util.Date;

public class SearchBLDriver {

	SearchBLService searchBLService = new SearchBLStub();

	public void drive() {
		System.out.println(searchBLService.setCity("city"));
		System.out.println(searchBLService.setDistrict("district"));
		System.out.println(searchBLService.setHotelName("hotel name"));
		System.out.println(searchBLService.setLevel(5));
		System.out.println(searchBLService.setCheckinTime(new Date()));
		System.out.println(searchBLService.setCheckoutTime(new Date()));
		System.out.println(searchBLService.setRoomType(RoomType.Single));
		System.out.println(searchBLService.setNumberOfRooms(1));
		System.out.println(searchBLService.setLowerPrice(0));
		System.out.println(searchBLService.setUpperPrice(100));
		System.out.println(searchBLService.setLowerScore(0));
		System.out.println(searchBLService.setUpperScore(5));
		System.out.println(searchBLService.setOnlyReservationBefore(false));
		System.out.println(searchBLService.search());
		System.out.println(searchBLService.sortByScoreLowToHigh());
		System.out.println(searchBLService.sortByScoreHighToLow());
		System.out.println(searchBLService.sortByPriceLowToHigh());
		System.out.println(searchBLService.sortByPriceHighToLow());
		System.out.println(searchBLService.sortByLevelLowToHigh());
		System.out.println(searchBLService.sortByLevelHighToLow());
	}

	public static void main(String[] args) {
		SearchBLDriver searchBLDriver = new SearchBLDriver();
		searchBLDriver.drive();
	}

}
