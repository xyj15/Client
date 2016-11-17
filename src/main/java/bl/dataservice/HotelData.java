package bl.dataservice;

import java.util.ArrayList;

import po.HotelPO;
import po.MemberPO;
import po.OrderPO;
import po.roomPO;

public interface HotelData {

	public MemberPO getMInformation(String memberID);
	public ArrayList<OrderPO> getOrderList(String hotelID,String time);
	public OrderPO getOrder(String orderID);
	public HotelPO getHotelInformat(String hotelID);
	public boolean updataOrder(String orderID, OrderPO OR);
	public boolean updataHotelInformat(String hotelID, HotelPO po);
	public boolean check(String orderID, String memberID, String roomID, roomPO RO, int mark);
	
}