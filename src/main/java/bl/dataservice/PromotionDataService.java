package bl.dataservice;

import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDataService {
	
	public PromotionPO getPromotion(String promotionID);
	public boolean addPromotion(PromotionPO promotion);
	public boolean deletePromotion(String promotionID);
	public boolean updatePromotion(String promotionID, PromotionPO promotion);
	public ArrayList<PromotionPO> getPromotionList();
}
