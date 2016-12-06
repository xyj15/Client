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
	
	private String memberID;
	private MemberVO memberVO;
	
	private Search search;
	private Reserve reserve;
	private Order order;
	
	private MemberDataService memberDataService;
	
	/**
	 * 注册用户时使用这个构造方法，分配一个可用的ID
	 */
	public Member() {
		init();
		memberVO = new MemberVO();
		memberVO.setUserID(memberDataService.getAvailableID());
		updateDataToFile();
	}

	public Member(String memberID) {
		init();
		this.memberID = memberID;
		updateDataFromFile();
	}
	
	public void init() {
		
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
	public boolean newReservation(String hotelID) {
		reserve = new Reserve(memberVO.getUserID(), hotelID);
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
	
	/**
	 * member的VO转换成PO
	 * @param memberVO VO
	 * @return PO
	 */
	public static MemberPO memberVOtoPO(MemberVO memberVO) {
		String memberID = memberVO.getUserID();
		String password = memberVO.getPassword();
		String name = memberVO.getName();
		String tel = memberVO.getTel();
		int level = memberVO.getLevel();
		double discount = memberVO.getDiscount();
		MemberType memberType = memberVO.getMemberType();
		Date birthday = memberVO.getBirthday();
		String enterprise = memberVO.getEnterprise();
		MemberPO memberPO = new MemberPO(memberID, password, name, tel,
				level, discount, memberType, birthday, enterprise);
		return memberPO;
	}
	
	/**
	 * member的PO转换成VO
	 * @param memberPO PO
	 * @return VO
	 */
	public static MemberVO memberPOtoVO(MemberPO memberPO) {
		String memberID = memberPO.getMemberID();
		String password = memberPO.getPassword();
		String name = memberPO.getName();
		String tel = memberPO.getPhone();
		int level = memberPO.getLevel();
		double discount = memberPO.getDiscount();
		MemberType memberType = memberPO.getMemberType();
		Date birthday = memberPO.getBirthday();
		String enterprise = memberPO.getEnterprise();
		MemberVO memberVO = new MemberVO(memberID, password, name, tel, level, discount,
				memberType, birthday, enterprise);
		return memberVO;
	}
	
	/**
	 * 将新用户的信息传入数据层
	 * @param memberVO 新用户的信息
	 * @return 传入成功则返回true，否则返回false
	 */
	public boolean registerMember(MemberVO memberVO) {
		MemberPO memberPO = memberVOtoPO(memberVO);
		this.memberVO = memberVO;
		updateDataToFile();
		return memberDataService.addMember(memberPO);
	}
	
	/**
	 * 删除当前客户
	 * @return 删除成功则返回true，否则返回false
	 */
	public boolean deleteMember() {
		return memberDataService.deleteMember(memberID);
	}
}