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
	public String getAvailableHotelID();   //得到可用的新增ID
}
