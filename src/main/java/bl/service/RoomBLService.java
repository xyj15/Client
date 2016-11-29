package bl.service;

import vo.RoomVO;

import java.util.ArrayList;

/**
 * 
 * @author 张新悦
 * @version 2016-11-04 
 *
 */
public interface RoomBLService {
	
	public ArrayList<RoomVO> getRoomList();
	public RoomVO getRoomInformation(String roomID);
	public boolean addRoom(RoomVO roomVO);
	public boolean deleteRoom(String roomID);
	public boolean updateRoom(String roomID, RoomVO roomVO);
}
