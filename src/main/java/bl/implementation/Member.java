package bl.implementation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bl.service.MemberBLService;
import vo.MemberVO;
import vo.OrderVO;
import setup.*;


public class Member extends User implements MemberBLService {
	
	public Order ordermanager = new Order();
	public Search searchmanager =new Search();
	
	private String name;
	private Date birthday;
	private String phone;
	private double credit;
	private MemberVO vo;
	private List<String> creditList;
	private MemberType type;
	private Enterprise enterprise;
	
	public Member(String ID,String password,Date birthday,String name,String phone,
			double credit,MemberType type,Enterprise enterprise) {
		
		setID(ID);
		setPassword(password);
		this.name=name;
		this.birthday=birthday;
		this.phone=phone;
		this.credit=credit;
		creditList.add(""+credit);
		setType(type);
		setEnterprise(enterprise);
	}

	public MemberVO getMInformation (String memberID) {
		return vo;
	}
	
	public boolean saveMInformation (String memberID, MemberVO M) {
		if(memberID.equals(ID)){
			setVo(vo);
			return true;
		}
		return false;
	}
	
	public List<String> getCreditList (String memberID) {
		return creditList;
	}
	
	public String getCredit(String memberID) {
		// TODO Auto-generated method stub
		return ""+credit;
	}
	
	public boolean updateCredit(String memberID, double newCredit) {
		// TODO Auto-generated method stub
		if(memberID.equals(ID)){
			setCredit(newCredit);
			creditList.add(""+credit);
			return true;
		}
		return false;
	}
	
	public boolean checkCredit(String memberID) {
		// TODO Auto-generated method stub
		if(credit>=0){
			return true;
		}
		return false;
	}

	public OrderVO getOrder(String orderID) {
		// TODO Auto-generated method stub
		return ordermanager.getOrder(orderID);
	}

	public List<OrderVO> gerOrderList(String userID) {
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

	public ArrayList<OrderVO> getUnOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getAlOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getAandCOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
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
	
	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public MemberVO getVo() {
		return vo;
	}

	public void setVo(MemberVO vo) {
		this.vo = vo;
	}

	public List<String> getCreditList() {
		return creditList;
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

}