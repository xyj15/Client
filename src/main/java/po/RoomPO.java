package po;

import other.RoomType;

public class RoomPO {
	
	private boolean available;	//客房是否可使用
	private String roomNumber;	//客房号
	private String roomName;	//客房名称
	private RoomType roomType;	//客房类型
	private double price;	//客房单价
	private String hotelID;	//所属酒店
	
	public RoomPO(boolean available, String roomNumber, String roomName,
				  RoomType roomType, double price, String hotelID) {
		this.available = available;
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.roomType = roomType;
		this.price = price;
		this.hotelID = hotelID;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
}
