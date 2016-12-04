package bl.stub;

import bl.service.RoomBLService;
import other.RoomType;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

public class RoomBLStub implements RoomBLService {
	
	private RoomVO roomVO;
	
	public RoomBLStub() {
		boolean reserved = false;
		boolean available = false;
		String roomNumber = "3304";
		String roomName = "总统专用豪华研讨间";
		RoomType roomType = RoomType.Suite;
		double price = 99999;
		String hotelID = "123456";
		roomVO = new RoomVO(reserved, available, roomNumber, roomName, roomType, price, hotelID);
	}
	
	@Override
	public RoomVO getRoomInformation(Date date, String roomID) {
		System.out.println("获取客房信息成功");
		return roomVO;
	}
	
	@Override
	public boolean addRoom(RoomVO roomVO) {
		System.out.println("添加客房成功");
		return true;
	}
	
	@Override
	public boolean deleteRoom(String roomID) {
		System.out.println("删除客房成功");
		return true;
	}
	
	@Override
	public boolean updateRoom(Date date, RoomVO roomVO) {
		System.out.println("更新客房信息成功");
		return true;
	}
}
