package bl.driver;

import bl.service.ReserveBLService;
import bl.stub.ReserveBLStub;
import vo.PromotionVO;
import vo.RoomVO;

import java.util.Date;

public class ReserveBLDriver {

	ReserveBLService reserveBLService = new ReserveBLStub();

	public void drive() {
		System.out.println(reserveBLService.getPromotionList());
		System.out.println(reserveBLService.getPromotion());
		System.out.println(reserveBLService.getPrice());
		System.out.println(reserveBLService.setPromotion(new PromotionVO()));
		System.out.println(reserveBLService.getHotelName());
		System.out.println(reserveBLService.getHotelAddress());
		System.out.println(reserveBLService.getHotelLevel());
		System.out.println(reserveBLService.getRoomList(new Date()));
		System.out.println(reserveBLService.getSelectedRoom());
		System.out.println(reserveBLService.setSelectedRoom(new RoomVO()));
		System.out.println(reserveBLService.setCheckinTime(new Date()));
		System.out.println(reserveBLService.setChekckoutTime(new Date()));
		System.out.println(reserveBLService.setLatestArriveTime(new Date()));
		System.out.println(reserveBLService.setClientName("XXX"));
		System.out.println(reserveBLService.setClientTel("12345678910"));
		System.out.println(reserveBLService.setHaveKids(false));
		System.out.println(reserveBLService.setNumberOfClient(1));
		System.out.println(reserveBLService.setNumberOfRoom(1));
		System.out.println(reserveBLService.setOtherReq("XXXXXXXXXXXX"));
		System.out.println(reserveBLService.createOrder());
	}

	public static void main(String[] args) {
		ReserveBLDriver reserveBLDriver = new ReserveBLDriver();
		reserveBLDriver.drive();
	}

}
