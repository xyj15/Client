package bl.dataservice;

import java.util.ArrayList;

import po.*;

/**
 * Search模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-12-1
 */
public interface SearchDataService {

	public ArrayList<HotelPO> getReservedHotelList(String memberID);	//获得某用户预定过的酒店列表
}

