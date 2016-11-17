package bl.stub;

import java.util.ArrayList;
import java.util.List;

import bl.service.MemberBLService;
import vo.MemberVO;
import vo.OrderVO;

public class MemberBLStub implements MemberBLService {

	String memberID;
	String name;
	String level;
	String pass;
	double credit;
	String phone;
	String birth;

	public MemberBLStub(String level,String memberID,String pass,String name,String birth,String phone,double credit) {
		this.memberID = memberID;
		this.name = name;
		this.level = level;
		this.credit = credit;
		this.phone = phone;
		this.pass = pass;
		this.birth = birth;
	}
	
	public MemberVO getMInformation(String memberID) {
		// TODO Auto-generated method stub
		return new MemberVO(memberID,pass, name, birth, phone, credit);
	}

	public boolean saveMInformation(String memberID, MemberVO M) {
		// TODO Auto-generated method stub
		System.out.println("用户信息保存成功");
		return true;
	}

	public List<String> getCreditList(String memberID) {
		// TODO Auto-generated method stub
		ArrayList<String> creditList = new ArrayList<String>();
		creditList.add("2016-10-01			+100");
		return creditList;
	}

	public String getCredit(String memberID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCredit(String memberID, double newCredit) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkCredit(String memberID) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderVO getOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> gerOrderList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		
	}

	public List<OrderVO> getUnOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getAlOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getAandCOrder(ArrayList<OrderVO> orderList) {
		// TODO Auto-generated method stub
		return null;
	}

}
