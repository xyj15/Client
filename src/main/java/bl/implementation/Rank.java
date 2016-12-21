package bl.implementation;

import data.service.RankDataService;
import data.stub.RankDataStub;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 * 存储会员等级制度相关信息的类
 * @author CROFF
 * @version 2016-11-29
 */
public class Rank {
    
	private ArrayList<Double> creditList;	//会员升级所需信用表
    private ArrayList<Double> discountList;	//会员各等级享受折扣表
	
	private RankDataService rankDataService;
	
	public Rank() {
		rankDataService = new RankDataStub();
//		rankDataService = RemoteHelper.getInstance().getRankDataService();
		updateDataFromFile();
	}
	
	/**
	 * 根据信用值获得会员等级
	 * @param credit 会员信用值
	 * @return 会员等级
	 */
	public int getLevel(double credit) {
		updateDataFromFile();
		int level;
		for(level = 0; level<creditList.size(); level++) {
			if(credit<creditList.get(level)) {
				break;
			}
		}
		return level+1;
    }
	
	/**
	 * 根据信用值获得会员等级折扣
	 * @param credit 会员信用值
	 * @return 折扣
	 */
	public double getDiscount(double credit) {
		updateDataFromFile();
		int level = getLevel(credit);
		if(level==1) {
			return 1;
		} else {
			return discountList.get(level-2);
		}
	}
	
	/**
	 * 重新设置会员等级制度和折扣
	 * @param creditList 会员升级所需信用表
	 * @param discountList 会员各等级享受折扣表
	 * @return 设置成功返回true，否则返回false
	 */
	public boolean setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList) {
		this.creditList = creditList;
		this.discountList = discountList;
		return updateDataToFile();
	}
	
	/**
	 * 获取客户升级所需信用表
	 * @return 客户升级所需信用表
	 */
	public ArrayList<Double> getCreditList() {
		return creditList;
	}
	
	/**
	 * 获取客户每级享受的折扣表
	 * @return 客户每级享受的折扣表
	 */
	public ArrayList<Double> getDiscountList() {
		return discountList;
	}
	
	/**
	 * 从数据层更新数据
	 */
	public void updateDataFromFile() {
		try {
			creditList = rankDataService.getCreditList();
			discountList = rankDataService.getDiscountList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将数据更新到数据层
	 * @return 更新成功则返回true，否则false
	 */
	public boolean updateDataToFile() {
		try {
			if(rankDataService.updateCreditList(creditList) && rankDataService.updateDiscountList(discountList)) {
				return true;
			} else {
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
}
