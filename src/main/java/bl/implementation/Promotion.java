package bl.implementation;

import java.util.ArrayList;

import bl.dataservice.PromotionDataService;
import bl.service.PromotionBLService;
import po.PromotionPO;
import vo.PromotionVO;

public class Promotion implements PromotionBLService {
	
	private PromotionDataService promotionDataService;
	private ArrayList<PromotionVO> promotionVOList;
	private ArrayList<PromotionPO> promotionPOList;
	
	public Promotion() {
		
	}
	
	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}
	
	@Override
	public boolean addPromotion(PromotionVO promotion) {
		return false;
	}
	
	@Override
	public boolean deletePromotion(String promotionID) {
		return false;
	}
	
	@Override
	public boolean updatePromotion(String promotionID, PromotionVO promotion) {
		return false;
	}
	
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		return null;
	}

//	public PromotionVO getPromotion(String promotionID){
//		for(int i=0;i<promotionList.size();i++){
//			if(promotionList.get(i).getID().equals(promotionID)){
//				return promotionList.get(i);
//			}
//		}
//		return null;
//	}
//
//    public boolean addPromotion(PromotionVO promotion) {
//    	promotionList.add(promotion);
//		return true;
//	}
//
//    public boolean delPromotion(PromotionVO promotion) {
//    	promotionList.remove(promotion);
//		return true;
//	}
//
//    public boolean changePromotion(PromotionVO promotion) {
//    	for(int i=0;i<promotionList.size();i++){
//			if(promotionList.get(i).getID().equals(promotion.getID())){
//				promotionList.set(i,promotion);
//			}
//		}
//		return true;
//	}
//
//    public ArrayList<PromotionVO> getPromotionList() {
//		return promotionList;
//    }
}
