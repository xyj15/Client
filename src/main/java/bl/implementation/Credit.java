package bl.implementation;

import data.service.CreditDataService;
import bl.service.CreditBLService;
import other.OrderAction;
import po.CreditChangePO;
import vo.CreditChangeVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 97147 on 2016/11/18.
 * Credit模块的bl实现类
 * @author CROFF
 * @version 2016-12-1
 */
public class Credit implements CreditBLService {

	private String memberID;
	private double credit;
    private ArrayList<CreditChangeVO> creditChangeList;
	private CreditDataService creditDataService;

	public Credit() {
		
	}
	
    public Credit(String memberID) {
		this.memberID = memberID;
        credit = creditDataService.getCredit(memberID);
    }
	
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		return creditChangeList;
	}
	
	@Override
	public double getCredit() {
		return credit;
	}
	
	public void creditChange(CreditChangeVO creditChange) {
		
	}

    public boolean checkCredit() {
        if(credit>=0) {
            return true;
        } else {
			return false;
		}
    }
    
    public void updateCreditChangeList() {
		ArrayList<CreditChangePO> creditChangePOList = creditDataService.getCreditChange(memberID);
		creditChangeList = new ArrayList<CreditChangeVO>();
		for(int i=0; i<creditChangePOList.size(); i++) {
			CreditChangePO creditChangePO = creditChangePOList.get(i);
			Date date = creditChangePO.getDate();
			String orderID = creditChangePO.getOrderID();
			OrderAction orderAction = creditChangePO.getOrderAction();
			double change = creditChangePO.getChange();
			double result = creditChangePO.getResult();
			CreditChangeVO creditChangeVO = new CreditChangeVO(date, orderID,
					orderAction, change, result);
			creditChangeList.add(creditChangeVO);
		}
	}
}
