package bl.driver;

import bl.service.RoomBLService;
import bl.stub.RoomBLStub;
import vo.RoomVO;

import java.util.Date;

public class RoomBLDriver {

	RoomBLService roomBLService = new RoomBLStub();
	
	public void drive() {
		System.out.println(roomBLService.addRoom(new RoomVO()));
		System.out.println(roomBLService.deleteRoom("3304"));
		System.out.println(roomBLService.getRoomInformation(new Date(), "3304"));
		System.out.println(roomBLService.updateRoom(new Date(), new RoomVO()));
	}

	public static void main(String[] args) {
		RoomBLDriver roomBLDriver = new RoomBLDriver();
		roomBLDriver.drive();
	}

}
