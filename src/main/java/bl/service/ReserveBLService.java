package bl.service;

import other.Date;
import other.RoomType;
import vo.PromotionVO;

/**
 * Reserve的bl类的接口
 * @author CROFF
 * @version 2016-11-27
 */
public interface ReserveBLService {

	public void setPromotion(PromotionVO promotion);
	
	public double getPrice();
	
	public String getHotelName();
	
	public String getHotelAddress();
	
	public String getHotelLevel();
	
	public String getHotelTel();
	
	public RoomType getRoomType();
	
	public void setCheckinTime(Date checkinTime);
	
	public void setChekckoutTime(Date chekckoutTime);
	
	public void setClientName(String clientName);
	
	public void setClientTel(String clientTel);
	
	public void setOtherReq(String otherReq);
	
	public void createOrder();
}
