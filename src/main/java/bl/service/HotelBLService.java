package bl.service;

import other.HotelService;
import vo.HotelVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Hotel模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface HotelBLService {

	public String getHotelName();	//获得酒店名称
	public String getHotelAddress();	//获得酒店地址
	public int getHotelLevel();	//获得酒店星级
	public String getDistrict();	//获得酒店所属商圈
	public double getHotelScore();	//获得酒店评分
	public HotelService getHotelService();	//获得酒店服务设施情况
	public String getHotelIntroduction();	//获得酒店简介
	public String getHotelManagerName();	//获得酒店工作人员名称
	public String getHotelManagerTel();	//获得酒店工作人员联系方式
	public boolean setHotelInformation(HotelVO hotelInformation);	//设置酒店信息

	public boolean checkin(String orderID, String roomID);	//办理入住手续
	public boolean checkout(String orderID, String roomID);	//办理离店手续
	public boolean delay(String orderID);	//延迟入住
}
