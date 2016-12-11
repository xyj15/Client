package bl.driver;

import bl.service.SalerBLService;
import bl.stub.SalerBLStub;
import vo.PromotionVO;
import vo.SalerVO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/7.
 */
public class SalerBLDriver {
	
	private SalerBLService salerBLService = new SalerBLStub();
	
	public void drive() {
		System.out.println(salerBLService.getPromotionList());
		System.out.println(salerBLService.getPromotion("12345"));
		System.out.println(salerBLService.getDailyUnexcutedOrderList());
		System.out.println(salerBLService.getSalerInformation());
		System.out.println(salerBLService.createPromotion(new PromotionVO()));
		System.out.println(salerBLService.cancelAbnormalOrder("1991121208091012345678", 0.5));
		System.out.println(salerBLService.creditRecharge("12345678", 100));
		System.out.println(salerBLService.deletePromotion("12345"));
		System.out.println(salerBLService.updatePromotion(new PromotionVO()));
		System.out.println(salerBLService.setSalerInformation(new SalerVO()));
		System.out.println(salerBLService.setRankInformation(new ArrayList<Double>(), new ArrayList<Double>()));
		System.out.println(salerBLService.getCreditList());
		System.out.println(salerBLService.getDiscountList());
	}
	
	public static void main(String[] args) {
		SalerBLDriver salerBLDriver = new SalerBLDriver();
		salerBLDriver.drive();
	}
}
