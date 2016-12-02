package vo;

import other.RoomType;

/**
 * 存储Room信息的VO类
 * @author CROFF
 * @version 2016-12-1
 */
public class RoomVO {
	
	private boolean available;	//客房是否可使用
	private String roomNumber;	//客房号码
	private String roomName;	//客房名称
	private RoomType roomType;	//客房类型
	private double price;	//客房单价
	private String hotelID;	//所属酒店ID
	
	/**
	 * 空构造方法
	 */
	public RoomVO() {
		
	}
	
	/**
	 * 带参数的构造方法
	 * @param available 客房是否可使用
	 * @param roomNumber 客房号码
	 * @param roomName 客房名称
	 * @param roomType 客房类型
	 * @param price 客房单价
	 * @param hotelID 所属酒店ID
	 */
	public RoomVO(boolean available, String roomNumber, String roomName,
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

//	/**
//	 * 查看房间类型
//	 * @return 以整数为代表的房间类型
//	 * @author 张新悦
//	 * @version 2016-11-04 09:50
//	 */
//	public RoomType getType() {
//		return roomType;
//	}
//
//	/**
//	 * 查看房间号
//	 * @return 以字符串为代表的房间号
//	 * @author 张新悦
//	 * @version 2016-11-04 09:50
//	 */
//	public String getNumber() {
//		return roomNumber;
//	}
//
//	/**
//	 * 查看房间价格
//	 * @return 以浮点数显示的房间价格
//	 * @author 张新悦
//	 * @version 2016-11-04 09:50
//	 */
//	public double getPrice() {
//		return price;
//	}
//
//	/**
//	 * 查看房间入住情况
//	 * @return 以布尔值为代表的房间入住情况
//	 * @author 张新悦
//	 * @version 2016-11-04 09:50
//	 */
//	public boolean isAvailable() {
//		return available;
//	}
//
//	/**
//	 * 修改房间价格
//	 * @param pri
//	 *    要更改的新的房间价格
//	 * @return
//	 * @author 张新悦
//	 * @version 2016-11-04 09:50
//	 */
//	public void setPrice(double pri) {
//		price = pri;
//	}
//
//	/**
//	 * 登记入住
//	 * @return 以布尔值为代表的更改房间入住情况成功与否
//	 * @author 张新悦
//	 * @version 2016-11-04 09:59
//	 */
//	public boolean checkIn() {
//		if(!available) return false;
//		available = false;
//		return true;
//	}
//
//	/**
//	 * 离开房间
//	 * @return 以布尔值为代表的更改房间入住情况成功与否
//	 * @author 张新悦
//	 * @version 2016-11-04 10:04
//	 */
//	public boolean checkOut() {
//		if(available) return false;
//		available = true;
//		return true;
//	}
}
