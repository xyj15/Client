package bl.dataservice;

import java.util.ArrayList;

import po.*;

public interface SearchData {

	public ArrayList<HotelPO> getHotelList(String str, searchHotelInfo info);
	public ArrayList<roomPO> getRoomList(String hotelID);
	
	enum searchHotelInfo {
		DISTRICT, ADDRESS
	}
}

