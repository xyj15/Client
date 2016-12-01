package po;

import bl.implementation.Credit;
import other.Enterprise;
import other.MemberType;
import other.User;
import other.UserType;

import java.util.ArrayList;
import java.util.Date;

public class MemberPO extends User {
	
	private String name;
	private String tel;
	private Credit credit;
	private int level;
	private double discount;
	private MemberType memberType;
	private Date birthday;
	private String enterprise;
	
	public MemberPO() {
		credit = null;
		memberType = null;
		birthday = null;
	}
	
	public MemberPO(String name, String tel, Credit credit, int level, double discount,
					MemberType memberType, Date birthday, String enterprise) {
		this.name = name;
		this.tel = tel;
		this.credit = credit;
		this.level = level;
		this.discount = discount;
		this.memberType = memberType;
		this.birthday = birthday;
		this.enterprise = enterprise;
	}
	
	public MemberPO(String userID, String password, String name, String tel, Credit credit,
					int level, double discount, MemberType memberType, Date birthday, String enterprise) {
		super(userID, password, UserType.Member);
		this.name = name;
		this.tel = tel;
		this.credit = credit;
		this.level = level;
		this.discount = discount;
		this.memberType = memberType;
		this.birthday = birthday;
		this.enterprise = enterprise;
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
}