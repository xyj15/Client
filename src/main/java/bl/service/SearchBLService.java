package bl.service;

import java.util.ArrayList;

import bl.implementation.Hotel;
import other.Date;
import other.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public interface SearchBLService {
	
	public boolean setAddress(String address);
	public boolean setDistrict(String district);
	public boolean setHotelName(String hotelName);
	public boolean setLevel(int level);
	public boolean setScore(double score);
	public boolean setRoomType(RoomType roomType);
	public boolean setLowerPrice(double lowerPrice);
	public boolean setUpperPrice(double upperPrice);
	public boolean setCheckinTime(Date checkinTime);
	public boolean setCheckoutTime(Date checkoutTime);
	public boolean setOnlyReservationBefore(boolean onlyReservationBefore);
	
	public ArrayList<HotelVO> search();
	public ArrayList<RoomVO> getRoomList(String hotelID);
	public boolean setSelectedHotel(HotelVO hotelVO);
	public boolean setSelectedRoom(RoomVO roomVO);
	
	public ArrayList<HotelVO> sortByPriceHighToLow();
	public ArrayList<HotelVO> sortByPriceLowToHigh();
	public ArrayList<HotelVO> sortByScoreHighToLow();
	public ArrayList<HotelVO> sortByScoreLowToHigh();
	public ArrayList<HotelVO> sortByLevelHighToLow();
	public ArrayList<HotelVO> sortByLevelLowToHigh();
}
