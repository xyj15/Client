package bl.driver;

import bl.service.PromotionBLService;
import bl.stub.PromotionBLStub;
import vo.PromotionVO;

public class PromotionBLDriver {

	PromotionBLService promotionBLService = new PromotionBLStub();

	public void drive() {
		System.out.println(promotionBLService.addPromotion(new PromotionVO()));
		System.out.println(promotionBLService.deletePromotion("12345"));
		System.out.println(promotionBLService.getHotelPromotionList("123456"));
		System.out.println(promotionBLService.getPromotion("12345"));
		System.out.println(promotionBLService.getWebPromotionList());
		System.out.println(promotionBLService.updatePromotion(new PromotionVO()));
		System.out.println(promotionBLService.getDistrictPromotionList());
		System.out.println(promotionBLService.getEnterprisePromotionList());
		System.out.println(promotionBLService.getHotelDatePromotionList());
		System.out.println(promotionBLService.getWebDatePromotionList());
	}

	public static void main(String[] args) {
		PromotionBLDriver promotionBLDriver = new PromotionBLDriver();
		promotionBLDriver.drive();
	}

}
