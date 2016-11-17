package vo;

import java.util.ArrayList;

public class HotelVO {


	private String hotelID;
	private String name;
	private String address;
	private String level;
	private String district;
	private ArrayList<RoomVO> roomList;
	
	public HotelVO(){}
	
	public HotelVO(String hotelID,String name,String address,String level,String district){
		this.setHotelID(hotelID);
		this.setName(name);
		this.setAddress(address);
		this.setLevel(level);
		this.setDistrict(district);
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	public ArrayList<RoomVO> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<RoomVO> roomList) {
		this.roomList = roomList;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}