package data.driver;

import data.service.PromotionDataService;
import data.stub.PromotionDataStub;
import other.PromotionType;
import po.PromotionPO;

/**
 * Created by CROFF on 2016/12/9.
 */
public class PromotionDataDriver {
	
	private PromotionDataService promotionDataService = new PromotionDataStub();
	
	public void drive() {
		System.out.println(promotionDataService.getAvailablePromotionID());
		System.out.println(promotionDataService.addPromotion(new PromotionPO("00000", "生日特惠", PromotionType.Discount)));
		System.out.println(promotionDataService.deletePromotion("00000"));
		System.out.println(promotionDataService.getPromotion("00000"));
		System.out.println(promotionDataService.getPromotionList());
		System.out.println(promotionDataService.updatePromotion(new PromotionPO("00000", "生日特惠", PromotionType.Discount)));
	}
	
	public static void main(String[] args) {
		PromotionDataDriver promotionDataDriver = new PromotionDataDriver();
		promotionDataDriver.drive();
	}
}
