package bl.service;

import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Room模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-04
 */
public interface RoomBLService {
	
	public RoomVO getRoomInformation(Date date, String roomID);	//获得某天的客房信息
	public boolean addRoom(RoomVO roomVO);	//添加客房
	public boolean deleteRoom(String roomID);	//删除客房
	public boolean updateRoom(Date date, RoomVO roomVO);	//更新某天的客房信息
	public ArrayList<RoomVO> getAvailableRoomByName(Date date, String roomName);	//根据日期和房间名称获取可用房间列表
	public ArrayList<RoomVO> getDailyRoomList(Date date);	//获得酒店某天的所有客房信息
}
