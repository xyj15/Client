package bl.implementation;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 */
public class Rank {
    private  double creditPerLevel=1000;
    private ArrayList<Double> discountList = new ArrayList<Double>();

    private static Rank rank=new Rank();

    private Rank(){ }

    public static Rank getInstance(){
        return rank;
    }

    public int getLevel(Double credit){
        return 1;
    }

    public void setCreditPerLevel(double creditPerLevel) {
        rank.creditPerLevel = creditPerLevel;
    }

    public double getCreditPerLevel() {
        return rank.creditPerLevel;
    }

    public void setDiscountList(ArrayList<Double> discountList) {
        rank.discountList = discountList;
    }
}
