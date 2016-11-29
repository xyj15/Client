package bl.dataservice;

import java.util.ArrayList;

import po.*;

/**
 * Search模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface SearchDataService {

	public ArrayList<HotelPO> getAllHotelList();	//获得所有酒店的列表
	public ArrayList<RoomPO> getRoomList(String hotelID);	//获得某一酒店的房间列表
	public ArrayList<HotelPO> getReservedHotelList(String memberID);	//获得某用户预定过的酒店列表
}

