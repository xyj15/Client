package bl.dataservice;

import po.RoomPO;

import java.util.ArrayList;

/**
 * Room模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface RoomDataService {

	public RoomPO getRoomInformation(String roomID);	//获得客房信息
	public ArrayList<RoomPO> getRoomList(String hotelID);	//获得酒店的客房列表
	public boolean updateRoom(String roomID, RoomPO roomPO);	//更新客房状态
	public boolean addRoom(RoomPO roomPO);	//添加客房
	public boolean deleteRoom(String roomID, RoomPO roomPO);	//删除客房
}
