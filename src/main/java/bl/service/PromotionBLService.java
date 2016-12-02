package bl.service;

import java.util.ArrayList;

import vo.PromotionVO;

/**
 * Promotion模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface PromotionBLService {
	
	public PromotionVO getPromotion(String promotionID);	//获得营销策略信息
	public boolean addPromotion(PromotionVO promotion);	//添加营销策略
	public boolean deletePromotion(String promotionID);	//删除营销策略
	public boolean updatePromotion(String promotionID, PromotionVO promotion);	//更新营销策略信息
	public ArrayList<PromotionVO> getHotelPromotionList(String hotelID);	//获得酒店营销策略列表
	public ArrayList<PromotionVO> getWebPromotionList();	//获得网站营销策略列表
}
