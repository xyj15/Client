package bl.stub;

import bl.service.CreditBLService;
import other.OrderAction;
import vo.CreditChangeVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class CreditBLStub implements CreditBLService {
	
	private String memberID;
	
	public CreditBLStub() {
		memberID = null;
	}
	
	public CreditBLStub(String memberID) {
		this.memberID = memberID;
	}
	
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		System.out.println("获取信用变化列表成功");
		ArrayList<CreditChangeVO> creditChangeList = new ArrayList<CreditChangeVO>();
		CreditChangeVO creditChange = new CreditChangeVO(new Date(), "20161101000000", OrderAction.ExecuteOrder, 100, 100);
		creditChangeList.add(creditChange);
		creditChange = new CreditChangeVO(new Date(), "20161102000000", OrderAction.ExecuteOrder, 100, 200);
		creditChangeList.add(creditChange);
		return creditChangeList;
	}
	
	@Override
	public double getCredit() {
		System.out.println("获取信用成功");
		return 100;
	}
	
	@Override
	public boolean checkCredit() {
		System.out.println("检查信用成功");
		return true;
	}
}
