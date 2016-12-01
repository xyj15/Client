package vo;

import bl.implementation.Credit;
import other.Enterprise;
import other.MemberType;
import other.User;
import other.UserType;
import po.OrderPO;

import java.util.ArrayList;
import java.util.Date;

public class MemberVO extends User {

	private String name;
	private String tel;
	private Credit credit;
	private int level;
	private double discount;
	private MemberType memberType;
	private Date birthday;
	private String enterprise;
	private ArrayList<OrderVO> orderList;
	private ArrayList<HotelVO> reservedHotelList;
	
	public MemberVO() {
		credit = null;
		memberType = null;
		birthday = null;
		enterprise = null;
		orderList = new ArrayList<OrderVO>();
		reservedHotelList = new ArrayList<HotelVO>();
	}
	
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
	}
	
	public MemberVO(String username, String password, String name, String tel, Credit credit,
					int level, double discount, MemberType memberType, Date birthday, String enterprise,
					ArrayList<OrderVO> orderList, ArrayList<HotelVO> reservedHotelList) {
		super(username, password, UserType.Member);
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