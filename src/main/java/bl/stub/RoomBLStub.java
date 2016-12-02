package bl.stub;

import bl.service.RoomBLService;
import other.RoomType;
import vo.RoomVO;

import java.util.ArrayList;

public class RoomBLStub implements RoomBLService {
	
	private RoomVO roomVO;
	
	public RoomBLStub() {
		boolean available = false;
		String roomNumber = "3304";
		String roomName = "总统专用豪华研讨间";
		RoomType roomType = RoomType.Suite;
		double price = 99999;
		String hotelID = "123456";
		roomVO = new RoomVO(available, roomNumber, roomName, roomType, price, hotelID);
	}
	
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		System.out.println("获取客房列表成功");
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		roomList.add(roomVO);
		return roomList;
	}
	
	@Override
	public RoomVO getRoomInformation(String roomID) {
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
	public boolean updateRoom(String roomID, RoomVO roomVO) {
		System.out.println("更新客房信息成功");
		return true;
	}
}
