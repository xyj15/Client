package ui.presentation;

import vo.PromotionVO;

public class PromotionUI {
	private class promotion_main{
		protected PromotionVO getPromotion(String promotionID){
			return null;
		}
	    protected boolean addPromotion(PromotionVO promotion) {
			return true;
		}
	    protected boolean delPromotion(PromotionVO promotion) {
			return true;
		}
	    protected boolean changePromotion(PromotionVO promotion) {
			return true;
		}
	    protected PromotionVO[] getPromotionList() {
			return null;
	    }

	}
}

