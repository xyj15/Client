package data.stub;

import data.service.HotelDataService;
import po.HotelPO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/2.
 */
public class HotelDataStub implements HotelDataService {
	
	@Override
	public boolean addHotel(HotelPO hotel) {
		return false;
	}
	
	@Override
	public boolean deleteHotel(String hotelID) {
		return false;
	}
	
	@Override
	public boolean updateHotel(HotelPO hotel) {
		return false;
	}
	
	@Override
	public HotelPO getHotelByID(String hotelID) {
		return null;
	}
	
	@Override
	public HotelPO getHotelByName(String hotelName) {
		return null;
	}
	
	@Override
	public ArrayList<HotelPO> getHotelListByCityDistrict(String city, String district) {
		return null;
	}
	
	@Override
	public ArrayList<HotelPO> getHotelListSortedByScore(double lowScore, double highScore, String city, String district) {
		return null;
	}
	
	@Override
	public ArrayList<HotelPO> getHotelListFilteredByLevel(int level, String city, String district) {
		return null;
	}
	
	@Override
	public ArrayList<HotelPO> getHotelListFilteredByPrice(double lowPrice, double highPrice, String city, String district) {
		return null;
	}
	
	@Override
	public String getAvailableID() {
		return null;
	}
	
	@Override
	public void close() {
		
	}
}
