package bl.service;

import java.util.List;

import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

/**
 * 
 * 
 * @author zgq
 *
 */

public interface HotelBLService {	

	public List<OrderVO> getOrderList (String hotelID,String time);
	public OrderVO getOrder(String orderID);
	public HotelVO getHotelInformat (String hotelID);
	public boolean updataOrder (String orderID,OrderVO OR);
	public boolean updataHotelInformat (String hotelID,HotelVO HO);
	public boolean check (String orderID, String memberID, String roomID, RoomVO RO, int mark);
	public boolean delay(String orderID);
	
}
