package vo;

import other.User;
import other.UserType;
import po.PromotionPO;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 * 存储Saler信息的VO类
 * @author CROFF
 * @version 2016-12-1
 */
public class SalerVO extends User {
	
	private String name;	//姓名或名称
	private String tel;	//联系方式
	private ArrayList<PromotionVO> promotionList;	//网站促销策略列表
	private ArrayList<OrderVO> dailyOrderList;	//当天所有订单列表
	
	/**
	 * 空构造方法
	 */
	public SalerVO() {
		promotionList = new ArrayList<PromotionVO>();
		dailyOrderList = new ArrayList<OrderVO>();
		super.setUserType(UserType.Saler);
	}
	
	/**
	 * 无用户名和密码的构造方法
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 * @param promotionList 网站营销策略列表
	 * @param dailyOrderList 当天所有订单列表
	 */
    public SalerVO(String name, String tel, ArrayList<PromotionVO> promotionList, ArrayList<OrderVO> dailyOrderList) {
		this.name = name;
		this.tel = tel;
		this.promotionList = promotionList;
		this.dailyOrderList = dailyOrderList;
		super.setUserType(UserType.Saler);
	}
	
	/**
	 * 有用户名和密码的构造方法
	 * @param username 用户名
	 * @param password 密码
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 * @param promotionList 网站营销策略列表
	 * @param dailyOrderList 当天所有订单列表
	 */
	public SalerVO(String username, String password, String name, String tel,
				   ArrayList<PromotionVO> promotionList, ArrayList<OrderVO> dailyOrderList) {
		super(username, password, UserType.Saler);
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
