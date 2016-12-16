package data.stub;

import data.service.CreditDataService;
import other.OrderAction;
import po.CreditChangePO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class CreditDataStub implements CreditDataService {
	
	private double credit = 0;
	private ArrayList<CreditChangePO> creditChangeList = new ArrayList<>();
	
	public CreditDataStub() {
		String orderID = "1234567890123456789012";
		CreditChangePO creditChange1 = new CreditChangePO(new Date(), orderID, OrderAction.CancelOrder, -50, 50);
		CreditChangePO creditChange2 = new CreditChangePO(new Date(), orderID, OrderAction.RechargeCredit, 100, 150);
		CreditChangePO creditChange3 = new CreditChangePO(new Date(), orderID, OrderAction.ExecuteOrder, 300, 450);
		CreditChangePO creditChange4 = new CreditChangePO(new Date(), orderID, OrderAction.CancelOrder, -200, 250);
		creditChangeList.add(creditChange1);
		creditChangeList.add(creditChange2);
		creditChangeList.add(creditChange3);
		creditChangeList.add(creditChange4);
	}
	
	@Override
	public double getCredit(String memberID) {
		System.out.println("获取信用成功");
		return credit;
	}
	
	@Override
	public ArrayList<CreditChangePO> getCreditChange(String memberID) {
		System.out.println("获取信用变化列表成功");
		return creditChangeList;
	}
	
	@Override
	public boolean setCredit(String memberID, double credit) {
		System.out.println("设置信用成功");
		this.credit = credit;
		return true;
	}
	
	@Override
	public boolean addCreditChange(String memberID, CreditChangePO creditChange) {
		System.out.println("添加信用变化成功");
		creditChangeList.add(creditChange);
		credit = creditChange.getResult();
		return true;
	}
}
