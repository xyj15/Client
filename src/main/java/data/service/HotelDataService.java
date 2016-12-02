package data.service;

import po.HotelPO;

import java.util.ArrayList;

/**
 * Created by zhangxinyue on 2016/12/1.
 */
public interface HotelDataService {
	public boolean addHotel(HotelPO hotel);
	public boolean deleteHotel(String hotelID);
	public boolean updateHotel(HotelPO hotel);
	public HotelPO getHotelByID(String hotelID);
	public HotelPO getHotelByName(String hotelName);
	public ArrayList<HotelPO> getHotelListByCityDistrict(String city, String district);
	public ArrayList<HotelPO> getHotelListSortedByScore(double lowScore, double highScore, String hotelScope);
	public ArrayList<HotelPO> getHotelListFilteredByLevel(int level, String hotelScope);
	public ArrayList<HotelPO> getHotelListFilteredByPrice(double lowPrice, double highPrice, String hotelScope);
}