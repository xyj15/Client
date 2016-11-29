package bl.service;

import java.util.ArrayList;

import vo.PromotionVO;

public interface PromotionBLService {
	
	public PromotionVO getPromotion(String promotionID);
	public boolean addPromotion(PromotionVO promotion);
	public boolean deletePromotion(String promotionID);
	public boolean updatePromotion(String promotionID, PromotionVO promotion);
	public ArrayList<PromotionVO> getPromotionList();
}
