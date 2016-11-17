package bl.service;

import java.util.ArrayList;

import vo.HotelVO;
import vo.RoomVO;

public interface SearchBLService {

	public void setAddress(String address);
	public String getAddress();
	public void setDistrict(String district);
	public String getDistrict();
	public ArrayList<HotelVO> getHotelList();
	public ArrayList<RoomVO> getRoomList(String hotelID);
}
