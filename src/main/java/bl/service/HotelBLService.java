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
	
	public ArrayList<RoomVO> getRoomList();	//获得酒店的客房列表
	public RoomVO getRoomInformation(String roomID);	//获得客房信息
	public boolean addRoom(RoomVO roomVO);	//添加客房
	public boolean deleteRoom(String roomID);	//删除客房
	public boolean updateRoom(String roomID, RoomVO roomVO);	//更新客房信息
	
	public ArrayList<PromotionVO> getPromotionList();	//获得酒店营销策略列表
	public boolean createPromotion(PromotionVO promotionVO);	//创建新的营销策略
	public boolean deletePromotion(String promotionID);	//删除营销策略
	public boolean updatePromotion(String promotionID, PromotionVO promotionVO);	//更新营销策略信息
	
	public boolean checkin(String orderID, String roomID);	//办理入住手续
	public boolean checkout(String orderID, String roomID);	//办理离店手续
	public boolean delay(String orderID);	//延迟入住
	
	public ArrayList<OrderVO> getUnexcutedOrderList();	//获得未执行订单列表
	public ArrayList<OrderVO> getExcutedOrderList();	//获得已执行订单列表
	public ArrayList<OrderVO> getAbnormalOrderList();	//获得异常订单列表
	public ArrayList<OrderVO> getCanceledOrderList();	//获得已撤销订单列表
}
