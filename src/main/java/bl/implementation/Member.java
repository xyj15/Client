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
	
	private Search search;
	private Reserve reserve;
	private Order order;
	
	private MemberDataService memberDataService;
	
	/**
	 * 注册用户时使用这个构造方法，分配一个可用的ID
	 */
	public Member() {
		memberVO = new MemberVO();
		memberVO.setUserID(memberDataService.getAvailableID());
	}

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
	
	public boolean updateDataToFile() {
		return false;
	}
	
	public boolean updateDataFromFile() {
		return false;
	}
	
	public static MemberPO memberVOtoPO(MemberVO memberVO) {
		return null;
	}
	
	public static MemberVO memberPOtoVO(MemberPO memberPO) {
		return null;
	}
	
	/**
	 * 将新用户的信息传入数据层
	 * @param memberVO 新用户的信息
	 * @return 传入成功则返回true，否则返回false
	 */
	public boolean registerMember(MemberVO memberVO) {
		MemberPO memberPO = memberVOtoPO(memberVO);
		return memberDataService.addMember(memberPO);
	}
}