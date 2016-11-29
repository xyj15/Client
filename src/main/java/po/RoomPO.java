package po;

import other.RoomType;

public class RoomPO {
	
	private boolean isReserved;	//客房是否被预定
	private boolean available;	//客房是否可使用
	private String roomID;	//客房号
	private RoomType roomType;	//客房类型
	private double price;	//客房单价
	private HotelPO hotelPO;	//所属酒店
	
	public RoomPO() {
		
	}
}
