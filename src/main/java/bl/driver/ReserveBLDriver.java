package bl.driver;

import bl.implementation.Reserve;
import bl.service.ReserveBLService;
import bl.stub.ReserveBLStub;
import vo.*;

public class ReserveBLDriver {

	ReserveBLService reservebl = new ReserveBLStub();
	
	public void drive(Reserve reserve) {
		reserve.setDate(new DateVO(2016, 12, 5));
		reserve.setDays(1);
		reserve.setPromotion(new PromotionVO(new DateVO(1997, 06, 01), 5, false, new DateVO(2016, 10, 02), true, "南京市新街口", 0.8, "0011"));
		reserve.getPrice();
	}
	
	public static void main(String[] args) {
		ReserveBLDriver driver = new ReserveBLDriver();
		driver.drive(new Reserve(500));
	}
	
}
