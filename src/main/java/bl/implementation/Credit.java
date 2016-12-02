package bl.implementation;

import data.service.CreditDataService;
import bl.service.CreditBLService;
import vo.CreditChangeVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 * Credit模块的bl实现类
 * @author CROFF
 * @version 2016-12-1
 */
public class Credit implements CreditBLService {

	private double credit;
    private ArrayList<CreditChangeVO> creditChangeList;
	private CreditDataService creditDataService;

	public Credit() {
		
	}
	
    public Credit(String memberID) {
        
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
}
