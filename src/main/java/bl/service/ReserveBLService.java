package bl.service;

import other.Date;
import other.RoomType;
import other.Time;
import vo.PromotionVO;

/**
 * Reserve的bl类的接口
 * @author CROFF
 * @version 2016-11-27
 */
public interface ReserveBLService {
	
	public PromotionVO getPromotion();

	public void setPromotion(PromotionVO promotion);
	
	public double getPrice();
	
	public String getHotelName();
	
	public String getHotelAddress();
	
	public String getHotelLevel();
	
	public String getHotelTel();
	
	public RoomType getRoomType();
	
	public void setCheckinTime(Date checkinTime);
	
	public void setChekckoutTime(Date chekckoutTime);
	
	public void setLatestArriveTime(Time time);	//设置最晚到店时间
	
	public void setClientName(String clientName);
	
	public void setClientTel(String clientTel);
	
	public void setNumberOfClient(int numberOfClient);	//设置预计入住人数
	
	public void setHasKids(boolean hasKids);	//设置有无儿童
	
	public void setNumberOfRoom(int numberOfRoom);	//设置预定客房数量
	
	public void setOtherReq(String otherReq);
	
	public void createOrder();
}
