package bl.implementation;

import java.sql.Date;
import java.util.ArrayList;

import bl.service.MemberBLService;
import vo.MemberVO;
import vo.OrderVO;
import other.*;


public class Member extends User implements MemberBLService {
	
	public Order ordermanager = new Order();

	private ArrayList<OrderVO> orderList;

	private String name;
	private Date birthday;
	private String phone;
	private MemberVO memberVO;
	private MemberType type;
	private Enterprise enterprise;
	private Credit credit;

	private int level;
	private double discount;
	
	private Search search;

	public Member(){};
	public Member(String ID,String password,Date birthday,String name,String phone,
			Double credit,MemberType type,Enterprise enterprise) {
		setID(ID);
		setPassword(password);
		setName(name);
		this.birthday=birthday;
		setPhone(phone);
		this.credit=new Credit(credit);
		setType(type);
		setEnterprise(enterprise);
	}

	public MemberVO getMInformation (String memberID) {
		return memberVO;
	}
	
	public boolean saveMInformation (String memberID, MemberVO M) {
		if(memberID.equals(ID)){
			setMemberVO(memberVO);
			return true;
		}
		return false;
	}

	public OrderVO getOrder(String orderID) {
		// TODO Auto-generated method stub
		return ordermanager.getOrder(orderID);
	}

	public ArrayList<OrderVO> gerOrderList(String userID) {
		// TODO Auto-generated method stub
		if(ID.equals(userID)){
			return ordermanager.getOrderList();
		} else {
			return null;
		}
	}

	public void cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<OrderVO> getUnOrder(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getAlOrder(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getAandCOrder(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void startSearch() {
		search = new Search(memberVO);
	}
	
	public String getPassword() {
		return passWord;
	}
	
	public void setPassword(String password) {
		this.passWord = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	public Search getSearch() {
		return search;
	}
	
	public void setSearch(Search search) {
		this.search = search;
	}
}