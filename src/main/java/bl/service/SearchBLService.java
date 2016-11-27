package bl.service;

import java.util.ArrayList;

import bl.implementation.Hotel;
import other.Date;
import other.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public interface SearchBLService {
	
	public void setAddress(String address);
	
	public void setDistrict(String district);
	
	public void setHotelName(String hotelName);
	
	public void setLevel(int level);
	
	public void setScore(double score);
	
	public void setRoomType(RoomType roomType);
	
	public void setLowerPrice(double lowerPrice);
	
	public void setUpperPrice(double upperPrice);
	
	public void setCheckinTime(Date checkinTime);
	
	public void setCheckoutTime(Date checkoutTime);
	
	public void setOnlyReservationBefore(boolean onlyReservationBefore);
	
	public ArrayList<HotelVO> search();
	
	public ArrayList<RoomVO> getRoomList(String hotelID);
	
}
