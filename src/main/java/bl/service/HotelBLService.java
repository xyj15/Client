package bl.service;

import other.HotelService;
import vo.HotelVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * 
 * 
 * @author zgq
 *
 */

public interface HotelBLService {	

	public String getHotelName();
	public String getHotelAddress();
	public int getHotelLevel();
	public String getDistrict();
	public double getHotelScore();
	public HotelService getHotelService();
	public String getHotelIntroduction();
	public String getHotelManagerName();
	public String getHotelManagerTel();
	
	public boolean setHotelInformation(HotelVO hotelInformation);
	
	public ArrayList<RoomVO> getRoomList();
	public boolean addRoom(RoomVO roomVO);
	public boolean deleteRoom(String roomID);
	public boolean updateRoom(String roomID, RoomVO roomVO);
	
	public ArrayList<PromotionVO> getPromotionList();
	public boolean createPromotion(PromotionVO promotionVO);
	public boolean deletePromotion(String promotionID);
	public boolean updatePromotion(String promotionID, PromotionVO promotionVO);
	
	public boolean checkin(String orderID, String roomID);
	public boolean checkout(String orderID, String roomID);
	public boolean delay(String orderID);
	
	public ArrayList<OrderVO> getUnexcutedOrderList();
	public ArrayList<OrderVO> getExcutedOrderList();
	public ArrayList<OrderVO> getAbnormalOrderList();
	public ArrayList<OrderVO> getCanceledOrderList();
}
