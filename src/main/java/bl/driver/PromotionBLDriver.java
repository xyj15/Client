package bl.driver;

import bl.service.PromotionBLService;
import bl.stub.PromotionBLStub;
import vo.DateVO;
import vo.PromotionVO;

public class PromotionBLDriver {
	
	PromotionBLService promotion = new PromotionBLStub();
	
	public void drive(PromotionVO uservo){
		System.out.println(promotion.addPromotion(uservo));
		System.out.println(promotion.changePromotion(uservo));
		System.out.println(promotion.delPromotion(uservo));
		System.out.println(promotion.getPromotion("12345678"));
		System.out.println(promotion.getPromotionList());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PromotionBLDriver driver =new PromotionBLDriver();
		driver.drive(new PromotionVO(new DateVO(1997, 03, 04), 1, false, new DateVO(2015, 03, 21), false,"12345678", 0.8, null));
	}
	
}
