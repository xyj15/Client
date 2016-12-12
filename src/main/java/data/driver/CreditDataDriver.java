package data.driver;

import data.service.CreditDataService;
import data.stub.CreditDataStub;
import other.OrderAction;
import po.CreditChangePO;

import java.util.Date;

/**
 * Created by CROFF on 2016/12/8.
 */
public class CreditDataDriver {
	
	private CreditDataService creditDataService = new CreditDataStub();
	
	public void drive() {
		System.out.println(creditDataService.getCredit(null));
		System.out.println(creditDataService.getCreditChange(null));
		System.out.println(creditDataService.setCredit(null, 0));
		System.out.println(creditDataService.addCreditChange(null, new CreditChangePO(new Date(), "", OrderAction.CancelOrder, 50, 50)));
	}
	
	public static void main(String[] args) {
		CreditDataDriver creditDataDriver = new CreditDataDriver();
		creditDataDriver.drive();
	}
}
