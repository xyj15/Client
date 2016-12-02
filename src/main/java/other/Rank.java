package other;

import data.service.RankDataService;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 * 存储会员等级制度相关信息的类
 * @author CROFF
 * @version 2016-11-29
 */
public class Rank {
    
	private RankDataService rankDataService;
    private ArrayList<Double> creditList;	//会员升级所需信用表
    private ArrayList<Double> discountList;	//会员各等级享受折扣表
	
    private static Rank rank = new Rank();
	public static Rank getInstance(){
        return rank;
    }
	
	/**
	 * 根据信用值获得会员等级
	 * @param credit 会员信用值
	 * @return 会员等级
	 */
	public int getLevel(double credit){
        return 0;
    }
	
	/**
	 * 根据信用值获得会员等级折扣
	 * @param credit 会员信用值
	 * @return 折扣
	 */
	public double getDiscount(double credit) {
		return 0;
	}
}
