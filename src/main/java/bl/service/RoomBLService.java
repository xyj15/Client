package bl.service;

import vo.RoomVO;

import java.util.ArrayList;

/**
 * Room模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-04
 */
public interface RoomBLService {
	
	public ArrayList<RoomVO> getRoomList(String hotelID);	//获得客房列表
	public RoomVO getRoomInformation(String roomID);	//获得客房信息
	public boolean addRoom(RoomVO roomVO);	//添加客房
	public boolean deleteRoom(String roomID);	//删除客房
	public boolean updateRoom(String roomID, RoomVO roomVO);	//更新客房信息
}
