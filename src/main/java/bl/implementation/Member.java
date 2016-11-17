package bl.implementation;

import java.util.ArrayList;
import java.util.List;

import bl.service.MemberBLService;
import vo.MemberVO;
import vo.OrderVO;

public class Member extends User implements MemberBLService {
	
	public Order ordermanager = new Order();
	
	private String name;
	private String birthday;
	private String phone;
	private double credit;
	private MemberVO vo;
	private List<String> creditList;
	public Member(String ID,String password,String birthday,String name,String phone,double credit) {
		setID(ID);
		setPassword(password);
		this.name=name;
		this.birthday=birthday;
		this.phone=phone;
		this.credit=credit;
		//creditList.add(""+credit);
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
	@Override
	public String getCredit(String memberID) {
		// TODO Auto-generated method stub
		return ""+credit;
	}
	@Override
	public boolean updateCredit(String memberID, double newCredit) {
		// TODO Auto-generated method stub
		if(memberID.equals(ID)){
			setCredit(newCredit);
			//creditList.add(""+credit);
			return true;
		}
		return false;
	}
	@Override
	public boolean checkCredit(String memberID) {
		// TODO Auto-generated method stub
		if(credit>=0){
			return true;
		}
		return false;
	}
	@Override
	public OrderVO getOrder(String orderID) {
		// TODO Auto-generated method stub
		return ordermanager.getOrder(orderID);
	}
	@Override
	public List<OrderVO> gerOrderList(String userID) {
		// TODO Auto-generated method stub
		if(ID.equals(userID)){
			return ordermanager.getOrderList();
		} else {
			return null;
		}
	}
	@Override
	public void cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<OrderVO> getUnOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrderVO> getAlOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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

	
}