package bl.implementation;

import data.service.MemberDataService;
import bl.service.MemberBLService;

import other.MemberType;
import po.MemberPO;
import vo.CreditChangeVO;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Member模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Member implements MemberBLService {
	
	private MemberVO memberVO;
	private MemberPO memberPO;
	private MemberDataService memberDataService;
	private Search search;
	private Reserve reserve;
	private Order order;

	public Member(String memberID) {
		
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
	public ArrayList<CreditChangeVO> getCreditChangeList() {
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
	public String getEnterprise() {
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
	public boolean newReservation(String hotelID, String roomID) {
		reserve = new Reserve(memberVO.getUserID());
		return false;
	}
	
	@Override
	public boolean markHotel(String hotelID) {
		return false;
	};
	
	@Override
	public boolean CreateOrder(OrderVO orderVO) {
		return false;
	}
}