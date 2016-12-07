package bl.driver;

import bl.service.HotelBLService;
import bl.stub.HotelBLStub;
import vo.HotelVO;

public class HotelBLDriver {

	private HotelBLService hotelBLService = new HotelBLStub();

	public void drive() {
		System.out.println(hotelBLService.getHotelName());
		System.out.println(hotelBLService.getHotelAddress());
		System.out.println(hotelBLService.getCity());
		System.out.println(hotelBLService.getDistrict());
		System.out.println(hotelBLService.getHotelLevel());
		System.out.println(hotelBLService.getHotelScore());
		System.out.println(hotelBLService.getHotelService());
		System.out.println(hotelBLService.getHotelIntroduction());
		System.out.println(hotelBLService.getHotelManagerName());
		System.out.println(hotelBLService.getHotelManagerTel());
		System.out.println(hotelBLService.getHotelInformation());
		System.out.println(hotelBLService.setHotelInformation(new HotelVO()));
		System.out.println(hotelBLService.checkin("orderID", "roomID"));
		System.out.println(hotelBLService.checkout("orderID", "roomID"));
		System.out.println(hotelBLService.delay("orderID", "roomID"));
	}

	public static void main(String[] args) {
		HotelBLDriver hotelBLDriver = new HotelBLDriver();
		hotelBLDriver.drive();
	}

}
