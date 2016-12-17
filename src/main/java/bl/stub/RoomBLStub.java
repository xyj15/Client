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
	public ArrayList<RoomVO> getAvailableRoomByName(Date date, String roomName) {
		System.out.println("获取客房列表成功");
		ArrayList<RoomVO> roomList = new ArrayList<>();
		RoomVO roomVO = new RoomVO(true, false, "301", "海景大床房", RoomType.BigBed, 500, "000000");
		RoomVO roomVO1 = new RoomVO(true, false, "222", "海景大床房", RoomType.BigBed, 100, "111110");
		RoomVO roomVO2 = new RoomVO(true, false, "333", "海景大床房", RoomType.BigBed, 5111, "0555550");
		roomList.add(roomVO);
		roomList.add(roomVO1);
		roomList.add(roomVO2);
		return roomList;
	}
	
	@Override
	public ArrayList<RoomVO> getDailyRoomList(Date date) {
		System.out.println("获取客房列表成功");
		ArrayList<RoomVO> roomList = new ArrayList<>();
		RoomVO roomVO = new RoomVO(true, false, "301", "海景大床房", RoomType.BigBed, 500, "000000");
		roomList.add(roomVO);
		return roomList;
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
