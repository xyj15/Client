package bl.implementation;

import bl.dataservice.RankDataService;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 * 存储会员等级制度相关信息的类
 * @author CROFF
 * @version 2016-11-29
 */
public class Rank {
    
	private RankDataService rankDataService;
    private ArrayList<Double> creditList;
    private ArrayList<Double> discountList;
    private static Rank rank = new Rank();
	
	public static Rank getInstance(){
        return rank;
    }
	
	public Rank() {
		
	}
	
	public int getLevel(double credit){
        return 0;
    }
    
    public double getDiscount(double credit) {
		return 0;
	}
}
