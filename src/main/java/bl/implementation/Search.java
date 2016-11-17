package bl.implementation;

import java.util.ArrayList;

import bl.service.SearchBLService;
import vo.*;

public class Search implements SearchBLService {
	
	private String address;
	private String district;
	private ArrayList<HotelVO> hotelList;
	
	public Search() {
		address = null;
		district = null;
		hotelList = null;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public ArrayList<HotelVO> getHotelList() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		
		if(address==null && district==null) {
			return null;
		} else if(address==null) {
			for(int i=0; i<hotelList.size(); i++) {
				if(district.equals(hotelList.get(i).getDistrict())) {
					resultList.add(hotelList.get(i));
				}
			}
			return resultList;
		} else {
			for(int i=0; i<hotelList.size(); i++) {
				if(address.equals(hotelList.get(i).getAddress())) {
					resultList.add(hotelList.get(i));
				}
			}
			return resultList;
		}
	}
	
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		for(int i=0; i<hotelList.size(); i++) {
			if(hotelList.get(i).getHotelID().equals(hotelID)) {
				return hotelList.get(i).getRoomList();
			}
		}
		return null;
	}

	public void setHotelList(ArrayList<HotelVO> hotelList) {
		this.hotelList = hotelList;
	}

	public String getAddress() {
		return address;
	}

	public String getDistrict() {
		return district;
	}
	
}
