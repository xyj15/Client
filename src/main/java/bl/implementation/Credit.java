package bl.implementation;

import bl.service.CreditBLService;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 */
public class Credit implements CreditBLService{

    private CreditChange creditChange=new CreditChange();
    private Double credit;
    private ArrayList<Double> creditList=creditChange.getCreditList();


    public  Credit(Double Credit){
        credit=Credit;
        //creditList.add(credit);
    }



    @Override
    public Double getCredit() {
        return credit;
    }

    @Override
    public boolean updateCredit(double newCredit) {
        setCredit(newCredit);
        creditList.add(credit);
        return true;
    }

    @Override
    public boolean checkCredit() {
        if(credit>=0){
            return true;
        }
        return false;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
