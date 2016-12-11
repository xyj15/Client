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
	public String getAvailableHotelID() {
		return null;
	}
}
