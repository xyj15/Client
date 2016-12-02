package vo;

import bl.implementation.Credit;
import other.MemberType;
import other.User;
import other.UserType;

import java.util.ArrayList;
import java.util.Date;

/**
 * 存储Member信息的VO类
 * @author CROFF
 * @version 2016-12-1
 */
public class MemberVO extends User {

	private String name;	//姓名或名称
	private String tel;	//联系方式
	private Credit credit;	//信用和信用变化情况
	private int level;	//会员等级
	private double discount;	//当前会员等级享受折扣
	private MemberType memberType;	//客户类型
	private Date birthday;	//生日
	private String enterprise;	//合作企业名称
	private ArrayList<OrderVO> orderList;	//订单列表
	private ArrayList<HotelVO> reservedHotelList;	//预定过的酒店列表
	
	/**
	 * 空构造方法
	 */
	public MemberVO() {
		credit = null;
		memberType = null;
		birthday = null;
		enterprise = null;
		orderList = new ArrayList<OrderVO>();
		reservedHotelList = new ArrayList<HotelVO>();
		super.setUserType(UserType.Member);
	}
	
	/**
	 * 无用户名和密码的构造方法
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 * @param credit 信用和信用变化情况
	 * @param level 会员等级
	 * @param discount 当前会员等级享受折扣
	 * @param memberType 客户类型
	 * @param birthday 生日
	 * @param enterprise 合作企业名称
	 * @param orderList 订单列表
	 * @param reservedHotelList 预定过的酒店列表
	 */
	public MemberVO(String name, String tel, Credit credit, int level, double discount, MemberType memberType,
					Date birthday, String enterprise, ArrayList<OrderVO> orderList, ArrayList<HotelVO> reservedHotelList) {
		this.name = name;
		this.tel = tel;
		this.credit = credit;
		this.level = level;
		this.discount = discount;
		this.memberType = memberType;
		this.birthday = birthday;
		this.enterprise = enterprise;
		this.orderList = orderList;
		this.reservedHotelList = reservedHotelList;
		super.setUserType(UserType.Member);
	}
	
	/**
	 * 有用户名和密码的构造方法
	 * @param userID 用户名
	 * @param password 密码
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 * @param credit 信用和信用变化情况
	 * @param level 会员等级
	 * @param discount 当前会员等级享受折扣
	 * @param memberType 客户类型
	 * @param birthday 生日
	 * @param enterprise 合作企业名称
	 * @param orderList 订单列表
	 * @param reservedHotelList 预定过的酒店列表
	 */
	public MemberVO(String userID, String password, String name, String tel, Credit credit,
					int level, double discount, MemberType memberType, Date birthday, String enterprise,
					ArrayList<OrderVO> orderList, ArrayList<HotelVO> reservedHotelList) {
		super(userID, password, UserType.Member);
		this.name = name;
		this.tel = tel;
		this.credit = credit;
		this.level = level;
		this.discount = discount;
		this.memberType = memberType;
		this.birthday = birthday;
		this.enterprise = enterprise;
		this.orderList = orderList;
		this.reservedHotelList = reservedHotelList;
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
	
	public Credit getCredit() {
		return credit;
	}
	
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public MemberType getMemberType() {
		return memberType;
	}
	
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getEnterprise() {
		return enterprise;
	}
	
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	
	public ArrayList<OrderVO> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<OrderVO> orderList) {
		this.orderList = orderList;
	}
	
	public ArrayList<HotelVO> getReservedHotelList() {
		return reservedHotelList;
	}
	
	public void setReservedHotelList(ArrayList<HotelVO> reservedHotelList) {
		this.reservedHotelList = reservedHotelList;
	}
}