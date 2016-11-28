package bl.implementation;

import other.CreditChange;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 */
public class Credit {

    private double credit;
    private ArrayList<Double> creditChangeList;

    public  Credit(double credit){
        this.credit = credit;
        creditChangeList = new ArrayList<Double>();
    }
    
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
