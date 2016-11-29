package bl.service;

import vo.RoomVO;

/**
 * 
 * @author 张新悦
 * @version 2016-11-04 
 *
 */
public interface RoomBLService {

	public boolean addRoom(RoomVO room);
	public RoomVO getRoom(String num);
	public boolean updateRoom(RoomVO room);
	public boolean deleteRoom(String roomNUM);
}
