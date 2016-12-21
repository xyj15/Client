package data.stub;

import data.service.SearchDataService;
import po.HotelPO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/12.
 */
public class SearchDataStub implements SearchDataService {
	
	private ArrayList<HotelPO> hotelList;
	
	public SearchDataStub() {
		HotelDataStub hotelDataStub = new HotelDataStub();
		hotelList = hotelDataStub.getHotelList();
	}
	
	@Override
	public ArrayList<String> getCityList() {
		ArrayList<String> cityList = new ArrayList<>();
		for(int i=0; i<hotelList.size(); i++) {
			String city = hotelList.get(i).getCity();
			if(!cityList.contains(city)) {
				cityList.add(city);
			}
		}
		return cityList;
	}
	
	@Override
	public ArrayList<String> getDistrictList(String city) {
		ArrayList<String> districtList = new ArrayList<>();
		for(int i=0; i<hotelList.size(); i++) {
			HotelPO hotelPO = hotelList.get(i);
			if(hotelPO.getCity().equals(city)) {
				String district = hotelPO.getDistrict();
				if(!districtList.contains(district)) {
					districtList.add(district);
				}
			}
		}
		return districtList;
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
	public ArrayList<HotelPO> getHotelListByCityDistrict(String city, String district) {
		ArrayList<HotelPO> list = new ArrayList<>();
		for(int i=0; i<hotelList.size(); i++) {
			HotelPO hotelPO = hotelList.get(i);
			if(hotelPO.getCity().equals(city) && hotelPO.getDistrict().equals(district)) {
				list.add(hotelPO);
			}
		}
		return list;
	}
}
