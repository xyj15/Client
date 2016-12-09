package bl.implementation;

import data.service.MemberDataService;
import bl.service.MemberBLService;

import other.MemberType;
import po.MemberPO;
import vo.CreditChangeVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Member模块bl的实现类
 * @author CROFF
 * @version 2016-12-8
 */
public class Member implements MemberBLService {
	
	private String memberID;
	private MemberVO memberVO;
	private Credit credit;
	private Order order;
	
	private MemberDataService memberDataService;
	
	/**
	 * 注册用户时使用这个构造方法，分配一个可用的ID
	 */
	public Member(MemberVO memberVO) {
		this.memberID = memberDataService.getAvailableID();
		memberVO.setUserID(memberID);
		this.memberVO = memberVO;
		MemberPO memberPO = memberVOtoPO(memberVO);
		memberDataService.addMember(memberPO);
		updateDataFromFile();
		credit = new Credit(memberID);
		credit.initialCredit();
	}
	
	/**
	 * 一般客户的构造方法，需要提供客户ID
	 * @param memberID 客户ID
	 */
	public Member(String memberID) {
		this.memberID = memberID;
		updateDataFromFile();
	}
	
	/**
	 * 获取客户名称
	 * @return 客户名称
	 */
	@Override
	public String getName() {
		updateDataFromFile();
		return memberVO.getName();
	}
	
	/**
	 * 获取客户联系方式
	 * @return 客户联系方式
	 */
	@Override
	public String getTel() {
		updateDataFromFile();
		return memberVO.getTel();
	}
	
	/**
	 * 获取客户信用值
	 * @return 客户信用值
	 */
	@Override
	public double getCredit() {
		updateDataFromFile();
		return credit.getCredit();
	}
	
	/**
	 * 获取客户信用变化列表
	 * @return 信用变化列表
	 */
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		updateDataFromFile();
		return credit.getCreditChangeList();
	}
	
	/**
	 * 获取客户会员等级
	 * @return 会员等级
	 */
	@Override
	public int getLevel() {
		updateDataFromFile();
		return memberVO.getLevel();
	}
	
	/**
	 * 获取当前等级享受折扣
	 * @return 当前等级享受折扣
	 */
	@Override
	public double getDiscount() {
		updateDataFromFile();
		return memberVO.getDiscount();
	}
	
	/**
	 * 获取客户类型
	 * @return 客户类型：普通客户或企业客户
	 */
	@Override
	public MemberType getMemberType() {
		updateDataFromFile();
		return memberVO.getMemberType();
	}
	
	/**
	 * 获取客户生日
	 * @return 客户生日
	 */
	@Override
	public Date getBirthday() {
		updateDataFromFile();
		return memberVO.getBirthday();
	}
	
	/**
	 * 获取合作企业名称
	 * @return 合作企业名称
	 */
	@Override
	public String getEnterprise() {
		updateDataFromFile();
		return memberVO.getEnterprise();
	}
	
	/**
	 * 获得预定过的酒店列表
	 * @return 预定过的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> getReservedHotelList() {
		ArrayList<String> hotelIDList = new ArrayList<String>();
		ArrayList<OrderVO> excutedOrderList = order.getExcutedOrders();
		for(int i=0; i<excutedOrderList.size(); i++) {
			String hotelID = excutedOrderList.get(i).getHotelID();
			if(!hotelIDList.contains(hotelID)) {
				hotelIDList.add(hotelID);
			}
		}
		
		ArrayList<HotelVO> reservedHotelList = new ArrayList<HotelVO>();
		Hotel hotel;
		for(int i=0; i<hotelIDList.size(); i++) {
			hotel = new Hotel(hotelIDList.get(i));
			reservedHotelList.add(hotel.getHotelInformation());
		}
		return reservedHotelList;
	}
	
	/**
	 * 获取客户信息
	 * @return 客户信息
	 */
	@Override
	public MemberVO getMemberInformation() {
		updateDataFromFile();
		return memberVO;
	}
	
	/**
	 * 更新客户信息
	 * @param memberVO 客户信息
	 * @return 更新成功则返回true，否则返回false
	 */
	@Override
	public boolean updateMemberInformation(MemberVO memberVO) {
		this.memberVO = memberVO;
		return updateDataToFile();
	}
	
	/**
	 * 打开对应酒店的预订界面
	 * @param hotelID 酒店ID
	 * @return 打开成功则返回true，否则返回false
	 */
	@Override
	public boolean newReservation(String hotelID) {
		return false;
	}
	
	/**
	 * 创建新订单
	 * @param orderVO 订单信息
	 * @return 创建成功则返回true，否则返回false
	 */
	@Override
	public boolean createOrder(OrderVO orderVO) {
		return false;
	}
	
	/**
	 * 更新数据到Data层
	 * @return 更新成功则返回true，否则返回false
	 */
	public boolean updateDataToFile() {
		MemberPO memberPO = memberVOtoPO(memberVO);
		return memberDataService.updateMember(memberPO);
	}
	
	/**
	 * 从Data层更新数据
	 * @return 更新成功则返回true，否则返回false
	 */
	public boolean updateDataFromFile() {
		credit = new Credit(memberID);
		order = new Order(memberID);
		memberVO = memberPOtoVO(memberDataService.getMember(memberID));
		Rank rank = new Rank();
		int level = rank.getLevel(credit.getCredit());
		double discount = rank.getDiscount(credit.getCredit());
		memberVO.setLevel(level);
		memberVO.setDiscount(discount);
		return true;
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
	 * 删除当前客户
	 * @return 删除成功则返回true，否则返回false
	 */
	public boolean deleteMember() {
		return memberDataService.deleteMember(memberID);
	}
}