package bl.implementation;

import java.util.ArrayList;

import bl.service.PromotionBLService;
import vo.PromotionVO;

public class Promotion implements PromotionBLService {
	private String ID;
	private ArrayList<PromotionVO> promotionList=new ArrayList<PromotionVO>();
	
	public PromotionVO getPromotion(String promotionID){
		for(int i=0;i<promotionList.size();i++){
			if(promotionList.get(i).getID().equals(promotionID)){
				return promotionList.get(i);
			}
		}
		return null;
	}
	
    public boolean addPromotion(PromotionVO promotion) {
    	promotionList.add(promotion);
		return true;
	}
    
    public boolean delPromotion(PromotionVO promotion) {
    	promotionList.remove(promotion);
		return true;
	}
    
    public boolean changePromotion(PromotionVO promotion) {
    	for(int i=0;i<promotionList.size();i++){
			if(promotionList.get(i).getID().equals(promotion.getID())){
				promotionList.set(i,promotion);
			}
		}
		return true;
	}
    
    public ArrayList<PromotionVO> getPromotionList() {
		return promotionList;
    }
    
    public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
}
