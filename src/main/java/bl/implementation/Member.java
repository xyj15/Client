package bl.implementation;

import bl.dataservice.MemberDataService;
import bl.service.MemberBLService;
import other.Date;
import other.Enterprise;
import other.MemberType;
import other.User;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;


public class Member extends User implements MemberBLService {
	
	private MemberVO memberVO;
	private ArrayList<OrderVO> orderList;
	private MemberDataService memberDataService;
	private Search search;
	private Reserve reserve;

	public Member(){
		
	}
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public String getTel() {
		return null;
	}
	
	@Override
	public double getCredit() {
		return 0;
	}
	
	@Override
	public int getLevel() {
		return 0;
	}
	
	@Override
	public double getDiscount() {
		return 0;
	}
	
	@Override
	public MemberType getMemberType() {
		return null;
	}
	
	@Override
	public Date getBirthday() {
		return null;
	}
	
	@Override
	public Enterprise getEnterprise() {
		return null;
	}
	
	@Override
	public MemberVO getMemberInformation() {
		return null;
	}
	
	@Override
	public boolean setMemberInformation(MemberVO memberVO) {
		return false;
	}
	
	@Override
	public ArrayList<OrderVO> getAllOrder() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getExcutedOrder() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getAbnormalOrder() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getCanceledOrder() {
		return null;
	}
	
	@Override
	public void cancelOrder(String orderID) {
		
	}
	
	@Override
	public void evaluateOrder(double score, String comment) {
		
	}
	
	@Override
	public void startSearch() {
		search = new Search(memberVO);
	}
	
	@Override
	public void newReservation() {
		reserve = new Reserve(memberVO);
	}
}