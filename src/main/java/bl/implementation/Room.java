package bl.implementation;

import data.service.RoomDataService;
import bl.service.RoomBLService;
import po.RoomPO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Room模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Room implements RoomBLService {
	
	private String hotelID;
	private RoomVO room;
	
	private RoomDataService roomDataService;
	
	/**
	 *
	 * @param hotelID
	 */
	public Room(String hotelID) {
		this.hotelID = hotelID;
		updateDataFromFile();
	}
	
	public void updateDataFromFile() {
		
	}
	
	/**
	 * 根据房间号查找房间
	 * @return RoomVO
	 * @author 张新悦
	 * @version 2016-11-13 16:17
	 */
	@Override
	public RoomVO getRoomInformation(String num){
		if(room.getRoomNumber().equals(num)) return room;
		//RoomPO temp = roomDataService.getRoomInformation(num);
		//room = new RoomVO(temp.getValid(), temp.getNumber(), temp.getRoomType(), temp.getPrice());
		return room;
	}

	
	/**
	 * 增加房间
	 * @author 张新悦
	 * @version 2016-11-13 17:33
	 */
	@Override
	public boolean addRoom(RoomVO room) {
		//RoomPO temp = new RoomPO(room.isAvailable(), room.getNumber(), room.getType(), room.getPrice());
		//new RoomPO(room.isAvailable(), room.getNumber(), room.getType(), room.getPrice());
		//roomDataService.addRoom(temp);
		return true;
	}
	
	/**
	 *
	 * @param roomID
	 * @return
	 */
	@Override
	public boolean deleteRoom(String roomID) {
		return false;
	}
	
	/**
	 * 更新房间信息
	 * @author 张新悦
	 * @version 2016-11-13 17:23
	 */
	@Override
	public boolean updateRoom(String roomID, RoomVO roomVO) {
		//RoomPO temp = new RoomPO(room.isAvailable(), room.getNumber(), room.getType(), room.getPrice());
		//new RoomPO(room.isAvailable(), room.getNumber(), room.getType(), room.getPrice());
		//roomDataService.updateRoom(temp);
		return true;
	}
}

