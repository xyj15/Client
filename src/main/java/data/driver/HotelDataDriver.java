package data.driver;

import data.service.HotelDataService;
import data.stub.HotelDataStub;
import po.HotelPO;

/**
 * Created by CROFF on 2016/12/12.
 */
public class HotelDataDriver {
	
	private HotelDataService hotelDataService = new HotelDataStub();
	
	public void drive() {
		System.out.println(hotelDataService.addHotel(new HotelPO()));
		System.out.println(hotelDataService.getAvailableHotelID());
		System.out.println(hotelDataService.getHotelByID("000000"));
		System.out.println(hotelDataService.updateHotel(new HotelPO()));
		System.out.println(hotelDataService.getHotelByName("新悦大酒店"));
		System.out.println(hotelDataService.deleteHotel("000000"));
	}
	
	public static void main(String[] args) {
		HotelDataDriver hotelDataDriver = new HotelDataDriver();
		hotelDataDriver.drive();
	}
}
