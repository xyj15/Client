package bl.implementation;

import bl.service.CreditBLService;
import other.CreditChange;
import vo.MemberVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 */
public class Credit implements CreditBLService {

	private MemberVO memberVO;
    private double credit;
    private ArrayList<Double> creditChangeList;

	public Credit() {
		
	}
	
    public Credit(String memberID) {
        creditChangeList = new ArrayList<Double>();
    }
	
	@Override
	public ArrayList<CreditChange> getCreditChangeList() {
		return null;
	}
	
	@Override
	public double getCredit() {
		return credit;
	}
	
	public void creditChange(CreditChange creditChange) {
		
	}

    public boolean checkCredit() {
        if(credit>=0){
            return true;
        }
        return false;
    }
}
