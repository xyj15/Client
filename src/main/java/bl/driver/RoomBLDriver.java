package bl.driver;

import bl.service.RoomBLService;
import bl.stub.RoomBLStub;
import vo.RoomVO;

public class RoomBLDriver {

	RoomBLService service = new RoomBLStub();
	
	public RoomBLDriver (RoomVO room) {
		System.out.println(service.addRoom(room));
		System.out.println(service.updateRoom(room));
		System.out.println(service.findRoom("512"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RoomVO room = new RoomVO(true ,"521" , 0, 250);
		new RoomBLDriver(room);
	}

}
