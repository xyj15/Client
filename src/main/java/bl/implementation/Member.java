package bl.implementation;

import bl.dataservice.MemberDataService;
import bl.service.MemberBLService;
import other.*;
import po.MemberPO;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;


public class Member implements MemberBLService {
	
	private MemberVO memberVO;
	private MemberPO memberPO;
	private MemberDataService memberDataService;
	private Search search;
	private Reserve reserve;
	private Order order;

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
	public ArrayList<CreditChange> getCreditChangeList() {
		return null;
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
	public boolean updateMemberInformation(MemberVO memberVO) {
		return false;
	}
	
	@Override
	public boolean startSearch() {
		search = new Search(memberVO);
		return false;
	}
	
	@Override
	public boolean newReservation(String hotelID, String roomID) {
		reserve = new Reserve(memberVO);
		return false;
	}
	
	@Override
	public boolean showOrder() {
		return false;
	}
	
	@Override
	public boolean markHotel() {
		return false;
	}
	
	@Override
	public boolean CreateOrder(OrderVO orderVO) {
		return false;
	}
}