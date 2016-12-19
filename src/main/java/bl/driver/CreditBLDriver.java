package bl.driver;

import bl.service.CreditBLService;
import bl.stub.CreditBLStub;

/**
 * Created by CROFF on 2016/12/7.
 */
public class CreditBLDriver {
	
	private CreditBLService creditBLService = new CreditBLStub();
	
	public void drive() {
		System.out.println(creditBLService.getCredit());
		System.out.println(creditBLService.getCreditChangeList());
		System.out.println(creditBLService.checkCredit());
	}
	
	public static void main(String[] args) {
		CreditBLDriver creditBLDriver = new CreditBLDriver();
		creditBLDriver.drive();
	}
}
