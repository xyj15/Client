package vo;

import other.RoomType;

public class RoomVO {

	private boolean isReserved;	//客房是否被预定
	private boolean available;	//客房是否可使用
	private String roomID;	//客房号
	private RoomType roomType;	//客房类型
	private double price;	//客房单价
	private HotelVO hotelVO;	//所属酒店
	
	public RoomVO() {
		
	}
	
	public RoomVO(RoomType normal, String number, int i, int price) {
		
	}
	
	public RoomVO(boolean valid, String number,RoomType type,double price){
		this.available =valid;
		this.roomID =number;
		this.roomType=type;
		this.price =price;
	}
	
	/**
	 * 查看房间类型
	 * @return 以整数为代表的房间类型
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public RoomType getType() {
		return roomType;
	}
	
	/**
	 * 查看房间号
	 * @return 以字符串为代表的房间号
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public String getNumber() {
		return roomID;
	}
	
	/**
	 * 查看房间价格
	 * @return 以浮点数显示的房间价格
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 查看房间入住情况
	 * @return 以布尔值为代表的房间入住情况
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * 修改房间价格
	 * @param pri
	 *    要更改的新的房间价格
	 * @return 
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public void setPrice(double pri) {
		price = pri;
	}
	
	/**
	 * 登记入住
	 * @return 以布尔值为代表的更改房间入住情况成功与否
	 * @author 张新悦
	 * @version 2016-11-04 09:59
	 */
	public boolean checkIn() {
		if(!available) return false;
		available = false;
		return true;
	}
	
	/**
	 * 离开房间
	 * @return 以布尔值为代表的更改房间入住情况成功与否
	 * @author 张新悦
	 * @version 2016-11-04 10:04
	 */
	public boolean checkOut() {
		if(available) return false;
		available = true;
		return true;
	}
}
