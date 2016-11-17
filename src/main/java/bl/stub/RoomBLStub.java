package bl.stub;

import bl.service.RoomBLService;
import vo.RoomVO;

public class RoomBLStub implements RoomBLService {

	public boolean addRoom(RoomVO room) {
		// TODO Auto-generated method stub
		System.out.println("----新添房间———");
		return true;
	}

	public RoomVO findRoom(String num) {
		// TODO Auto-generated method stub
		System.out.println("----查找房间———");
		return new RoomVO(true, "512",0, 280);
	}

	public boolean updateRoom(RoomVO room) {
		// TODO Auto-generated method stub
		System.out.println("----更新房间----");
		return true;
	}

}
