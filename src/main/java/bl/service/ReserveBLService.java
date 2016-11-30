package bl.service;

import other.Date;
import other.RoomType;
import other.Time;
import vo.PromotionVO;

/**
 * Reserve模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-27
 */
public interface ReserveBLService {
	
	public PromotionVO getPromotion();	//获得营销策略信息
	public boolean setPromotion(PromotionVO promotion);	//设置营销策略信息
	
	public double getPrice();	//获得订单价值
	public String getHotelName();	//获得酒店名称
	public String getHotelAddress();	//获得酒店地址
	public String getHotelLevel();	//获得酒店星级
	public String getHotelTel();	//获得酒店联系方式
	public RoomType getRoomType();	//获得客房房型
	
	public boolean setCheckinTime(Date checkinTime);	//设置入住时间
	public boolean setChekckoutTime(Date chekckoutTime);	//设置离店时间
	public boolean setLatestArriveTime(Time time);	//设置最晚到店时间
	public boolean setClientName(String clientName);	//设置客户姓名
	public boolean setClientTel(String clientTel);	//设置客户联系方式
	public boolean setNumberOfClient(int numberOfClient);	//设置预计入住人数
	public boolean setHasKids(boolean hasKids);	//设置有无儿童
	public boolean setNumberOfRoom(int numberOfRoom);	//设置预定客房数量
	public boolean setOtherReq(String otherReq);	//设置其他要求，若无则为""（空字符串）
	
	public boolean createOrder();	//创建新订单
}
