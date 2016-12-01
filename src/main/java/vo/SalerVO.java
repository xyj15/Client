package vo;

import other.User;
import po.PromotionPO;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerVO extends User {
	
	private String name;
	private String tel;
	private ArrayList<PromotionVO> promotionList;	//网站促销策略列表
	private ArrayList<OrderVO> dailyOrderList;	//当天所有订单列表

    public SalerVO(String name, String tel, ArrayList<PromotionVO> promotionList, ArrayList<OrderVO> dailyOrderList) {
		this.name = name;
		this.tel = tel;
		this.promotionList = promotionList;
		this.dailyOrderList =dailyOrderList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public ArrayList<PromotionVO> getPromotionList() {
		return promotionList;
	}
	
	public void setPromotionList(ArrayList<PromotionVO> promotionList) {
		this.promotionList = promotionList;
	}
	
	public ArrayList<OrderVO> getDailyOrderList() {
		return dailyOrderList;
	}
	
	public void setDailyOrderList(ArrayList<OrderVO> dailyOrderList) {
		this.dailyOrderList = dailyOrderList;
	}
}
