package vo;

import other.MemberType;
import other.User;
import other.UserType;

import java.util.Date;

/**
 * 存储Member信息的VO类
 * @author CROFF
 * @version 2016-12-1
 */
public class MemberVO extends User {

	private String name;	//姓名或名称
	private String tel;	//联系方式
	private int level;	//会员等级
	private double discount;	//当前会员等级享受折扣
	private MemberType memberType;	//客户类型
	private Date birthday;	//生日
	private String enterprise;	//合作企业名称
	
	/**
	 * 空构造方法
	 */
	public MemberVO() {
		memberType = null;
		birthday = null;
		enterprise = null;
		super.setUserType(UserType.Member);
	}
	
	/**
	 * 无用户名和密码的构造方法
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 * @param level 会员等级
	 * @param discount 当前会员等级享受折扣
	 * @param memberType 客户类型
	 * @param birthday 生日
	 * @param enterprise 合作企业名称
	 */
	public MemberVO(String name, String tel, int level, double discount,
					MemberType memberType, Date birthday, String enterprise) {
		this.name = name;
		this.tel = tel;
		this.level = level;
		this.discount = discount;
		this.memberType = memberType;
		this.birthday = birthday;
		this.enterprise = enterprise;
		super.setUserType(UserType.Member);
	}
	
	/**
	 * 有用户名和密码的构造方法
	 * @param userID 用户名
	 * @param password 密码
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 * @param level 会员等级
	 * @param discount 当前会员等级享受折扣
	 * @param memberType 客户类型
	 * @param birthday 生日
	 * @param enterprise 合作企业名称
	 */
	public MemberVO(String userID, String password, String name, String tel, int level,
					double discount, MemberType memberType, Date birthday, String enterprise) {
		super(userID, password, UserType.Member);
		this.name = name;
		this.tel = tel;
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