package bl.dataservice;

import po.roomPO;

public interface RoomData {

	public roomPO getRoom(String ID) ;
	public boolean updateRoom(roomPO room);
	public boolean addRoom(roomPO room);
	
}
